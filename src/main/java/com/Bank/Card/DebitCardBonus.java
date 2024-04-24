package com.Bank.Card;

class DebitCardBonus extends DebitCard{
    private double bonusRate=0.01;   //бонусная ставка

    public DebitCardBonus(double balance, double bonusRate) {
        super(balance);
        this.bonusRate = bonusRate;
    }
    //Метод оплаты с начислением бонусов
    @Override
    public boolean pay(double amount) {
        boolean paymentStatus = super.pay(amount);
        if (paymentStatus) {
            double bonus = amount * bonusRate;
            System.out.println("Начислено бонусных баллов: " + bonus);
        }
        return paymentStatus;
    }
    //метод получения баланса с бонусами
    @Override
    public double getAvailableFunds() {
        return super.getAvailableFunds() + bonusRate * balance;
    }


}
