package Chapter_11;

import ToolKit.Account;

/**
 * Chapter 11 Exercise 8:
 *
 *      (New Account class) An Account class was specified in Programming
 *      Write a test program that creates an Account with annual interest rate 1.5%,
 *      balance 1000, id 1122, and name George. Deposit $30, $40, and $50 to the
 *      account and withdraw $5, $4, and $2 from the account. Print an account summary
 *      that shows account holder name, interest rate, balance, and all transactions.
 *      Programming Exercises 447
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_08 {

    public static void main(String[] args) {

        Account account = new Account("George", 1122, 1000);
        account.setAnnualInterestRate(1.5);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);
        System.out.println(account);
    }
}
