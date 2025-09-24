package pack3;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PaymentModeComponent extends Component {
    private ComboBox<String> comboBox;
    private HBox modePaiementBox;

    public PaymentModeComponent(PaymentFormMediator mediator) {
        this.mediator = mediator;
    	comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Carte de crédit", "Carte Cadeau", "Paiement à la livraison");//ce qui s'affiche dans les choix
        comboBox.setOnAction(e -> mediator.notify(this, "PaymentModeChanged"));
   
        Label modePaiementLabel = new Label("Mode de paiement :");
        modePaiementBox = new HBox(modePaiementLabel, comboBox);
        modePaiementBox.setSpacing(10);
    }

    public String getSelectedMode() {
        return comboBox.getValue();
    }

    public HBox getPaiementModeBox() {
        return modePaiementBox;
    }
    
    
}
