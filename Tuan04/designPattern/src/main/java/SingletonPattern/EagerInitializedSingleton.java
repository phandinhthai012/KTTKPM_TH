package SingletonPattern;

public class EagerInitializedSingleton {
    private static final  EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton(){};

    public  static EagerInitializedSingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        EagerInitializedSingleton eagerInitializedSingleton1 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton eagerInitializedSingleton2 = EagerInitializedSingleton.getInstance();
        System.out.println(eagerInitializedSingleton1);
        System.out.println(eagerInitializedSingleton1);
        if(eagerInitializedSingleton1==eagerInitializedSingleton2){
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }
    }
}
