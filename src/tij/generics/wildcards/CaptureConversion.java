package tij.generics.wildcards;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Thinking in Java p493
 *
 *
 * One situation in particular requires the use of <?> rather than a raw type.
 * If you pass a raw type to a method that uses <?>, it’s possible for the compiler
 * to infer the actual type parameter, so that the method can turn around and call
 * another method that uses the exact type. The following example demonstrates the
 * technique, which is called capture conversion because the unspecified wildcard
 * type is captured and converted to an exact type. Here, the comments about warnings
 * only take effect when the @SuppressWarnings annotation is removed:
 *
 *
 * The type parameters in f1( ) are all exact, without wildcards or bounds.
 * In f2( ), the Holder parameter is an unbounded wildcard, so it would
 * seem to be effectively unknown. However, within f2( ), f1( ) is called
 * and f1( ) requires a known parameter.
 *
 * What’s happening is that the parameter type is captured in the process
 * of calling f2( ), so it can be used in the call to f1( ).
 *
 * You might wonder if this technique could be used for writing,
 * but that would require you to pass a specific type along with the Holder<?>.
 * Capture conversion only works in situations where, within the method, you need
 * to work with the exact type. Notice that you can’t return T from f2( ),
 * because T is unknown for f2( ). Capture conversion is interesting, but quite limited.
 *
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder); // Call with captured type
    }

   // @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<>(1);
        f1(raw); // Produces warnings
        f2(raw); // No warnings

        Holder rawBasic = new Holder();
        rawBasic.set(new Object()); // Warning
        f2(rawBasic); // No warnings

        // Upcast to Holder<?>, still figures it out:
        Holder<?> wildcarded = new Holder<>(1.0);
        f2(wildcarded);
    }
}
