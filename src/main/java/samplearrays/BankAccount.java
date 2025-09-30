package samplearrays;

public class BankAccount {
    private final String name;
    private double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    private final Double[] transactions = new Double[1000];
    int curr_index = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        // Update
        if (amount <= 0) {
            System.out.println("Invalid deposit amount value");
            return;
        }
        this.currentBalance += amount;
        transactions[curr_index++] = amount;
        // Display
        System.out.println("=== Deposit ===");
        System.out.println("--> " + this.name);
        System.out.println("--> Deposit amount: " + amount);
        System.out.println("--> Updated balance: " + this.currentBalance);
    }

    public void withdraw(double amount){
        // Validation
        if (amount <= 0) {
            System.out.println("Invalid deposit amount value");
            return;
        }
        if (amount >= this.currentBalance) {
            System.out.println("Insufficient funds");
            return;
        }
        // Update balance
        this.currentBalance -= amount;
        transactions[curr_index++] = -amount;
        // Display
        System.out.println("=== Withdrawal ===");
        System.out.println("--> " + this.name);
        System.out.println("--> Withdrawal amount: " + amount);
        System.out.println("--> Updated balance: " + this.currentBalance);
    }

    public void displayTransactions(){
        System.out.println("<---- Transaction History for " + this.name + " ---->");
        for (int i = 0; i < this.curr_index; ++i) {
            if (transactions[i] > 0) {
                System.out.println("Deposit amount of " + transactions[i]);
            } else {
                System.out.println("Withdrawal amount of " + (-transactions[i]));
            }
        }
    }

    public void displayBalance(){
        System.out.println("Current balance of " + this.name + ": " + this.currentBalance);
    }

    public static void main(String[] args) {
        BankAccount john = new BankAccount("John Doe", 100);
        // ----- DO NOT CHANGE -----
        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();
        // ----- DO NOT CHANGE -----
    }
}