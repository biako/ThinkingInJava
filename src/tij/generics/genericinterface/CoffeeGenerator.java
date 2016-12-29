package tij.generics.genericinterface;

import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Xiaolong on 12/29/2016.
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] coffeetypes = {CoffeeType1.class, CoffeeType2.class, CoffeeType3.class};
    private static Random rd = new Random(System.nanoTime());

    public CoffeeGenerator() {
    }


    // Size is the initial number argument in the CoffeeGenerator constructor coffees
    private int size;

    public CoffeeGenerator(int number) {
        size = number;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) coffeetypes[rd.nextInt(coffeetypes.length)].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    // Implement a specific iterator by through Iterator<T>
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


    // Override the Iterable's iterator() method to return a new type-specific Iterator
    @Override
    public java.util.Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }


    public static void main(String[] args) {
        CoffeeGenerator cg = new CoffeeGenerator(5);
        for (Coffee a : cg) {
            System.out.println(a);
        }

    }


}
