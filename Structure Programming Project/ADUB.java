import java.util.Scanner;

public class ADUB {
    public static Scanner input = new Scanner(System.in);
    public static int[] IDs = new int[10];
    public static String[] PINs = new String[10];
    public static double balance[] = new double[10];
    public static int loginAcc;

    public static void main(String[] args) {
        System.out.println("Welcome to Abu Dhabi University Bank\n");
        System.out.println("1) Sign up\n2) Login\n3) Exit");
        System.out.println("=======================================");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                signup();
                main(args);
                break;
            case 2:
                if(login()){
                    menu(args);
                }else{
                    main(args);
                }
                break;
            case 3:
                System.out.println("\nThank you for using Abu Dhabi University Bank!");
                System.exit(0);
            default:
                System.out.println("\nInvalid choice, please try again");
                System.out.println("=======================================\n");
                main(args);
                break;
        }
    }
    
    public static void menu(String[] args){
        while(true){
            System.out.println("=======================================");
            System.out.println("Menu:\n");
            System.out.println("1) View balance");
            System.out.println("2) Deposit money");
            System.out.println("3) Withdraw money");
            System.out.println("4) Transfer money");
            System.out.println("5) Delete account");
            System.out.println("6) Logout");
            System.out.println("=======================================");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    System.out.print("\nPlease enter the deposit amount: ");
                    double depositAmount = input.nextDouble();
                    depositMoney(depositAmount);
                    break;
                case 3:
                    System.out.print("\nPlease enter the withdrawal amount: ");
                    double withdrawAmount = input.nextDouble();
                    withdrawMoney(withdrawAmount);
                    break;
                case 4:
                    System.out.print("\nPlease enter the recipient acount number: ");
                    int recipient = input.nextInt();
                    int recipientIndex = accountIndex(recipient);
                    if(recipientIndex != -1){
                        System.out.print("Please enter the amount you want to transfer: ");
                        double amount = input.nextDouble();
                        transferMoney(recipientIndex, amount);
                    } else {
                        System.out.println("\nInvalid account number!");
                    }
                    break;
                case 5:
                    deleteAccount(args);
                    break;
                case 6:
                    System.out.println("\nYou've been logged out!");
                    System.out.println("=======================================");
                    main(args);
                    break;
                default:
                    System.out.println("\nInvalid choice, please try again");
                    break;
            }
        }
    }
    
    public static void signup(){
        input.nextLine();
        int index = emptyIndex(IDs);
        System.out.print("\nPlease enter your name: ");
        String name = input.nextLine();
        System.out.print("Please enter your gender: ");
        String gender = input.nextLine();
        System.out.print("Please enter your phone number: ");
        int phone = input.nextInt();
        int id = randomId();
        System.out.println("\nYour auto generated acccount number is " + id);
        input.nextLine();
        System.out.print("Please set your 4-digit PIN: ");
        String pin = input.nextLine();
        if (checkPin(pin)){
            IDs[index] = id;
            PINs[index] = pin;
            System.out.println("\nAccount created succefully!");
        }else{
            System.out.println("\nAccount was not created!");
        }
        System.out.println("=======================================");
    }
    
    public static boolean checkPin(String pin){
        for(int i = 0; i < pin.length(); i++){
            if(pin.charAt(i) >= '0' && pin.charAt(i) <= '9' && pin.length() == 4){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
    public static boolean login(){
        System.out.print("\nEnter your account number: ");
        int id = input.nextInt();
        int index = accountIndex(id);
        if (index != -1){
            input.nextLine();
            System.out.print("Enter your 4-digit PIN: ");
            String pin = input.nextLine();
            if (PINs[index].equals(pin)){
                loginAcc = id;
                System.out.println("\nLogin successful!");
                return true;
            }
        }
        System.out.println("\nIncorrect login");
        System.out.println("=======================================");
        return false;
    }
    
    public static double viewBalance(){
        int index = accountIndex(loginAcc);
        System.out.println("\nYour have " + balance[index] + " AED in your account");
        return balance[index];
    }
    
    public static void depositMoney(double amount){
        int index = accountIndex(loginAcc);
        if(amount > 0){
            balance[index] += amount;
            System.out.println("\nThe amount has been successfully deposited to your account!");
        }else{
            System.out.println("\nTransaction failed!");
        }
    }
    
    public static void withdrawMoney(double amount){
        int index = accountIndex(loginAcc);
        if(amount <= balance[index] && amount > 0){
            balance[index] -= amount;
            System.out.println("The amount has been successfully withdrawn from your account!");
        }else{
            System.out.println("\nTransaction failed!");
        }
    }
    
    public static void transferMoney(int recipientIndex, double amount){
    	int index = 0;
        for(int i = 0 ; i < IDs.length ; i++){
            if(IDs[i] == loginAcc){
                index = i;
                break;
            }
            else{
                continue;
            }
        }
        if(amount <= balance[index] && amount > 0){
            balance[index] -= amount;
            balance[recipientIndex] += amount;
                System.out.println("\nThe amount has been successfully transferred!");
        }else{
            System.out.println("\nTransaction failed!");
        }
    }
    
    public static void deleteAccount(String[] args){
        System.out.println("\nARE YOU SURE YOU WANT TO DELETE YOUR ACCOUNT?");
        System.out.println("1) Yes\n2) No");
        System.out.println("=======================================");
        int confirmation = input.nextInt();
        switch (confirmation){
            case 1:
                int index = accountIndex(loginAcc);
                IDs[index] = 0;
                PINs[index] = null;
                balance[index] = 0;
                System.out.println("\nAccount deleted successfully!");
                System.out.println("=======================================");
                main(args);
                break;
            case 2:
                System.out.println("\nDeletion canceled!");
                break;
            default:
                System.out.println("\nInvalid choice, please try again");
                break;
        }
    }
    
    public static int accountIndex(int id){
        for(int index = 0 ; index < IDs.length ; index++){
            if(IDs[index] == id){
                return index;
            }
        }
        return -1;
    }
    
    public static int emptyIndex(int IDs[]){
        for(int index = 0 ; index < IDs.length ; index++){
            if(IDs[index] == 0){
                return index;
            }
        }
        return -1;
    }
    
    public static int randomId(){
        int id = (int)(Math.random() * 900000) + 100000;
        if(isUnique(id)){
            return id;
            
        }else{
            randomId();
        }
        return -1;
    }
    
    public static boolean isUnique(int num){
        for(int index = 0 ; index < IDs.length ; index++){
            if(IDs[index] == num){
                return false;
            }
        }
        return true;
    }
}
