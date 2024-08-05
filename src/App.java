import java.util.*;
import java.time.LocalDate;
//import java.io.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        LocalDate currentDate = LocalDate.now();
        try{
        System.out.println("Welcome to Meezan Bank!");
        System.out.println("Press 1 to Sign up or press 2 to Sign in.");
        int choice = input.nextInt();
        if (choice == 1)
            Functions.sign_up();
        else if (choice == 2){
            User u1 = User.sign_in();
            System.out.println("How can we help you?");
            System.out.println("1. View account balance.");
            System.out.println("2. Cash Withdrawl");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Bank Transfer");
            System.out.println("5. RAAST Transfer ");
            System.out.println("6. Utility Bills");
            System.out.println("7. View User Details");
            System.out.println("8. Change Password");
            System.out.println("9. Exit");
            int choice1 = input.nextInt();
            switch (choice1) {
                case 1:
                    
                    break;
                
                case 2:

                    break;

                case 3:

                    break;
                
                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:
                    System.out.println("Name: "+u1.user_name);
                    System.out.println("Password: "+u1.user_password);
                    System.out.printf( "Account Number: " +u1.user_acc_number);
                    System.out.println("Contact Number: "+u1.user_cont_number);
                    System.out.println("CNIN: "+u1.user_cnic);
                    break;

                case 8:

                    break;

                case 9:

                    break;
                default:
                    System.out.println("Invalid choice. Try again or enter 9 to exit.");
            }
            }
        }    
        catch(Exception e){
            System.out.println("Invalid choice");
            }
        
    }
}