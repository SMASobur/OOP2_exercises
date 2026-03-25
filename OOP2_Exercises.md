![Lexicon Logo](https://lexicongruppen.se/media/wi5hphtd/lexicon-logo.svg)

# OOP Practice Exercises — Inheritance, Polymorphism & Abstraction

These exercises are based on the **Tire Service Booking** domain and are designed
to help you practice **core OOP concepts** step by step.

---

## Exercise 1

### Goal

Practice **inheritance** by modeling different tire-change services.

---

1. Create an **abstract class** `Service` with common properties:
    - `id`
    - `name`
    - `basePrice`

2. Create the following subclasses:
    - `WinterTireChange`
    - `SummerTireChange`

3. Each subclass may:
    - Define its own service duration
    - Adjust pricing rules if needed

---

### Requirements

- `Service` must be abstract
- Subclasses must extend `Service`
- Use proper encapsulation (private fields, getters)

---

## Exercise 2

### Goal

Practice **polymorphism** using method overriding.

---

### Task

1. Add the following abstract method to `Service`:
   ```java
   public abstract int calculatePrice();
   ```

2. Override `calculatePrice()` in each subclass:
    - `WinterTireChange` may include a storage fee
    - `SummerTireChange` may include a seasonal discount

3. Store service objects as:
   ```java
   List<Service> services;
   ```

4. Call `calculatePrice()` on each service and observe different behavior.

---

### Requirements

- Method must be overridden in subclasses
- Use a `Service` reference when calling the method
- Do not use `instanceof`

---

## Exercise 3

### Goal

Practice **abstraction using interfaces**.

---

### Task

1. Create an interface called `BookingProcessor`:

    ```java
    public interface BookingProcessor {
        Booking processBooking(BookingRequest request);
    }
    ```

   This interface defines **what** a booking processor must do,
   but not **how** the booking rules are applied.

2. Create two implementations:

    - `MemberBookingProcessor`
    - `NonMemberBookingProcessor`

   Each implementation should:

    - Apply different business rules
    - For example:
        - Members receive a discount
        - Members may get priority access to time slots
        - Non-members pay the full price

3. Use the interface type when processing bookings:

   ```java
   BookingProcessor processor = new MemberBookingProcessor();
   ```

   Later, you should be able to switch to:

   ```java
   BookingProcessor processor = new NonMemberBookingProcessor();
   ```

   without changing any other code.
   
   
