package tij.generics.genericinterface;

import java.util.Iterator;

/**
 * Created by Xiaolong on 12/29/2016.
 *
 * Thinking in Java p448-449
 *
 * Example of first implement Generator interface,
 *
 * then extends Generator interface and implementsIterable<T>,
 *
 * using the Adapter design pattern.
 *
 */
public class FibonacciIterable extends FibonacciGenerator implements Iterable<Integer> {
    private int size;

    public FibonacciIterable(int size) {
        this.size = size;
    }

    // Add the TypeIterator as the inner class, implementing Iterator<T>
    public class FibonacciIterator implements Iterator<Integer> {
        private int count;

        public FibonacciIterator() {
            this.count = size;
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        // Adapter here: to call the next() method of the Generator
        @Override
        public Integer next() {
            count--;
            return FibonacciIterable.this.next();
        }
    }

    // Return a new TypeIterator when iterator() is called
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }


    public static void main(String[] args) {
        FibonacciIterable fg = new FibonacciIterable(10);
        for (int a: fg){
            System.out.println(a);
        }
    }
}
