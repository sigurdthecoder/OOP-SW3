package products.hotfood;

public class Soup extends HotFoodProduct {
    private int millilitres;

    public Soup(String name, double price, int preparationTimeInMinutes, int millilitres) {
        super(name, price, preparationTimeInMinutes);
        this.millilitres = millilitres;
    }
}
