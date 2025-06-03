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
public class PriorityServices {
    private String id;
    private int priorityScore;

    public PriorityServices(String id, int priorityScore) {
        this.id = id;
        this.priorityScore = priorityScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(int priorityScore) {
        this.priorityScore = priorityScore;
    }
}
