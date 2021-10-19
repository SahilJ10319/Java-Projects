package ca.cmpt213.asn4.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    SavingsAccount sa;

    @org.junit.jupiter.api.Test
    void standardConstructorTest() {
        sa = new SavingsAccount(100,10);
        assert sa.balance == 100;
        assert sa.annualInterestRate == 10;
    }

    @Test
    void badConstructorTest() {
        try {
            sa = new SavingsAccount(-100,-10);
            fail();
        }
        catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        sa = new SavingsAccount(50,10);
        sa.deposit(20);
        assert sa.balance == 70;
        sa.deposit(10);
        assert sa.balance == 80;
        assert sa.accountStatus;
        assert sa.numOfDeposits == 2;
        try {
            sa.deposit(-50);
            fail();
        }
        catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        sa = new SavingsAccount(40,10);
        sa.withdraw(10);
        assert sa.balance == 30;
        assert sa.accountStatus == true;
        try {
            sa.withdraw(100000);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            sa.withdraw(-5);
            fail();
        }
        catch(IllegalArgumentException e) {
            assertTrue(true);
        }
        sa.withdraw(20);
        assert sa.balance == 10;
        assert sa.accountStatus == false;
    }

    @org.junit.jupiter.api.Test
    void monthlyProcess() {
        sa = new SavingsAccount(90,12);
        sa.withdraw(10);
        sa.withdraw(10);
        sa.withdraw(10);
        sa.withdraw(10);
        sa.withdraw(10);
        sa.monthlyProcess();
        assertEquals(sa.balance, 39.39);
        assertEquals(sa.numOfDeposits,0);
        assertEquals(sa.numOfWithdrawals,0);
        assertEquals(sa.monthlyServiceCharge,0);
    }
}