package entities;

public class Account {
    private int number;
    private String holder;
    private double balance;

    public Account(String holder, int number) {
        this.holder = holder;
        this.number = number;
    }

    public Account(String holder, int number, double initialDeposit) {
        this.holder = holder;
        this.number = number;
        deposit(initialDeposit);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        // Assume a taxa fixa de saque, se quiser
        balance -= amount + 5.0;
    }

    public String toString() {
        return "Account "
                + number
                + ", Holder: "
                + holder
                + ", Balance: $ "
                + String.format("%.2f", balance);
    }
}
