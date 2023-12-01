package vendingmachines;

import exceptions.ProductOutOfStockException;
import exceptions.UnderageException;
import payment.CreditCardPayment;
import products.Inventory;
import products.medical.MedicalProduct;
import dialog.MedicalVendingMachineDialog;

public class MedicalVendingMachine extends VendingMachine<MedicalProduct> {

    public MedicalVendingMachine() {
        super(new Inventory<MedicalProduct>(), new CreditCardPayment(), new MedicalVendingMachineDialog());
    }

    @Override
    public void selectProduct(MedicalProduct product) {
        try {
            if (!product.isOfAge()) {
                throw new UnderageException();
            } else {
                int quantityAvailable = inventory.getProductQuantity(product);
                if (quantityAvailable <= 0) {
                    throw new ProductOutOfStockException();
                } else {
                    vendingMachineDialog.purchaseInformation(product);
                    this.paymentStrategy = vendingMachineDialog.chooseMethodOfPayment();
                    paymentStrategy.processPayment(product.getPrice());
                    vendingMachineDialog.displayMessage("Enjoy your " + product.getName() + "!");
                }
            }
        } catch (UnderageException | ProductOutOfStockException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


