package paymentService;

import java.util.HashMap;
/**
 * productAmt : 지불금
 * paymentAmt : 실지불금
 */
public class PaymentService {
    final static Double POINT_RATE = 0.05;
    private CustomerRepository customerRepository = new CustomerRepository(new HashMap<>());
    private Long paymentAmt;

    public PaymentService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Receipt pay(Long productAmt, Long customerId) { // 계산하고 영수증 발급
        if (productAmt == null || productAmt < 0) {
            throw new IllegalArgumentException("productAmt is invalid: " + productAmt);
        }

        Customer customer = customerRepository.findById(customerId);

        paymentAmt = productAmt - customer.getPoint(); // 실지불금액 계산

        customer.afterPayBalance(customer.getBalance() - paymentAmt); // 고객 잔액 변경
        customer.earnPoint((long) (paymentAmt * POINT_RATE)); // 고객 포인트 변경

        AlertDummy alertDummy = new AlertDummy();
        alertDummy.alertCall();

        return new Receipt(customerId, productAmt);
    }
}
