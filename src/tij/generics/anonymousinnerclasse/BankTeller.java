package tij.generics.anonymousinnerclasse;

import tij.generics.genericinterface.Generator;
import tij.generics.genericinterface.Generators;

import java.util.*;

/**
 * Created by Xiaolong on 12/31/2016.
 *
 * Thinking in Java p459-460
 *
 * The below is the example using anonymous inner class without lambda:
 *
 * For private constructors, must use generator to return a new object.
 *
 *  class Teller {
        private static long counter = 1;
        private final long id = counter++;
        private Teller() {}
        public String toString() { return "Teller " + id; }

        // A single Generator object. Not using lambda.
        public static Generator<Teller> generator =
            new Generator<Teller>() {
            public Teller next() { return new Teller(); }
        };
    }
 *
 *
 */

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    //Both Customer and Teller have private constructors, thereby forcing you to use Generator objects.
    private Customer() {
    }

    public String toString() {
        return "Customer " + id;
    }

    // A method to produce Generator objects:
    // Customer has a generator( ) method that produces a new Generator<Customer> object each
    // time you call it. You may not need multiple Generator objects, and Teller creates a single
    // public generator object.
    // Using lambda here.
    public static Generator<Customer> generator() {
        return () -> new Customer();
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    //Both Customer and Teller have private constructors, thereby forcing you to use Generator objects.
    private Teller() {
    }

    public String toString() {
        return "Teller " + id;
    }

    // A single Generator object:
    // Customer has a generator( ) method that produces a new Generator<Customer> object each
    // time you call it. You may not need multiple Generator objects, and Teller creates a single
    // public generator object.
    // Using lambda here.
    public static Generator<Teller> generator =
            () -> new Teller();
}

public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);

        // Use Queue interface and LinkedList constructor for creating line.
        Queue<Customer> line = new LinkedList<>();

        // public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n):
        // This is a static method in class Generators.
        // Fill into Collection<T> n number of type T objects by calling T's generator.

        // 15 customers and 4 tellers in this examples.
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);

        // Randomly assign teller to customers on the list
        for (Customer c : line)
            serve(tellers.get(rand.nextInt(tellers.size())), c);
    }
}
