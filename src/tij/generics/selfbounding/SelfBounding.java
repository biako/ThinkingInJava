package tij.generics.selfbounding;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 *
 * Thinking in Java p502
 *
 * This forces you to pass the class that you are defining as a parameter to the base class.
 * What’s the added value in self-bounding the parameter?
 * The type parameter must be the same as the class being defined.
 *
 * As you can see in the definition of class B, you can also derive
 * from a SelfBounded that uses a parameter of another SelfBounded,
 * although the predominant use seems to be the one that you see for
 * class A.
 *
 * The attempt to define E shows that you cannot use a type parameter
 * that is not a SelfBounded.
 *
 * Unfortunately, F compiles without warnings, so the self-bounding idiom
 * is not enforceable. If it’s really important, it may require an external
 * tool to ensure that raw types are not being used in place of parameterized types.
 *
 */
class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() { return element; }
}

class A extends SelfBounded<A> {}

class B extends SelfBounded<A> {} // Also OK

class C extends SelfBounded<C> {
    C setAndGet(C arg) { set(arg); return get(); }
}

class D {}

// Can't do this:
// class E extends SelfBounded<D> {}
// Compile error: Type parameter D is not within its bound

// Alas, you can do this, so you can't force the idiom:
class F extends SelfBounded {}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}