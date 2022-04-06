package paymentService;

public class Customer {
    private String id;
    private int balance;
    private int point;

    public Customer() {
        this.id = null;
        this.balance = 0;
        this.point = 0;
    }
    public Customer(String id, int balance, int point) {
        this.id = id;
        this.balance = balance;
        this.point = point;
    }

    public String getId() {
        return id;
    }
}
