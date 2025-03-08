package SingletonPattern;

public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;
    private StaticBlockSingleton(){}
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    public static StaticBlockSingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        // Get the first instance
        StaticBlockSingleton instance1 = StaticBlockSingleton.getInstance();

        // Get the second instance
        StaticBlockSingleton instance2 = StaticBlockSingleton.getInstance();

        // Print both instances
        System.out.println(instance1);
        System.out.println(instance2);

        if (instance1 == instance2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }
    }
}
