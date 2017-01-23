package tij.container2.choosing;
import java.util.*;

/**
 * Created by Xiaolong on 1/23/2017.
 *
 * Thinking in Java p627-628
 *
 * Demonstrates performance differences in Sets.
 *
 * I. Summary of Set Performance
 *
 * The performance of HashSet is generally superior to TreeSet, but especially
 * when adding elements and looking them up, which are the two most important
 * operations. TreeSet exists because it maintains its elements in sorted order
 * , so you use it only when you need a sorted Set. Because of the internal
 * structure necessary to support sorting and because iteration is something
 * you’re more likely to do, iteration is usually faster with a TreeSet than a HashSet.
 *
 *
 */
public class SetPerformance {
    static List<Test<Set<Integer>>> tests = new ArrayList<>();


    static {
        tests.add(new Test<Set<Integer>>("add") {
            int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    set.clear();
                    for(int j = 0; j < size; j++)
                        set.add(j);
                }
                return loops * size;
            }
        });


        tests.add(new Test<Set<Integer>>("contains") {
            int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops;int span = tp.size * 2;
                for(int i = 0; i < loops; i++)
                    for(int j = 0; j < span; j++)
                        set.contains(j);
                return loops * span;
            }
        });


        tests.add(new Test<Set<Integer>>("iterate") {
            int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; i++) {
                    Iterator<Integer> it = set.iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops * set.size();
            }
        });
    }



    public static void main(String[] args) {
        if(args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<Integer>(), tests);
        Tester.run(new HashSet<Integer>(), tests);
        Tester.run(new LinkedHashSet<Integer>(), tests);
    }
}