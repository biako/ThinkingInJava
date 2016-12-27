package dp.adpater2;

/**
 * Created by Xiaolong on 12/25/2016.
 *
 * The adapter implements the interface and include a member from the adaptee class.
 *
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
