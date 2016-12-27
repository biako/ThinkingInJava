package dp.templatemethod;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class StringDisplayMethod extends AbstractMethod {
    private String string;
    private int width;

    public StringDisplayMethod(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.format("|%s|\n", string);
    }

    @Override
    public void close() {
        printLine();
    }


    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) System.out.print("-");
        System.out.println("+");
    }
}
