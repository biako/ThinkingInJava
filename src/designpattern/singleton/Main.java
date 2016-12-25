package designpattern.singleton;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class Main extends Thread {
    //Constructor for thread
    public Main(String name) {
        super(name);
    }

    public static void test() {
        System.out.println("Start");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println("obj1 == obj2?: " + (obj1 == obj2));
        System.out.println("End");
    }

    public static void multiThreadTest() {
        System.out.println("Start");
        new Main("A").start();
        new Main("B").start();
        new Main("C").start();
        System.out.println("End");
    }


    public void run() {
        //System.out.println("Wrong Singleton");
        SingletonMultithreadWrong obj1 = SingletonMultithreadWrong.getInstance();
        System.out.format("%s: obj1=%s\n",getName(), obj1);

        //System.out.println("Wrong Singleton");
        SingletonMultithreadRight obj2 = SingletonMultithreadRight.getInstance();
        System.out.format("%s: obj2=%s\n",getName(), obj2);

        //System.out.println("Singleton");
        Singleton obj3 = Singleton.getInstance();
        System.out.format("%s: obj3=%s\n",getName(), obj3);
    }


}
