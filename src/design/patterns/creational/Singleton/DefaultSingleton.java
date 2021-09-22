package design.patterns.creational.Singleton;

public class DefaultSingleton {
    private static DefaultSingleton ourInstance = new DefaultSingleton();

    private DefaultSingleton() {
    }

    public static DefaultSingleton getInstance() {
        return ourInstance;
    }
}
