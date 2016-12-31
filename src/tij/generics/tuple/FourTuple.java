package tij.generics.tuple;

/**
 * Created by Xiaolong on 12/31/2016.
 */
public class FourTuple <A,B,C,D> extends ThreeTuple<A,B,C>{
    public final D fourth;
    public FourTuple(A first, B second, C third,D fourth) {
        super(first, second, third);
        this.fourth = fourth;
    }

    @Override
    public String toString() {
        return super.toString() + " fourth:" + fourth;
    }
}
