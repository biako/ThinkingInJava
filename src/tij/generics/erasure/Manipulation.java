package tij.generics.erasure;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Thinking in Java p464-465
 *
 * Example to illustrate the erasure in Java!
 *
 */

// Error: cannot find symbol: method f() if there is no <T extends HasF>:
class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }


    // Error: cannot find symbol: method f() if there is no <T extends HasF>:
    //public void manipulate() { obj.f(); }
    public void manipulate() {obj.f();}
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator =
                new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
