/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinecheckinsystem_sec2_g15;
import java.util.*;
/**
 *
 * @author omar
 */
public class AirlineCheckInSystem {
    // Data structures for managing passengers, luggage, and priority services.
    private Queue<Passenger> passengersQueue;
    private Stack<Luggage> luggageStack;
    private PriorityQueue<PriorityServices> priorityServicesQueue;
    private Set<String> passengerIds; // To keep track of unique passenger IDs

    // Constructor
    public AirlineCheckInSystem() {
        // Initialize data structures
        passengersQueue = new LinkedList<>(); // Using a Queue for passengers
        luggageStack = new Stack<>(); // Using a Stack for luggage (Last-In-First-Out)
        priorityServicesQueue = new PriorityQueue<>(); // Using a PriorityQueue for priority services
        passengerIds = new HashSet<>(); // Initialize the set for unique passenger IDs
    }

    // Methods
    public void enqueuePassenger(Passenger passenger) {
        // Check if the passenger's ID is unique before adding them to the queue
        if (!passengerIds.contains(passenger.getId())) {
            passengersQueue.offer(passenger); // Add the passenger to the end of the queue
            passengerIds.add(passenger.getId()); // Add the passenger's ID to the set
        } else {
            System.out.println("Passenger with ID " + passenger.getId() + " already exists.");
        }
    }
 
    public void enqueuePriorityPassenger(String id, int priorityScore) {
        // Check if the passenger's ID is unique before adding them to the priority queue
        if (!passengerIds.contains(id)) {
            PriorityServices newPriorityPassenger = new PriorityServices(id, priorityScore);
            priorityServicesQueue.offer(newPriorityPassenger); // Add to the priority queue
            passengerIds.add(id); // Add the passenger's ID to the set
        } else {
            System.out.println("Passenger with ID " + id + " already exists in the priority queue.");
        }
    }
    
    private boolean isValidLuggage(Luggage luggage) {
        // Check if the luggage is within the weight and dimension limits
        if (luggage.getWeight() <= 50 &&
            luggage.getLength() <= 90 &&
            luggage.getWidth() <= 60 &&
            luggage.getHeight() <= 40) {
        
            // Check if the luggage ID is unique
            if (isUniqueLuggageId(luggage.getId())) {
                // Count the total luggage weight for the passenger
                double totalWeightForPassenger = 0.0;
                int luggageCountForPassenger = 0;

                for (Luggage existingLuggage : luggageStack) {
                    if (existingLuggage.getPassengerId().equals(luggage.getPassengerId())) {
                        totalWeightForPassenger += existingLuggage.getWeight();
                        luggageCountForPassenger++;
                    }
                }

                // Check if adding the new luggage exceeds the weight limit or luggage count limit
                if (totalWeightForPassenger + luggage.getWeight() <= 50 && luggageCountForPassenger < 3) {
                    return true;
                }
            } else {
                System.out.println("Luggage with duplicate ID found.");
            }
        }
        return false;
    }

    private boolean isUniqueLuggageId(String luggageId) {
        // Check if the luggage ID is unique
        for (Luggage existingLuggage : luggageStack) {
            if (existingLuggage.getId().equals(luggageId)) {
                return false; // Luggage with the same ID already exists
            }
        }
        return true; // Luggage ID is unique
    }

    
    public void pushLuggage(Luggage luggage) {
        // Check if the luggage is valid based on constraints
        if (isValidLuggage(luggage)) {
            luggageStack.push(luggage); // Push the luggage onto the top of the stack
        } else {
            System.out.println("Invalid luggage. It exceeds weight or count limits.");
        }
    }

    public Luggage popLuggage() {
        // Logic to process the luggage from the luggage stack (Last-In-First-Out)
        if (!luggageStack.isEmpty()) {
            return luggageStack.pop(); // Pop the top luggage from the stack
        }
        return null; // No luggage to pop
    }
  
    public Passenger getNextPassenger() {
        if (!priorityServicesQueue.isEmpty()) {
            // If there is a passenger in the priority queue, return them
            PriorityServices priorityPassenger = priorityServicesQueue.peek();
            return getPassengerById(priorityPassenger.getId());
        } else if (!passengersQueue.isEmpty()) {
            // Otherwise, return the next regular passenger
            return passengersQueue.peek();
        } else {
            return null; // No passengers left to serve
        }
    }

    public Passenger dequeuePassenger() {
        if (!priorityServicesQueue.isEmpty()) {
            // Remove the passenger from the priority queue
            PriorityServices priorityPassenger = priorityServicesQueue.poll();
            return getPassengerById(priorityPassenger.getId());
        } else if (!passengersQueue.isEmpty()) {
            // If no priority passengers, dequeue from the regular queue
            return passengersQueue.poll();
        } else {
            return null; // No passengers left to serve
        }
    }
    private Passenger getPassengerById(String id) {
        // This method will look for a passenger with the given ID only in the passengersQueue
        // since priorityServicesQueue does not contain Passenger objects.

        for (Passenger passenger : passengersQueue) {
            if (passenger.getId().equals(id)) {
                return passenger;
            }
        }

        // If the passenger is not found in the regular queue, 
        // it implies they are not present or already served if they were in priority.
        return null; // Passenger not found
    }

    public Luggage getTopLuggage() {
        // Logic to view the top luggage without popping
        if (!luggageStack.isEmpty()) {
            return luggageStack.peek(); // View the top luggage in the stack
        }
        return null; // No luggage in the stack
    }
}
