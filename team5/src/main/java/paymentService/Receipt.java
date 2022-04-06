package paymentService;

/**
 * customerId 고객아이디
 * productAmt 물건 가격
 */
public class Receipt {
    private Long customerId;
    private Long productAmt;

    public Receipt(Long customerId, Long productAmt) {
        this.customerId = customerId;
        this.productAmt = productAmt;
    }

}
