/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policesystem;

/**
 *
 * @author omar
 */
public class Report {
    private int CivilianID;
    private String Type;
    private String Description;

    public Report(int CivilianID, String Type, String Description) {
        this.CivilianID = CivilianID;
        this.Type = Type;
        this.Description = Description;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}
