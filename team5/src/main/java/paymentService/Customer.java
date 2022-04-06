package paymentService;

public class Customer {

    private Long customerId;
    private Long balance;

    public Customer(Long customerId, Long balance) {
        this.customerId = customerId;
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }

}
