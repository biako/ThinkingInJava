package designpattern.singleton;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
        System.out.println("A instance of Singleton initialized");
    }
}
