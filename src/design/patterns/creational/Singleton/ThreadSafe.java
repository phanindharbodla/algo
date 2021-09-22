package design.patterns.creational.Singleton;

public class ThreadSafe {
    private static volatile ThreadSafe ourInstance = null;

    private ThreadSafe() {
    }

    public static ThreadSafe getInstance() {
        if (ourInstance == null) {// first null check to avoid sync overhead while returning instance
            synchronized (ThreadSafe.class) {
                if (ourInstance == null)// second null null check to lazy load in sync
                    ourInstance = new ThreadSafe();
            }
        }
        return ourInstance;
    }

    public static void main(String args[]) {
        ThreadSafe i1 = ThreadSafe.getInstance();
        ThreadSafe i2 = ThreadSafe.getInstance();

        System.out.println(i1);
        System.out.println(i2);

    }
}
