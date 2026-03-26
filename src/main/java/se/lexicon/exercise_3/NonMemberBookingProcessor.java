package se.lexicon.exercise_3;

import java.time.LocalDateTime;
import java.util.UUID;

public class NonMemberBookingProcessor implements BookingProcessor {

    private static final int STANDARD_BOOKING_HOURS = 24; // Non-members can book 24 hours in advance

    @Override
    public Booking processBooking(BookingRequest request) {
        // Validate request
        if (request == null) {
            throw new IllegalArgumentException("Booking request cannot be null");
        }

        // Apply non-member business rules
        double fullPrice = getServicePrice(request.getServiceId());

        // Non-members don't get priority access
        boolean priorityAccess = false;

        // Generate booking ID
        String bookingId = generateBookingId();

        // Check if requested time slot is within standard booking window
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime maxBookingTime = now.plusHours(STANDARD_BOOKING_HOURS);

        String status;
        if (request.getRequestedTimeSlot().isBefore(maxBookingTime)) {
            status = "CONFIRMED - Standard Booking";
        } else {
            status = "REJECTED - Booking time exceeds allowed window";
        }

        return new Booking(
                bookingId,
                request.getCustomerName(),
                request.getServiceId(),
                request.getRequestedTimeSlot(),
                fullPrice,
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
        return "NONMEMBER-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}