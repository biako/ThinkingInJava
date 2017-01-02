package tij.generics.selfbounding;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p500
 *
 * An ordinary generic basic holder holding type T
 *
 */
public class BasicHolder<T> {
    T element;

    void set(T arg) { element = arg; }

    T get() { return element; }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
