package ToolKit;

import java.util.Date;

/**
 * Chapter 11 Exercise 8:
 * <p>
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Transaction {

    private Date mDate; // The date of this transaction.
    private char mType; // The type of the transaction, such as 'W' for withdrawal, 'D' for deposit.

    private double mAmount; // The amount of the transaction.
    private double mBalance; // The new balance after this transaction.
    private String mDescription; // The description of this transaction.

    public Transaction(char type, double amount, double balance, String description) {
        mType = type;
        mAmount = amount;
        mBalance = balance;
        mDescription = description;
        mDate = new Date();
    }

    public Date getDate() {
        return mDate;
    }

    public char getType() {
        return mType;
    }

    public double getAmount() {
        return mAmount;
    }

    public double getBalance() {
        return mBalance;
    }

    public String getDescription() {
        return mDescription;
    }

    @Override
    public String toString() {
        return "Type: " + mType + " Date: " + mDate + "Description: " + mDescription +
                "Amount: " + mAmount + " Balance: " + mBalance + "\n";
    }
}
