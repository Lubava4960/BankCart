package com.Bank.Card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebitCartCashbackTest {

    @Test
    void payWithCashback() {
        DebitCartCashback debitCardCashback = new DebitCartCashback(10000.0);
        // оплатa суммы 6000.0
         debitCardCashback.pay(6000.0);
         debitCardCashback.pay(3000);

        // проверка, что начислен кэшбэк  (5% от 9000.0)
         assertEquals(450.0, debitCardCashback.calculateTotalCashback());
    }

    @Test
    void payNoCashback(){
        DebitCartCashback debitCardCashback = new DebitCartCashback(9000.0);
        //  оплатa суммы 4000.0
        debitCardCashback.pay(4000.0);
        // проверка, что кэшбэк не начислен, так как общая сумма потраченных средств меньше 5000.0
        assertEquals(00.0, debitCardCashback.calculateTotalCashback());
    }

    @Test
    void calculateTotalCashback() {
        DebitCartCashback debitCardCashback = new DebitCartCashback(9000.0);
        //  оплатa сумм
        debitCardCashback.pay(5000.0);
        debitCardCashback.pay(2000.0);
        assertEquals(350.0, debitCardCashback.calculateTotalCashback());
    }
    @Test
    public void testCalculateTotalDepositBonus() {

        DebitCartCashback debitCardCashback = new DebitCartCashback(10000.0);

        // пополняется счет на сумму 3000.0
        debitCardCashback.deposit(3000.0);

        //  начислен бонус за пополнение  (0.005)
        assertEquals(15.0, debitCardCashback.calculateTotalDepositBonus());
    }
    @Test
    void getTotalSpent() {
        DebitCartCashback debitCardCashback = new DebitCartCashback(10000.0);
        //  оплатa сумм
        debitCardCashback.pay(5000.0);
        debitCardCashback.pay(350.0);
        assertEquals(5350.00,debitCardCashback.getTotalSpent());

    }
}