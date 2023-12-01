package exceptions;

public class ProductOutOfStockException extends Exception {

    public ProductOutOfStockException() {
        super("Product is out of stock.");
    }
}
