package paymentService;

import java.util.HashMap;

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

        paymentAmt = productAmt - customer.getPoint();

        customer.setBalance(customer.getBalance() - paymentAmt);
        customer.setPoint((long) (paymentAmt * POINT_RATE));
        
        //customerRepository.getCustomers().put(customerId, customer);

        return new Receipt(customerId, productAmt);

    }

    public void setPaymentService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
/*
productAmt : 지불금
paymentAmt : 실지불금
 */