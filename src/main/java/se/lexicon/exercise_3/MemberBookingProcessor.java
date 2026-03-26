package se.lexicon.exercise_3;

import java.time.LocalDateTime;
import java.util.UUID;

public class MemberBookingProcessor implements BookingProcessor {

    private static final double MEMBER_DISCOUNT = 0.20; // 20% discount
    private static final int PRIORITY_HOURS = 48; // Members can book 48 hours in advance

    @Override
    public Booking processBooking(BookingRequest request) {
        // Validate request
        if (request == null) {
            throw new IllegalArgumentException("Booking request cannot be null");
        }

        // Apply member business rules
        double originalPrice = getServicePrice(request.getServiceId());
        double discountedPrice = originalPrice * (1 - MEMBER_DISCOUNT);

        // Members get priority access to time slots
        boolean priorityAccess = true;

        // Generate booking ID
        String bookingId = generateBookingId();

        // Check if requested time slot is within member priority window
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime maxBookingTime = now.plusHours(PRIORITY_HOURS);

        String status;
        if (request.getRequestedTimeSlot().isBefore(maxBookingTime)) {
            status = "CONFIRMED - Member Priority Booking";
        } else {
            status = "PENDING - Requested time exceeds priority window";
        }

        return new Booking(
                bookingId,
                request.getCustomerName(),
                request.getServiceId(),
                request.getRequestedTimeSlot(),
                discountedPrice,
                status,
                priorityAccess
        );
    }

    private double getServicePrice(String serviceId) {
        // Simplified price lookup
        switch(serviceId) {
            case "W01":
                return 299.99;
            case "S01":
                return 199.99;
            default:
                return 149.99;
        }
    }

    private String generateBookingId() {
        return "MEMBER-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}