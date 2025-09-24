import java.util.*;

class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Balances for " + name + ":");
        for (Account acc : accounts) {
            System.out.println("Account " + acc.getAccountNumber() + " → ₹" + acc.getBalance());
        }
    }
}

class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, int accNo, double initialDeposit) {
        Account newAccount = new Account(accNo, initialDeposit);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account " + accNo + " opened for " + customer.getName() + " at " + bankName);
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank("Global Bank");

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();
            Customer customer = new Customer(name);

            System.out.print("Enter number of accounts for " + name + ": ");
            int accCount = sc.nextInt();

            for (int j = 0; j < accCount; j++) {
                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();
                System.out.print("Enter initial deposit: ");
                double deposit = sc.nextDouble();
                bank.openAccount(customer, accNo, deposit);
            }
            sc.nextLine(); 
            customer.viewBalance();
        }

        sc.close();
    }
}
