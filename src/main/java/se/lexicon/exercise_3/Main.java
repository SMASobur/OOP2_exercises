package se.lexicon.exercise_3;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Booking System with Interface Abstraction ===\n");

        // Create booking requests
        BookingRequest memberRequest = new BookingRequest(
                "C01",
                "Shamu S",
                "W01",
                LocalDateTime.now().plusHours(36),
                true  // Member
        );

        BookingRequest nonMemberRequest = new BookingRequest(
                "C02",
                "Ragavi G",
                "S01",
                LocalDateTime.now().plusHours(36),
                false  // Non-member
        );

        // Demonstrate abstraction - using interface type
        // Can easily switch between implementations without changing other code

        System.out.println("Processing Member Booking:");
        BookingProcessor memberProcessor = new MemberBookingProcessor();
        processBooking(memberProcessor, memberRequest);

        System.out.println("\nProcessing Non-Member Booking:");
        BookingProcessor nonMemberProcessor = new NonMemberBookingProcessor();
        processBooking(nonMemberProcessor, nonMemberRequest);

        // Demonstrate switching processors without code changes
        System.out.println("\n=== Demonstrating Processor Switching ===");
        System.out.println("Switching Member to Non-Member rules for the same request:");

        BookingProcessor processor = new MemberBookingProcessor(); // Start with member
        System.out.println("Using MemberProcessor:");
        Booking memberResult = processor.processBooking(memberRequest);
        System.out.println(memberResult);

        // Switch processor - only this line changes!
        processor = new NonMemberBookingProcessor();
        System.out.println("\nSwitched to NonMemberProcessor:");
        Booking nonMemberResult = processor.processBooking(memberRequest);
        System.out.println(nonMemberResult);

        // Show that member benefits don't apply after switching
        System.out.println("\nNote: Same customer now pays full price and loses priority access!");
    }

    // Method accepts interface type - works with ANY BookingProcessor implementation
    private static void processBooking(BookingProcessor processor, BookingRequest request) {
        System.out.println("Request: " + request);
        Booking booking = processor.processBooking(request);
        System.out.println("Result: " + booking);

        // Show specific benefits based on booking type
        if (booking.hasPriorityAccess()) {
            System.out.println("  ✓ Priority access granted");
        } else {
            System.out.println("  ✗ No priority access");
        }

        if (booking.getPrice() < getOriginalPrice(request.getServiceId())) {
            System.out.println("  ✓ Member discount applied");
        } else {
            System.out.println("  ✗ Full price charged");
        }
    }

    private static double getOriginalPrice(String serviceId) {
        switch(serviceId) {
            case "W01": return 299.99;
            case "S01": return 199.99;
            default: return 149.99;
        }
    }
}