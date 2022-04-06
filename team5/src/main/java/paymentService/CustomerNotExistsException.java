package paymentService;

public class CustomerNotExistsException extends IllegalArgumentException {
    public CustomerNotExistsException(String s) {
        super(s);
    }
}
