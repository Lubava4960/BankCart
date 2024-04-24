package com.Bank.Card;

public class DebitCartCashback extends DebitCard{

    private static final double MINIMUM_SPEND_AMOUNT = 5000;//константа для хранения значений минимальной суммы трат
    private static final double CASHBACK_RATE = 0.05;//константа процента кэшбэка
    private static final double DEPOSIT_BONUS_RATE = 0.005;//константа процента бонуса за пополнение

    public DebitCartCashback(double balance) {
        super(balance);

    }
    @Override
    public boolean pay(double amount) {
        boolean paymentStatus = super.pay(amount);
        if (paymentStatus) {
            if (amount >= MINIMUM_SPEND_AMOUNT) {
                double cashback = amount * CASHBACK_RATE;
                System.out.println("Начислено кэшбэка: " + cashback);
            }
        }
        return paymentStatus;
    }


    //метод для расчета общей суммы начисленного кэшбэка
    public double calculateTotalCashback() {

        if (getTotalSpent() >= MINIMUM_SPEND_AMOUNT) {

            return getTotalSpent() * CASHBACK_RATE;
        }
        return 0;
    }
    //метод для расчета общей суммы начисленного процентного  бонуса за пополнение
    public double calculateTotalDepositBonus() {
        return  getTotalDeposited() * DEPOSIT_BONUS_RATE;
    }


}
