package tij.generics.genericmethod;

/**
 * Created by Xiaolong on 12/29/2016.
 *
 * Thinking in Java p449
 *
 * To define a generic method, you simply place a
 * generic parameter list before the return value, like this:
 *
 * public <T> void f(T x)
 *
 * So calls to f( ) look like normal method calls, and it
 * appears that f( ) has been infinitely overloaded. It
 * will even take an argument of the type GenericMethods.
 */
public class GenericMethods {

    // Put <T> before the return type and use T type as argument for the method
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }


}