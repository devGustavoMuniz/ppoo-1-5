public class Account {
    private String name;
    private double balance;
    private double debitCeiling;

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