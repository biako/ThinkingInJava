package tij.generics.wildcards;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 *
 */
import java.util.*;
public class GenericWriting {

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruit = new ArrayList<>();


    /**
     *
     * The writeExact( ) method uses an exact parameter type (no wildcards).
     * In f1( ) you can see that this works fine—as long as you only put an
     * Apple into a List<Apple>. However, writeExact( ) does not allow you
     * to put an Apple into a List<Fruit>, even though you know that should
     * be possible.
     *
     * */
    static void f1() {
        writeExact(apples, new Apple());
    // writeExact(fruit, new Apple()); // Error:
    // Incompatible types: found Fruit, required Apple
    }


    /**
     * In writeWithWildcard( ), the argument is now a List<? super T>,
     * so the List holds a specific type that is derived from T; thus
     * it is safe to pass a T or anything derived from T as an argument
     * to List methods. You can see this in f2( ), where it’s still
     * possible to put an Apple.
     *
     * */
    static <T> void
    writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }
    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args) { f1(); f2(); }
}