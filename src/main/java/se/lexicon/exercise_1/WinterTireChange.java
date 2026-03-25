package se.lexicon.exercise_1;


// WinterTireChange subclass
public class WinterTireChange extends Service {
    private static final int WINTER_SERVICE_DURATION = 60;
    private static final double WINTER_SURCHARGE = 20.00;

    public WinterTireChange(String id, String name, double basePrice) {
        super(id, name, basePrice);
    }

    @Override
    public int getServiceDuration() {
        return WINTER_SERVICE_DURATION;
    }

    @Override
    public String toString() {
        return String.format("WinterTireChange[id: = %s, Name: = %s, basePrice = %.2f, Duration = %d min]",
                getId(), getName(), getBasePrice(), getServiceDuration());
    }
}