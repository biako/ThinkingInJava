package thinkinginjava.example.typeinformation;

/**
 *
 * Thinking in Java p397-398
 *
 * Get reference to class: Class c = Class.forName(String className)
 *
 * Java provides a second way to produce the reference to the Class object:
 * the class literal.
 *
 * FancyToy.class;
 *
 * which is not only simpler, but also safer since it’s checked at
 * compile time (and thus does not need to be placed in a try block).
 * Because it eliminates the forName( ) method call, it’s also more efficient.
 */

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    /*Toy() {
    }*/

    Toy(int i) {
    }
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;

        try {
            c = Class.forName("thinkinginjava.example.typeinformation.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can’t find FancyToy");
            System.exit(1);
        }
        printInfo(c);


        for (Class face : c.getInterfaces())
            printInfo(face);


        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

