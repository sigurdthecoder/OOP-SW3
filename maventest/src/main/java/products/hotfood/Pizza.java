package products.hotfood;

public class Pizza extends HotFoodProduct {
    private int numberOfSlices;

    public Pizza(String name, double price, int preparationTimeInMinutes, int numberOfSlices) {
        super(name, price, preparationTimeInMinutes);
        this.numberOfSlices = numberOfSlices;
    }
}
