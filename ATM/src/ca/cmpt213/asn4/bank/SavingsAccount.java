/**
 *This is the SavingsAccount Class
 *Sub Class of Bank Account Class
 * Holds all features from Bank account
 * while also holding saving account features
 */

package ca.cmpt213.asn4.bank;

public class SavingsAccount extends BankAccount {

    public boolean accountStatus;

    SavingsAccount(double balance, double annualInterestRate) throws IllegalArgumentException {
        super(balance, annualInterestRate);
        if(this.balance <= 25) {
            accountStatus = false;
        }
        else {
            accountStatus = true;
        }
    }

    @Override
    protected void deposit(double amount) throws IllegalArgumentException {
        super.deposit(amount);
        if (this.balance > 25) {
            accountStatus = true;
        }
        else if (this.balance <= 25) {
            accountStatus = false;
        }
    }

    @Override
    protected void withdraw(double amount) throws IllegalArgumentException {
        if (accountStatus == true) {
            super.withdraw(amount);
            if (this.balance <= 25) {
                accountStatus = false;
            }
        }
        else {
            System.out.println("The Account is not active. Withdrawal can't be made!");
        }
    }

    @Override
    protected void monthlyProcess() {
        if(this.numOfWithdrawals > 4) {
            this.monthlyServiceCharge = this.numOfWithdrawals - 4;
        }
        super.monthlyProcess();
        if (this.balance <= 25) {
            this.accountStatus = false;
        }
    }
}












