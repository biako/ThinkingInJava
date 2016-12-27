package tij.typeinformation.dynamicproxy;

/**
 * Created by Xiaolong on 12/27/2016.
 *
 * Thinking in Java p420-421
 *
 */
interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

/**
 * Both the proxy and the proxied implements the base interface.
 *
 * The proxy takes in the proxied, making it a private member, and re-implementing the interface. *
 *
 */
class SimpleProxy implements Interface {
    // The proxy takes in the proxied as its private member.
    private Interface proxied;

    // The proxy takes in the proxied as its private member.
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    // The proxy re-implement the interface, also calling the proxied's implementation at the same time.
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}