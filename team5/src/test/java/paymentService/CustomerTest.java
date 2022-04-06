package paymentService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("one",20,30);
    }

    @Test
    void Check_madeCustomer() {
        assertThat(customer.getId()).isEqualTo("one");
    }
}