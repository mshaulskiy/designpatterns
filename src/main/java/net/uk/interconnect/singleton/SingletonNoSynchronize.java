package net.uk.interconnect.singleton;

/**
 * Created by mshaulskiy on 21/02/2017.
 */
public class SingletonNoSynchronize {

    /*
     * We maintain just one private static instance
     * This is the single object
     */

    /**
     * Instantiate this member variable eagerly, to make sure that
     * this happens exacly once, and the getter then need not be synchronized
     */
    private volatile static SingletonNoSynchronize singleton = new SingletonNoSynchronize();

    /**
     * The private constructor is the key:
     * nobody can instantiate outside the class
     */
    private SingletonNoSynchronize(){

    }

    public static SingletonNoSynchronize getSingleton(){
        return singleton;
    }
}
