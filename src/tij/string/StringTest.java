package tij.string;

import java.util.Arrays;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Xiaolong on 12/24/2016.
 *
 * Example for String Chapter.
 *
 */
public class StringTest {


    /** Overload method with predefined arguments for for testing regexMatcher below.*/
    public static void regexMatcher() {
        String text = "abcabcabcdefabc";
        String[] regex = new String[]{"abc+", "(abc)+", "(abc){2,}"};
        regexMatcher(text, regex);
    }


    /**
    To demonstrate the basics of matcher.find() (acting as an iterator), matcher.group() (returning the match),
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
                 the previous match operation (find( ), for tij).

                public int start(int group) returns the start index of
                 the group found in the previous match operation.

                public int end(int group) returns the index of the
                last character, plus one, of the group found in the previous match operation.*/
                System.out.println("Match \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end() - 1));

            }

        }

    }
    /**
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

    /**
    To demonstrate the flags in Pattern.compile(String regex, int flags)
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

    /**
     To demonstrate Pattern.compile(String regex).split(CharSequence input, int limit)
     */
    public static void regexMatcherSplit() {
        final String input =
                "This!!unusual use!!of exclamation!!points";

        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input)));

        // Only do the first three:
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input, 3)));

        // Can call Spring.split(String regex, int limit), which is simpler.
        System.out.println(Arrays.toString(
                input.split("!!")));

        // Only do the first three:
        System.out.println(Arrays.toString(
                input.split("!!", 3)));
    }

    /**
     To demonstrate the replaceAll() and replastFirst().

     mInput is created to match all the text (notice the grouping parentheses) between
     Then, more than two spaces are reduced to a single space, and any space at the beginning
     of each line is removed (in order to do this on all lines and not just the beginning of
     the input, multiline mode must be enabled). These two replacements are performed with
     the equivalent (but more convenient, in this case) replaceAll() that’s part of String.
     Note that since each replacement is only used once in the program, there’s no extra
     cost to doing it this way rather than precompiling it as a Pattern.
     */
    public static void regexMatcherReplace() {
        String s = "/*!Here’s a block of text to use as input to the regular expression matcher.\n Note that we’ll first extract the block of text by looking for the special delimiters,\n then process the extracted block.!*/";
        // Match the specially commented block of text above:

        System.out.println(s);
        Matcher mInput =
                Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL)
                        .matcher(s);
        if (mInput.find())
            s = mInput.group(1); // Captured by parentheses (.*)
        // Use String's replaceAll() to replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");
        // Replace one or more spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);

        // replaceFirst( ) only performs the first replacement that it finds.
        // Use String's replaceFirst() to replace first vowel:
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");

        /*
        The replacement strings in replaceFirst( ) and replaceAll( )
        are just literals, so if you want to perform some processing on each
        replacement, they don’t help. In that case, you need to use
        appendReplacement( ), which allows you to write any amount of
        code in the process of performing the replacement.
        */
        StringBuffer sbuf = new StringBuffer();
        Matcher m = Pattern.compile("[aeiou]").matcher(s);
        // Process the find information as you perform the replacements:
        // A group( ) is selected and processed—in this situation, setting the vowel
        // found by the regular expression to uppercase—as the resulting sbuf is being built.
        while (m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        // Put in the remainder of the text:
        // Normally, you step through and perform all the replacements and then call appendTail( ),
        // but if you want to simulate replaceFirst( ) (or "replace n"),
        // you just do the replacement one time and then call appendTail( )
        // to put the rest into sbuf.
        m.appendTail(sbuf);
        System.out.println(sbuf);

    }

    /** To demonstrate an existing Matcher object can be applied to a new character
     *  sequence using the reset( ) addmethods:*/
    public static void regexMatcherReset() {
        Matcher m = Pattern.compile("[frb][aiu][gx]")
                .matcher("fix the rug with bags");
        while (m.find())
            System.out.print(m.group() + " ");
        System.out.println();
        m.reset("fix the rig with rags");
        while (m.find())
            System.out.print(m.group() + " ");
    }


}

/**
* A tij class to demonstrate Formatter (System.out.Formatter and String.Formatter).
*
* To directly print as System.out:
* new System.out.Formatter (%[argument_index$][flags][width][.precision]conversion)
*
* To convert as a String:
* String.format (%[argument_index$][flags][width][.precision]conversion)
*
*
* [flag]: By default, the data is right justified,
*       but this can be overridden by including a ‘-’ in the flags section.
* [width]: the minimum size of a field
* [.precision]: the maximum size of a field
*
* [conversion]:
*     %d: Integral (as decimal)
      %c: Unicode character
      %b: Boolean value
      %s: String
      %f: Floating point (as decimal)
      %e: Floating point (in scientific notation)
      %x: Integral (as hex)
      %h: Hash code (as hex)
      %%: Literal "%"*
* */
class Receipt {
    double total = 0;
    Formatter f = new Formatter(System.out);

       private void printTitle() {
        // The following is an equivalent.
        // System.out.print(String.format("%-15s %5s %10s\n", "Item", "Qty", "Price"));
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    private void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    private void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "",
                total * 1.06);
    }

    public void printReceipt() {
        printTitle();
        print("Jack’s Magic Beans", 4, 4.25);
        print("Princess Peas", 3, 5.1);
        print("Three Bears Porridge", 1, 14.29);
        printTotal();
    }
}
