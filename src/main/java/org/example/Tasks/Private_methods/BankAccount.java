package org.example.Tasks.Private_methods;

/**
 * Класс BankAccount демонстрирует первый
 * случай использования private методов.
 */

public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (isAmountValid(amount)) {
            balance += amount;
            System.out.println("Счет пополнен на: " + amount);
        } else {
            System.out.println("Некорректная сумма для пополнения: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (isAmountValid(amount) && balance >= amount) {
            balance -= amount;
            System.out.println("Со счета снято: " + amount);
        } else {
            System.out.println("Некорректная сумма для снятия или недостаточно средств: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    private boolean isAmountValid(double amount) {
        return amount > 0;
    }

    public void displayAccountInfo() {
        System.out.println("Номер счета: " + accountNumber);
        System.out.println("Баланс: " + balance);
    }
}
