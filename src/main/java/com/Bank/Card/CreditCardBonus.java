package com.Bank.Card;

public class CreditCardBonus extends CreditCard{
    private double bonusRateCreditCard;   //бонусная ставка
    private double bonusEarned;


    public CreditCardBonus(double balance, double creditLimit, double bonusRateCreditCard) {
        super(balance, creditLimit);
        this.bonusRateCreditCard = bonusRateCreditCard;
        this.bonusEarned = 0;
    }

    // Метод для оплаты с учетом начисления бонусов
    public boolean payWithBonus(double amount) {
        bonusEarned += amount * bonusRateCreditCard; // Используется поле класса
        super.pay(amount); // Метод оплаты из класса-родителя
        System.out.println("Начислено бонусов: " + (amount * bonusRateCreditCard));
        return false;
    }


    public double printCreditBalance(double bonus) {
        double totalCreditBalance;

        if (balance <= 0) {
            // Если собственных средств нет или они равны 0, прибавляются бонусы на кредитные средства
            totalCreditBalance = getCreditLimit() + bonusEarned;
            System.out.println("Баланс кредитных средств после учета бонусов: " + totalCreditBalance);
        } else {
            // Если собственный баланс больше 0, прибавляютсяя бонусы к собственному балансу
            totalCreditBalance=getBalance()+bonusEarned;
            System.out.println("Баланс собственных средств после учета бонусов: " + totalCreditBalance);
        }

        return totalCreditBalance;
    }


    }


