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

    public long getAccountNumber() {
        return accountNumber;
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

    public long getMobileNumber(){
        return mobileNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    @Override
    public String toString() {
        return "Customer Name : " + customerName + ", "
                + "Account Number : " + accountNumber + ", "
                    + "Mobile Number : " + mobileNumber;
    }
}
