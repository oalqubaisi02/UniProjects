/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policesystem;

/**
 *
 * @author omar
 */
public class User {
    
    public String Role;
    public String Name;
    public int EID;
    public String Username;
    public String Password;
    
    public User(String Role, String Name, int EID, String Username, String Password){
        this.Role = Role;
        this.Name = Name;
        this.EID = EID;
        this.Username = Username;
        this.Password = Password;
    }

    public String getRole(){
        return Role;
    }
    
    public void setRole(String Role){
        this.Role = Role;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
