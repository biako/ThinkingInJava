package tij.generics.stack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Xiaolong on 12/28/2016.
 * <p>
 * LinkedStack consists of Nodes.
 * <p>
 * Nodes has two fields: (1) the item of the type U; and (2) the link to the next Node
 * <p>
 * This example makes use of an end sentinel to determine when the stack is empty.
 */
public class LinkedStack<T> {
    //This example makes use of an end sentinel to determine when the stack is empty.
    private Node<T> top = new Node<>(); // The initial one is null. and of the type of T.

    private static class Node<U> {
        U item; // This item of the type U

        Node<U> next; // Linked next Node<U>

        // Default constructor: set both item and next as null
        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        // return false if both item and next == null
        boolean end() {
            return item == null && next == null;
        }

    }

    // Push an item of type T into the stack
    public void push(T item) {
        top = new Node<T>(item, top);
    }

    // Pop an item of type T from the stack.
    // If the current top is not the last one, the linked next top becomes the new top.
    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) (((int) 'A') + i);
            linkedStack.push(String.valueOf(ch));
            System.out.format("push(%s)\n", ch);
        }

        while (!linkedStack.top.end()) {
            System.out.println("pop(): " + linkedStack.pop());
        }

        // If still pop after the end, will return null.
        System.out.println("pop(): " + linkedStack.pop());
    }

}
