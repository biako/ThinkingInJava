package tij.container2.queues;

import tij.generics.genericinterface.Generator;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Xiaolong on 1/9/2017.
 *
 * Thinking in Java p594
 *
 * I. Queue interface:
 *
 * (1) boolean offer(E e): Inserts the specified element into this queue (use offer() instead of add())
 *       When using a capacity-restricted queue, this method is generally preferable to add(),
 *       which can fail to insert an element only by throwing an exception.
 *
 * (2) E peek(): Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
 *
 * (3) E remove(): Retrieves and removes the head of this queue.  This method differs from poll() only in
 * that it throws an exception if this queue is empty.
 *
 * (4) E poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty.
 *
 * II. Types of Queues using Queue interface
 *
 * With the exception of the priority queues, a Queue will produce elements in exactly the same order
 * as they are placed in the Queue.
 *
 * (1) LinkedList<>
 * (2) PriorityQueue<>
 * (3) ArrayBlockingQueue<>
 * (4) ConcurrentLinkedQueue<>
 * (5) LinkedBlockingQueue<>
 * (6) PriorityBlockingQueue<>
 *
 * To use PriorityQueue / PriorityBlockingQueue, elements must also implement the Comparable interface.
 *
 */
public class QueueBehavior {
    private static int count = 10;

    static <T> void test(Queue<T> queue, Generator<T> gen) {
        System.out.println(queue.getClass().getCanonicalName());
        System.out.println("offer(gen.next()):");
        for(int i = 0; i < count; i++)
            queue.offer(gen.next());
        System.out.println();
        System.out.println("remove():");
        while(queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
        System.out.println(queue.peek()); // will return null
        System.out.println();
        System.out.println();
    }

    static class Gen implements Generator<String> {
        String[] s = ("one two three four five six seven " +
                "eight nine ten").split(" ");
        int i;
        public String next() {
            System.out.print(s[i] + " ");
            return s[i++]; }
    }

    public static void main(String[] args) {

        test(new LinkedList<>(), new Gen());

        // PriorityQueue will not produce the elements in the exactly same order as they are placed in the Queue
        test(new PriorityQueue<>(), new Gen());

        test(new ArrayBlockingQueue<>(count), new Gen());

        test(new ConcurrentLinkedQueue<>(), new Gen());

        test(new LinkedBlockingQueue<>(), new Gen());

        // PriorityQueue will not produce the elements in the exactly same order as they are placed in the Queue
        test(new PriorityBlockingQueue<>(), new Gen());
    }
}