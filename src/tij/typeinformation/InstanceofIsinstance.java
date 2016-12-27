package tij.typeinformation;


/**
 * Created by Xiaolong on 12/26/2016.
 *
 * Thinking in Java p416
 * <p>
 * Class<?> Object.getClass()
 * <p>
 * Class<?>
 * <p>
 * boolean Object instanceof Class
 * <p>
 * boolean ClassName.class.isInstance (Object X)
 * <p>
 * boolean Base.class.isAssignableFrom(Derived.class) == true
 */


class Base {
}

class Derived extends Base {
}

public class InstanceofIsinstance {
    static void test(Object x) {
        //Class<?> Object.getClass()
        System.out.println("Testing x of type " + x.getClass());

        //boolean Object instanceof Class
        System.out.println("x instanceof Base " + (x instanceof Base));
        System.out.println("x instanceof Derived " + (x instanceof Derived));

        //boolean ClassName.class.isInstance (Object X)
        System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));

        System.out.println("x.getClass() == Base.class " +
                (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class " +
                (x.getClass() == Derived.class));
        System.out.println("x.getClass().equals(Base.class)) " +
                (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derived.class)) " +
                (x.getClass().equals(Derived.class)));
        System.out.println();
    }

    public static void main(String[] args) {
        /*test(new Base());
        test(new Derived());*/

        Base x = new Derived();
        Class<?> xClass = x.getClass();
        Derived y = Derived.class.cast(x);
        System.out.println(xClass.getName());
        System.out.println(xClass.getSuperclass().getName());
        System.out.println(Base.class.isAssignableFrom(Derived.class));

    }
}

