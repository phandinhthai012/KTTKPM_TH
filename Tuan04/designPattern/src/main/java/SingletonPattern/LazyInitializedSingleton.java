package SingletonPattern;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    private LazyInitializedSingleton(){}
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazyInitializedSingleton instance1 = LazyInitializedSingleton.getInstance();

        // Get the second instance
        LazyInitializedSingleton instance2 = LazyInitializedSingleton.getInstance();

        // Print both instances
        System.out.println(instance1);
        System.out.println(instance2);

        // Check if both instances are the same
        if (instance1 == instance2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }

    }
}
