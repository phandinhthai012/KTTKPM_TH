package SingletonPattern;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){}
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        // Testing the synchronized method
        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();

        // Testing the double-checked locking method
        ThreadSafeSingleton instance3 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
        ThreadSafeSingleton instance4 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();

        // Print both instances to confirm they are the same
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance3);
        System.out.println(instance4);

        // Verify if the instances are the same (singleton check)
        System.out.println("Are instance1 and instance2 the same? " + (instance1 == instance2));
        System.out.println("Are instance3 and instance4 the same? " + (instance3 == instance4));



        // Creating multiple threads to test the Singleton
        Thread thread1 = new Thread(new SingletonTask(), "Thread 1");
        Thread thread2 = new Thread(new SingletonTask(), "Thread 2");
        Thread thread3 = new Thread(new SingletonTask(), "Thread 3");
        Thread thread4 = new Thread(new SingletonTask(), "Thread 4");

        // Starting the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
    static class SingletonTask implements Runnable {
        @Override
        public void run() {
            // Calling getInstanceUsingDoubleLocking() method to test Singleton behavior
            ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();

            // Printing the instance with the thread name to see if it's the same instance
            System.out.println(Thread.currentThread().getName() + " - " + instance);
        }
    }
}
