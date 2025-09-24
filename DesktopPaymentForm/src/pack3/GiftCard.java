package pack3;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class GiftCard extends Component {
    private VBox giftCardBox;
    private TextField giftCardNumber;

    public GiftCard() {
        giftCardBox = new VBox();
        giftCardNumber = new TextField();
        giftCardNumber.setPromptText("Gift Card Number");
        giftCardBox.getChildren().add(giftCardNumber);
        giftCardBox.setVisible(false);
    }

    public void setVisible(boolean visible) {
        giftCardBox.setVisible(visible);
    }

    public VBox getGiftCardBox() {
        return giftCardBox;
    }
}
