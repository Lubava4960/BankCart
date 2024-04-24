package com.Bank.Card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardCashbackTest {

    @Test
    void calculateTotalCashbackWithCashback() {
        CreditCardCashback creditCardCashback= new CreditCardCashback(2000.0,10000);
        creditCardCashback.pay(6000);
        assertEquals(300.00, creditCardCashback.calculateTotalCashback());
    }
    @Test
    void calculateNoTotalCashback(){
        CreditCardCashback creditCardCashback= new CreditCardCashback(2000.0,10000);
        creditCardCashback.pay(1000);
        assertEquals(0.00, creditCardCashback.calculateTotalCashback());
    }


    @Test
    void calculateTotalDepositBonus() {
        CreditCardCashback creditCartCashback = new CreditCardCashback(1000.0, 10000.0);

        // пополняется счет на сумму 3000.0
        creditCartCashback.deposit(3000.0);

        //  начислен бонус за пополнение  (0.002)
        assertEquals(6.0, creditCartCashback.calculateTotalDepositBonus());
    }

    @Test
    void getTotalSpent() {
        CreditCardCashback creditCartCashback = new CreditCardCashback(1000.0, 10000.0);
        //оплата сумм
        creditCartCashback.pay(1000.0);
        creditCartCashback.pay(5000.0);
        assertEquals(6000.0,creditCartCashback.getTotalSpent());



    }
}