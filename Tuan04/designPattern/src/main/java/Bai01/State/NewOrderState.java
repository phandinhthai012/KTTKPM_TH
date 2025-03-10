package Bai01.State;

public class NewOrderState implements OrderState{
    @Override
    public void doAction() {
        System.out.println("New order state");
    }

    @Override
    public String getNameState() {
        return "New order state";
    }

    @Override
    public OrderState preState() {
        return null;
    }

    @Override
    public OrderState nextState() {
        return new ProcessingOrderState();
    }
}
