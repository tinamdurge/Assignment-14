package DataStructurePrograms.Problem4;

public class Main {
    public static void main(String[] args) {
        CashCounter counter = new CashCounter(100000);

        // adding customers to the queue
        counter.addCustomer(new Customer(BankOperation.WITHDRAW, 10000));
        counter.addCustomer(new Customer(BankOperation.DEPOSIT, 50000));
        counter.addCustomer(new Customer(BankOperation.WITHDRAW, 25000));
        counter.addCustomer(new Customer(BankOperation.WITHDRAW, 15000));
        counter.addCustomer(new Customer(BankOperation.DEPOSIT, 30000));

        // handling first two customers
        counter.handle(2);
        System.out.println(counter.getBalance());

        // handling next customers
        counter.handle(5);
        System.out.println(counter.getBalance());
    }
}
