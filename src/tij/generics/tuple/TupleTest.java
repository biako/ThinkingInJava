package tij.generics.tuple;

/**
 * Created by Xiaolong on 12/28/2016.
 *
 * Thinking in Java p443
 *
 */




public class TupleTest {
    public static TwoTuple<String, Integer> f() {
        // Autoboxing converts the int to Integer:
        return new TwoTuple<>("hi", 47);
    }

    public static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(
                new Amphibian(), "hi", 47);
    }

    public static FourTuple<Vehicle, Amphibian,  String, Integer> h() {
        return new FourTuple<>(
                new Vehicle(), new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        System.out.println(f());
        System.out.println(g());
    }

}
