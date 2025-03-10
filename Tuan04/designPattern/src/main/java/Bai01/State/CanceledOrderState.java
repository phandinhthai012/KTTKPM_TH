package Bai01.State;

public class CanceledOrderState implements OrderState {

    @Override
    public void doAction() {
        System.out.println("Canceled order");
    }

    @Override
    public String getNameState() {
        return "Canceled order";
    }

    @Override
    public OrderState preState() {
        return new DeliveredOrderState();
    }

    @Override
    public OrderState nextState() {
        return null;
    }
}
