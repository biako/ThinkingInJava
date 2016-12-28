package tij.generics.tuple;

/**
 * Created by Xiaolong on 12/28/2016.
 */
public class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
    public final C third;
    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return super.toString() + " third:" + third;
    }
}
