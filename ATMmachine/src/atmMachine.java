import java.util.Scanner;

public class atmMachine {

    // Initialize account balance
    private static double balance = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display welcome message
        System.out.println("Welcome to the ATM!");

        // Infinite loop for ATM functionality
        while (true) {
            // Display menu options
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");

            // Read user input
            int choice = scanner.nextInt();

            // Perform action based on user choice
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney(scanner);
                    break;
                case 3:
                    depositMoney(scanner);
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    // Method to check account balance
    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Method to withdraw money from account
    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient funds. Please enter a smaller amount.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
        }
    }

    // Method to deposit money into account
    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful. Your new balance is: $" + balance);
    }
}
