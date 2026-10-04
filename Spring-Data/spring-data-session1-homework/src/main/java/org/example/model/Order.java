package org.example.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "ordered_at")
    private LocalDateTime orderedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Payment payment;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> items = new ArrayList<>();


    public BigDecimal getTotal() {
        return items.stream()
                .map(orderItem ->
                        BigDecimal.valueOf(orderItem.getQuantity())
                                .multiply(orderItem.getUnitPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        if(payment == null) {
            return;
        }
        payment.setOrder(this);
        this.payment = payment;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addOrderItem(OrderItem item) {
        if(item == null) {
            return;
        }
        item.setOrder(this);
        items.add(item);
    }

    public void removeOrderItem(OrderItem item) {
        if(item == null) {
            return;
        }
        item.setOrder(null);
        items.remove(item);
    }
}
