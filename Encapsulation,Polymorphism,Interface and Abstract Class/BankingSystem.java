import java.util.*;

// Abstract class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal.");
        }
    }

    public abstract double calculateInterest();
}

// Interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; 
    private boolean loanApproved = false;

    public SavingsAccount(String accNo, String holder, double balance) {
        super(accNo, holder, balance);
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            loanApproved = true;
            System.out.println("Loan of " + amount + " approved for Savings Account holder " + getHolderName());
        } else {
            System.out.println("Loan denied for Savings Account holder " + getHolderName());
        }
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; 
    }
}

// CurrentAccount
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; 
    private boolean loanApproved = false;

    public CurrentAccount(String accNo, String holder, double balance) {
        super(accNo, holder, balance);
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            loanApproved = true;
            System.out.println("Loan of " + amount + " approved for Current Account holder " + getHolderName());
        } else {
            System.out.println("Loan denied for Current Account holder " + getHolderName());
        }
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000; 
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Account " + (i + 1));
            System.out.print("Enter Account Number: ");
            String accNo = sc.nextLine();
            System.out.print("Enter Holder Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter Account Type (1 = Savings, 2 = Current): ");
            int type = sc.nextInt();
            sc.nextLine();

            if (type == 1) {
                accounts.add(new SavingsAccount(accNo, name, balance));
            } else if (type == 2) {
                accounts.add(new CurrentAccount(accNo, name, balance));
            } else {
                System.out.println("Invalid type, skipping...");
            }
        }

        System.out.println("\n=== Account Summary ===");
        for (BankAccount acc : accounts) {
            System.out.println("\nAccount Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                ((Loanable) acc).applyForLoan(5000); 
            }
        }

        sc.close();
    }
}
