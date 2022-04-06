package paymentService;

public class Customer {

    private Long customerId;
    private Long balance;
    private Long point;

    public Customer(Long customerId, Long balance, Long point) {
        this.customerId = customerId;
        this.balance = balance;
        this.point = point;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getPoint() {
        return point;
    }
}
