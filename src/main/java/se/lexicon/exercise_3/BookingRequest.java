package se.lexicon.exercise_3;

import java.time.LocalDateTime;

// Fields
public class BookingRequest {
    private String customerId;
    private String customerName;
    private String serviceId;
    private LocalDateTime requestedTimeSlot;
    private boolean isMember;

    // Constructor
    public BookingRequest(String customerId, String customerName,
                          String serviceId, LocalDateTime requestedTimeSlot,
                          boolean isMember) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.serviceId = serviceId;
        this.requestedTimeSlot = requestedTimeSlot;
        this.isMember = isMember;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public LocalDateTime getRequestedTimeSlot() {
        return requestedTimeSlot;
    }

    public boolean isMember() {
        return isMember;
    }

    @Override
    public String toString() {
        return String.format("BookingRequest[customer=%s, service=%s, time=%s, member=%s]",
                customerName, serviceId, requestedTimeSlot, isMember);
    }
}