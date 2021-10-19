/**
 * This is the Bank Account Class
 * It is a Abstract Class/ Super Class
 * It holds all the general features a bank account holds
 */

package ca.cmpt213.asn4.bank;

public abstract class BankAccount {

    protected double balance;
    protected double annualInterestRate;
    protected int numOfDeposits;
    protected int numOfWithdrawals;
    protected int monthlyServiceCharge;

    BankAccount(double balance, double annualInterestRate) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance can not be Negative ");
        }
        if (annualInterestRate < 0) {
            throw new IllegalArgumentException("Annual Interest Rate can not be Negative");
        }
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    protected void deposit(double amount) throws IllegalArgumentException {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount to Deposit can not be Negative");
        }
        this.balance = this.balance + amount;
        numOfDeposits++;
    }

    protected void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount to Withdraw can not be Negative");
        }
        if(amount > this.balance) {
            throw new IllegalArgumentException("You don't have enough money to withdraw that amount");
        }
        this.balance = this.balance - amount;
        numOfWithdrawals++;
    }

    protected void CalcInterest() {
        double monthlyInterestRate = this.annualInterestRate / 12;
        double monthlyInterest = this.balance * (monthlyInterestRate / 100);
        this.balance = this.balance + monthlyInterest;
    }

    protected void monthlyProcess() {
        this.balance = this.balance - this.monthlyServiceCharge;
        CalcInterest();
        numOfWithdrawals = 0;
        numOfDeposits = 0;
        monthlyServiceCharge = 0;
    }
}
