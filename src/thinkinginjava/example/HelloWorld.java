package thinkinginjava.example;

import org.jetbrains.annotations.NotNull;

class HelloWorld {
    private int value1;

    public HelloWorld() {
        System.out.println("HelloWorld Constructor!");
    }

    // Without "public": the methods are package-private
    void method1(float a) {
        System.out.println("Method 1 (int) is called!");
        System.out.println(a);
    }

    void method1(String a) {
        System.out.println("Method 1 (String) is called!");
        System.out.println(a);
    }

    void method2(@NotNull String... args) {
        for (String a : args) {
            System.out.println(a);
        }
        System.out.println("method2 String...");
    }

    void method2() {
        System.out.println("method2 null");

    }
}

class HelloWorld2 extends HelloWorld {
    HelloWorld2() {
        //Super constructor will be automatically called.
        System.out.println("HelloWorld 2 Constructor!");
    }

    @Override
    void method1(String a) {
        super.method1(a); //Super method will NOT be automatically called.
        System.out.println("Overridden method 1 called");
    }
}