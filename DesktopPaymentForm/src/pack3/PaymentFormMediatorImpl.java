package pack3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PaymentFormMediatorImpl implements PaymentFormMediator {
    private PaymentModeComponent paymentModeComponent;
    private CreditCard creditCardComponent;
    private GiftCard giftCardComponent;
    private Address deliveryAddressComponent;
    private Address billingAddressComponent;
    private DeliveryOption deliveryOptionComponent;
    private SameAddressCheckbox sameAddressCheckboxComponent;

    public void setPaymentModeComponent(PaymentModeComponent paymentModeComponent) {
        this.paymentModeComponent = paymentModeComponent;
    }

    public void setCreditCardComponent(CreditCard creditCardComponent) {
        this.creditCardComponent = creditCardComponent;
    }

    public void setGiftCardComponent(GiftCard giftCardComponent) {
        this.giftCardComponent = giftCardComponent;
    }

    public void setDeliveryAddressComponent(Address deliveryAddressComponent) {
        this.deliveryAddressComponent = deliveryAddressComponent;
    }

    public void setBillingAddressComponent(Address billingAddressComponent) {
        this.billingAddressComponent = billingAddressComponent;
    }

    public void setDeliveryOptionComponent(DeliveryOption deliveryOptionComponent) {
        this.deliveryOptionComponent = deliveryOptionComponent;
    }

    public void setSameAddressCheckboxComponent(SameAddressCheckbox sameAddressCheckboxComponent) {
        this.sameAddressCheckboxComponent = sameAddressCheckboxComponent;
    }

    /*@Override
    public void notify(Component sender, String event) {
        if (sender instanceof PaymentModeComponent) {
            handlePaymentModeChange(((PaymentModeComponent) sender).getSelectedMode());
        } else if (sender instanceof SameAddressCheckbox) {
            handleSameAddressCheckboxChange(((SameAddressCheckbox) sender).isChecked());
        }
    }*/
    
    @Override
    public void notify(Component sender, String event) {
        if (sender instanceof SameAddressCheckbox && "SameAddressCheckboxChanged".equals(event)) {
            boolean sameAddress = sameAddressCheckboxComponent.isChecked();
            if (sameAddress) {
                String deliveryAddress = deliveryAddressComponent.getAddress();
                updateBillingAddress(deliveryAddress);
                billingAddressComponent.setEditable(false);
            } else {
                billingAddressComponent.setEditable(true);
            }
        } else if (sender instanceof PaymentModeComponent && "PaymentModeChanged".equals(event)) {
            String selectedPaymentMode = paymentModeComponent.getSelectedMode();
            handlePaymentModeChange(((PaymentModeComponent) sender).getSelectedMode());
            updateDeliveryOptions(selectedPaymentMode);
        }
    }

    private void handlePaymentModeChange(String selectedMode) {
        if ("Carte de crédit".equals(selectedMode)) {
            creditCardComponent.setVisible(true);
            giftCardComponent.setVisible(false);
        } else if ("Carte Cadeau".equals(selectedMode)) {
            creditCardComponent.setVisible(false);
            giftCardComponent.setVisible(true);
        } else {
            creditCardComponent.setVisible(false);
            giftCardComponent.setVisible(false);
        }
    }

    private void handleSameAddressCheckboxChange(boolean isChecked) { //Empeche la modification de l'adrresse de facturation
        if (isChecked) {
            billingAddressComponent.setAddress(deliveryAddressComponent.getAddress());
            billingAddressComponent.setEditable(false);
        } else {
            billingAddressComponent.setEditable(true);
        }
    }
    
    @Override
    public void updateBillingAddress(String address) {
        billingAddressComponent.setAddress(address);
    }
    
    public void updateDeliveryOptions(String paymentMode) {
        ObservableList<String> options = FXCollections.observableArrayList("Livraison en main propre", "Se retrouver à l’extérieur", "Laisser à la porte");
        if ("Paiement à la livraison".equals(paymentMode)) {
            options.remove("Laisser à la porte");
        }
        deliveryOptionComponent.updateOptions(options);
    }
}
