package Definition;

public class Branch {
    private static String bankName = "Canara Bank";
    private String branchName;
    Customer[] customers = new Customer[100];
    private int numberOfCustomers = 0;
    private double revenue = 0.0;
    public final double MINIMUM_BALANCE = 1000.0;

    public Branch(String branchName) {
        this.branchName = branchName;
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
    public void addCustomer(String newCustomerName, long mobileNumber) {
        customers[numberOfCustomers] = new Customer(newCustomerName, mobileNumber, generateAccountNumber());
        numberOfCustomers++;
        System.out.println("Your Account Is Created Successfully.\nYour Account Number Is : " + customers[numberOfCustomers].getAccountNumber());
    }

    /**
     * This method prints the account number of the Customer, if forgotten.
     *
     * @param customerName Name of the Customer.
     * @param mobileNumber Mobile Number of the Customer.
     */
    public void giveAccountNumber(String customerName, long mobileNumber) {
        for(Customer customer : customers) {
            if(customer.getCustomerName().equals(customerName) && customer.getMobileNumber() == mobileNumber) {
                System.out.println(customer.getAccountNumber());
            } else {
                System.out.println("NO ACCOUNT FOUND WITH THESE DETAILS.");
            }
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
        for(Customer customer : customers) {
            boolean matched = false;
            if(customer.getAccountNumber() == accountNumber && customer.getPinNumber() == pinNumber){
                customer.setAccountBalance(customer.getAccountBalance() + money);
                customer.passbook.depositMoney(money);
                matched = true;
                System.out.println(money + " Added Successfully.");
            } else if (customer.getAccountNumber() ==accountNumber) {
                System.out.println("INCORRECT PIN");
            }
            if(!matched){
                System.out.println("NO RECORD FOUND FOR THIS ACCOUNT NUMBER.");
            }
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
        for(Customer customer : customers) {
            boolean matched = false;
            if(customer.getAccountNumber()==accountNumber && customer.getPinNumber()==pinNumber){
                if(customer.getAccountBalance() > money) {
                    customer.setAccountBalance(customer.getAccountBalance() - money);
                    customer.passbook.withdrawMoney(money);
                    matched = true;
                    System.out.println(money + " Withdrawal Successfully.");
                } else {
                    System.out.println("Transaction Not Possible. Not Enough Money In The Account.");
                }
            } else if(customer.getAccountNumber() == accountNumber) {
                System.out.println("INCORRECT PIN");
            }
            if(!matched) {
                System.out.println("NO RECORD FOUND FOR THIS ACCOUNT NUMBER.");
            }
        }
    }

    /**
     * This method prints all the transaction associated with the given account number.
     *
     * @param accountNumber The Account Number of the Customer.
     */
    public void printTransactionHistory(long accountNumber, int pinNumber){
        for(Customer customer : customers) {
            boolean matched = false;
            if (customer.getAccountNumber() == accountNumber && customer.getPinNumber()==pinNumber) {
                customer.passbook.toString();
                System.out.println("Final Account Balance : " + customer.getAccountBalance());
                matched = true;
            } else if(customer.getAccountNumber() == accountNumber) {
                System.out.println("INCORRECT PIN");
            }
            if(!matched) {
                System.out.println("NO RECORD FOUND FOR THIS ACCOUNT NUMBER.");
            }
        }
    }
}