package DataStructurePrograms.Problem4;

import DataStructures.*;

public class CashCounter {
    // maintaining a queue for customers
    private Queue<Customer> queue;
    private int balance;

    public CashCounter(int balance) {
        this.queue = new Queue<>();
        this.balance = balance;
    }

    public void addCustomer(Customer customer) {
        this.queue.enqueue(customer);
    }

    public int getBalance() {
        return this.balance;
    }

    // method to handle n customers
    public void handle(int n) {
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                return;
            }
            Customer customer = queue.dequeue();
            if (customer.operation.equals(BankOperation.WITHDRAW)) {
                if (this.balance > customer.amount) {
                    this.balance -= customer.amount;
                } else {
                    System.out.println("Insufficient balance");
                    return;
                }
            }
            if (customer.operation.equals(BankOperation.DEPOSIT)) {
                this.balance += customer.amount;
            }
        }
    }
}
