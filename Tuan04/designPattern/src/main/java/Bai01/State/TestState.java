package Bai01.State;

import Bai01.Context.Order;

public class TestState {
    public static void main(String[] args) {
        Order order = new Order();

        order.doAction();     // Trạng thái đầu tiên
        System.out.println("----------------------");

        order.nextState();   // Chuyển sang trạng thái tiếp theo
        order.doAction();
        System.out.println("----------------------");

        order.nextState();
        order.doAction();
        System.out.println("----------------------");

        order.nextState();
        order.doAction();
        System.out.println("----------------------");

    }
}
