package pack3;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Address extends Component {
    private VBox addressBox;
    private TextField addressField;

    public Address(String addressType) {
    	Label addressLabel = new Label(addressType); //addressType peut etre : Addresse de livraison ou addresse de facturation
        addressBox = new VBox();
        addressField = new TextField();
        addressField.setPromptText(addressType);
        HBox addressHBox = new HBox(addressLabel, addressField);
        
        addressHBox.setSpacing(10);
        addressBox.getChildren().add(addressHBox);
    }

    public void setAddress(String address) {
        addressField.setText(address);
    }

    public String getAddress() {
        return addressField.getText();
    }

    public void setEditable(boolean editable) {
        addressField.setEditable(editable); //on peut modifier où non l'adresse
    }

    public VBox getAddressBox() {
        return addressBox;
    }
}
