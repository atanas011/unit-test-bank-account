package tests;

import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AccountTest {

    private final String name = "Ana";
    private final String accountNum = "123";
    private final double balance = 0d;
    private final Account account = new Account(name, accountNum);

    @Test
    public void testConstructor() {
        var softAssert = new SoftAssert();
        softAssert.assertEquals(account.getName(), name);
        softAssert.assertEquals(account.getNum(), accountNum);
        softAssert.assertEquals(account.getBalance(), balance);
        softAssert.assertAll();
    }

    @Test
    public void testSetGet() {
        var softAssert = new SoftAssert();
        var newBalance = 1000d;
        softAssert.assertEquals(account.getBalance(), balance);
        account.setBalance(newBalance);
        softAssert.assertEquals(account.getBalance(), newBalance);
        softAssert.assertAll();
    }

    @Test
    public void testPrint() {
        var expected = String.format("%s\t%s\t%.2f",
                account.getNum(), account.getName(), account.getBalance());
        Assert.assertEquals(account.toString(), expected);
    }

    @Test
    public void testCreate() { // 2.5'
        var max = 100;
        var accounts = new Account[max];
        for (int i = 0; i < max; i++) {
            accounts[i] = new Account(name);
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < i; j++) {
                Assert.assertNotEquals(accounts[i].getNum(), accounts[j].getNum());
            }
        }
    }
}