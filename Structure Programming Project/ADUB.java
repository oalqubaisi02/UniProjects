/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adub;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author omar
 */
public class ADUB {
    public static Scanner information;
    public static int acounts[] = new int[10]; //array for account numbers
    public static int pin[] = new int[10]; //array for pins
    public static String names[] = new String[10]; //array for names
    public static int numbers[] = new int[10]; //array for phone numbers
    public static double salary[] = new double[10]; //array for salary
    public static String gender[] = new String[10]; //array for genders
    public static double balance[] = new double[10]; //array for balance 
    public static int trans[] = new int[100]; //array for transactions
    public static double loanPerc = 10; //the percent of loan for example if salary is 1000 then loan = 1000*10 = 10000 AED
    public static int loginAcc = 0 ; //intial acount number
    public static int pass = 1 ; //intial pin code
    public static int ipin;

    public static void main(String[] args) {
        information = new Scanner(System.in);
        //welcome message
        System.out.println("\nWelcome To Abu Dhabi University Bank \n\n");
        System.out.println("1-Sign up \t 2-Login");
        int opt = information.nextInt();
        if(opt == 1){
            //create new account and then redirect you back to login
            int x = createAccount();
            main(args);
        }
        if(opt == 2){
            if(login()){
                //after login will open menu 
                int opt2 =1;
                while(opt2 != 0){
                    System.out.println("\n==========================================");
                    System.out.println("Menu:\n");
                    System.out.println("1-View balance");
                    System.out.println("2-Deposit");
                    System.out.println("3-Withdraw");
                    System.out.println("4-Loan");
                    System.out.println("5-Delete Account");
                    System.out.println("6-Logout");
                    System.out.println("==========================================");
                    System.out.println("Please select an option:");
                    opt2=information.nextInt();
                    switch(opt2){
                        //switch for the selection from the menu
                    case 1:getBalance(loginAcc);
                           break;    
                    case 2:System.out.println("Enter an amout you want to deposit:");
                           Deposit(information.nextDouble(),loginAcc);
                           break;
                    case 3:System.out.println("Enter an amout you want to withdraw:");
                           withDraw(information.nextDouble(),loginAcc);
                           break;
                    case 4:System.out.println("Enter an amount for loan:");
                           getLoan(information.nextDouble(),loginAcc);
                           break;
                    case 5:System.out.println("ARE YOU SURE? \n1-yes , 2-no");
                           int oo = information.nextInt();
                           if(oo==1){
                                delete();
                                main(args);
                                break;
                            }
                           
                    case 6:opt=0;
                           main(args);
                           break;       
                    }
                }
            }else{
                System.out.println("Sorry Invalid Login");
                main(args);
            }
        }
    }
    public static int createAccount(){
        //this method is for creating an new account and will store all your info in arrays
        System.out.println("\n==========================================");
        System.out.print("Please enter your name: ");
        int index = returnnullIndex(names);
        names[index] = information.next();
        System.out.print("Please enter your phone number: ");
        numbers[index] = information.nextInt();
        System.out.print("Please enter your salary: ");
        salary[index] = information.nextDouble();
        System.out.print("Please enter your gender: ");
        gender[index] = information.next();
        int acnum = getAccountNum();
        acounts[index]=acnum;
        System.out.println("==========================================");
        System.out.println("Your acccount number is: " + acnum);
        System.out.print("Please set your pin (Numbers only): ");
        ipin = information.nextInt();
        pin[index] = ipin;
        System.out.println("==========================================");
        return 0;
    }
    public static boolean login(){
        //this method is for login
        int an;
        int pins;
        System.out.println("Enter your account number:");
        an = information.nextInt();
        int index = returnIndexForAcount(an);
        if (acounts[index] == an){
            //if account exist it will ask for pin
            System.out.println("Enter your pin: ");
            int p = information.nextInt();
            if (p == ipin){
                //if pin enterd correspondence with user pin you will login
                loginAcc = an;
                return true;
            }
        }
        return false;
    }
    public static double getBalance(int accnum){
        //this method is to view your balance
        System.out.println("Your balance is "+balance[returnIndexForAcount(accnum)]+" AED");
        return balance[returnIndexForAcount(accnum)];
    }
    public static void Deposit(double amount , int accnum){
        //this method will add the amount you entered to your balance
        balance[returnIndexForAcount(accnum)] += amount;
        System.out.println("You have deposited " + amount + " AED");
    }
    public static void withDraw(double amount , int accnum){
        //this method is for withdraw
        double bal = balance[returnIndexForAcount(accnum)];
        if(amount<= bal){
            //if you had enough money in your account then it will be deducted from your balance
            balance[returnIndexForAcount(accnum)] -= amount;
            System.out.println("You have withdraw " + amount + " AED");
        }else{
            //if you didnt have enogh money then the transaction wont be done
            System.out.println("Sorry your Balance not enough for transaction");
        }
    }
    public static void getLoan(double amount , int accnum){
        //this method is for the loan
        if((amount/loanPerc)<=salary[returnIndexForAcount(accnum)]){
            //if the amount you entered gets approved by the bank the it will be added to your balance
            //example: if your salary is 1000 the the maximum load you can get is 10000 (1000*10)
            balance[returnIndexForAcount(accnum)] += amount;
            System.out.println(amount + " AED loan have been approved and credited to your account");
        }else{
            //and if its more than 10000 then your request will be rejected
            System.out.println("Sorry You Cant get this loan");
        }
    }
    public static boolean delete(){
        //this method deletes your account and all your information
        int an  = 0;
        System.out.println("Enter yout account number for confirmation:");
        an = information.nextInt();  
        int index = returnIndexForAcount(an);
        acounts[index] = 0;
        pin[index] = 0 ;
        names[index]=null;
        return true;
    }
    public static int returnIndexForAcount(int accnum){
        //this mathod search for acount and return the indx of acccount number from array
        for(int i =0 ; i<acounts.length ; i++){
            if(acounts[i] == accnum){
                return i;
            }
        }
        return 0;
    }
    public static int returnnullIndex(int x[]){
        //this mathod get index of empty place in array of int
        for(int i =0 ; i<x.length ; i++){
            if(x[i] ==0){
                return i;
            }
        }
        return 0;
    }
    public static int returnnullIndex(String x[]){
        for(int i =0 ; i<x.length ; i++){
            if(x[i] == null){
                return i;
            }
        }
        return 0;
    }
    public static int getAccountNum() {
        //It will generate 6 digit random Number
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        int num = Integer.valueOf(String.format("%06d", number).trim());
        if(!isAccountNumUnique(num)){
            //if the account number is taken it will generate a new account number
            getAccountNum();
        }
        return num;
    }
    public static boolean isAccountNumUnique(int num){
        for(int i =0 ; i<acounts.length ; i++){
            if(acounts[i] == num){
                return false;
            }
        }
        return true;
    }
}
