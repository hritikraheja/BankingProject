package Definition;

public class Customer {
    private String customerName;
    private long accountNumber;
    private long mobileNumber;
    private double accountBalance;

    public Customer(String customerName, long mobileNumber) {
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
    }
}
