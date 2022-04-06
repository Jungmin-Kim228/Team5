package paymentService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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

    @DisplayName("실 결재 금액을 기준으로 적립율에 따라서 적립됨.")
    @Test
    void pay_and_save_and_callAlert() {
        Long productAmt = 2000L;
        Long customerId = 1L;

        Customer customer = new Customer(customerId, 10000L, 0L);
        when(customerRepository.findById(customerId)).thenReturn(customer);

        Receipt result = service.pay(productAmt, customerId);

        assertThat(customer.getBalance()).isEqualTo(8000L);
        assertThat(customer.getPoint()).isEqualTo(100L);
        assertThat(result).isNotNull();

//        verify(alertDummy).alertCall();
    }

    @DisplayName("가지고 있는 포인트가 결제 금액보다 큰 경우")
    @Test
    void pay_more_point_than_productAmt() {
        Long productAmt = 2000L;
        Long customerId = 1L;

        Customer customer = new Customer(customerId, 10000L, 5000L);
        when(customerRepository.findById(customerId)).thenReturn(customer);

        Receipt result = service.pay(productAmt, customerId);

        assertThat(customer.getBalance()).isEqualTo(10000L);
        assertThat(customer.getPoint()).isEqualTo(3000L);
    }

    @DisplayName("가지고 있는 포인트가 결제 금액보다 같은 경우")
    @Test
    void pay_less_point_than_productAmt() {
        Long productAmt = 2000L;
        Long customerId = 1L;

        Customer customer = new Customer(customerId, 10000L, 2000L);
        when(customerRepository.findById(customerId)).thenReturn(customer);

        Receipt result = service.pay(productAmt, customerId);

        assertThat(customer.getBalance()).isEqualTo(10000L);
        assertThat(customer.getPoint()).isEqualTo(0L);
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
