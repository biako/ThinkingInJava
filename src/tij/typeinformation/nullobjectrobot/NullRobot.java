package tij.typeinformation.nullobjectrobot;

import tij.typeinformation.nullobjectposition.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * Created by Xiaolong on 12/27/2016.
 */



public class NullRobot {
    /**
     * The constructor of NullRobot will return a proxy for the specific type of NullRobot.
     *
     * the proxy is = (InterfaceName) Proxy.newProxyInstance(
     *                  proxyInterfaces.class.getClassLoader(),
     *                  new Class[]{proxyInterfaces},
     *                  new ProxyHandler(type).
     *
     */
    // To create a NullRobot proxy for a specific type. Takes in a class type.
    public static Robot
    newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(
                // No difference to use the classloader of NullRobotProxyHandler??
                NullRobot.class.getClassLoader(),
                // The proxied implements both Null and Robot interfaces.
                new Class[]{Null.class, Robot.class},
                // Use the handler to take in a specific type information
                // to create a type-specific proxied NRobot.
                new NullRobotProxyHandler(type));
    }

    public static void main(String[] args) {
        Robot[] bots = {
                new SnowRobot("SnowBee"),
                newNullRobot(SnowRobot.class)
        };
        for (Robot bot : bots)
            Robot.Test.test(bot);
    }
}


/**
 *
 * To use dynamic proxy, should create a ProxyHandler that implements InvocationHandler:
 *
 * (a) Set a private field proxied in the type of interface type.
 *
 * (b) Must override the invoke(Object proxy, Method method, Object[] args) method.
 * invoke() should return method.invoke(proxied, args).
 *
 *
 *
 */

class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    // The proxied NRobot class is defined within the handler.
    private Robot proxied = new NRobot();

    // Use the constructor to set a type-specific nullName
    NullRobotProxyHandler(Class<? extends Robot> type){
        nullName = type.getSimpleName() + " NullRobot";
    }

    // he proxied NRobot class is defined within the handler.
    // The Null-type class implements both Null and the base class Robot.
    private class NRobot implements Null, Robot {
        public String name() {
            return nullName;
        }

        public String model() {
            return nullName;
        }

        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }


}