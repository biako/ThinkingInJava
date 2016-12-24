package designpattern.adpater2;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class Main2 {
    public static void test (){
        new PrintAdapter2("abc").printMethod1();
        new PrintAdapter2("abc").printMethod2();
    }
}

