/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airlinecheckinsystem_sec2_g15;
import java.util.*;

/**
 *
 * @author omar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AirlineCheckInSystem checkInSystem = new AirlineCheckInSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Airline Check-In System Menu:");
            System.out.println("1. Register Passenger");
            System.out.println("2. Enqueue Priority Passenger");
            System.out.println("3. Push Luggage");
            System.out.println("4. Dequeue Passenger");
            System.out.println("5. Pop Luggage");
            System.out.println("6. View Next Passenger");
            System.out.println("7. View Top Luggage");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            System.out.println("\n--------------------------------");
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Passenger ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Ticket Class (ECONOMY, BUSINESS, FIRST_CLASS): ");
                    String ticketClassStr = scanner.nextLine();
                    TicketClass ticketClass;
                    
                    try {
                        ticketClass = TicketClass.valueOf(ticketClassStr.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid ticket class. Please enter ECONOMY, BUSINESS, or FIRST_CLASS.");
                        System.out.println("\n--------------------------------");
                        continue; // Restart the loop
                    }

                    System.out.print("Enter Luggage Count: ");
                    int luggageCount = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    
                    scanner.nextLine(); // Consume newline left-over

                    // Create a Passenger object and register it
                    Passenger passenger = new Passenger(id, name, ticketClass, luggageCount);
                    checkInSystem.enqueuePassenger(passenger);
                    System.out.println("\n--------------------------------");
                    break;
                case 2:
                    System.out.print("Enter Passenger ID: ");
                    String ppid = scanner.nextLine();
                    System.out.print("Enter Priority Score: ");
                    int priorityScorep = scanner.nextInt();
                      checkInSystem.enqueuePriorityPassenger(ppid,priorityScorep);
                    System.out.println("\n--------------------------------");
                    break;
                case 3:
                    System.out.print("Enter Luggage ID: ");
                    String luggageId = scanner.nextLine();
                    System.out.print("Enter Passenger ID: ");
                    String passengerId = scanner.nextLine();
                    System.out.print("Enter Luggage Weight: ");
                    double luggageWeight = scanner.nextDouble();
                    System.out.print("Enter Luggage Length: ");
                    double luggageLength = scanner.nextDouble();
                    System.out.print("Enter Luggage Width: ");
                    double luggageWidth = scanner.nextDouble();
                    System.out.print("Enter Luggage Height: ");
                    double luggageHeight = scanner.nextDouble();

                    // Create a Luggage object and push it onto the luggage stack
                    Luggage luggage = new Luggage(luggageId, passengerId, luggageWeight, luggageLength, luggageWidth, luggageHeight);
                    checkInSystem.pushLuggage(luggage);
                    System.out.println("\n--------------------------------");
                    break;
                case 4:
                    // Dequeue the next passenger and display their details
                    Passenger dequeuedPassenger = checkInSystem.dequeuePassenger();
                    if (dequeuedPassenger != null) {
                        System.out.println("Dequeued Passenger:");
                        System.out.println("Name: " + dequeuedPassenger.getName());
                        System.out.println("Ticket Class: " + dequeuedPassenger.getTicketClass());
                        System.out.println("\n--------------------------------");
                    } else {
                        System.out.println("No passengers to dequeue.");
                        System.out.println("\n--------------------------------");
                    }
                    break;
                case 5:
                    // Pop the top luggage and display its details
                    Luggage poppedLuggage = checkInSystem.popLuggage();
                    if (poppedLuggage != null) {
                        System.out.println("Popped Luggage:");
                        System.out.println("ID: " + poppedLuggage.getId());
                        System.out.println("Passenger ID: " + poppedLuggage.getPassengerId());
                        System.out.println("\n--------------------------------");
                    } else {
                        System.out.println("No luggage to pop.");
                        System.out.println("\n--------------------------------");
                    }
                    break;
                case 6:
                    // View the next passenger without dequeuing and display their details
                    Passenger nextPassenger = checkInSystem.getNextPassenger();
                    if (nextPassenger != null) {
                        System.out.println("Next Passenger:");
                        System.out.println("Name: " + nextPassenger.getName());
                        System.out.println("Ticket Class: " + nextPassenger.getTicketClass());
                        System.out.println("\n--------------------------------");
                    } else {
                        System.out.println("No passengers in the queue.");
                        System.out.println("\n--------------------------------");
                    }
                    break;
                case 7:
                    // View the top luggage without popping and display its details
                    Luggage topLuggage = checkInSystem.getTopLuggage();
                    if (topLuggage != null) {
                        System.out.println("Top Luggage:");
                        System.out.println("ID: " + topLuggage.getId());
                        System.out.println("Passenger ID: " + topLuggage.getPassengerId());
                        System.out.println("\n--------------------------------");
                    } else {
                        System.out.println("No luggage in the stack.");
                        System.out.println("\n--------------------------------");
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.out.println("\n--------------------------------");
                    scanner.close(); // Close the scanner before exiting
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    System.out.println("\n--------------------------------");
            }
        }
    }
}