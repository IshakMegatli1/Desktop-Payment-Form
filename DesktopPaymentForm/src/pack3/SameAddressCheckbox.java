package pack3;

import javafx.scene.control.CheckBox;
//component
public class SameAddressCheckbox extends Component {
    private CheckBox checkBox;
    private PaymentFormMediator mediator;
    
    public SameAddressCheckbox(PaymentFormMediator mediator) {
    	this.mediator = mediator;
        checkBox = new CheckBox("Use same address for billing");
        checkBox.setOnAction(e -> mediator.notify(this, "SameAddressCheckboxChanged"));
    }

    public void setChecked(boolean checked) {
        checkBox.setSelected(checked);
    }

    public boolean isChecked() {
        return checkBox.isSelected();
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }
}
