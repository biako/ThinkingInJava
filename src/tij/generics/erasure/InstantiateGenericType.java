package tij.generics.erasure;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Thinking in Java p.473
 *
 * Instantiate a Generic Type with a Class Object passed in by calling Class.newInstance():
 *
 * NOTE: This only can call the Class's default constructor.
 *
 * A runtime exception will be thrown if the there is no default constructor.
 * <p>
 * The solution in Java is to pass in a factory object, and use that to make the new instance.
 * A convenient factory object is just the Class object, so if you use a type tag, you can use
 * newlnstance( ) to create a new object of that type:
 *
 */
class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

/**
 * This compiles, but fails with ClassAsFactory<Integer> because Integer has no default constructor.
 * Because the error is not caught at compile time, this approach is frowned upon by the Sun folks.
 * They suggest instead that you use an explicit factory and constrain the type so that it only takes
 * a class that implements this factory:
 *
 */
public class InstantiateGenericType {

    public static void main(String[] args) {

        // NoSuchMethodException!
        // Integer does NOT have a default constructor
        // newInstance() will only call the Class's default constructor.
        try {
            Integer a = Integer.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        ClassAsFactory<Employee> fe =
                new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");

        // Integer does NOT have a default constructor,
        // so it cannot be instantiated by using Integer.class.newInstance();
        try {
            ClassAsFactory<Integer> fi =
                    new ClassAsFactory<>(Integer.class);

        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}