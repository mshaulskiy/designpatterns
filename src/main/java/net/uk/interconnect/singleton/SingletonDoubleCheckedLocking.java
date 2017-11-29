package net.uk.interconnect.singleton;

/**
 * Created by mshaulskiy on 21/02/2017.
 */
public class SingletonDoubleCheckedLocking {

    private static volatile SingletonDoubleCheckedLocking singleton;

    private SingletonDoubleCheckedLocking() {

    }

    public static SingletonDoubleCheckedLocking getInstance() {
        // Check 1 of the double-checked lock
        if (singleton == null) {
            synchronized (SingletonDoubleCheckedLocking.class) {
                // Check 2 of the double-checked lock
                if (singleton == null) {
                    singleton = new SingletonDoubleCheckedLocking();
                }
            }
        }
        return singleton;
    }
}
