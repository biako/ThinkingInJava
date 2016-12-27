package tij.typeinformation.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Xiaolong on 12/27/2016.
 *
 * Thinking in Java p423
 *
 */

interface SomeMethods {
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}


class Implementation implements SomeMethods {
    public void boring1() { System.out.println("boring1"); }
    public void boring2() { System.out.println("boring2"); }
    public void interesting(String arg) {
        System.out.println("interesting " + arg);
    }
    public void boring3() { System.out.println("boring3"); }
}


// The ProxyHandler acts as a dynamic method handler, detecting specific method when called.
class MethodSelector implements InvocationHandler {

    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    public Object
    invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        if(method.getName().equals("interesting"))
            System.out.println("Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}


class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy= (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{ SomeMethods.class },
                new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
}