package Execution;

import Definition.Branch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {
    private static final int DEPOSIT_MONEY = 1;
    private static final int WITHDRAW_MONEY = 2;
    private static final int CHECK_TRANSACTION_HISTORY = 3;
    private static final int CREATE_ACCOUNT = 4;
    private static final int CHANGE_PIN = 5;
    private static final int FORGOT_PIN = 6;
    private static final int FORGOT_ACCOUNT_NUMBER = 7;
    private static final int EXIT = 8;

    public static void main(String[] args) {
        Branch b = new Branch("Kamla Nagar");
        Scanner scannerObject = new Scanner(System.in);
        int clientInput;
        do{
            System.out.println("-=-=--=-=-=-=-=-=-"+ "WELCOME" + "-=-=--=-=-=-=-=-=-");
            System.out.println("How may I help you today?\n" + "1. Deposit Money.\n" + "2. Withdraw Money.\n" +
                    "3. Check Transaction History(Passbook).\n" + "4. Create Account. \n" + "5. Change Pin Number.\n" +
                    "6. Forgot Account Number ?\n" + "7. Forgot Pin Number ?\n" + "8. Exit");
            try{
                clientInput = scannerObject.nextInt();
            }
            catch (InputMismatchException i) {
                clientInput = 0;
                scannerObject.nextLine();
            }
            switch (clientInput) {
                case DEPOSIT_MONEY :
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter Your Account Number : ");
                    try {
                        long accountNumber = scanner.nextLong();
                        System.out.println("Enter 4-Digit Pin : ");
                        int pinNumber = scanner.nextInt();
                        System.out.println("Enter Amount That You Want To Deposit : ");
                        double amount = scanner.nextDouble();
                        b.addMoney(accountNumber,pinNumber,amount);
                    } catch (Exception e) {
                        System.out.println("Enter Details Properly.");
                    }

                    break;
                case WITHDRAW_MONEY :
                    scanner = new Scanner(System.in);
                    try {
                        System.out.println("Enter Your Account Number : ");
                        long accountNumber = scanner.nextLong();
                        System.out.println("Enter 4-Digit Pin : ");
                        int pinNumber = scanner.nextInt();
                        System.out.println("Enter Amount That You Want To Deposit : ");
                        double amount = scanner.nextDouble();
                        b.takeMoney(accountNumber, pinNumber, amount);
                    } catch (Exception e) {
                        System.out.println("ENTER DETAILS PROPERLY");
                    }
                    break;
                case CHECK_TRANSACTION_HISTORY :
                    scanner = new Scanner(System.in);
                    try {
                        System.out.println("Enter Your Account Number : ");
                        long accountNumber = scanner.nextLong();
                        System.out.println("Enter 4-Digit Pin : ");
                        int pinNumber = scanner.nextInt();
                        b.printTransactionHistory(accountNumber, pinNumber);
                    } catch (Exception e) {
                        System.out.println("ENTER DETAILS PROPERLY");
                    }
                    break;
                case CREATE_ACCOUNT:
                    scanner = new Scanner(System.in);
                    System.out.println("Enter Your Name : ");
                    String customerName = scanner.nextLine();
                    try{
                        System.out.println("Enter Your Mobile Number : ");
                        long mobileNumber = scanner.nextLong();
                        b.addCustomer(customerName,mobileNumber);
                    } catch (InputMismatchException i) {
                        System.out.println("Enter Correct Phone Number.");
                    }
                    break;
                case CHANGE_PIN:
            }
        }while(clientInput != EXIT);
    }
}
