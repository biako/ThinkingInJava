package tij.container2.lists;

import tij.container2.filling.abstractclass.Countries;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p586-588
 *
 * add() to insert objects, use get() to get them out one at a time,
 * and call iterator() to get an Iterator for the sequence.
 *
 * I. Basic methods of a List (ArrayList and LinkedList)
 *  boolean add(Object),
 *  void add(int,Object),
 *  Object remove(int),
 *  boolean remove(Object),
 *  Object get(int),
 *  int indexOf(Object),
 *  void clear(),
 *  boolean contains(Object),
 *  boolean isEmpty(),
 *  Iterator iterator(),
 *  int lastIndexOf(Object),
 *  void replaceAll(),
 *  int size(),
 *  sublist (int,int),
 *  Object[] toArray(),
 *  Object[] toArray(Object[]),
 *  boolean addAll(Collection),
 *  boolean addAll(int,Collection),
 *  Object set(int,Object),
 *  boolean containsAll(Collection),
 *  Iterator listIterator(int),
 *  Iterator listIterator(),
 *  boolean removeAll(Collection),
 *  boolean retainAll(Collection)
 *
 * II. LinkedList: Additional
 *  void addFirst(E e),
 *  void addLast
 *  getFirst(),
 *  getLast(),
 *  boolean	offer(E e): Adds the specified element as the tail (last element) of this list.
 *  boolean	offerFirst(E e): Inserts the specified element at the front of this list.
 *  boolean	offerLast(E e): Inserts the specified element at the end of this list.
 *  peek(): Retrieves, but does not remove, the head (first element) of this list.
 *	peekFirst(): Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
 *	peekLast(): Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
 *	poll(): Retrieves and removes the head (first element) of this list.
 *	pollFirst(): Retrieves and removes the first element of this list, or returns null if this list is empty.
 *	pollLast(): Retrieves and removes the last element of this list, or returns null if this list is empty.
 *	pop(): Pops an element from the stack represented by this list.
 *	push(E e): Pushes an element onto the stack represented by this list.
 * 	remove(): Retrieves and removes the head (first element) of this list.
 * 	remove(int index): Removes the element at the specified position in this list.
 * 	removeFirst(): Removes and returns the first element from this list.
 *  removeFirstOccurrence(Object o): Removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
 *	removeLast(): Removes and returns the last element from this list.
 * 	removeLastOccurrence(Object o): Removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
 *
 *
 *
 *
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        a.add(1, "x"); // Add at location 1
        a.add("x"); // Add at end

        // Add a collection:
        a.addAll(Countries.names(5));

        // Add a collection starting at location 3:
        a.addAll(3, Countries.names(5));

        b = a.contains("1"); // Is it in there?

        // Is the entire collection in there?
        b = a.containsAll(Countries.names(5));

        // Lists allow random access, which is cheap
        // for ArrayList, expensive for LinkedList:
        s = a.get(1); // Get (typed) object at location 1

        i = a.indexOf("1"); // Tell index of object

        b = a.isEmpty(); // Any elements inside?

        it = a.iterator(); // Ordinary Iterator
        lit = a.listIterator(); // ListIterator
        lit = a.listIterator(3); // Start at loc 3

        i = a.lastIndexOf("1"); // Last match

        a.remove(1); // Remove location 1
        a.remove("3"); // Remove this object

        a.set(1, "y"); // Set location 1 to "y"

        // Keep everything that’s in the argument
        // (the intersection of the two sets):
        a.retainAll(Countries.names(5));

        // Remove everything that’s in the argument:
        a.removeAll(Countries.names(5));

        i = a.size(); // How big is it?

        a.clear(); // Remove all elements
    }


    // Moving around with an Iterator
    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    // Changing things with an Iterator
    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        // Must move to an element after add():
        it.next();
        // Remove the element after the newly produced one:
        it.remove();
        // Must move to an element after remove():
        it.next();
        // Change the element after the deleted one:
        it.set("47");
    }

    // Seeing the effects of List manipulation
    public static void testVisual(List<String> a) {
        System.out.println(a);
        List<String> b = Countries.names(5);
        System.out.println("b = " + b);

        a.addAll(b);
        a.addAll(b);
        System.out.println(a);

        // Insert, remove, and replace elements
        // using a ListIterator:
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());

        x.remove();
        System.out.println(x.next());

        x.set("47");
        System.out.println(a);

        // Traverse the list backwards:
        x = a.listIterator(a.size());
        while (x.hasPrevious())
            System.out.println(x.previous() + " ");
        System.out.println();
        System.out.println("testVisual finished");
    }


    // There are some things that only LinkedLists can do:
    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addAll(Countries.names(5));
        System.out.println(ll);

        // Treat it like a stack, pushing:
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);

        // Like "peeking" at the top of a stack:
        System.out.println(ll.getFirst());
        System.out.println(ll.peek());

        // Like popping a stack:
        System.out.println(ll.removeFirst());
        System.out.println(ll.pop());
        System.out.println(ll.poll());

        // Treat it like a queue, pulling elements
        // off the tail end:
        System.out.println(ll.removeLast());
        System.out.println(ll);
    }



    public static void main(String[] args) {
        // Make and fill a new list each time:
        basicTest(
                new LinkedList<String>(Countries.names(5)));
        basicTest(
                new ArrayList<String>(Countries.names(5)));
        iterMotion(
                new LinkedList<String>(Countries.names(5)));
        iterMotion(
                new ArrayList<String>(Countries.names(5)));
        iterManipulation(
                new LinkedList<String>(Countries.names(5)));
        iterManipulation(
                new ArrayList<String>(Countries.names(5)));
        testVisual(
                new LinkedList<String>(Countries.names(5)));
        testLinkedList();
    }
}