class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

   
    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

  
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    
    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
       
    }
}

public class ATM {
    public static void main(String[] args) {
        
        BankAccount account1 = new BankAccount("Alice", 1001, 5000);

        
        account1.displayBalance();
        account1.deposit(2000);
        account1.withdraw(1500);
        account1.withdraw(7000); 
        account1.displayBalance();
    }
}

