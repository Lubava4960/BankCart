package com.Bank.Card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    void deposit() {
      CreditCard creditCard=new CreditCard(1000.0, 15000.0) ;
      creditCard.deposit(2000.0);
      assertEquals(18000.0,18000.0);
    }

    @Test
    void getTotalDepositedCreditCard() {
        CreditCard creditCard=new CreditCard(1000.0, 15000.0) ;
        creditCard.deposit(2000.0);
        creditCard.deposit(500.0);
        assertEquals(18500.0,18500.0);

    }

    @Test
    void testPayWithSufficientFunds() {
        CreditCard creditCard = new CreditCard(200.0, 100.0);
        //  оплата сумму 150.0
        boolean paymentResult = creditCard.pay(150.0);
        // проверка, что баланс уменьшился на 150.0
        assertEquals(50.0, creditCard.getBalance());
        // проверка, что кредитный лимит остался прежним (100.0)
        assertEquals(100.0, creditCard.getCreditLimit());
    }
    @Test
    public void testPayWithInsufficientFunds() {

        CreditCard creditCard = new CreditCard(50.0, 100.0);
        boolean paymentResult = creditCard.pay(100.0);
        assertEquals(00.0, creditCard.getBalance());
        assertEquals(50.0, creditCard.getCreditLimit());
    }
    @Test
    void getCreditLimit() {
        CreditCard creditCard = new CreditCard(5000.0, 10000.0);
        boolean paymentResult = creditCard.pay(10000.0);
        assertEquals(5000,creditCard.getCreditLimit());
    }

    @Test
    void getAvailableFunds() {
        CreditCard creditCard = new CreditCard(5000.0, 10000.0);
        boolean paymentResult = creditCard.pay(10000.0);
        creditCard.deposit(2000.0);
        assertEquals(7000,creditCard.getAvailableFunds());

    }
}