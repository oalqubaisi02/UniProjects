/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policesystem;

/**
 *
 * @author omar
 */
public class Fine {
    private int CivilianID;
    private String Type;
    private double Fee;

    
    public Fine(int CivilianID, String Type, double Fee) {
        this.CivilianID = CivilianID;
        this.Type = Type;
        this.Fee = Fee;
    }

    public int getCivilianID() {
        return CivilianID;
    }

    public void setCivilianID(int CivilianID) {
        this.CivilianID = CivilianID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getFee() {
        return Fee;
    }

    public void setFee(double Fee) {
        this.Fee = Fee;
    }
}
