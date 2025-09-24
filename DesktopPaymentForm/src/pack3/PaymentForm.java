package pack3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaymentForm extends Application {
    @Override
    public void start(Stage primaryStage) {
        PaymentFormMediatorImpl mediator = new PaymentFormMediatorImpl();

        PaymentModeComponent paymentMode = new PaymentModeComponent(mediator);
        CreditCard creditCard = new CreditCard();
        GiftCard giftCard = new GiftCard();
        Address deliveryAddress = new Address("Addresse de Livraison :");
        Address billingAddress = new Address("Addresse de Facturation :");
        DeliveryOption deliveryOption = new DeliveryOption();
        SameAddressCheckbox sameAddressCheckbox = new SameAddressCheckbox(mediator);

        paymentMode.setMediator(mediator);
        creditCard.setMediator(mediator);
        giftCard.setMediator(mediator);
        deliveryAddress.setMediator(mediator);
        billingAddress.setMediator(mediator);
        deliveryOption.setMediator(mediator);
        sameAddressCheckbox.setMediator(mediator);

        mediator.setPaymentModeComponent(paymentMode);
        mediator.setCreditCardComponent(creditCard);
        mediator.setGiftCardComponent(giftCard);
        mediator.setDeliveryAddressComponent(deliveryAddress);
        mediator.setBillingAddressComponent(billingAddress);
        mediator.setDeliveryOptionComponent(deliveryOption);
        mediator.setSameAddressCheckboxComponent(sameAddressCheckbox);

        VBox root = new VBox();
        root.getChildren().addAll(          //ajouter dans la page principale 
            paymentMode.getPaiementModeBox(),
            giftCard.getGiftCardBox(),
            creditCard.getCreditCardBox(),
            
            deliveryAddress.getAddressBox(),
            sameAddressCheckbox.getCheckBox(),
            billingAddress.getAddressBox(),
            deliveryOption.getDeliveryOptionBox()
        );

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Paiement de la commande");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
