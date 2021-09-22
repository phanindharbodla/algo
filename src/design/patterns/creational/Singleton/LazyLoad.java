package design.patterns.creational.Singleton;

public class LazyLoad {
    private static LazyLoad ourInstance = null;

    private LazyLoad() {
    }

    public static LazyLoad getInstance() {
        if (ourInstance == null) {
            ourInstance = new LazyLoad();
        }
        return ourInstance;
    }
}
