package Definition;

public class Passbook {
    private long accountNumber;
    private String customerName;
    private double[] deposits = new double[20];
    private int numberOfDeposits = 0;
    private double[] withdrawals = new double[20];
    private int numberOfWithdrawals = 0;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
