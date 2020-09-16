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
}
