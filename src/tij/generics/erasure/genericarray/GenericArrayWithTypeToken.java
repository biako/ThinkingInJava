package tij.generics.erasure.genericarray;

import java.lang.reflect.*;

/**
 * Created by Xiaolong on 1/1/2017.
 * <p>
 * Thinking in Java p.478-479
 * <p>
 * Pass in a type token in this case with the constructor
 * <p>
 * Use Array.newInstance(Class<?> componentType, int length) to create an array of the exact type
 * <p>
 * <p>
 * The type token Class<T> is passed into the constructor in order
 * to recover from the erasure, so that we can create the actual type
 * of array that we need, although the warning from the cast must be
 * suppressed with @SuppressWarnings. Once we do get the actual type,
 * we can return it and get the desired results, as you see in main( ).
 * The runtime type of the array is the exact type T[].
 */

public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    // Pass in a Class object as type token
    public GenericArrayWithTypeToken(Class<T> type, int sz) {

        // Use this Array static method to create an actual array of type T
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Expose the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {

        GenericArrayWithTypeToken<Integer> gai =
                new GenericArrayWithTypeToken<>(
                        Integer.class, 2);

        // This now works:
        Integer[] ia = gai.rep();

        for (int i = 0; i < ia.length; i++) {
            System.out.println(i + ": " + ia[i]);
        }


        // NOTE!! Must use Wrapper type for foreach if there is empty elements in Integer array.
        for (Integer a : ia) {
            System.out.println(a);
        }

        int[]intarray = {1, 2};

        for (int i = 0; i < intarray.length; i++) {
            System.out.println(i + ": " + intarray[i]);
        }

        for (int a : intarray) {
            System.out.println(a);
        }


    }
}
