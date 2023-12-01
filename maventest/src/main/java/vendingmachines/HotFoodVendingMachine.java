package vendingmachines;

import exceptions.ProductOutOfStockException;
import payment.CreditCardPayment;
import products.Inventory;
import products.hotfood.HotFoodProduct;
import dialog.HotFoodVendingMachineDialog;

public class HotFoodVendingMachine extends VendingMachine<HotFoodProduct> {

    public HotFoodVendingMachine() {
        super(new Inventory<HotFoodProduct>(), new CreditCardPayment(), new HotFoodVendingMachineDialog());
    }

    @Override
    public void selectProduct(HotFoodProduct product) {

        try {
            int quantityAvailable = inventory.getProductQuantity(product);

            if (quantityAvailable <= 0) {
                throw new ProductOutOfStockException();
            } else {
                vendingMachineDialog.purchaseInformation(product);
                this.paymentStrategy = vendingMachineDialog.chooseMethodOfPayment();
                paymentStrategy.processPayment(product.getPrice());
                vendingMachineDialog.displayMessage("Enjoy your " + product.getName() + "!");
            }
        } catch (ProductOutOfStockException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
