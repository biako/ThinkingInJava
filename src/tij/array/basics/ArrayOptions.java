package tij.array.basics;
import java.util.*;
/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p538
 *
 * Example to show Initialization & re-assignment of array:
 *
 * You can’t find out how many elements are actually in the array,
 * since length tells you only how many elements can be placed in
 * the array; that is, the size of the array object, not the number
 * of elements it actually holds. However, when an array object is
 * created, its references are automatically initialized to null,
 * so you can see whether a particular array slot has an object in
 * it by checking to see whether it’s null. Similarly, an array of
 * primitives is automatically initialized to zero for numeric types,
 * (char)o for char, and false for boolean.
 *
 */

// Initialization & re-assignment of arrays.
public class ArrayOptions {
    public static void main(String[] args) {


        // Arrays of objects:
        BerylliumSphere[] a; // Local uninitialized variable
        BerylliumSphere[] b = new BerylliumSphere[5];
        // The references inside the array are
        // automatically initialized to null:
        System.out.println("b: " + Arrays.toString(b));

        BerylliumSphere[] c = new BerylliumSphere[4];
        for(int i = 0; i < c.length; i++)
            if(c[i] == null) // Can test for null reference
                c[i] = new BerylliumSphere();


        // Aggregate initialization:
        BerylliumSphere[] d = { new BerylliumSphere(),
                new BerylliumSphere(), new BerylliumSphere()
        };

        // Dynamic aggregate initialization:
        a = new BerylliumSphere[]{
                new BerylliumSphere(), new BerylliumSphere(),
        };

        // (Trailing comma is optional in both cases)
        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
        a = d;
        System.out.println("a.length = " + a.length);


        // The second part of ArrayOptions.java shows that
        // primitive arrays work just like object arrays except
        // that primitive arrays hold the primitive values directly.
        // Arrays of primitives:
        int[] e; // Null reference
        int[] f = new int[5];
        // The primitives inside the array are
        // automatically initialized to zero:
        System.out.println("f: " + Arrays.toString(f));

        int[] g = new int[4];
        for(int i = 0; i < g.length; i++)
            g[i] = i*i;
        int[] h = { 11, 47, 93 };
        // Compile error: variable e not initialized:
        //!print("e.length = " + e.length);
        System.out.println("f.length = " + f.length);
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[]{ 1, 2 };
        System.out.println("e.length = " + e.length);
    }
}