/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package policesystem;
import java.util.*;
/**
 *
 * @author omar
 */
public class PoliceSystem {
    
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Civilian> Civilians = new ArrayList<>();
    private static ArrayList<Police> Policemen = new ArrayList<>();
    private static ArrayList<Fine> Fines = new ArrayList<>();
    private static ArrayList<Report> Reports = new ArrayList<>();
    
    public static void main(String[] args) {
        MainMenu();
    }
    
    public static void MainMenu(){
        
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Police System");
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            System.out.println("=========================================");
            System.out.print("Select one of the choices: ");
            int choice = input.nextInt();
        
            switch (choice) {
                
                case 1: Login(); break;
                case 2: Signup(); break;
                case 3: System.out.println("=========================================");
                        System.out.println("Exiting program.");
                        System.out.println("=========================================");
                        System.exit(0);
                        break;
                default: System.out.println("=========================================");
                         System.out.println("Invalid choice. Try again.");
                         System.out.println("=========================================");
            }
        }
    }
    
    public static void Signup() {
        
        Scanner input = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.print("Are you a policeman or civilian? ");
        String role = input.nextLine();
        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        System.out.print("Please enter your EID: ");
        int EID = input.nextInt();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Please enter username: ");
        String username = input2.nextLine();
        System.out.print("Please enter your password: ");
        String password = input2.nextLine();
        
        if ("policeman".equals(role)) {
            System.out.print("Please enter your police ID: ");
            int PID = input2.nextInt();
            Scanner input3 = new Scanner(System.in);
            System.out.print("Please enter your rank: ");
            String rank = input3.nextLine();
            Police police = new Police(role, name, EID, username, password, PID, rank);
            Policemen.add(police);
        }
        else if ("civilian".equals(role)){
            Civilian civilian = new Civilian(role, name, EID, username, password);
            Civilians.add(civilian);
        }
        else if(!"policeman".equals(role) || "civilian".equals(role)){
            System.out.println("Registration failed!");
            System.out.println("=========================================");
            Signup();
        }
        System.out.println("Account created successfully!");
        System.out.println("=========================================");
    }
    
    public static void Login(){
        
        Scanner input = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.print("Please enter your Username: ");
        String username = input.nextLine();
        System.out.print("Please enter your password: ");
        String password = input.nextLine();
        
        User user = SearchUsername(username, Civilians, Policemen);
        if (user.getPassword().equals(password)) {
            if (user instanceof Civilian) {
                System.out.println("=========================================");
                System.out.println("Logged in successfully! Welcome, " + username + "!\n");
                CivilianMenu();
            } else if (user instanceof Police) {
                System.out.println("=========================================");
                System.out.println("Logged in successfully! Welcome, " + username + "!\n");
                PoliceMenu();
            }
        } else {
            System.out.println("Incorrect password. Try again.");
            Login();
        }
    }
    
    public static User SearchUsername(String username, ArrayList<Civilian> Civilians, ArrayList<Police> Policemen) {
        
        for (Civilian civilian : Civilians) {
            if (civilian.getUsername().equals(username)) {
                return civilian;
            }
        }

        for (Police police : Policemen) {
            if (police.getUsername().equals(username)) {
                return police;
            }
        }
        return null;
    }
    
    public static void CivilianMenu(){
        while (true){
            System.out.println("Civilian Menu:");
            System.out.println("1. Check Fines");
            System.out.println("2. View laws");
            System.out.println("3. Logout");
            System.out.println("=========================================");
            System.out.print("Select one of the choices: ");
            int choice = input.nextInt();
        
            switch (choice) {
                case 1: CheckFines(); break;
                case 2: System.out.println("=========================================");
                        System.out.println("Laws:");
                        System.out.println("Speeding: Driving over the speed limit");
                        System.out.println("Engine modification: Modifying engine without permit");
                        System.out.println("Littering: Littering in a public place");
                        System.out.println("Jaywalking: Walking outside pedestrian lanes");
                        System.out.println("=========================================");
                        break;
                case 3: System.out.println("=========================================");
                        System.out.println("Logged out successfully!");
                        System.out.println("=========================================");
                        MainMenu(); break;
                default: System.out.println("=========================================");
                         System.out.println("Invalid choice. Try again.");
                         System.out.println("=========================================");
            }
        }
    }
    
    public static void PoliceMenu(){
        while (true){
            System.out.println("Police Menu:");
            System.out.println("1. Write Fine");
            System.out.println("2. Write report");
            System.out.println("3. View laws");
            System.out.println("4. Logout");
            System.out.println("=========================================");
            System.out.print("Select one of the choices: ");
            int choice = input.nextInt();
            
            switch (choice) {
                case 1: WriteFines(); break;
                case 2: WriteReports(); break;
                case 3: System.out.println("=========================================");
                        System.out.println("Laws:");
                        System.out.println("Speeding: Driving over the speed limit");
                        System.out.println("Engine modification: Modifying engine without permit");
                        System.out.println("Littering: Littering in a public place");
                        System.out.println("Jaywalking: Walking outside pedestrian lanes");
                        System.out.println("=========================================");
                        break;
                case 4: System.out.println("=========================================");
                        System.out.println("Logged out successfully!");
                        System.out.println("=========================================");
                        MainMenu(); break;
                default: System.out.println("=========================================");
                         System.out.println("Invalid choice. Try again.");
                         System.out.println("=========================================");
            }
        }
    }
    
    public static void CheckFines(){
        Scanner input6 = new Scanner(System.in);
        System.out.print("Please enter your EID: ");
        int EID = input6.nextInt();
        
        System.out.println("=========================================");
        System.out.println("You have no fines.");
        System.out.println("=========================================");
        CivilianMenu();
    }
    
    public static void WriteFines(){
        Scanner input4 = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.print("Please enter civilian EID: ");
        int EID = input4.nextInt();
        Scanner input5 = new Scanner(System.in);
        System.out.print("Please enter type of fine: ");
        String type = input5.nextLine();
        System.out.print("Please enter fine fee: ");
        double fee = input5.nextDouble();
        Fine fine = new Fine(EID, type, fee);
        System.out.println("Fine registered successfully!");
        System.out.println("=========================================");
        Fines.add(fine);
        PoliceMenu();
    }
    
    public static void WriteReports(){
        Scanner input = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.print("Please enter civilian EID: ");
        int EID = input.nextInt();
        Scanner input6 = new Scanner(System.in);
        System.out.print("Please enter type of incident: : ");
        String type = input6.nextLine();
        System.out.print("Please enter description of incident: ");
        String description = input6.nextLine();
        Report report = new Report(EID, type, description);
        System.out.println("Report registered successfully!");
        System.out.println("=========================================");
        Reports.add(report);
        PoliceMenu();
    }
}
