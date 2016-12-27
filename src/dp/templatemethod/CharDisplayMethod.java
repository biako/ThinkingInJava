package dp.templatemethod;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class CharDisplayMethod extends AbstractMethod {
    private char ch;

    public CharDisplayMethod(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
