package dialog;

import payment.PaymentStrategy;
import products.Product;

public interface VendingMachineDialog {
    void welcomeMessage();
    void purchaseInformation(Product product);
    void displayMessage(String message);
    PaymentStrategy chooseMethodOfPayment();
}
