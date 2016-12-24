package com.thinkinginjava;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Xiaolong on 12/24/2016. String test.
 */
public class StringTest {

    // Overload method with predefined arguments for for testing.
    public static void regexMatcher() {
        String text = "abcabcabcdefabc";
        String[] regex = new String[]{"abc+", "(abc)+", "(abc){2,}"};
        StringTest.regexMatcher(text, regex);
    }


    /*
    To demonstrate the basics of matcher.find() (acting as an iterator), matcher.roup() (returning the match),
    matcher.start() and matcher.end() (returning the start index and the end index.
    */
    public static void regexMatcher(String text, String... regex) {
        System.out.println("Input: \"" + text + "\"");

        // Separately print out each characters of the String
        char[] ch = text.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.print(i + ":" + ch[i] + " ");
            if (i == ch.length - 1) System.out.println();
        }

        // Do find() for each of the regexs
        for (String arg : regex) {
            System.out.println("Regular expression: \"" + arg + "\"");

            // Get a matcher object from Pattern.compile(String regex).matcher(String)
            Matcher m = Pattern.compile(arg)
                    .matcher(text);

            // boolean find() is an iterator, returning false if cannot find next match
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
    /*
    To demonstrate different groups in a regex.

    REGEX is (?m)(\S+)\s+((\S+)\s+(\S+))$


    You can see that the regular expression pattern has a number of parenthesized groups,
    consisting of any number of non-whitespace characters (‘\S+’) followed by any number of
    whitespace characters (‘\s+’).

    The goal is to capture the last three words on each line; the end of a line is
    delimited by ‘$’. However, the normal behavior is to match ‘$’ with the end of
    the entire input sequence, so you must explicitly tell the regular expression
    to pay attention to newlines within the input. This is accomplished with the ‘(?m)’
    pattern flag at the beginning of the sequence (pattern flags will be shown shortly).
    */

    public static void regexMatcherGroup() {
        final String POEM =
                "Twas brillig, and the slithy toves\n" +
                        "Did gyre and gimble in the wabe.\n" +
                        "All mimsy were the borogoves,\n" +
                        "And the mome raths outgrabe.\n\n" +
                        "Beware the Jabberwock, my son,\n" +
                        "The jaws that bite, the claws that catch.\n" +
                        "Beware the Jubjub bird, and shun\n" +
                        "The frumious Bandersnatch.";
        final String REGEX = "(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$";

        Matcher m =
                Pattern.compile(REGEX)
                        .matcher(POEM);
        System.out.println(POEM);
        System.out.println();
        System.out.println();
        System.out.println(REGEX);
        System.out.println();
        System.out.println();

        while (m.find()) {
            for (int j = 0; j <= m.groupCount(); j++)
                System.out.println("Group Number: " + j + ":[" + m.group(j) + "] ");
            System.out.println();
            System.out.println();
        }

    }

    /*
    Demonstrate the flags in Pattern.compile(String regex, int flags)
    You can combine the effect flags through an "OR" (‘|’) operation,
    like "Pattern.CASE_INSENSITIVE | Pattern.MULTILINE"


    In multiline mode, the expressions ‘^’ and ‘$’ match the beginning and ending of a line,
    respectively.’^’ also matches the beginning of the input string, and ‘$’ also matches the
    end of the input string. By default, these expressions only match at the beginning and
    the end of the entire input string.
    */
    public static void regexMatcherFlag() {
        final String TEX = "java has regex\nJava has regex\n" +
                "JAVA has pretty good regular expressions\n" +
                "Regular expressions are in Java";

        // ^ matches the beginning of the input string.
        final String REGEX = "^java";

        Matcher m = Pattern.compile(REGEX,
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE)
                .matcher(TEX);
        while (m.find())
            System.out.println(m.group());
    }


    public static void regexMatcherSplit() {
        String input =
                "This!!unusual use!!of exclamation!!points";

        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input)));

        // Only do the first three:
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input, 3)));

        // Can call Spring.split(String regex, int limit)
        System.out.println(Arrays.toString(
                input.split("!!"))
        );

        // Only do the first three:
        System.out.println(Arrays.toString(
                input.split("!!",3)));


    }

}
