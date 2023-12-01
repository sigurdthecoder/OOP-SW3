package payment;

public class MobilePayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Mobile Payment of " + amount + " kr. processed successfully");
    }
}
