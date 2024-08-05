import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Functions {
    public static void sign_up() {
        Scanner input = new Scanner(System.in);
        LocalDate currentDate = LocalDate.now();
        int count = 0;
        while (true) {
            try {
                count++;
                // first name
                System.out.println("Enter your first name: ");
                String first_name = input.nextLine();
                // last name
                System.out.println("Enter your last name: ");
                String last_name = input.nextLine();
                // user name
                String user_name = first_name + "_" + last_name;
                String userName = first_name + " " + last_name;
                // password
                System.out.println("Set a password for your account: ");
                String password = input.nextLine();
                // cnic
                System.out.println("Enter your CNIC without hyphens: ");
                long cnic = Long.parseLong(input.nextLine()); // parse after reading line
                // contact number
                System.out.println("Enter your contact number: ");
                long contact_number = Long.parseLong(input.nextLine()); // parse after reading line
                // email
                System.out.println("Enter your email: ");
                String email = input.nextLine();
                // acc number
                int account_number = count;
                int account_balance = 0;

                String directory = "D:\\BankingApplication\\users";
                String filePath = directory + "\\" + user_name + ".txt";
                File dir = new File(directory);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                FileOutputStream fout = new FileOutputStream(filePath);
                PrintStream ps = new PrintStream(fout);

                // writing data to file
                ps.println(userName);
                ps.println(password);
                ps.println(account_number);
                ps.println(contact_number);
                ps.println(cnic);
                ps.println(email);
                ps.println(account_balance);
                ps.println(currentDate);
                ps.close();
                System.out.println("Your account has been created. Please sign in again.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Something went wrong! Try again!");
                input.nextLine(); // consume the leftover invalid input
            } catch (IOException e1) {
                System.out.println("Invalid Input!");
            }
        }
    }
}
