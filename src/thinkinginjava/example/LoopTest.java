package thinkinginjava.example;

/**
 * Created by Xiaolong on 12/24/2016.
 */
public class LoopTest {

    public static void test() {
        int i = 0;
        while (i != 10) {
            System.out.println(i);
            i++;
        }
    }

    public static boolean test1(int i) {
        if (i < 10) {
            return true;
        } else {
            return false;

        }

    }
}
