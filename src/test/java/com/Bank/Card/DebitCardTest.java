package com.Bank.Card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebitCardTest {

    @Test
    void deposit() {
        DebitCard debitCard=new DebitCard(50.0);
        debitCard.deposit(300);
        assertEquals(350.0, debitCard.getBalance());
    }
    @Test
    void getTotalDeposited() {
        DebitCard debitCard = new DebitCard(100.0);
        debitCard.deposit(50.0);
        debitCard.deposit(30.0);
        assertEquals(80.0, debitCard.getTotalDeposited());
        assertEquals(180.0,debitCard.getBalance());
    }

    @Test
    void testPayWithSufficientBalance() {
        DebitCard debitCard = new DebitCard(200.0);
        debitCard.pay(50.0);
        assertEquals(150.0, debitCard.getBalance());
    }
    @Test
    public void testPayWithInsufficientBalance() {
        DebitCard debitCard = new DebitCard(50.0);
        debitCard.pay(100.0);
        assertEquals(50.0, debitCard.getBalance());
    }

    @Test
    void getAvailableFunds() {
        DebitCard debitCard = new DebitCard(150.0);
        debitCard.pay(100.0);
        debitCard.deposit(200.0);
        assertEquals(250.0, debitCard.getAvailableFunds());
    }
    @Test
    void getTotalSpent() {
        DebitCard debitCard = new DebitCard(10000.0);
        //  оплатa сумм
        debitCard.pay(5000.0);
        debitCard.pay(350.0);
        assertEquals(5350.00,debitCard.getTotalSpent());
    }

    @Test
    void getTotalSpentNoPay() {
        DebitCard debitCard = new DebitCard(10000.0);
        //  оплатa сумм
        debitCard.pay(15000.0);
        assertEquals(00.0,debitCard.getTotalSpent());
    }
}