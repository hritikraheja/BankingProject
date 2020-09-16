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

    public void addCustomer(String newCustomerName, long mobileNumber) {
        customers[numberOfCustomers] = new Customer(newCustomerName, mobileNumber, generateAccountNumber());
        numberOfCustomers++;
        System.out.println("Your Account Is Created Successfully.\nYour Account Number Is : " + customers[numberOfCustomers].getAccountNumber());
    }

    public void addMoney(long accountNumber, double money) {
        for(Customer customer : customers) {
            boolean matched = false;
            if(customer.getAccountNumber() == accountNumber){
                customer.setAccountBalance(customer.getAccountBalance() + money);
                customer.passbook.depositMoney(money);
                matched = true;
                System.out.println(money + " Added Successfully.");
            }
            if(!matched){
                System.out.println("NO RECORD FOUND FOR THIS ACCOUNT NUMBER.");
            }
        }
    }

    public void takeMoney(long accountNumber, double money) {
        for(Customer customer : customers) {
            boolean matched = false;
            if(customer.getAccountNumber()==accountNumber){
                if(customer.getAccountBalance() > money) {
                    customer.setAccountBalance(customer.getAccountBalance() - money);
                    customer.passbook.withdrawMoney(money);
                    matched = true;
                    System.out.println(money + " Withdrawal Successfully.");
                } else {
                    System.out.println("Transaction Not Possible. Not Enough Money In The Account.");
                }
            }
            if(!matched) {
                System.out.println("NO RECORD FOUND FOR THIS ACCOUNT NUMBER.");
            }
        }
    }

    public void printTransactionHistory(long accountNumber){
        for(Customer customer : customers) {
            boolean matched = false;
            if (customer.getAccountNumber() == accountNumber) {
                customer.passbook.toString();
                System.out.println("Final Account Balance : " + customer.getAccountBalance());
                matched = true;
            }
            if(!matched) {
                System.out.println("NO RECORD FOUND FOR THIS ACCOUNT NUMBER.");
            }
        }
    }
}