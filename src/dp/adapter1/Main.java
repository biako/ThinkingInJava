package dp.adapter1;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class Main {
    public static void test (){
        // Up-cast to interface Print from class PrintAdapter
        // to emphasize only use the addmethods under the interface:
        Print printinterface = new PrintAdapter("abc");
        printinterface.printMethod1();
        printinterface.printMethod2();

    }
}

