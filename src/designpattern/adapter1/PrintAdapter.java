package designpattern.adapter1;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class PrintAdapter extends PrintAdaptee implements Print {

    public PrintAdapter(String text) {
        super(text);
    }

    public void printMethod1() {
        this.printWithAster();
    }


    public void printMethod2() {
        this.printWithParen();
    }

}
