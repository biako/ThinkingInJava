package tij.generics.wildcards;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Thinking in Java p487
 *
 */
import java.util.*;

public class GenericReading {

    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());


    // A static method adapts to each call:
    /**
     * the first method readExact( ) uses the precise type.
     * So if you use the precise type with no wildcards,
     * you can both write and read that precise type into
     * and out of a List.
     *
     * In addition, for the return value,
     * the static generic method readExact( ) effectively "adapts"
     * to each method call, and returns an Apple from a List<Apple>
     * and a Fruit from a List<Fruit>, as you can see in f1( ).
     *
     * Thus, if you can get away with a static generic method,
     * you don't necessarily need covariance if you're just reading.
     *
     * */
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }

    // If, however, you have a class, then its type is
    // established when the class is instantiated:.
    /**
     * If you have a generic class, however, the parameter is established
     * for the class when you make an instance of that class. As you can
     * see in f2( ), the fruitReader instance can read a piece of Fruit
     * from a List<Fruit>, since that is its exact type. But a List<Apple>
     * should also produce Fruit objects, and the fruitReader doesn't allow this.
     *
     * */
    static class Reader<T> {
        T readExact(List<T> list) { return list.get(0); }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruit);
        // Fruit a = fruitReader.readExact(apples); // Error:
        // readExact(List<Fruit>) cannot be applied to (List<Apple>).
    }



    /**
     * To fix the problem, the CovariantReader.readCovariant( ) method
     * takes a List<? extends T>, and so it's safe to read a T from that
     * list (you know that everything in that list is at least a T, and
     * possibly something derived from a T). In f3( ) you can see that
     * it's now possible to read a Fruit from a List<Apple>.     *
     *
     * */

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitReader =
                new CovariantReader<>();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }


    public static void main(String[] args) {
        f1(); f2(); f3();
    }
}