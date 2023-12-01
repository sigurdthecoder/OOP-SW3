package products.medical;

public class MedicalEquipment extends MedicalProduct {
    private boolean isReusable;

    public MedicalEquipment(String name, double price, int minimumAge, boolean isReusable) {
        super(name, price, minimumAge);
        this.isReusable = isReusable;
    }
}
