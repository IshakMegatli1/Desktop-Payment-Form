package pack3;

import javafx.scene.control.ComboBox;

public class PaymentMode extends Component {
    private ComboBox<String> comboBox;

    public PaymentMode() {
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Carte de crédit", "Carte Cadeau", "Paiement à la livraison");
        comboBox.setOnAction(e -> mediator.notify(this, "PaymentModeChanged"));
    }

    public String getSelectedMode() {
        return comboBox.getValue();
    }

    public ComboBox<String> getComboBox() {
        return comboBox;
    }
}
