package tij.typeinformation.reflection;

/**
 * Created by Xiaolong on 12/26/2016.
 *
 * Thinking in Java p418-419
 *
 * Default argument: ShowMethods
 *
 * To list all the addmethods in the class identified by the argument.
 *
 * Use Pattern.matcher to remove the extra class information in the format of "xxx.xxx.xxx."
 *
 * Regex is ("\\w+\\.")
 * Note: \\. means .
 * Note: . means any character
 *
 *
 *
 */

import java.lang.reflect.*;
import java.util.regex.*;

public class ShowMethods {
    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all addmethods in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for addmethods involving ‘word’";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
      /*  if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }*/
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();

            //Use matcher to remove the portion with xxx.xxx.xx
            for (Method method : methods)
                System.out.println(
                        p.matcher(method.toString()).replaceAll(""));
            for (Constructor ctor : ctors)
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));


/*
            for (Method method : addmethods)
                System.out.println(
                        method.toString());
            for (Constructor ctor : ctors)
                System.out.println(
                        ctor.toString());
*/


            /*if (args.length == 1) {
                for (Method method : addmethods)
                    System.out.println(
                            p.matcher(method.toString()).replaceAll(""));
                for (Constructor ctor : ctors)
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                lines = addmethods.length + ctors.length;
            } else {
                for (Method method : addmethods)
                    if (method.toString().contains(args[1])) {
                        System.out.println(
                                p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                for (Constructor ctor : ctors)
                    if (ctor.toString().contains(args[1])) {
                        System.out.println(p.matcher(
                                ctor.toString()).replaceAll(""));
                        lines++;
                    }
            }*/
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
