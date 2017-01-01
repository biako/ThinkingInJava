package tij.generics.treesettest;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Crazy Java Lecture p350.
 *
 * Topic: wildcard for generics; TreeSet's constructor with Comparator; Lambda expression
 *
 * (1) TreeSet's constructor with Comparator
 * Create a TreeSet using the constructor below:
 *
 * public class TreeSet<E> extends AbstractSet<E>{
 *      TreeSet public TreeSet(Comparator<? super E> comparator){...}...}
 *
 * Pay attention to <? super E>, which means could pass in a comparator objector of the superclass of E
 *
 *
 * (2) Functional interfaces: its only abstract method could be overridden by lambda expression.
 * Example of functional interfaces:
 *      public interface Runnable { void run(); }
 *      public interface Callable<V> { V call() throws Exception; }
 *      public interface ActionListener { void actionPerformed(ActionEvent e); }
 *      public interface OnClickListener { void onClick(View v); } (Android)
 *      public interface Comparator<T> { int compare(T o1, T o2); boolean equals(Object obj); }
 *
 */
public class TreeSetTest {
    public static void main(String[] args) {

        // Using the constructor of TreeSet public TreeSet(Comparator<? super E> comparator)
        // Pass in a comparator object
        // Using lambda here
        // (Comparator is a functional interface, has only one method to be overridden)
        Set<String> ts1 = new TreeSet<>(
                (o1, o2) -> o1.hashCode() < o2.hashCode() ? 1 :
                        o1.hashCode() > o2.hashCode() ? -1 : 0);
        ts1.add("Hello");
        ts1.add("World");
        System.out.println(ts1);

        // Here, the type parameters for constructor and TreeSet are the same.
        // Constructor's type parameter could be the superclass of TreeSet's type parameter
        // Here, the comparator's type parameter is Object, a super class of String.
        // NOT using lambda here (using)
        Set<String> ts2 = new TreeSet<>(
                new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return o1.hashCode() > o2.hashCode() ? 1 :
                                o1.hashCode() < o2.hashCode() ? -1 : 0;
                    }
                });
        ts2.add("Hello");
        ts2.add("World");
        System.out.println(ts2);
    }
}