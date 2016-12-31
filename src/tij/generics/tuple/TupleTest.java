package tij.generics.tuple;

/**
 * Created by Xiaolong on 12/28/2016.
 *
 * Thinking in Java p443
 *
 */
class Vehicle {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

class Amphibian {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        // Autoboxing converts the int to Integer:
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(
                new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        System.out.println(f());
        System.out.println(g());
    }

}
