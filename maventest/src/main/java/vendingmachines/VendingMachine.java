package vendingmachines;

import payment.PaymentStrategy;
import products.Inventory;
import dialog.VendingMachineDialog;

public abstract class VendingMachine <T> {
    protected Inventory<T> inventory;
    protected PaymentStrategy paymentStrategy;
    protected VendingMachineDialog vendingMachineDialog;
    public VendingMachine(Inventory<T> inventory, PaymentStrategy paymentStrategy, VendingMachineDialog vendingMachineDialog) {
        this.inventory = inventory;
        this.paymentStrategy = paymentStrategy;
        this.vendingMachineDialog = vendingMachineDialog;
    }

    public Inventory<T> getInventory() {
        return inventory;
    }

    public VendingMachineDialog getVendingMachineDialog() {return vendingMachineDialog; }
    public abstract void selectProduct(T product);

}
