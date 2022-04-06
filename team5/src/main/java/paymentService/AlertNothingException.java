package paymentService;

public class AlertNothingException extends RuntimeException {
    public AlertNothingException(String message) {
        super(message);
    }
}
