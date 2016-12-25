package designpattern.templatemethod;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class Main {
    public static void test (){
        AbstractMethod d1 = new CharDisplayMethod('C');
        AbstractMethod d2 = new StringDisplayMethod("Hello");
        AbstractMethod d3 = new StringDisplayMethod("World");
        d1.display();
        d2.display();
        d3.display();

    }
}

