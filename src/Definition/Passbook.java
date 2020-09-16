package Definition;

public class Passbook {
    private long accountNumber;
    private String customerName;
    private double[] deposits = new double[20];
    private int numberOfDeposits = 0;
    private double[] withdrawals = new double[20];
    private int numberOfWithdrawals = 0;

    public Passbook(String customerName, long accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }

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

    /**
     * This method writes the details of deposit in the Passbook.
     *
     * @param money The money deposited in the account.
     */
    public void depositMoney(double money) {
        deposits[numberOfDeposits] = money;
        numberOfDeposits++;
    }

    /**
     * This method writes the details of withdrawal in the Passbook.
     *
     * @param money The money withdrawn from the account.
     */
    public void withdrawMoney(double money) {
        withdrawals[numberOfWithdrawals] = money;
        numberOfWithdrawals++;
    }

    @Override
    public String toString() {
        String depositString = "";
        String withdrawalString = "";
        for(int i = 0; i < numberOfDeposits; i++){
            depositString = depositString + ", "+  deposits[i];
        }
        for(int i = 0; i < numberOfWithdrawals; i++){
            withdrawalString = withdrawalString + ", " +  withdrawals[i];
        }
        return "Customer Name : " + customerName + "\n"
                + "Account Number : " + accountNumber + "\n"
                    + "Deposits : " + depositString + "\n"
                        + "Withdrawals" + withdrawalString;
    }
}
