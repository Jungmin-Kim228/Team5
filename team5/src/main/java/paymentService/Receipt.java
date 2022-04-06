package paymentService;

public class Receipt {
    private Long customerId;
    private Long productAmt; // 물건 가격

    public Receipt(Long customerId, Long productAmt) {
        this.customerId = customerId;
        this.productAmt = productAmt;
    }

    public Long getProductAmt() {
        return 2000L;
    }

    public Long getCustomerId() {
        return this.customerId;
    }
}
