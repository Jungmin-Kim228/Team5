package paymentService;

public class PaymemtService {
    private CustomerRepository customerRepository;

    public PaymemtService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Receipt pay(long productAmt, Long customerId) {
        if (productAmt == null || productAmt < 0) {
            throw IllegalAccessException("productAmt is invalid: " + productAmt);
        }
        Customer cusotmer = customerRepository.findById(customerId);

        return null;
    }
}
