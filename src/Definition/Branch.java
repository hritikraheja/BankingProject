package Definition;

public class Branch {
    public Customer[] customers = new Customer[100];
    private int numberOfCustomers = 0;

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    private long generateAccountNumber(){
        return (long) 1469000350 + numberOfCustomers;
    }

    /**
     * This method adds a new customer to the Customer array.
     *
     * @param newCustomerName Name of new Customer.
     * @param mobileNumber Mobile Number Of new Customer.
     */
    public long addCustomer(String newCustomerName, long mobileNumber) {
        long accountNumber = generateAccountNumber();
        customers[numberOfCustomers] = new Customer(newCustomerName, mobileNumber, accountNumber);
        numberOfCustomers++;
        System.out.println("Your Account Is Created Successfully.\nYour Account Number Is : " + accountNumber);
        System.out.println("Pin For Your ACCOUNT IS " + 1234);
        System.out.println("Do Not Share This Pin With AnyOne And Change This As Soon As Possible");
        return accountNumber;
    }

    /**
     * This method prints the account number of the Customer, if forgotten.
     *
     * @param customerName Name of the Customer.
     * @param mobileNumber Mobile Number of the Customer.
     */
    public void giveAccountNumber(String customerName, long mobileNumber) {
        boolean matched = false;
        for(int i = 0; i < numberOfCustomers; i++) {
            if (customers[i].getCustomerName().equals(customerName) && customers[i].getMobileNumber() == mobileNumber) {
                System.out.println("Your Account Number Is : " + customers[i].getAccountNumber());
                matched = true;
            }
        }
        if(!matched) {
            System.out.println("NO RECORD FOUND.");
        }
    }

    /**
     * This method gives the pin number of the Customer, if forgotten.
     *
     * @param accountNumber Account number of the Customer.
     * @param customerName Name of the Customer.
     */
    public void givePinNumber(long accountNumber, String customerName) {
        boolean matched = false;
        for(int i = 0; i < numberOfCustomers; i++) {
            if (customers[i].getAccountNumber() == accountNumber && customers[i].getCustomerName().equals(customerName)) {
                System.out.println("Your Pin Number Is : " + customers[i].getPinNumber() + "\nDon't Share This With Anyone.");
                matched = true;
            }
        }
        if(!matched) {
            System.out.println("No Record Found");
        }
    }

    /**
     * This method is used to change the pin of Customer's Account.
     *
     * @param customerName Name of the Customer.
     * @param accountNumber Account Number of the Customer.
     * @param pinNumber Change old pin number with this.
     */
    public void changePin(String customerName, long accountNumber, int pinNumber){
        boolean matched = false;
        for(int i = 0; i < numberOfCustomers; i++) {
            if(customers[i].getCustomerName().equals(customerName) && customers[i].getAccountNumber() == accountNumber) {
                customers[i].setPinNumber(pinNumber);
                System.out.println("Pin Reset Successful");
                matched = true;
            }
        }
        if(!matched) {
            System.out.println("No Record Found");
        }
    }

    /**
     * This methods deposits money to the account.
     *
     * @param accountNumber The account number of the Customer.
     * @param pinNumber The pin number of the given account.
     * @param money The money to be deposited.
     */
    public void addMoney(long accountNumber,int pinNumber, double money) {
        boolean matched = false;
        for(int i = 0; i< numberOfCustomers; i++) {
            if(customers[i].getAccountNumber() == accountNumber && customers[i].getPinNumber() == pinNumber){
                customers[i].setAccountBalance(customers[i].getAccountBalance() + money);
                customers[i].passbook.depositMoney(money);
                matched = true;
                System.out.println(money + " Added Successfully");
            } else if (customers[i].getAccountNumber() ==accountNumber) {
                System.out.println("INCORRECT PIN");
            }
            }
        if(!matched){
            System.out.println("NO RECORD FOUND FOR THIS ACCOUNT NUMBER.");
        }
    }

    /**
     * This method withdraws money from the account if the account number and pin matches.
     *
     * @param accountNumber The account number of the Customer.
     * @param pinNumber Pin number of the given account.
     * @param money Money to be withdrawn.
     */
    public void takeMoney(long accountNumber,int pinNumber,  double money) {
        boolean matched = false;
        for(int i = 0; i < numberOfCustomers; i++) {
            if (customers[i].getAccountNumber() == accountNumber && customers[i].getPinNumber() == pinNumber) {
                if (customers[i].getAccountBalance() > money) {
                    customers[i].setAccountBalance(customers[i].getAccountBalance() - money);
                    customers[i].passbook.withdrawMoney(money);
                    matched = true;
                    System.out.println(money + " Withdrawal Successfully.");
                } else {
                    System.out.println("Transaction Not Possible. Not Enough Money In The Account.");
                    matched = true;
                }
            } else if (customers[i].getAccountNumber() == accountNumber) {
                System.out.println("INCORRECT PIN");
                matched = true;
            }
        }
            if(!matched) {
                System.out.println("NO RECORD FOUND FOR THIS ACCOUNT NUMBER.");
        }
    }

    /**
     * This method prints all the transaction associated with the given account number.
     *
     * @param accountNumber The Account Number of the Customer.
     */
    public void printTransactionHistory(long accountNumber, int pinNumber){
        boolean matched = false;
        for(int i = 0; i < numberOfCustomers; i++) {
            if (customers[i].getAccountNumber() == accountNumber && customers[i].getPinNumber() == pinNumber) {
                System.out.println(customers[i].passbook.toString());
                System.out.println("Final Account Balance : " + customers[i].getAccountBalance());
                matched = true;
            } else if (customers[i].getAccountNumber() == accountNumber) {
                System.out.println("INCORRECT PIN");
            }
        }
            if(!matched) {
                System.out.println("NO RECORD FOUND FOR THIS ACCOUNT NUMBER.");
        }
    }
}