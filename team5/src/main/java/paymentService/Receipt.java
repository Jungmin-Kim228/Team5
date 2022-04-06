package paymentService;

public class Receipt {
    private Long customerId;
    private Long productAmt; // 물건 가격
    private Long paymentAmt; // 할인된 가격

    public Receipt(Long customerId, Long productAmt, Long paymentAmt) {
        this.customerId = customerId;
        this.productAmt = productAmt;
        this.paymentAmt = paymentAmt;
    }

    public Long getProductAmt() {
        return 2000L;
    }

    public Long getPaymentAmt() {
        return paymentAmt;
    }
}
