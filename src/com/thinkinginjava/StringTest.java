package com.thinkinginjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Xiaolong on 12/24/2016. String test.
 */
public class StringTest {

    //Overload method with predefined arguments for for testing.
    public static void regexMatcher() {
        String text = "abcabcabcdefabc";
        String[] regex = new String[]{"abc+", "(abc)+", "(abc){2,}"};
        StringTest.regexMatcher(text, regex);
    }

    public static void regexMatcher(String text, String... regex) {
        System.out.println("Input: \"" + text + "\"");

        //Separately print out each characters of the String
        char[] ch = text.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.print(i + ":" + ch[i] + " ");
            if (i == ch.length - 1) System.out.println();
        }

        //Do find() for each of the regexs
        for (String arg : regex) {
            System.out.println("Regular expression: \"" + arg + "\"");

            //Get a matcher object from Pattern.compile(String regex).matcher(String)
            Matcher m = Pattern.compile(arg)
                    .matcher(text);

            //boolean find() is an iterator, returning false if cannot find next match
            while (m.find()) {
                /*public String group( ) returns group 0 (the entire match) from
                 the previous match operation (find( ), for example).

                public int start(int group) returns the start index of
                 the group found in the previous match operation.

                public int end(int group) returns the index of the
                last character, plus one, of the group found in the previous match operation.*/

                System.out.println("Match \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end() - 1));

            }

        }

    }

}
