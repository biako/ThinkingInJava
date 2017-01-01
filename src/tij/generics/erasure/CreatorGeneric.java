package tij.generics.erasure;

/**
 * Created by Xiaolong on 1/1/2017.
 * <p>
 * Thinking in Java p.474
 * <p>
 * Instantiate a generic class by using Factory Method.
 *
 * Call the create() interally and pass in to private member element
 *
 * Different from passing in a factory object, this create an abstract class
 * with a GenericWithCreate() method to instantiate an object.
 *
 */
//: generics/CreatorGeneric.java

abstract class GenericWithCreate<T> {
    final T element;

    // The constructor will call the internal create() and pass in the T object to element!!
    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {
}


class Creator extends GenericWithCreate<X> {
    // Calling the class's constructor when implementing create() method.
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}