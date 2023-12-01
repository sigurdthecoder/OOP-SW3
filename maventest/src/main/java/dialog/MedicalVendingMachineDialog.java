package dialog;

import payment.CreditCardPayment;
import payment.MobilePayment;
import payment.PaymentStrategy;
import products.Product;

import java.util.Scanner;

public class MedicalVendingMachineDialog implements VendingMachineDialog {

    @Override
    public void welcomeMessage() {
        System.out.println("Welcome to this Medical Vending Machine! :-)");
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public PaymentStrategy chooseMethodOfPayment() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose one of the following methods of payment: \n\n1) Credit card\n2) Mobile\n");
            int userResponse = scanner.nextInt();

            while (userResponse != 1 && userResponse != 2) {
                System.out.println("You have to either answer 1 or 2");
                userResponse = scanner.nextInt();
            }

            if (userResponse == 1) {
                System.out.println("You have chosen Credit card as your method of payment");
                return new CreditCardPayment();
            } else if (userResponse == 2) {
                System.out.println("You have chosen Mobile as your method of payment");
                return new MobilePayment();
            }

            return null;
    }

    @Override
    public void purchaseInformation(Product product) {
        System.out.println(product.getName() + " is in stock, costs " + product.getPrice() + " kr. and is now chosen");
    }
}
