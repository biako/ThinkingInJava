package tij.generics.genericinterface;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Xiaolong on 12/29/2016.
 *
 * Example of implementing both Generator and Iterable
 *
 * To use foreach:
 *
 * (1)  The class should have a static size.
 *
 * (2)  The class of type T should implement Iterable<T>:
 *      Override interator() method to return a TypeIterator
 *
 * (3) The class of type T should create an inner class of TypeIterator, which implements Iterator<T>:
 *        The initial count is just the size.
 *        hasNext() to return if current count still >0;
 *        T next() to count-- and return a Type T instance.
 *
 *
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private static final Class[] COFFEETYPES = {CoffeeType1.class, CoffeeType2.class, CoffeeType3.class};
    private static Random rd = new Random(System.nanoTime());

    public CoffeeGenerator() {
    }

    // Size is the initial number argument in the CoffeeGenerator constructor coffees
    private int size;

    public CoffeeGenerator(int number) {
        size = number;
    }

    // Implement Generator's interface
    @Override
    public Coffee next() {
        try {
            return (Coffee) COFFEETYPES[rd.nextInt(COFFEETYPES.length)].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    // Implement a specific iterator by implementing Iterator<T>.
    // The TypeIterator will be returned using Iterable's interface when calling interator();
    class CoffeeIterator implements Iterator<Coffee> {
        // The iterator should have the initial size of the generator
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        // next() will always return an instance of type T
        @Override
        public Coffee next() {
            count--;
            // Return a random new Coffee by calling CoffeeGenerator's next()
            return CoffeeGenerator.this.next();
        }
    }


    // Implement Iterable's interface.
    // Override the Iterable's iterator() method to return a new TypeIterator
    @Override
    public java.util.Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }


    public static void main(String[] args) {
        // Using iterator. Calling the constructor with the maximum member object.
        // foreach will return a instance of type T.
        CoffeeGenerator cg = new CoffeeGenerator(5);
        for (Coffee a : cg) {
            System.out.println(a);
        }

        // Not using iterator. Use next() directly to generate new instances.
        CoffeeGenerator cg2 = new CoffeeGenerator();
        for (int i=0; i<5; i++){
            System.out.println(cg2.next());
        }
    }
}
