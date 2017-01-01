package tij.generics.erasure;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Thinking in Java p.471
 *
 * Type tag of generics in Java:
 *
 * Explicitly pass in the Class object for the type so that you can use it in type expressions.
 *
 *
 */
class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
    Class<T> kind;

    // Explicitly pass in the Class object in the constructor
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 =
                new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 =
                new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}