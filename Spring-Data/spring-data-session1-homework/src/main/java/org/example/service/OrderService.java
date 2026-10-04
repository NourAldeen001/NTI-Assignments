package org.example.service;

import org.example.dto.OrderItemDTO;
import org.example.dto.OrderSummaryDTO;
import org.example.exception.*;
import org.example.model.*;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    private final AuditLogService auditLogService;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository,
                        CustomerRepository customerRepository,
                        AuditLogService auditLogService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;

        this.auditLogService = auditLogService;
    }

    @Transactional
    public void placeOrder(Long customerId, Map<Long, Integer> productQuantities) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        /// Commit even if outer (@Transactional on placeOrder) fails
        /// For example: if throws InsufficientStockException
        /// This auditLogService.addLog() saved not rollback
        auditLogService.addLog("Order creation started...");

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.NEW);
        order.setOrderedAt(LocalDateTime.now());

        for(Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Long productId = entry.getKey();
            Integer quantity = entry.getValue();

            if(quantity <= 0) {
                throw new IllegalArgumentException(
                        "Quantity must be greater than 0"
                );
            }

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotFoundException(productId));

            if(product.getStock() < quantity) {
                throw new InsufficientStockException(productId);
            }

            product.setStock(product.getStock() - quantity);

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setUnitPrice(product.getPrice());

            order.addOrderItem(orderItem);

        }

        orderRepository.save(order);
    }

    @Transactional
    public void pay(Long orderId, PaymentMethod paymentMethod) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        if(order.getStatus() != OrderStatus.NEW) {
            throw new InvalidOrderStateException();
        }

        if(order.getPayment() != null) {
            throw new InvalidOrderStateException();
        }

        Payment payment = new Payment();
        payment.setMethod(paymentMethod);
        payment.setAmount(order.getTotal());
        payment.setPaidAt(LocalDateTime.now());

        order.setStatus(OrderStatus.PAID);
        order.setPayment(payment); // dirty checking handle it

    }

    @Transactional
    public void ship(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        if(order.getStatus() != OrderStatus.PAID) {
            throw new InvalidOrderStateException();
        }

        order.setStatus(OrderStatus.SHIPPED); // dirty checking handle it
    }

    @Transactional
    public void cancel(Long orderId) {
        Order order = orderRepository.findByIdWithItems(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        if(order.getStatus() != OrderStatus.NEW &&
                order.getStatus() != OrderStatus.PAID) {
            throw new InvalidOrderStateException();
        }

        for(OrderItem item : order.getItems()) {
            Product currentProduct = item.getProduct();
            currentProduct.setStock(currentProduct.getStock() + item.getQuantity());
        }

        order.setStatus(OrderStatus.CANCELLED); // dirty checking handle it
    }

    @Transactional(readOnly = true)
    public OrderSummaryDTO getOrderSummary(Long orderId) {
        Order order = orderRepository.findByIdWithItems(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        List<OrderItemDTO> items =
                order.getItems()
                        .stream()
                        .map(item -> new OrderItemDTO(
                                item.getProduct().getName(),
                                item.getQuantity(),
                                item.getUnitPrice()
                        ))
                        .toList();

        return new OrderSummaryDTO(
                order.getCustomer().getName(),
                order.getCustomer().getEmail(),
                order.getCustomer().getShippingAddress(),
                order.getStatus(),
                order.getOrderedAt(),
                order.getPayment().getAmount(),
                order.getPayment().getMethod(),
                order.getPayment().getPaidAt(),
                items
        );
    }
}
