package tij.array.basics;
import java.util.*;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p542
 *
 * Example to show how an array of non-primitive objects can be built up piece-by-piece:
 *
 */
public class AssemblingMultidimensionalArrays {
    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = i * j; // Autoboxing
        }
        System.out.println(Arrays.deepToString(a));
    }
}