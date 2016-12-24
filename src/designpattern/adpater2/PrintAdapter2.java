package designpattern.adpater2;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class PrintAdapter2 implements Print2 {

    private PrintAdaptee2 printeradaptee;

    public PrintAdapter2(String text) {
        this.printeradaptee = new PrintAdaptee2(text);
    }

    public void printMethod1() {
        printeradaptee.printWithAster();
    }


    public void printMethod2() {
        printeradaptee.printWithParen();

    }

}
