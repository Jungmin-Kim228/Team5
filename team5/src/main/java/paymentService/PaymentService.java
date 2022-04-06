package paymentService;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();

        customers.add(new Customer("one", 0, 0));
        customers.add(new Customer("two", 1000, 1000));
        customers.add(new Customer("three", 10000, 0));

    }
}