package Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject{
    private String message;
    private boolean changed;
    private List<Observer> observers;
    private final Object MUTEX = new Object();

    public MyTopic(){
        this.observers = new ArrayList<>();
    }


    @Override
    public void register(Observer obj) {
        if(observers.contains(obj))
            return;
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg){
        System.out.println("Message Posted to Topic:"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }
}
