package paymentService;

import java.util.Map;

public class CustomerRepository {

    Map<Long, Customer> customers;

    public CustomerRepository(Map<Long, Customer> customers) {
        this.customers = customers;
    }

    /**
    * @throws 만약 존재하지 않는 아이디로 조회할 경우 예외를 발생한다.
     */
    public Customer findById(Long customerId) {
        // TODO
        if(customers.get(customerId) == null){
            throw new CustomerNotExistsException(customerId + "가 존재하지 않습니다.");
        }
        return customers.get(customerId);
    }


}
