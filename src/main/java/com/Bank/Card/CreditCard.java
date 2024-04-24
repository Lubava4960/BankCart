package com.Bank.Card;

public class CreditCard extends BankCard{


    private double creditLimit;
    private double totalDepositedCreditCard; // Общая сумма всех пополнений
    public CreditCard(double balance, double creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
    }

    // Метод для пополнения карты на определенную сумму
    public void deposit(double amount) {
        totalDepositedCreditCard+=amount;
        balance += amount;
    }

    // Метод для получения общей суммы пополнений
    public double getTotalDepositedCreditCard() {
        return totalDepositedCreditCard;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= balance + creditLimit) {//условие проверяет, что запрашиваемая для снятия сумма amount не превышает сумму доступных средств на балансе (balance) и кредитный лимит (creditLimit)
            if (amount <= balance) {//  условие проверяет, что запрашиваемая сумма amount не превышает текущий баланс (balance)
                balance -= amount;//выполняется, тогда снимается сумма amount с текущего баланса.
            } else {
                creditLimit -= (amount - balance);//корректируется кредитный лимит: сумма, превышающая текущий баланс, вычитается из кредитного лимита
                balance = 0;
                System.out.println("Оплата по кредитной карте прошла успешно: ");
            }
            return true;
        }
        System.out.println("Оплата по крдитной карте не прошла. Недостаточно средств : ");
        return false;
    }
    public double getCreditLimit() {
        return getAvailableFunds() - getBalance();
    }

    //метод возвращает общую сумму денежных средств, доступных для использования,
    // учитывая как текущий баланс, так и кредитный лимит.
    @Override
    public double getAvailableFunds() {
        return balance + creditLimit;
    }


}
