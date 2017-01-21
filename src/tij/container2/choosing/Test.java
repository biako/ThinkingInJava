package tij.container2.choosing;

/**
 * Created by Xiaolong on 1/21/2017.
 * <p>
 * Thinking in Java p618
 *
 * Framework for performing timed tests of containers.
 */
//
public abstract class Test<C> {
    String name;
    public Test(String name) { this.name = name; }

    // Override this method for different tests.
    // Returns actual number of repetitions of test.
    abstract int test(C container, TestParam tp);
}