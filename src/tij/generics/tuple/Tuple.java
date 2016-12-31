package tij.generics.tuple;

/**
 * Created by Xiaolong on 12/31/2016.
 */
public class Tuple {
    // The method's argument type is <A, B>; TwoTuple also holds <A, B>
    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<A, B, C>(a, b, c);
    }

}

