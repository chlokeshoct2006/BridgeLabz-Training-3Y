class BankAccount {
    static String bankName = "ABC Bank";
    private static int totalAccounts = 0;
    
    private String accountHolderName;
    private final int accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Raj", 101, 5000.0);
        BankAccount acc2 = new BankAccount("Amit", 102, 8000.0);

        acc1.displayDetails();
        System.out.println();
        acc2.displayDetails();

        System.out.println("\nTotal Accounts: " + BankAccount.getTotalAccounts());
    }
}
