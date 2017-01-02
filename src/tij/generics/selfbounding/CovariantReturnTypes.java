package tij.generics.selfbounding;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p504
 *
 * The value of self-bounding types is that they produce covariant argument types's
 *
 * method argument types vary to follow the subclasses.
 * Although self-bounding types also produce return types that are the same
 * as the subclass type, this is not so important because covariant return types were introduced in Java SE5:
 *
 */
class Base {}

class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    // Return type of overridden method is allowed to vary:
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }
}