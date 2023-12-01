package products.hotfood;

import products.Product;

public abstract class HotFoodProduct extends Product {

    private int preparationTimeInMinutes;

    public HotFoodProduct(String name, double price, int preparationTimeInMinutes) {
        super(name, price);
        this.preparationTimeInMinutes = preparationTimeInMinutes;
    }

}
