package paymentService;

public class PaymentService {
    private CustomerRepository customerRepository;
    final static Double POINT_RATE = 0.05;
    private Long paymentAmt;

    public PaymentService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Receipt pay(Long productAmt, Long customerId) {
        if (productAmt == null || productAmt < 0) {
            throw new IllegalArgumentException("productAmt is invalid: " + productAmt);
        }
        Customer customer = customerRepository.findById(customerId);
        paymentAmt = productAmt - customer.getPoint();
        return new Receipt(customerId, productAmt, (long) (paymentAmt*POINT_RATE));
    }

}
