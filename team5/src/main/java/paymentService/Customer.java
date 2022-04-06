package paymentService;

public class Customer {

    private Long id;
    private Long balance;
    private Long point;

    public Customer(Long id, Long balance, Long point) {
        this.id = id;
        this.balance = balance;
        this.point = point;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getPoint() {
        return point;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setPoint(Long point) {
        this.point = point;
    }
}
