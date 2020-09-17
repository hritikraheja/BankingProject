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
    private static final int FORGOT_PIN = 7;
    private static final int FORGOT_ACCOUNT_NUMBER = 6;
    private static final int EXIT = 8;

    public static void main(String[] args) {
        Branch b = new Branch();
        System.out.println(b.toString());
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
                    if(b.getNumberOfCustomers() == 0) {
                        System.out.println("Create An Account First.");
                        break;
                    }
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter Your Account Number : ");
                    try {
                        long accountNumber = scanner.nextLong();
                        System.out.println("Enter 4-Digit Pin : ");
                        int pinNumber = scanner.nextInt();
                        System.out.println("Enter Amount That You Want To Deposit : ");
                        double amount = scanner.nextDouble();
                        b.addMoney(accountNumber, pinNumber, amount);
                    } catch (Exception e) {
                        System.out.println("Account Number And Password Didn't Matched");
                    }

                    break;
                case WITHDRAW_MONEY :
                    if(b.getNumberOfCustomers() == 0) {
                        System.out.println("Create An Account First.");
                        break;
                    }
                    scanner = new Scanner(System.in);
                    try {
                        System.out.println("Enter Your Account Number : ");
                        long accountNumber = scanner.nextLong();
                        System.out.println("Enter 4-Digit Pin : ");
                        int pinNumber = scanner.nextInt();
                        System.out.println("Enter Amount That You Want To Withdraw : ");
                        double amount = scanner.nextDouble();
                        b.takeMoney(accountNumber, pinNumber, amount);
                    } catch (Exception e) {
                        System.out.println("Account Number And Password Didn't Matched");
                    }
                    break;
                case CHECK_TRANSACTION_HISTORY :
                    if(b.getNumberOfCustomers() == 0) {
                        System.out.println("Create An Account First.");
                        break;
                    }
                    scanner = new Scanner(System.in);
                    try {
                        System.out.println("Enter Your Account Number : ");
                        long accountNumber = scanner.nextLong();
                        System.out.println("Enter 4-Digit Pin : ");
                        int pinNumber = scanner.nextInt();
                        b.printTransactionHistory(accountNumber, pinNumber);
                    } catch (Exception e) {
                        System.out.println("Account Number And Password Didn't Matched");
                    }
                    break;
                case CREATE_ACCOUNT:
                    scanner = new Scanner(System.in);
                    System.out.println("Enter Your Name : ");
                    String customerName = scanner.nextLine();
                    try{
                        System.out.println("Enter Your Mobile Number : ");
                        long mobileNumber = scanner.nextLong();
                        long accountNumber = b.addCustomer(customerName,mobileNumber);
                        System.out.println("Minimum Account Balance Is 1000Rs \n Add Some Money To Your Account(More Than 1000Rs) : ");
                        System.out.println("Enter The Amount That You Want To Add : ");
                        double money = scanner.nextDouble();
                        b.addMoney(accountNumber,1234,money);
                        System.out.println(" Your Account Balance : " + money);

                    } catch (InputMismatchException i) {
                        System.out.println("Enter Details Properly.");
                    }
                    break;
                case CHANGE_PIN:
                    if(b.getNumberOfCustomers() == 0) {
                        System.out.println("Create An Account First.");
                        break;
                    }
                    scanner = new Scanner(System.in);
                    System.out.println("Enter Your Name : ");
                    customerName = scanner.nextLine();
                    System.out.println("Enter Your Account Number : ");
                    try{
                        long accountNumber = scanner.nextLong();
                        System.out.println("Enter The Pin That You Want To Set :");
                        int pinNumber = scanner.nextInt();
                        b.changePin(customerName,accountNumber,pinNumber);
                    } catch (InputMismatchException i) {
                        System.out.println("Account Number And Name Didn't Matched.");
                    }
                    break;
                case FORGOT_PIN:
                    if(b.getNumberOfCustomers() == 0) {
                        System.out.println("Create An Account First.");
                        break;
                    }
                    scanner = new Scanner(System.in);
                    System.out.println("ENTER YOUR NAME");
                    customerName = scanner.nextLine();
                    try{
                        System.out.println("Enter Your Account Number : ");
                        long accountNumber = scanner.nextLong();
                        b.givePinNumber(accountNumber,customerName);
                    } catch (InputMismatchException i) {
                        System.out.println("Account Number And Name Didn't Matched");
                    }
                    break;
                case FORGOT_ACCOUNT_NUMBER :
                    if(b.getNumberOfCustomers() == 0) {
                        System.out.println("Create An Account First.");
                        break;
                    }
                    scanner = new Scanner(System.in);
                    customerName = scanner.nextLine();
                    try {
                        System.out.println("Enter Your Mobile Number : ");
                        long mobileNumber = scanner.nextLong();
                        b.giveAccountNumber(customerName,mobileNumber);
                    } catch (InputMismatchException i) {
                        System.out.println("Enter Details Properly.");
                    }
                case EXIT:
                    System.out.println("Exited Successfully.");
                    break;
                default:
                    System.out.println("Enter Only Between (1-8)");
            }
        }while(clientInput != EXIT);
    }
}