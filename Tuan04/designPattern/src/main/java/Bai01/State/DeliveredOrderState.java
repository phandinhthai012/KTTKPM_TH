package Bai01.State;

public class DeliveredOrderState implements OrderState {

    @Override
    public void doAction() {
        System.out.println("Delivered order");
    }

    @Override
    public String getNameState() {
        return "Delivered order";
    }

    @Override
    public OrderState preState() {
        return new ProcessingOrderState();
    }

    @Override
    public OrderState nextState() {
        return new CanceledOrderState();
    }
}
