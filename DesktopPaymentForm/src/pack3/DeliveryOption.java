package pack3;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DeliveryOption extends Component {
    private ComboBox<String> comboBox;
    private HBox deliveryOptionBox;
    
    public DeliveryOption() {
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Livraison en main propre", "Se retrouver à l’extérieur", "Laisser à la porte");
        comboBox.setOnAction(e -> mediator.notify(this, "DeliveryOptionChanged"));
        
        Label deliveryOptionLabel = new Label("Options de Livraison :");
        deliveryOptionBox = new HBox(deliveryOptionLabel, comboBox);
        deliveryOptionBox.setSpacing(10);
    }

    public String getSelectedOption() {
        return comboBox.getValue();
    }

    public ComboBox<String> getComboBox() {
        return comboBox;
    }
    
    public HBox getDeliveryOptionBox() {
        return deliveryOptionBox;
    }
    
    public void updateOptions(ObservableList<String> options) {
        comboBox.setItems(options);
    }
}
