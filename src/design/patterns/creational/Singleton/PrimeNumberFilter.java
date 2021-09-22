package design.patterns.creational.Singleton;

public class PrimeNumberFilter {
    private static PrimeNumberFilter ourInstance = null;
    private final int MAXSIZE = 10000;
    private boolean[] numbers;

    private PrimeNumberFilter() {
        this.numbers = new boolean[MAXSIZE];
        //fill true if i sis prime in number[i] else false
    }

    public static PrimeNumberFilter getInstance() {
        if (ourInstance == null) {// first null check to avoid sync overhead while returning instance
            synchronized (ThreadSafe.class) {
                if (ourInstance == null)// second null null check to lazy load in sync
                    ourInstance = new PrimeNumberFilter();
            }
        }
        return ourInstance;
    }

    public boolean isPrime(int n) throws Exception {
        if (n > MAXSIZE)
            return numbers[MAXSIZE];
        else
            throw new Exception("Number Out Of Range");
    }
}
