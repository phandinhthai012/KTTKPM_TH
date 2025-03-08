package SingletonPattern;

public class BillPughSingleton {
    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new
                BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public static void main(String[] args) {
        // Get the first instance
        BillPughSingleton instance1 = BillPughSingleton.getInstance();

        // Get the second instance
        BillPughSingleton instance2 = BillPughSingleton.getInstance();

        // Print both instances to verify that they are the same
        System.out.println(instance1);
        System.out.println(instance2);

        // Verify if the instances are the same (singleton check)
        if (instance1 == instance2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }
    }
}
