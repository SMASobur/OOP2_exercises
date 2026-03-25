package se.lexicon.exercise_2;

// Abstract class
public abstract class Service {
    private String id;
    private String name;
    private double basePrice;

    // Constructor
    public Service(String id, String name, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // Setters with validation
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            throw new IllegalArgumentException("Base price cannot be negative");
        }
    }

    // Abstract methods to be implemented by subclasses
    public abstract int getServiceDuration();
    public abstract double calculateFinalPrice();
    public abstract int calculatePrice();

    @Override
    public String toString() {
        return String.format("Service[id= %s, name= %s, basePrice= %.2f]",
                id, name, basePrice);
    }
}