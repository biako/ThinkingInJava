package tij.generics.latenttyping;

import java.lang.reflect.*;
/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p518
 *
 * Example to achieve latent typing by using refection.
 *
 * The advantage is: The classes don't have to implement a same interface.
 * The disadvantage is: No compile-time checking available.
 *
 */


// Does not implement Performs:
class Mime {
    public void walkAgainstTheWind() {}
    public void sit() { System.out.println("Pretending to sit"); }
    public void pushInvisibleWalls() {}
    public String toString() { return "Mime"; }
}

// Does not implement Performs:
class SmartDog {
    public void speak() { System.out.println("Woof!"); }
    public void sit() { System.out.println("Sitting"); }
    public void reproduce() {}
}

// Using reflection to achieve latent typing:
class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch(NoSuchMethodException e) {
                System.out.println(speaker + " cannot speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch(NoSuchMethodException e) {
                System.out.println(speaker + " cannot sit");
            }
        } catch(Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}


public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}