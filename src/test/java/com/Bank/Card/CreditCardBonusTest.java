package com.Bank.Card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardBonusTest {

    @Test
    void payWithBonus() {
        // объект CreditCardBonus с начальным балансом 5000 и бонусной ставкой 0.01
        CreditCardBonus creditCardBonus = new CreditCardBonus(5000.0,10000, 0.01);
        //  оплата суммы 1000.0
        boolean paymentResult =creditCardBonus.payWithBonus(1000);
        // проверка, что баланс уменьшился на 1000.0 с начислением бонусов
        assertEquals(4000.0, creditCardBonus.getBalance());
        assertEquals(10000.0,creditCardBonus.getCreditLimit());

    }
    @Test
    void payWithBonusNoBalance(){
        // объект CreditCardBonus с начальным балансом 5000 и бонусной ставкой 0.01
        CreditCardBonus creditCardBonus = new CreditCardBonus(5000.0,10000, 0.01);
        //  оплата суммы 7000.0
        boolean paymentResult =creditCardBonus.payWithBonus(7000);
        // проверка, что баланс уменьшился на 7000.0 с начислением бонусов
        assertEquals(0.0, creditCardBonus.getBalance());
        assertEquals(8000.0,creditCardBonus.getCreditLimit());
    }


    @Test
    void printCreditBalanceNoBalance() {
        // объект CreditCardBonus с начальным балансом 5000 и бонусной ставкой 0.01
        CreditCardBonus creditCardBonus = new CreditCardBonus(5000.0,10000, 0.01);
        //оплата больше чем собственных средств. Бонусы прибавятся к кредитным средствам
        boolean paymentResult =creditCardBonus.payWithBonus(7000);
        assertEquals(8070.0,creditCardBonus.printCreditBalance(creditCardBonus.getBalance()));

    }
    @Test
    void printCreditBalanceWithBalance(){
        // объект CreditCardBonus с начальным балансом 5000 и бонусной ставкой 0.01
        CreditCardBonus creditCardBonus = new CreditCardBonus(1000.0,10000, 0.01);
        //оплата меньше чем собственных средств. Бонусы прибавятся к собственным средствам
        boolean paymentResult =creditCardBonus.payWithBonus(500);
        assertEquals(505.0, creditCardBonus.printCreditBalance(creditCardBonus.getBalance()));

    }


}