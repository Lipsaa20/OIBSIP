import java.util.ArrayList;
import java.util.Scanner;

class ATMachine {
    private static ArrayList<String> transactionHistory = new ArrayList<>();
    private static int bal = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO THE ATM!");
        System.out.print("Type your USER ID: ");
        sc.nextLine();

        System.out.print("Type your USER PIN: ");
        sc.nextLine();

        System.out.println("LOGIN SUCCESSFUL!");
        mainMenu();
    }

    private static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    tranHistory();
                    break;
                case 2:
                    withdrawExecute();
                    break;
                case 3:
                    depositExecute();
                    break;
                case 4:
                    transferExecute();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("It's Invalid! Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private static void tranHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static void withdrawExecute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        int amt = sc.nextInt();

        if (amt > 0 && amt <= bal) {
            bal -= amt;
            transactionHistory.add("Withdraw: " + amt);
            System.out.println("Withdrawal successful. Current balance: " + bal);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private static void depositExecute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        int amt = sc.nextInt();

        if (amt > 0) {
            bal += amt;
            transactionHistory.add("Deposit: " + amt);
            System.out.println("Deposit successful. Current balance: " + bal);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void transferExecute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter recipient's account number: ");
        String recipientAccount = sc.nextLine();

        System.out.print("Enter amount to transfer: ");
        int amt = sc.nextInt();

        if (amt > 0 && amt <= bal) {
            bal -= amt;
            transactionHistory.add("Transfer: " + amt + " to " + recipientAccount);
            System.out.println("Transfer successful. Current balance: " + bal);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}