package payment;

public class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Cash payment of " + amount + " kr. processed successfully. \nAny change is found at the bottom right of the machine");
    }
}
