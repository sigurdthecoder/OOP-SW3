package products.medical;

public class Drugs extends MedicalProduct {
    private boolean prescriptionRequired;

    public Drugs(String name, double price, int minimumAge, boolean prescriptionRequired) {
        super(name, price, minimumAge);
        this.prescriptionRequired = prescriptionRequired;
    }
}
