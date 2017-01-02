package tij.array.basics;

import java.util.*;

/**
 * Created by Xiaolong on 1/2/2017.
 * <p>
 * Thinking in Java p540
 * <p>
 * Arrays.deepToString()
 * This method is designed for converting multidimensional arrays to strings.
 * The Arrays.deepToString( ) method works with both primitive arrays and object arrays:
 * <p>
 * <p>
 * You can see that primitive array values are automatically
 * initialized if you don't give them an explicit initialization value.
 * Arrays of objects are initialized to null.
 */
public class MultidimensionalPrimitiveArray {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3,},
                {4, 5, 6,},
        };
        System.out.println(Arrays.deepToString(a));

        // 3-D array with fixed length:
        // You can see that primitive array values are automatically
        // initialized if you don't give them an explicit initialization value.
        // Arrays of objects are initialized to null.
        int[][][] b = new int[2][2][4];
        System.out.println(Arrays.deepToString(b));
    }
}