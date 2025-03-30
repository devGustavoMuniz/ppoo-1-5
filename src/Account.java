public class Account {
    private String name;
    private double balance;
    private double debitCeiling;

    public Account(String name) {
        this.name = name;
        this.balance = 0;
        this.debitCeiling = -500;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void depositBalance(double amount) {
        this.balance += amount;
    }

    public boolean withdrawBalance(double amount) {
        if (this.balance - amount < this.debitCeiling) {
            return false;
        }

        this.balance -= amount;
        return true;
    }
}