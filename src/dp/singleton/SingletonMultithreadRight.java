package dp.singleton;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class SingletonMultithreadRight {
    private static SingletonMultithreadRight ourInstance = null;

    //Add synchronized here to make it thread-safe
    public static synchronized SingletonMultithreadRight getInstance() {
        if (ourInstance == null)
            ourInstance = new SingletonMultithreadRight();
        return ourInstance;
    }


    private SingletonMultithreadRight() {
        System.out.println("A instance of SingletonMultithreadRight initialized");
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
