package se.lexicon.exercise_1;


public class Main {
    public static void main(String[] args) {
        // Create service instances
        WinterTireChange winterService = new WinterTireChange("W01", "Winter Tire Change", 299.99);
        SummerTireChange summerService = new SummerTireChange("S01", "Summer Tire Change", 199.99);

        // Display service information
        System.out.println("=== Service Details ===");
        System.out.println(winterService);
        System.out.println("Winter Service Duration: " + winterService.getServiceDuration() + " minutes");

        System.out.println("\n" + summerService);
        System.out.println("Summer Service Duration: " + summerService.getServiceDuration() + " minutes");

        // Demonstrate polymorphism
        System.out.println("\n=== Polymorphism Example ===");
        Service[] services = {winterService, summerService};

        for (Service service : services) {
            System.out.println(service.getName() + " -> Duration: " +
                    service.getServiceDuration() + " min");
        }
    }
}