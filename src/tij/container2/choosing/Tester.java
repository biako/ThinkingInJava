package tij.container2.choosing;
import java.util.*;

/**
 * Created by Xiaolong on 1/21/2017.
 *
 * Thinking in Java p619-620
 *
 * To use the framework, you pass the container to be tested along with
 * a List of Test objects to a Tester.run( ) method (these are overloaded
 * generic convenience methods which reduce the amount of typing necessary
 * to use them). Tester.run( ) calls the appropriate overloaded constructor,
 * then calls timedTest( ), which executes each test in the list for that
 * container. timedTest( ) repeats each test for each of the TestParam objects
 * in paramList. Because paramList is initialized from the static defaultParams
 * array, you can change the paramList for all tests by reassigning defaultParams,
 * or you can change the paramList for one test by passing in a custom paramList
 * for that test:
 *
 *
 * The stringField( ) and numberField( ) methods produce formatting strings
 * for outputting the results. The standard width for formatting can be changed
 * by modifying the static fieldWidth value. The displayHeader( ) method formats
 * and prints the header information for each test.
 *
 *
 * If you need to perform special initialization, override the initialize( ) method.
 * This produces an initialized container object of the appropriate size—you can either
 * modify the existing container object or create a new one. You can see in test( )
 * that the result is captured in a local reference called kontainer, which allows
 * you to replace the stored member container with a completely different initialized container.
 *
 * The return value of each Test.test( ) method must be the number of operations
 * performed by that test, which is used to calculate the number of nanoseconds
 * required for each operation. You should be aware that System.nanoTime( ) typically
 * produces values with a granularity that is greater than one (and this granularity
 * will vary with machines and operating systems), and this will produce a certain
 * amount of rattle in the results.
 *
 * The results may vary from machine to machine; these tests are only intended to
 * compare the performance of the different containers.
 *
 *
 */
public class Tester<C> {

    public static int fieldWidth = 8;
    public static TestParam[] defaultParams= TestParam.array(
            10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    // Override this to modify pre-test initialization:
    protected C initialize(int size) { return container; }
    protected C container;
    private String headline = "";
    private List<Test<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    private TestParam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if(container != null)
            headline = container.getClass().getSimpleName();
    }

    public Tester(C container, List<Test<C>> tests,
                  TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHeadline(String newHeadline) {
        headline = newHeadline;
    }


    // Generic methods for convenience :
    public static <C> void run(C cntnr, List<Test<C>> tests){
        new Tester<C>(cntnr, tests).timedTest();
    }

    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<C>(cntnr, tests, paramList).timedTest();
    }


    private void displayHeader() {
        // Calculate width and pad with ‘-’:
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for(int i = 0; i < dashLength/2; i++)
            head.append('-');
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for(int i = 0; i < dashLength/2; i++)
            head.append('-');
        System.out.println(head);
        // Print column headers:
        System.out.format(sizeField, "size");
        for(Test test : tests)
            System.out.format(stringField(), test.name);
        System.out.println();
    }


    // Run the tests for this container:
    public void timedTest() {
        displayHeader();
        for(TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for(Test<C> test : tests) {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                // Call the overridden method:
                int reps = test.test(kontainer, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps; // Nanoseconds
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
}