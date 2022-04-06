package paymentService;

public class AlertDummy {
    Boolean alert(Boolean check) {
        if (!check) {
            throw new AlertNothingException();
        }
        return check;
    }

}
