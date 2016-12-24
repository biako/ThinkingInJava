package designpattern.adapter1;

import java.security.PrivateKey;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class PrintAdaptee {
    private String text;

    public PrintAdaptee(String text) {
        this.text = text;
    }

    public void printWithParen(){
        System.out.format("(%s)\n",text);
    }

    public void printWithAster(){
        System.out.format("*%s*\n",text);
    }
}
