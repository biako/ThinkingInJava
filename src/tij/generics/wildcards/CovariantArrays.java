package tij.generics.wildcards;

/**
 * Created by Xiaolong on 1/1/2017.
 * <p>
 * Thinking in Java p482
 *
 * We’ll start with an example that shows a particular behavior of arrays:
 * You can assign an array of a derived type to an array reference of the base type:
 *
 *
 * The first line in main( ) creates an array of Apple and assigns it to a reference to an array of Fruit. This makes sense—an Apple is a kind of Fruit, so an array of Apple should also be an array of Fruit.
 However, if the actual array type is Apple [], you should only be able to place an Apple or a subtype of Apple into the array, which in fact works at both compile time and run time. But notice that the compiler allows you to place a Fruit object into the array. This makes sense to the compiler, because it has a Fruit[] reference—why shouldn’t it allow a Fruit object, or anything descended from Fruit, such as Orange, to be placed into the array? So at compile time, this is allowed. The runtime array mechanism, however, knows that it’s dealing with an Apple [] and throws an exception when a foreign type is placed into the array.

 "Upcast" is actually rather a misnomer here. What you’re really doing is assigning one array to another. The array behavior is that it holds other objects, but because we are able to upcast, it’s clear that the array objects can preserve the rules about the type of objects they contain. It’s as if the arrays are conscious of what they are holding, so between the compile-time checks and the runtime checks, you can’t abuse them.
 */
class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class CovariantArrays {
    public static void main(String[] args) {

        // The array is holding Apple. It cannot add Fruit or Orange
        // The Runtime type is Apple[]
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK

        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
        // Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
        // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
