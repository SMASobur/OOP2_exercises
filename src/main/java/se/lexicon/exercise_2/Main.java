package se.lexicon.exercise_2;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create service instances
        WinterTireChange winterService = new WinterTireChange("W01", "Winter Tire Change", 299.99);
        SummerTireChange summerService = new SummerTireChange("S01", "Summer Tire Change", 199.99);


        // Display service information
        System.out.println("-".repeat(50));
        System.out.println("=== Service Details ===");
        System.out.println("-".repeat(50));
        System.out.println(winterService);
        System.out.println("Winter Service Duration: " + winterService.getServiceDuration() + " minutes");
        System.out.println("Winter Final Price: SEK " + winterService.calculateFinalPrice());
        System.out.println("Winter Calculated Price: SEK " + winterService.calculatePrice());

        System.out.println("\n" + summerService);
        System.out.println("Summer Service Duration: " + summerService.getServiceDuration() + " minutes");
        System.out.println("Summer Final Price: SEK " + summerService.calculateFinalPrice());
        System.out.println("Summer Calculated Price: SEK " + summerService.calculatePrice());

        // Demonstrate polymorphism
        System.out.println("-".repeat(50));
        System.out.println("=== Polymorphism Example ===");
        System.out.println("-".repeat(50));

        // Store service objects in List<Service> - Polymorphism in action!
        List<Service> services = new ArrayList<>();
        services.add(winterService);
        services.add(summerService);

        for (Service service : services) {
            System.out.println("Service: "+service.getName() +
                    "\nBase Price: "+ service.getBasePrice()+
                    "\nCalculated Price: SEK "+ service.calculatePrice()+
                    "\nDuration: " + service.getServiceDuration() + " mins\n");
        }

        // Additional demonstration showing polymorphic behavior
        System.out.println("-".repeat(50));
        System.out.println("=== Price Calculation Summary ===");
        System.out.println("-".repeat(50));
        int totalPrice = 0;
        for (Service service : services) {
            int price = service.calculatePrice();
            totalPrice += price;
            System.out.printf("%s: SEK %d%n", service.getName(), price);
        }
        System.out.printf("Total: SEK %d%n", totalPrice);
    }
}