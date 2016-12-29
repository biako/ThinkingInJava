package tij.generics.genericinterface;

/**
 * Created by Xiaolong on 12/29/2016.
 *
 * Generic interface for generate.
 *
 * Use next() to get a new instance of type T
 *
 */
public interface Generator<T> {
    T next();
}
