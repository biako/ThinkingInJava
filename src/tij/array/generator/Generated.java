package tij.array.generator;

import tij.generics.genericinterface.Generator;

/**
 * Created by Xiaolong on 1/23/2017.
 *
 * Thinking in Java p551
 *
 * The first tool has two options, represented by an overloaded static method, array( ).
 *
 * The first version of the method takes an existing array and fills it using a Generator,
 * and the second version takes a Class object, a Generator, and the desired number of elements,
 * and creates a new array, again filling it using the Generator.
 *
 * Notice that this tool only produces arrays of Object subtypes and cannot create primitive arrays:
 *
 *
 */
public class Generated {
    // Fill an existing array:
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    // Create a new array:
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[])java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }
}
