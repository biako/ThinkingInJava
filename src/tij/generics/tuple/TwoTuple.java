package tij.generics.tuple;


/**
 * Created by Xiaolong on 12/28/2016.
 *
 * Thinking in Java p442
 *
 */
class ClassTypeA {
}

class ClassTypeB {
}

class ClassTypeC {
}

public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "first:" + first + " second:" + second;
    }

    public static void main(String[] args) {
        TwoTuple<ClassTypeA, ClassTypeB> twotuple = new TwoTuple<>(new ClassTypeA(), new ClassTypeB());
        System.out.println(twotuple);
        System.out.println(twotuple.first.getClass().getSimpleName());
        System.out.println(twotuple.second.getClass().getSimpleName());

        ThreeTuple<ClassTypeA, ClassTypeB, ClassTypeC> threeTuple =
                new ThreeTuple(new ClassTypeA(), new ClassTypeB(), new ClassTypeC());
        System.out.println(threeTuple);
        System.out.println(threeTuple.first.getClass().getSimpleName());
        System.out.println(threeTuple.second.getClass().getSimpleName());
        System.out.println(threeTuple.third.getClass().getSimpleName());

    }
}



