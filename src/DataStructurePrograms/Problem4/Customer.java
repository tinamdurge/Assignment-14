package DataStructurePrograms.Problem4;

public class Customer {
    BankOperation operation;
    int amount;

    public Customer(BankOperation operation, int amount) {
        this.operation = operation;
        this.amount = amount;
    }
}