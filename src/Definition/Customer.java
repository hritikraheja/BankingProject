package Definition;

public class Customer {
    private String customerName;
    private long accountNumber;
    private long mobileNumber;
    private double accountBalance;
    private Passbook passbook;

    public Customer(String customerName, long mobileNumber) {
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
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

    public void setPassbook(Passbook passbook) {
        this.passbook = passbook;
    }

}
