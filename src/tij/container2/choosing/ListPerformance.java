package tij.container2.choosing;
import tij.array.generator.CountingGenerator;
import tij.array.generator.Generated;
import tij.container2.filling.abstractclass.CountingIntegerList;

import java.util.*;
/**
 * Created by Xiaolong on 1/23/2017.
 *
 * Thinking in Java p621-624
 *
 *
 * Demonstrates performance differences in Lists.
 *
 * I. Summary of List Performance
 *
 * The best approach is probably to choose an ArrayList as your default and
 * to change to a LinkedList if you need its extra functionality or you discover
 * performance problems due to many insertions and removals from the middle of the
 * list. If you are working with a fixed-sized group of elements, either use a List
 * backed by an array (as produced by Arrays.asList( )), or if necessary, an actual
 * array.
 *
 * For random-access get( ) and set( ) operations, a List backed by an array is
 * slightly faster than an ArrayList, but the same operations are dramatically
 * more expensive for a LinkedList because it is not designed for random access operations.
 *
 * Vector should be avoided; it’s only in the library for legacy code support
 * (the only reason it works in this program is because it was adapted to be a List for forward compatibility).
 *
 * CopyOnWriteArrayList is a special implementation of List used in concurrent
 * programming, and will be discussed in the Concurrency chapter.
 *
 *
 *
 * II. About this code:
 *
 * Each test requires careful thought to ensure that you are producing meaningful
 * results. For example, the "add" test clears the List and then refills it to the
 * specified list size. The call to clear( ) is thus part of the test, and may have
 * an impact on the time, especially for small tests. Although the results here
 * seem fairly reasonable, you could imagine rewriting the test framework so that
 * there is a call to a preparation method (which would, in this case, include the
 * clear( ) call) outside of the timing loop.
 *
 *
 * Note that for each test, you must accurately calculate the number of operations
 * that occur and return that value from test( ), so the timing is correct.
 *
 * The "get" and "set" tests both use the random number generator to perform random
 * accesses to the List. In the output, you can see that, for a List backed by an
 * array and for an ArrayList, these accesses are fast and very consistent regardless
 * of the list size, whereas for a LinkedList is quite cheap and doesn’t vary with
 * the list size, but with an ArrayList, insertions especially are very expensive,
 * and the cost increases with list size.
 *
 *
 * From the Queue tests, you can see how quickly a LinkedList can insert and remove
 * elements from the endpoints of the list, which is optimal for Queue behavior.
 *
 * Normally, you can just call Tester.run( ), passing the container and the tests list.
 * Here, however, we must override the initialize( ) method so that the List is cleared
 * and refilled before each test—otherwise the List control over the size of the List
 * would be lost during the various tests. ListTester inherits from Tester and performs
 * this initialization using CountingIntegerList. The run( ) convenience method is also
 * overridden.
 *
 * We’d also like to compare array access to container access (primarily against ArrayList).
 * In the first test in main( ), a special Test object is created using an anonymous inner
 * class. The initialize( ) method is overridden to create a new object each time it is
 * called (ignoring the stored container object, so null is the container argument for this
 * Tester constructor). The new object is created using Generated.array( )
 * (which was defined in the Arrays chapter) and Arrays.asList( ).
 *
 * Only two of the tests can be performed in this case, because you cannot insert or
 * remove elements when using a List backed by an array, so the List.subList( ) method
 * is used to select the desired tests from the tests list.
 *
 */
public class ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qTests = new ArrayList<>();

    // Static initialization:
    static {
        tests.add(new Test<List<Integer>>("add") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < listSize; j++)
                        list.add(j);
                }
                return loops * listSize;
            }
        });

        tests.add(new Test<List<Integer>>("get") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("set") {int test(List<Integer> list, TestParam tp) {
            int loops = tp.loops * reps;
            int listSize = list.size();
            for(int i = 0; i < loops; i++)
                list.set(rand.nextInt(listSize), 47);
            return loops;
        }
        });

        tests.add(new Test<List<Integer>>("iteradd") {
            int test(List<Integer> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<Integer> it = list.listIterator(half);
                for(int i = 0; i < LOOPS; i++)
                    it.add(47);
                return LOOPS;
            }
        });

        tests.add(new Test<List<Integer>>("insert") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                for(int i = 0; i < loops; i++)
                    list.add(5, 47); // Minimize random-access cost
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("remove") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size() > 5)
                        list.remove(5); // Minimize random-access cost
                }
                return loops * size;
            }
        });


        // Tests for queue behavior:
        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < size; j++)
                        list.addFirst(47);
                }
                return loops * size;
            }
        });

        qTests.add(new Test<LinkedList<Integer>>("addLast") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < size; j++)
                        list.addLast(47);
                }
                return loops * size;
            }});

        qTests.add(
                new Test<LinkedList<Integer>>("rmFirst") {
                    int test(LinkedList<Integer> list, TestParam tp) {
                        int loops = tp.loops;
                        int size = tp.size;
                        for(int i = 0; i < loops; i++) {
                            list.clear();
                            list.addAll(new CountingIntegerList(size));
                            while(list.size() > 0)
                                list.removeFirst();
                        }
                        return loops * size;
                    }
                });

        qTests.add(new Test<LinkedList<Integer>>("rmLast") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container,
                          List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        // Fill to the appropriate size before each test:
        @Override
        protected List<Integer> initialize(int size){
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }

        // Convenience method:
        public static void run(List<Integer> list,
                               List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        // Pass in parameters through args in main()
        if(args.length > 0) Tester.defaultParams = TestParam.array(args);

        // Can only do these two tests on an array:
        Tester<List<Integer>> arrayTest =
                new Tester<List<Integer>>(null, tests.subList(1, 3)){
                    // This will be called before each test. It
                    // produces a non-resizeable array-backed list:
                    @Override
                    protected List<Integer> initialize(int size) {
                        Integer[] ia = Generated.array(Integer.class,
                                new CountingGenerator.Integer(), size);
                        return Arrays.asList(ia);
                    }
                };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();Tester.defaultParams= TestParam.array(
                10, 5000, 100, 5000, 1000, 1000, 10000, 200);


        // Pass in parameters through args in main()
        if(args.length > 0) Tester.defaultParams = TestParam.array(args);
        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<Integer>(), tests);
        ListTester.run(new Vector<Integer>(), tests);


        Tester.fieldWidth = 12;
        Tester<LinkedList<Integer>> qTest =
                new Tester<LinkedList<Integer>>(new LinkedList<Integer>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}