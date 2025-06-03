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
public class Passenger {
    private String id;
    private String name;
    private TicketClass ticketClass;
    private int luggageCount;
    private int priorityScore;
    
    public Passenger(String id, String name, TicketClass ticketClass, int luggageCount) {
        this.id = id;
        this.name = name;
        this.ticketClass = ticketClass;
        this.luggageCount = luggageCount;
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public void setLuggageCount(int luggageCount) {
        this.luggageCount = luggageCount;
    }
}

enum TicketClass {
    ECONOMY, BUSINESS, FIRST_CLASS
}