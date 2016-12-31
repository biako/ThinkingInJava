package tij.generics.tuple;


import static tij.generics.tuple.Tuple.tuple;

/**
 * Created by Xiaolong on 12/31/2016.
 *
 * Thinking in Java p455
 *
 * Notice that f( ) returns a parameterized TwoTuple object,
 * while f2( ) returns an unparameterized TwoTuple object.
 *
 * The compiler doesn’t warn about f2( ) in this case because
 * the return value is not being used in a parameterized fashion;
 * in a sense, it is being "upcast" to an unparameterized TwoTuple.
 *
 * However, if you were to try to capture the result of f2( ) into a
 * parameterized TwoTuple, the compiler would issue a warning.
 *
 */
public class TulpleTest2 {
    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
    }
}
