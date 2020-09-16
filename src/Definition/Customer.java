package Definition;

public class Customer {
    private String customerName;
    private long accountNumber;
    private int pinNumber = 1234;
    private long mobileNumber;
    private double accountBalance;
    public Passbook passbook;

    public Customer(String customerName, long mobileNumber, long accountNumber) {
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.accountNumber = accountNumber;
        passbook.setCustomerName(customerName);
        passbook.setAccountNumber(accountNumber);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Passbook getPassbook() {
        return passbook;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setPassbook(Passbook passbook) {
        this.passbook = passbook;
    }

    @Override
    public String toString() {
        return "Customer Name : " + customerName + ", "
                + "Account Number : " + accountNumber + ", "
                    + "Mobile Number : " + mobileNumber;
    }
}
