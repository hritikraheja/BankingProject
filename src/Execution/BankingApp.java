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
        }while(clientInput != EXIT);
    }
}
