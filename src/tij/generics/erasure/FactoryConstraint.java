package tij.generics.erasure;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * To create an instance of the generic type:
 *
 * Use an explicit factory and constrain the type so that it only takes a class that implements the factory.
 *
 * When implementing the factory, the create() method will explicitly call the constructor of the class.
 *
 */


// The Factory interface of type T: calling create() will return an instance of type T.
interface FactoryI<T> {
    T create();
}

// In this example, not passing in the Class object, but pass in the Factory object of the type T.
class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}

// Implement the Factory interface, return a new Integer by explicitly calling the constructor
class IntegerFactory implements FactoryI<Integer> {
    public Integer create() {
        return new Integer(0);
    }
}

// Implement the Factory interface, return a new Widget by explicitly calling the constructor
class Widget {
    public static class Factory implements FactoryI<Widget> {
        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory());
        new Foo2<>(new Widget.Factory());
    }
}