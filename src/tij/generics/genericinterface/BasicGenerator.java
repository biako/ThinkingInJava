package tij.generics.genericinterface;

import java.util.Iterator;

/**
 * Created by Xiaolong on 12/30/2016.
 *
 * Thinking in Java p454
 *
 * I. Constructors:
 * BasicGenerator is a generic generator which have two overloaded constructors:
 *
 *      (1) public BasicGenerator(Class<T> tClass)
 *      (2) public BasicGenerator(Class<T> tClass, int number)
 *
 * II. Interfaces:
 * BasicGenerator implements Generator<T> and can return a new instance of type T by calling next().
 *
 * BasicGenerator also implements Iterable<T>.
 * By using the overloaded constructor with an int argument, public BasicGenerator(Class<T> tClass, int number),
 * BasicGenerator can be used in foreach.
 *
 *
 */

// Note: Cannot omit the type parameters of the interfaces implemented!
public class BasicGenerator<T> implements Generator<T>, Iterable<T> {
    private Class<T> tClass;
    private int size = 0;

    // A constructor of the generator, which will pass in a Class<T> object
    // The Class<T> object will be used for creating new instance of type T
    public BasicGenerator(Class<T> tClass) {
        this.tClass = tClass;
    }

    // The overloaded constructor can also pass in a number as the size for the Iterator of the generator
    public BasicGenerator(Class<T> tClass, int number) {
        this.tClass = tClass;
        size = number;
    }


    // Note: newInstance() will throw two exceptions: InstantiationException and IllegalAccessException
    // When calling newInstance(), the two exceptions must be caught,
    // so the return sentence below must be put in a try-catch block.
    @Override
    public T next() {
        try {
            return tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    // Note: The Iterator is NOT Iterator<T>!
    public class BGIterator implements Iterator<T> {
        private int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public T next() {
            count--;
            // Calling the outer class's next(). Don't have to repeat here again.
            return BasicGenerator.this.next();
        }
    }

    // The iterator() will only return the iterator object.
    // Note: The Iterator is NOT Iterator<T>!
    @Override
    public Iterator iterator() {
        return new BGIterator();
    }

    public static void main(String[] args) {
        BasicGenerator<CoffeeType1> bg1 = new BasicGenerator<>(CoffeeType1.class);
        BasicGenerator<CoffeeType1> bg2 = new BasicGenerator<>(CoffeeType1.class, 10);
        for (int i = 0; i < 5; i++) {
            System.out.println(bg1.next());
        }
        for (CoffeeType1 c : bg2) {
            System.out.println(c);
        }
    }
}
