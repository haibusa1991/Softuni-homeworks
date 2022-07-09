package L06DefiningClasses.L03BankAccount;

import java.util.*;

public class Main {
    static Map<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            Account currentAccount;
            switch (tokens[0]) {
                case "Create":
                    currentAccount = new Account();
                    accounts.put(currentAccount.getId(), currentAccount);
                    System.out.printf("Account ID%d created%n", currentAccount.getId());
                    break;
                case "Deposit": {
                    int id = Integer.parseInt(tokens[1]);
                    String amount = tokens[2];
                    if (isExistingAccount(id)) {
                        currentAccount = accounts.get(id);
                        currentAccount.deposit(Double.parseDouble(amount));
                        System.out.printf("Deposited %s to ID%d%n", amount, currentAccount.getId());
                    }
                    break;
                }
                case "SetInterest":
                    Account.setInterestRate(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest": {
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (isExistingAccount(id)) {
                        currentAccount = accounts.get(id);
                        System.out.printf("%.2f%n", currentAccount.getInterest(amount));
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isExistingAccount(int id) {
        if (accounts.containsKey(id)) {
            return true;
        }
        System.out.println("Account does not exist");
        return false;
    }

}
