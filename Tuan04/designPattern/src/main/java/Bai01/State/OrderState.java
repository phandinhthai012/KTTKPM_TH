package Bai01.State;

public interface OrderState {

    public void doAction();
    public String getNameState();
    public OrderState preState();
    public OrderState nextState();
}
