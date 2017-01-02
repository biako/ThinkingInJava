package tij.array.utilities;

import java.util.Arrays;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p555-556
 *
 * Copying arrays by using System.arraycopy()
 *
 * public static native void arraycopy(Object src, int  srcPos, Object dest, int destPos, int length);
 *
 *
 */
public class CopyingArrays {
    public static void main(String[] args) {
        // Primitives:
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j = " + Arrays.toString(j));

        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);
        System.out.println("k = " + Arrays.toString(k));

        Arrays.fill(k, 103);
        System.arraycopy(k, 0, i, 0, k.length);
        System.out.println("i = " + Arrays.toString(i));


        // Objects:
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, new Integer(47));
        Arrays.fill(v, new Integer(99));
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("v = " + Arrays.toString(v));
        System.arraycopy(v, 0, u, u.length / 2, v.length);
        System.out.println("u = " + Arrays.toString(u));
    }
}