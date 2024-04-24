package com.Bank.Card;

public class CreditCardCashback extends CreditCard{
    private static final double MINIMUM_SPEND_AMOUNT = 5000; // Константа для хранения значения минимальной суммы трат
    private static final double CASHBACK_RATE = 0.05; // Константа процента кэшбэка
    private static final double DEPOSIT_BONUS_RATE_CREDIT_CART = 0.002;//константа процента бонуса за пополнение

    private double totalSpent; // Переменная общей суммы потраченных средств

    public CreditCardCashback(double balance, double creditLimit) {
        super(balance, creditLimit);
    }

    @Override
    public boolean pay(double amount) {
        boolean paymentStatus = super.pay(amount);
        if (paymentStatus) {
            totalSpent += amount;
            if (totalSpent >= MINIMUM_SPEND_AMOUNT) {
                double cashback = amount * CASHBACK_RATE;
                System.out.println("Начислено кэшбэка: " + cashback);
            }
        }
        return paymentStatus;
    }

    // Метод для расчета общей суммы начисленного кэшбэка
    public double calculateTotalCashback() {
        if (totalSpent >= MINIMUM_SPEND_AMOUNT) {
            return totalSpent * CASHBACK_RATE;
        }
        return 0;
    }
    //метод для расчета общей суммы начисленного процентного  бонуса за пополнение
    public double calculateTotalDepositBonus() {
        return  getTotalDepositedCreditCard() * DEPOSIT_BONUS_RATE_CREDIT_CART;
    }

    // Метод для расчета доступных кредитных средств
//    public double calculateAvailableCredit() {
//        return getCreditLimit() - getCurrentBalance();
//    }

    // Метод получения общей суммы трат
    public double getTotalSpent() {
        return totalSpent;
    }


}
