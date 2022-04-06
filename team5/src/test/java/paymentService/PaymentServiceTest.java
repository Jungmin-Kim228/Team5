package paymentService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        Customer customer = new Customer(1L, 10000L);
        Long productAmt = 2000L;
        Long customerId = 1L;

        Receipt result = service.pay(productAmt, customerId);

        assertThat(customer.getBalance() - result.getProductAmt()).isEqualTo(8000L);


        // assertion w/ receipt
    }

    @DisplayName("결재 금액이 유효해야함.(null이면 안됨, 음수이면 안됨)")
    @Test
    void pay_productAmtInvalid_throwIllegalArgumentException() {
        Long productAmt = -1L;
        Long customerId = 0L;

        assertThatThrownBy(() -> service.pay(productAmt, customerId))
            .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("productAmt is invalid");

    }


    @DisplayName("계정이 없으면 예외 발생.")
    @Test
    void pay_notExistsCustomer_throwCustomerNotExistsException(){
        long productAmt = 1_000L;
        long customerId = -1;

        when(customerRepository.findById(customerId)).thenThrow(new CustomerNotExistsException("id가 존재하지 않습니다"));

        assertThatThrownBy(() -> service.pay(productAmt, customerId))
            .isInstanceOf(CustomerNotExistsException.class);
    }




}
