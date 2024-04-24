package com.Bank.Card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebitCardBonusTest {

    @Test
    public void testPay() {
        // объект DebitCardBonus с начальным балансом 200.0 и бонусной ставкой 0.01
        DebitCardBonus debitCardBonus = new DebitCardBonus(200.0, 0.01);

        //  оплата суммы 100.0
        boolean paymentResult = debitCardBonus.pay(100.0);

        // Проверка, что баланс уменьшился на 100.0
        assertEquals(100.0, debitCardBonus.getBalance());

    }


    @Test
    void getAvailableFunds() {
        DebitCardBonus debitCard = new DebitCardBonus(200.0, 0.01);
        // проверка, что доступные средства равны начальному балансу плюс бонусы
        assertEquals(202.0, debitCard.getAvailableFunds());

        // оплата суммы 100.0
        debitCard.pay(100.0);

        //проверка, что доступные средства уменьшились на сумму оплаты
        assertEquals(101.0, debitCard.getAvailableFunds());
    }
}
