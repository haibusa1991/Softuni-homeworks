package L06DefiningClasses.L03BankAccount;

public class Account {
    private static int serialNum = 1;
    private static double interestRate = 0.02;
    private double balance = 0.0;
    private final int id;

    public Account() {
        id = serialNum;
        serialNum++;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return Account.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public int getId() {
        return this.id;
    }
}

