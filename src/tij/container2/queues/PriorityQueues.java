package tij.container2.queues;

import java.util.PriorityQueue;

/**
 * Created by Xiaolong on 1/9/2017.
 *
 * Thinking in Java p
 *
 * To use PriorityQueue, the elements in the PriorityQueue should
 * implement Comparable and override compareTo()
 */
class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    // The elements in the PriorityQueue should implements Comparable<T> and override compareTo()
    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(String td, char pri, int sec) {
            primary = pri;
            secondary = sec;
            item = td;
        }

        // Override compareTo()
        public int compareTo(ToDoItem arg) {
            if(primary > arg.primary)
                return +1;
            if(primary == arg.primary)
                if(secondary > arg.secondary)
                    return +1;
                else if(secondary == arg.secondary)
                    return 0;
            return -1;
        }

        public String toString() {
            return Character.toString(primary) +
                    secondary + ": " + item;
        }
    }

    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(td, pri, sec));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Feed bird",'B', 7);
        toDoList.add("Mow lawn", 'C', 3);
        toDoList.add("Water lawn",'A', 1);
        toDoList.add("Feed cat", 'B', 1);
        while(!toDoList.isEmpty())
            System.out.println(toDoList.remove());
    }
}
