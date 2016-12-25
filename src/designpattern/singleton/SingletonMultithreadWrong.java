package designpattern.singleton;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class SingletonMultithreadWrong {
    private static SingletonMultithreadWrong ourInstance = null;

    public static SingletonMultithreadWrong getInstance() {
        if (ourInstance == null)
            ourInstance = new SingletonMultithreadWrong();
        return ourInstance;
    }


    private SingletonMultithreadWrong() {
        System.out.println("A instance of SingletonMultithreadWrong initialized");
        slowdown();
    }

    private void slowdown() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
