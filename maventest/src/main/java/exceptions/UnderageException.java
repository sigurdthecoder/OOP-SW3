package exceptions;

public class UnderageException extends Exception {

    public UnderageException() {
        super("You are not old enough to purchase this product");
    }
}
