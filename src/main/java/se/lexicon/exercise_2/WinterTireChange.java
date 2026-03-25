package se.lexicon.exercise_2;

// WinterTireChange subclass
public class WinterTireChange extends Service {
    private static final int WINTER_SERVICE_DURATION = 60;
    private static final double WINTER_SURCHARGE = 20.00;
    private static final int STORAGE_FEE = 50;

    public WinterTireChange(String id, String name, double basePrice) {
        super(id, name, basePrice);
    }

    @Override
    public int getServiceDuration() {
        return WINTER_SERVICE_DURATION;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice()+WINTER_SURCHARGE; // Winter tire change includes additional surcharge
    }

    @Override
    public int calculatePrice() {
        return (int)(getBasePrice()+WINTER_SURCHARGE+STORAGE_FEE);
    }

    @Override
    public String toString() {
        return String.format("WinterTireChange[id: = %s, Name: = %s, basePrice = %.2f, finalPrice = %.2f, price = %d, Duration = %d min]",
                getId(), getName(), getBasePrice(), calculateFinalPrice(), calculatePrice(), getServiceDuration());
    }
}