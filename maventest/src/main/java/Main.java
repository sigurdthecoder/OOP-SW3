import products.hotfood.Soup;
import products.medical.Drugs;
import vendingmachines.HotFoodVendingMachine;
import vendingmachines.MedicalVendingMachine;

public class Main {
    public static void main(String[] args) {

        HotFoodVendingMachine hotFoodVendingMachine = new HotFoodVendingMachine();
        hotFoodVendingMachine.getVendingMachineDialog().welcomeMessage();

        Soup chickenSoup = new Soup("Chicken soup", 50.95, 30, 500);
        hotFoodVendingMachine.getInventory().addProduct(chickenSoup, 0);

        MedicalVendingMachine medicalVendingMachine = new MedicalVendingMachine();
        Drugs drug = new Drugs("Kokain", 50, 18, false);
        medicalVendingMachine.getInventory().addProduct(drug, 5);
        medicalVendingMachine.selectProduct(drug);
    }
}