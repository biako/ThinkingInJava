package thinkinginjava;

/**
 * Created by Xiaolong on 12/18/2016.
 */
class Base1 {
    public void method (){
        System.out.println("Base1 method called!");
    }
}

class Sub1 extends Base1 {
    @Override
    public void method() {
        super.method();
        System.out.println("Sub1's overridden method called!");
    }

    public void newMethod(){
        System.out.println("Sub1's newMethod called!");
    }
}

public class UpDownCastingTest {
    public static void run() {
        Base1 a = new Sub1();
        a.method(); //The overridden method will be called.
        //a.newMethod(); Cannot call Sub1's newly defined method.
        Sub1 b = (Sub1) a;
        b.newMethod();
    }

}
