/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policesystem;

/**
 *
 * @author omar
 */
public class Police extends User{
    
    public int PID;
    public String Rank;
    
    public Police(String Role, String Name, int EID, String Username, String Password,
                  int PID, String Rank){
        super(Role, Name, EID, Username, Password);
        this.PID = PID;
        this.Rank = Rank;
    }
    
    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }
    
}
