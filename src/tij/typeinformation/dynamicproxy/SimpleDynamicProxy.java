package tij.typeinformation.dynamicproxy;

/**
 * Created by Xiaolong on 12/27/2016.
 *
 * Thinking in Java p422
 *
 */
import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler {
    // The proxy takes in the proxied as its private member.
    private Object proxied;

    // The proxy takes in the proxied as its private member.
    // The proxied is taken in as an argument of the ProxyHandler constructor.
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    // The proxy re-implement the interface, also calling the proxied's implementation at the same time.
    // Dynamically calling by returning method.invoke(proxied, args).
    // Before that, the proxy can do something dynamic.
    // Advantage is that no need to re-implement each methods; only have to call them dynamically.
    public Object
    invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass());
        System.out.println("method: " + method);
        System.out.println(", args: " + args);
        if(args != null)
            for(Object arg : args)
                System.out.println(" " + arg);
        return method.invoke(proxied, args);
    }
}


class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        // The proxied is taken in as an argument of the ProxyHandler constructor.
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{ Interface.class },
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}