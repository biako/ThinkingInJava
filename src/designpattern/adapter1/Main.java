package designpattern.adapter1;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class Main {
    public static void test (){
        new PrintAdapter("abc").printMethod1();
        new PrintAdapter("abc").printMethod2();
    }
}

