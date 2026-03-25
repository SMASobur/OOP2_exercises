package se.lexicon.exercise_2;

//SummerTireChange subclass
public class SummerTireChange extends Service {
    private static final int SUMMER_SERVICE_DURATION = 45;
    private static final double SUMMER_DISCOUNT = 25.00;

    public SummerTireChange(String id, String name, double basePrice) {
        super(id, name, basePrice);
    }

    @Override
    public int getServiceDuration() {
        return SUMMER_SERVICE_DURATION;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice()-SUMMER_DISCOUNT;
    }

    @Override
    public int calculatePrice() {
        int price = (int)(calculateFinalPrice());
        return Math.max(price, 0); // Ensure price is not negative.
    }

    @Override
    public String toString() {
        return String.format("SummerTireChange[id: = %s, Name = %s, basePrice = %.2f, finalPrice = %.2f, price=%d, Duration = %d min]",
                getId(), getName(), getBasePrice(), calculateFinalPrice(), calculatePrice(), getServiceDuration());
    }
}