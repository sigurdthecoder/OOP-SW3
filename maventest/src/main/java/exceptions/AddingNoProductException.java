package exceptions;

public class AddingNoProductException extends Exception {
    public AddingNoProductException () {
        super("You can't add a quantity of zero or less");
    }
}
