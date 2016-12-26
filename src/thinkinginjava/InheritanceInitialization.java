package thinkinginjava;

/**
 * Created by Xiaolong on 12/18/2016.
 * Based on "Thinking in Java" p272-273 thinkinginjava.
 */

class BaseClass {
    //Static members will be initialized once the class is accessed.
    private static int static_base = printInit("Static in BaseClass initialized");
    private int nonstatic_base = printInit("Non-static in BaseClass initialized");

    //SubClass will first call BaseClass Constructor.
    BaseClass() {
        System.out.println("BaseClass Constructor");
    }

    //This method is to initialize an int and print a String at the same time.
    static int printInit(String s) {
        System.out.println(s);
        return 1;
    }
}

class SubClass extends BaseClass {
    //Static members will be initialized once the class is accessed.
    private static int j = printInit("Static in SubClass initialized");
    private int nonstatic_sub = printInit("Non-static in SubClass initialized");
    SubClass() {
        System.out.println("SubClass Constructor");
    }
}

public class InheritanceInitialization {
    //    private static int value = BaseClass.printInit("InheritanceInitialization Static Initialized");
    public static void initialize() {
        System.out.println("Initialize Method started");
        System.out.println("This is to creating new instance of SubClass (inherited from BaseClass)");
        SubClass SubClassInstance = new SubClass();
    }
}
