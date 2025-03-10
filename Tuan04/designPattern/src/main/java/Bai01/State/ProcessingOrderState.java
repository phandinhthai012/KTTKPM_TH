package Bai01.State;

public class ProcessingOrderState implements OrderState {

    @Override
    public void doAction() {
        System.out.println("Processing order");
    }

    @Override
    public String getNameState() {
        return "Processing order";
    }

    @Override
    public OrderState preState() {
        return new NewOrderState();
    }

    @Override
    public OrderState nextState() {
        return new DeliveredOrderState();
    }
}
