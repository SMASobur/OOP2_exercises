package se.lexicon.exercise_1;

//SummerTireChange subclass
public class SummerTireChange extends Service {
    private static final int SUMMER_SERVICE_DURATION = 45;

    public SummerTireChange(String id, String name, double basePrice) {
        super(id, name, basePrice);
    }

    @Override
    public int getServiceDuration() {
        return SUMMER_SERVICE_DURATION;
    }


    @Override
    public String toString() {
        return String.format("SummerTireChange[id: = %s, Name = %s, basePrice = %.2f, Duration = %d min]",
                getId(), getName(), getBasePrice(), getServiceDuration());
    }
}