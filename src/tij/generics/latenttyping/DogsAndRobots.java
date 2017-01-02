package tij.generics.latenttyping;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p517
 *
 * If implementing the same interface, in fact no need to use generics.
 *
 */
class Dog implements Performs {
    public void speak() { System.out.println("Woof!"); }
    public void sit() { System.out.println("Sitting"); }
    public void reproduce() {}
}

class Robot implements Performs {
    public void speak() { System.out.println("Click!"); }
    public void sit() { System.out.println("Clank!"); }
    public void oilChange() {}
}

class Communicate {
    public static <T extends Performs>
    void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

// Can simply pass in an Performs object, as the classes implements the interface.
class CommunicateSimply {
    static void perform(Performs performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {
    public static void main(String[] args) {
        Communicate.perform(new Dog());
        Communicate.perform(new Robot());

        CommunicateSimply.perform(new Dog());
        CommunicateSimply.perform(new Robot());
    }
}
