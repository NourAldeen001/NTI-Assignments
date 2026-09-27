package dynamicJDK;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount);
    }
}
