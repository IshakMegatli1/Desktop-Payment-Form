package pack3;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//component
public class CreditCard extends Component {
    private VBox creditCardBox;
    private TextField cardNumber;
    private TextField expirationDate;
    private TextField cvv;

    public CreditCard() {
     	creditCardBox = new VBox();
     	
    	//numero de carte
    	Label carteLabel = new Label("Numéro de carte :");
        cardNumber = new TextField();
        cardNumber.setPromptText("Card Number");
        HBox carteBox = new HBox(carteLabel, cardNumber);
        carteBox.setSpacing(10);
        
        //expiration
        Label expirationLabel = new Label("Date d'expiration :");
        expirationDate = new TextField();
        expirationDate.setPromptText("MM/YY");
        HBox expirationBox = new HBox(expirationLabel, expirationDate);
        expirationBox.setSpacing(10);
        
        //Code sécurité
        Label codeLabel = new Label("Code de sécurité :");
        cvv = new TextField();
        cvv.setPromptText("CVV");
        HBox cvvBox = new HBox(codeLabel, cvv);
        cvvBox.setSpacing(10);
        
        
        creditCardBox.getChildren().addAll(carteBox, expirationBox, cvvBox); //mettre les HBox visible
        creditCardBox.setVisible(false);
    }
  
    
    public void setVisible(boolean visible) {
        creditCardBox.setVisible(visible);
    }

    public VBox getCreditCardBox() {
        return creditCardBox;
    }
}
