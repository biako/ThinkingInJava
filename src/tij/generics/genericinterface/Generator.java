package tij.generics.genericinterface;

/**
 * Created by Xiaolong on 12/29/2016.
 *
 * Generic interface for generate.
 *
 * Use next() to get a new instance of type T
 *
 * Class<T> means the class has type T members or methods of type T return values
 *
 * public <T> void method(T arg) means the method has type T argument.
 *
 */
public interface Generator<T> {
    T next();
    // Consider <B> T next(B a); return type is T; argument type is B
}
