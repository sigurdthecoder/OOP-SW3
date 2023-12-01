package products.medical;

import products.Product;

import java.util.Scanner;

public abstract class MedicalProduct extends Product implements AgeRestricted {
    private int minimumAge;

    public MedicalProduct(String name, double price, int minimumAge) {
        super(name, price);
        this.minimumAge = minimumAge;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    @Override
    public boolean isOfAge() {
        System.out.println("Are you above the age of " + minimumAge + "?");
        Scanner scanner = new Scanner(System.in);
        String userResponse = scanner.nextLine();

        while (!userResponse.equalsIgnoreCase("yes") && !userResponse.equalsIgnoreCase("no")) {
            System.out.println("You have to provide either a yes or a no");
            userResponse = scanner.nextLine();
        }

        if (userResponse.equalsIgnoreCase("yes")) {
            return true;
        }
        else if (userResponse.equalsIgnoreCase("no")) {
            return false;
        }

        // just because the control has to have a return statement for every possible scenario... this return statement is not intended to be used
        return false;
    }
}
