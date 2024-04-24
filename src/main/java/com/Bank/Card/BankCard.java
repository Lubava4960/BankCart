package com.Bank.Card;

public abstract class BankCard {
    protected double balance;  // текущий баланс на карте, доступна для использования внутри класса, его подклассах и в том же пакете.

    public BankCard(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;//баланс с суммой вносимой на баланс карты
    }
    public abstract boolean pay(double amount);//метод для  выполнения операции оплаты

    public double getBalance() {   //возвращает текущий баланс
        return balance;
    }
    // Метод для получения общей суммы пополнений



    public abstract double getAvailableFunds(); //метод для получения доступных средств или средств, которые могут быть использованы для проведения определенных операций




}
