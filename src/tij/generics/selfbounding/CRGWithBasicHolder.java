package tij.generics.selfbounding;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p501
 *
 * The new class Subtype takes arguments and returns values of Subtype,
 * not just the base class BasicHolder. T
 * his is the essence of CRG: The base class substitutes the derived
 * class for its parameters.
 * This means that the generic base class becomes a kind of template
 * for common functionality for all its derived classes, but this
 * functionality will use the derived type for all of its arguments
 * and return values. That is, the exact type instead of the base type
 * will be used in the resulting class. So in Subtype, both the argument
 * to set( ) and the return type of get( ) are exactly Subtypes.
 *
 * What self-bounding does is require the use of the class in an inheritance relationship like this:
 * class A extends SelfBounded<A> {}
 *
 * This forces you to pass the class that you are defining as a parameter to the base class.
 *
 */

// This forces you to pass the class that you are defining as a parameter to the base class.
class Subtype extends BasicHolder<Subtype> {}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        System.out.println(st1.element);
        st1.f();
        System.out.println(st3.element);

    }
}
