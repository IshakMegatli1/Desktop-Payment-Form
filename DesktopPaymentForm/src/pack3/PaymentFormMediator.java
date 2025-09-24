package pack3;


//mediateur

public interface PaymentFormMediator {
    void notify(Component sender, String event);
    void updateBillingAddress(String address);
    void updateDeliveryOptions(String paymentMode);
}
