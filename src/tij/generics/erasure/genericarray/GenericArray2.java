package tij.generics.erasure.genericarray;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Thinking in Java p.477
 *
 */
public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array; // Warning: unchecked cast
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai =
                new GenericArray2<>(10);
        for (int i = 0; i < 10; i++)
            gai.put(i, i);
        for (int i = 0; i < 10; i++)
            System.out.print(gai.get(i) + " ");
        System.out.println();

       /* if you call rep( ), it again attempts to cast the Object[] to a T[], which is still incorrect,
       and produces a warning at compile time and an exception at run time.
       Thus there’s no way to subvert the type of the underlying array,
       which can only be Object[].

       The advantage of treating array internally
       as Object[] instead of T[] is that it’s less likely that you’ll forget
       the runtime type of the array and accidentally introduce a bug (although
       the majority, and perhaps all, of such bugs would be rapidly detected at run time).*/

        try {
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}