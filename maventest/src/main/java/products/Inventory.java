package products;

import exceptions.AddingNoProductException;
import exceptions.MaximumQuantityExceededException;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
    private Map<T, Integer> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(T product, int quantity) {

        try {
            int currentQuantity = products.getOrDefault(product, 0);

            if (quantity <= 0) {
                throw new AddingNoProductException();
            } else if (currentQuantity + quantity > 10) {
                throw new MaximumQuantityExceededException("Maximum quantity of product exceeded");
            } else {
                products.put(product, currentQuantity + quantity);
            }

        } catch (MaximumQuantityExceededException | AddingNoProductException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void removeProduct(T product, int quantity) {
        int currentQuantity = products.getOrDefault(product, 0);
        if (currentQuantity - quantity <= 0) {
            products.remove(product);
        } else {
            products.put(product, currentQuantity - quantity);
        }
    }

    public int getProductQuantity(T product) {
        return products.getOrDefault(product, 0);
    }

    public boolean isProductPresent(T product) {
        return products.containsKey(product);
    }
}