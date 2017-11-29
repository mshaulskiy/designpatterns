package net.uk.interconnect.singleton;

/**
 * Created by mshaulskiy on 21/02/2017.
 */
public class SingletonExample {

    /**
     * We maintain just one private, static instance
     * this is the singleton object
     */
    private static SingletonExample singleton;

    /**
     * The private constructor is the key:
     * nobody can instantiate outside the class
     */
    private SingletonExample(){

    }

    /**
     * The methode must be marked synchronized, else
     * it is possible that two different threads  might
     * enter this method simultaneously and create
     * more than one instance of the object
     */
    public static synchronized SingletonExample getInstance(){
        if(singleton == null){
            singleton = new SingletonExample();
        }
        return singleton;
    }
}
