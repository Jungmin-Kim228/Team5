package paymentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
    // SUT
    PaymentService service;
    // DOC
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = mock(CustomerRepository.class);
        service = new PaymentService(customerRepository);
    }

    @Test
    void pay() {
        long productAmt = 0L;
        Long customerId = 0L;

        Receipt result = service.pay(productAmt, customerId);

        // assertion w/ receipt
    }

    @Test
    void pay_productAmtInvalid_throwIllegalArgumentException() {
        long productAmt = null;
        Long customerId = 0L;

        assertThrownBy(() -> service.pay(productAmt, customerId))
            .isInstanceOf(IllegalAccessException.class);
    }

    @Test
    void pay_notExistsCustomer_throwCustomerNotExistsException {
        long productAmt = 1_000L;
        Long customerId = -1;

        when(customerRepository.findById(customerId)).thenThrow(new CustomerNotExistsException())

        assertThrownBy(() -> service.pay(productAmt, customerId))
            .isInstanceOf(CustomerNotExistsException.class);
    }
}
