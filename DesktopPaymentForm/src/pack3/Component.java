package pack3;

public abstract class Component {
    protected PaymentFormMediator mediator;

    public void setMediator(PaymentFormMediator mediator) {
        this.mediator = mediator;
    }
}
