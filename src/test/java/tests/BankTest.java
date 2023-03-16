package tests;

import models.Bank;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class BankTest {

    private Bank bank;
    private final String name = "Ana";

    @BeforeClass
    public void initBank() {
        bank = new Bank();
    }

    @BeforeMethod
    public void reset() {
        bank.reset();
    }

    @Test
    public void openAccount() {
        var max = 5;
        for (int i = 0; i < max; i++) {
            var account = bank.openAccount(name);
            assertEquals(bank.getAccount(account.getNum()), account);
        }
    }

    @Test
    public void testPayIn() {
        var account = bank.openAccount(name);
        account.setBalance(300d);
        bank.payInMoney(account.getNum(), 1000d);
        assertEquals(account.getBalance(), 1300d);
    }

    @Test
    public void testTransfer() {
        var account1 = bank.openAccount(name);
        var name2 = "Jeca";
        var account2 = bank.openAccount(name2);
        bank.payInMoney(account1.getNum(), 500d);
        bank.transferMoney(account1.getNum(), account2.getNum(), 300d);
        var softAssert = new SoftAssert();
        softAssert.assertEquals(account1.getBalance(), 200d);
        softAssert.assertEquals(account2.getBalance(), 300d);
        softAssert.assertAll();
    }

    @Test
    public void testSum() {
        var max = 5;
        for (int i = 0; i < max; i++) {
            var account = bank.openAccount(name);
            account.setBalance(1000d);
        }
        assertEquals(bank.getSumMoney(), 5000d);
    }
}