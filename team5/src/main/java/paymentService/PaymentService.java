package paymentService;

public class PaymentService {
    private CustomerRepository customerRepository;

    public PaymentService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Receipt pay(Long productAmt, Long customerId) {
        if (productAmt == null || productAmt < 0) {
            throw new IllegalArgumentException("productAmt is invalid: " + productAmt);
        }
        Customer customer = customerRepository.findById(customerId);

        return null;
    }
}
