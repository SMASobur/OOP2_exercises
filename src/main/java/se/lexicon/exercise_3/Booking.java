package se.lexicon.exercise_3;

import java.time.LocalDateTime;
// Fields
public class Booking {
    private String bookingId;
    private String customerName;
    private String serviceId;
    private LocalDateTime timeSlot;
    private double price;
    private String status;
    private boolean priorityAccess;

    // Constructor
    public Booking(String bookingId, String customerName, String serviceId,
                   LocalDateTime timeSlot, double price, String status,
                   boolean priorityAccess) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.serviceId = serviceId;
        this.timeSlot = timeSlot;
        this.price = price;
        this.status = status;
        this.priorityAccess = priorityAccess;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public LocalDateTime getTimeSlot() {
        return timeSlot;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public boolean hasPriorityAccess() {
        return priorityAccess;
    }

    @Override
    public String toString() {
        return String.format("Booking[id=%s, customer=%s, service=%s, time=%s, price=SEK%.2f, status=%s, priority=%s]",
                bookingId, customerName, serviceId, timeSlot, price, status, priorityAccess);
    }
}