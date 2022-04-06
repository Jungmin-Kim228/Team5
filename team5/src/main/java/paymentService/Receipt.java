package paymentService;

public class Receipt {
    private Long customerId;
    private Long productAmt;

    public Receipt(Long customerId, Long productAmt) {
        this.customerId = customerId;
        this.productAmt = productAmt;
    }

    public Long getProductAmt() {
        return 0L;
    }

}
