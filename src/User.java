import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class User {
    String user_name;
    String user_password;
    int user_acc_number;
    long user_cont_number;
    long user_cnic;
    String user_email;
    int user_acc_balance;
    LocalDate dateCreated;

    public User() {
        user_name = " ";
        user_password = " ";
        user_acc_number = 0;
        user_cont_number = 0L;
        user_cnic = 0L;
        user_email = " ";
        user_acc_balance = 0;
        dateCreated = LocalDate.now();
    }

    public static User userData(String userName) throws IOException {
        String directory = "D:\\BankingApplication\\users";
        String filePath = directory + "\\" + userName + ".txt";
        User user = new User();

        try (Scanner reader = new Scanner(new FileInputStream(filePath))) {
            user.user_name = reader.nextLine();
            user.user_password = reader.nextLine();
            user.user_acc_number = reader.nextInt();
            user.user_cont_number = Long.parseLong(reader.nextLine());
            user.user_cnic = Long.parseLong(reader.nextLine());
            user.user_email = reader.nextLine();
            user.user_acc_balance = reader.nextInt();
            user.dateCreated = LocalDate.parse(reader.nextLine()); // Assuming the date is stored in the correct format
        }

        return user;
    }

    public static User sign_in() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter your user name: ");
                String userName = input.nextLine();
                String[] user_name_array = userName.split("\\s");
                String user_name = user_name_array[0] + "_" + user_name_array[1];
                String directory = "D:\\BankingApplication\\users";
                String filePath = directory + "\\" + user_name + ".txt";

                FileInputStream fin = new FileInputStream(filePath);
                Scanner reader = new Scanner(fin);

                // Read data from file
                String storedUserName = reader.nextLine();
                String storedPassword = reader.nextLine();
                reader.close();

                System.out.println("Enter your password: ");
                String pass = input.nextLine();
                
                if (pass.equals(storedPassword)) {
                    User u1 = User.userData(user_name);
                    System.out.println("Welcome " + userName);
                    return u1;
                } else {
                    System.out.println("Incorrect password. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Something went wrong. Try again.");
                input.nextLine(); // consume the leftover invalid input
            } catch (IOException e) {
                System.out.println("Invalid input or user does not exist!");
            }
        }
    }

    public static void viewUserDetails(Scanner input) {
        System.out.println("Enter the username to view details (format: Firstname Lastname): ");
        String userName = input.nextLine();
        String[] user_name_array = userName.split("\\s");
        String user_name = user_name_array[0] + "_" + user_name_array[1];

        String directory = "D:\\BankingApplication\\users";
        String filePath = directory + "\\" + user_name + ".txt";

        try {
            User user = userData(user_name);
            System.out.println("User Details:");
            System.out.println("Name: " + user.user_name);
            System.out.println("Account Number: " + String.format("%05d", user.user_acc_number));
            System.out.println("Contact Number: " + user.user_cont_number);
            System.out.println("CNIC: " + user.user_cnic);
            System.out.println("Email: " + user.user_email);
            System.out.println("Account Balance: " + String.format("%05d", user.user_acc_balance));
            System.out.println("Account Created on: " + user.dateCreated);
        } catch (IOException e) {
            System.out.println("User does not exist or an error occurred while reading the user details.");
        }
    }

    @Override
    public String toString() {
        String formattedAccNumber = String.format("%05d", user_acc_number); // Format account number with leading zeros
        String formattedAccBalance = String.format("%05d", user_acc_balance); // Format account balance with leading zeros

        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_acc_number=" + formattedAccNumber +
                ", user_cont_number=" + user_cont_number +
                ", user_cnic=" + user_cnic +
                ", user_email='" + user_email + '\'' +
                ", user_acc_balance=" + formattedAccBalance +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
