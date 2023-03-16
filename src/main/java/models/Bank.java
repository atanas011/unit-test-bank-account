package models;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public Account openAccount(String name) {
        var account = new Account(name);
        accounts.add(account);
        return account;
    }

    public void closeAccount(Account account) {
        accounts.remove(account);
    }

    public void transferMoney(String accountFrom, String accountTo, double amount) {
        var from = getAccount(accountFrom);
        var to = getAccount(accountTo);
        if (from != null && to != null) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        }
    }

    public void payInMoney(String accountNum, double amount) {
        var account = getAccount(accountNum);
        if (account != null)
            account.setBalance(account.getBalance() + amount);
    }

    public Account getAccount(String accountNum) {
        for (var account : accounts) {
            if (account.getNum().equals(accountNum))
                return account;
        }
        return null;
    }

    public double getSumMoney() {
        var sum = 0d;
        for (var account : accounts) {
            sum += account.getBalance();
        }
        return sum;
    }

    public void reset() {
        accounts.clear();
    }
}