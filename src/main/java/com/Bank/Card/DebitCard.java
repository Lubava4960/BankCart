package com.Bank.Card;

public class DebitCard extends BankCard{
    private double totalDeposited; // Общая сумма всех пополнений
    private double totalSpent;//переменная общей суммы пораченных средств
    public DebitCard(double balance) {
        super(balance);
    }
@Override
    public void deposit(double amount) {
    balance += amount;
    totalDeposited += amount; // Увеличивается общая сумма пополнений
    System.out.println("Средства внесены: " + amount);
    }

    // Метод для получения общей суммы пополнений
    public double getTotalDeposited() {
        return totalDeposited;
    }

    //оплата
    @Override
    public boolean pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
            totalSpent+=amount;
            System.out.println("Оплата по дебетовой карте прошла успешно: ");
            return true;
        } else {
            System.out.println("Оплата по дебетовой карте  не прошла. Недостаточно средств: ");

            return false;
        }
    }
// баланс по карте
    @Override
    public double getAvailableFunds() {
        return balance;
    }
    //метод получения общих сумм трат
    public double getTotalSpent() {

        return totalSpent;
    }

}
