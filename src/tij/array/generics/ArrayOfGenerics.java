package tij.array.generics;

import java.util.*;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p544
 *
 * Although you cannot create an actual array object
 * that holds generics, you can create an array of the non-generified type and cast it:
 *
 */

class BerylliumSphere {
}

public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la; // "Unchecked" warning
        ls[0] = new ArrayList<String>();

        // Compile-time checking produces an error:
        //! ls[1] = new ArrayList<Integer>();
        // The problem: List<String> is a subtype of Object

        Object[] objects = ls; // So assignment is OK

        // Compiles and runs without complaint:
        objects[1] = new ArrayList<Integer>();

        // However, if your needs are straightforward it is
        // possible to create an array of generics, albeit
        // with an "unchecked" warning:
        List<BerylliumSphere>[] spheres =
                (List<BerylliumSphere>[])new List[10];

        for(int i = 0; i < spheres.length; i++)
            spheres[i] = new ArrayList<BerylliumSphere>();
    }
}