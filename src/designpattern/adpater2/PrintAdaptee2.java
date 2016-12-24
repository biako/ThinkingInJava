package designpattern.adpater2;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class PrintAdaptee2 {
    private String text;

    public PrintAdaptee2(String text) {
        this.text = text;
    }

    public void printWithParen(){
        System.out.format("(%s)\n",text);
    }

    public void printWithAster(){
        System.out.format("*%s*\n",text);
    }
}
