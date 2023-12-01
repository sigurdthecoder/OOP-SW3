package products;

import exceptions.AddingNoProductException;
import products.hotfood.Soup;
import products.medical.MedicalEquipment;
import vendingmachines.HotFoodVendingMachine;
import vendingmachines.MedicalVendingMachine;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryTest {

    @Test
    public void addFiveSoupShouldGiveFiveSoupInInventory() {
        HotFoodVendingMachine hotFoodVendingMachine = new HotFoodVendingMachine();

        Soup chickenSoup = new Soup("Chicken Soup", 50, 30, 500);

        hotFoodVendingMachine.getInventory().addProduct(chickenSoup, 5);

        assertEquals(5, hotFoodVendingMachine.getInventory().getProductQuantity(chickenSoup));
    }

    @Test
    public void addFiveThenTwoSoupShouldGiveSevenSoupInInventory() {

        HotFoodVendingMachine hotFoodVendingMachine = new HotFoodVendingMachine();

        Soup vegetableSoup = new Soup("Vegetable Soup", 30, 30, 350);

        hotFoodVendingMachine.getInventory().addProduct(vegetableSoup, 5);
        hotFoodVendingMachine.getInventory().addProduct(vegetableSoup, 2);

        assertEquals(7, hotFoodVendingMachine.getInventory().getProductQuantity(vegetableSoup));
    }

    @Test
    public void zeroQuantityShouldRemoveProduct() {
        MedicalVendingMachine medicalVendingMachine = new MedicalVendingMachine();
        MedicalEquipment earPlugs = new MedicalEquipment("Earplugs", 30, 10, true);

        medicalVendingMachine.getInventory().addProduct(earPlugs, 10);

        medicalVendingMachine.getInventory().removeProduct(earPlugs, 10);

        assertFalse(medicalVendingMachine.getInventory().isProductPresent(earPlugs));
    }

    @Test
    public void throwsWhenQuantityIsZero() {
        HotFoodVendingMachine hotFoodVendingMachine = new HotFoodVendingMachine();
        Soup soup = new Soup("Soup", 50, 50, 500);

        assertThrows(AddingNoProductException.class, () -> {
            hotFoodVendingMachine.getInventory().addProduct(soup, -1);
        });
    }

}