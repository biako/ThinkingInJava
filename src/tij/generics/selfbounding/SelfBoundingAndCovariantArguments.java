package tij.generics.selfbounding;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p505
 *
 */
interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}
interface Setter extends SelfBoundSetter<Setter> {}

public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        // s1.set(sbs); // Error:
        // set(Setter) in SelfBoundSetter<Setter>
        // cannot be applied to (SelfBoundSetter)
    }
}