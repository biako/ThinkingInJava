package tij.generics.wildcards;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Thinking in Java p485
 *
 */
public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) { value = val; }
    public void set(T val) { value = val; }
    public T get() { return value; }
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<Apple>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);
        // Holder<Fruit> Fruit = Apple; // Cannot upcast!!


        //if you create a Holder<Apple>, you cannot upcast it to a Holder<Fruit>,
        // but you can upcast to a Holder<? extends Fruit>.
        Holder<? extends Fruit> fruit = Apple; // OK

        //If you call get( ), it only returns a Fruit—
        // that’s as much as it knows given the "anything that extends Fruit" bound.
        Fruit p = fruit.get();

        d = (Apple)fruit.get(); // Returns ‘Object’
        try {
            Orange c = (Orange)fruit.get(); // No warning
        } catch(Exception e) { System.out.println(e); }

        // The set( ) method won’t work with either an Apple or a Fruit,
        // because the set( ) argument is also "? Extends Fruit," which
        // means it can be anything and the compiler can’t verify type safety for "anything."
        // fruit.set(new Apple()); // Cannot call set()
        // fruit.set(new Fruit()); // Cannot call set()

        System.out.println(fruit.equals(d)); // OK
    }
}