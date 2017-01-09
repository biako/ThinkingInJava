package tij.container2.queues;

/**
 * Created by Xiaolong on 1/9/2017.
 *
 * Thinking in Java p596
 *
 * A deque (double-ended queue) is like a queue, but you can add and remove elements from either end. There are methods in LinkedList that support deque operations, but there is no explicit interface for a deque in the Java standard libraries. Thus, LinkedList cannot implement this interface and you cannot upcast to a Deque interface as you can to a Queue in the previous example. However, you can create a Deque class using composition, and simply expose the relevant methods from LinkedList:
 *
 */
import java.util.*;
public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<T>();
    public void addFirst(T e) { deque.addFirst(e); }
    public void addLast(T e) { deque.addLast(e); }
    public T getFirst() { return deque.getFirst(); }
    public T getLast() { return deque.getLast(); }
    public T removeFirst() { return deque.removeFirst(); }
    public T removeLast() { return deque.removeLast(); }
    public int size() { return deque.size(); }
    public String toString() { return deque.toString(); }
    // And other methods as necessary...
}