package Bai01.Context;

import Bai01.State.NewOrderState;
import Bai01.State.OrderState;
import Bai01.State.ProcessingOrderState;

public class Order {
    private OrderState currentState;
    private OrderState previousState;
    private OrderState nextState2;


    public Order() {
        currentState = new NewOrderState();
        previousState = null;
        nextState2 = new ProcessingOrderState();

    }

    public void doAction() {
        String preState = previousState == null ? "null" : previousState.getNameState();
        String curState = currentState.getNameState();
        String nextState = nextState2 == null ? "null" : nextState2.getNameState();
        System.out.println("Trạng thái trước đó: " + preState);
        System.out.println("Trạng thái hiện tại: " + curState);
        System.out.println("Trạng thái tiếp theo: " + nextState);

    }

    public void nextState() {
        if (currentState.nextState() != null) {
            previousState = currentState;        // Lưu trạng thái hiện tại làm previous
            currentState = currentState.nextState(); // Chuyển sang trạng thái kế tiếp
            nextState2 = currentState.nextState();
        } else {
            System.out.println("Không thể chuyển sang trạng thái tiếp theo.");
        }
    }

    public void preState() {
        if (currentState.preState() != null) {
            nextState2 = currentState;        // Lưu trạng thái hiện tại làm previous
            currentState = currentState.preState(); // Chuyển sang trạng thái kế tiếp
            previousState = currentState.preState();
        } else {
            System.out.println("Không thể chuyển sang trạng thái trước đó.");
        }
    }
}
