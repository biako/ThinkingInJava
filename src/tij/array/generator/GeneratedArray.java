package tij.array.generator;

import tij.generics.genericinterface.Generator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Xiaolong on 1/2/2017.
 * <p>
 * Thinking in Java p569
 * <p>
 * Using the generator to fill in an array
 */
class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }

    // A generic convenience method:
    public static <T> CollectionData<T>
    list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}

public class GeneratedArray {

    // Fill an existing array:
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    // Create a new array:
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type,
                                Generator<T> gen, int size) {
        T[] a =
                (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }


    public static void main(String[] args) {
        // Direct assignment
        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));

        // Fill an existing array
        // Call public static <T> T[] array(T[] a, Generator<T> gen)
        a = array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));

        // Create a new array:
        // Call public static <T> T[] array(Class<T> type, Generator<T> gen, int size)
        Integer[] b = array(Integer.class,
                new CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b));
    }

}
