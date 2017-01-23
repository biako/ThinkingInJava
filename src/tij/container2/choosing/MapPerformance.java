package tij.container2.choosing;
import java.util.*;

/**
 * Created by Xiaolong on 1/23/2017.
 *
 * Thinking in Java p629
 *
 * Demonstrates performance differences in Maps.
 *
 * I. Summary of Map Performance
 *
 * Insertions for all the Map implementations except for IdentityHashMap get significantly slower as the size of the Map gets large. In general, however, lookup is much cheaper than insertion, which is good because you’ll typically be looking items up much more often than you insert them.
 *
 *
 Hashtable performance is roughly the same as HashMap. Since HashMap is intended to replace Hashtable, and thus uses the same underlying storage and lookup mechanism (which you will learn about later), this is not too surprising.
 A TreeMap is generally slower than a HashMap. As with TreeSet, a TreeMap is a way to create an ordered list. The behavior of a tree is such that it’s always in order and doesn’t have to be specially sorted. Once you fill a TreeMap, you can call keySet( ) to get a Set view of the keys, then toArray( ) to produce an array of those keys. You can then use the static method Arrays.binarySearch( ) to rapidly find objects in your sorted array. Of course, this only makes sense if the behavior of a HashMap is unacceptable, since HashMap is designed to rapidly find keys. Also, you can easily create a HashMap from a TreeMap with a single object creation or call to putAll( ). In the end, when you’re using a Map, your first choice should be HashMap, and only if you need a constantly sorted Map will you need TreeMap.



 LinkedHashMap tends to be slower than HashMap for insertions because it maintains the linked list (to preserve insertion order) in addition to the hashed data structure. Because of this list, iteration is faster.


 IdentityHashMap has different performance because it uses == rather than equals( ) for comparisons. WeakHashMap is described later in this chapter.



 * II HashMap performance factors
 *
 *
 *  It’s possible to hand-tune a HashMap to increase its performance for your
 *  particular application. So that you can understand performance issues when
 *  tuning a HashMap, some terminology is necessary:
 *
 *  Capacity: The number of buckets in the table.
 *
 *  Initial capacity: The number of buckets when the table is created. HashMap and
 *
 *  HashSet have constructors that allow you to specify the initial capacity.
 *
 *  Size: The number of entries currently in the table.
 *
 *  Load factor: Size/capacity. A load factor of o is an empty table, 0.5 is
 *  a half-full table, etc. A lightly loaded table will have few collisions and
 *  so is optimal for insertions and lookups (but will slow down the process of
 *  traversing with an iterator).
 *
 *  HashMap and HashSet have constructors that allow you to specify the load
 *  factor, which means that when this load factor is reached, the container
 *  will automatically increase the capacity (the number of buckets)
 *  by roughly doubling it and will redistribute the existing objects into the new
 *  set of buckets (this is called rehashing).
 *
 *
 *  The default load factor used by HashMap is 0.75 (it doesn’t rehash until the
 *  table is three-fourths full). This seems to be a good trade-off between time
 *  and space costs. A higher load factor decreases the space required by he table
 *  but increases the lookup cost, which is important because lookup is what you
 *  do most of the time including both get( ) and put( )).
 *
 *  If you know that you’ll be storing many entries in a HashMap, creating it
 *  with an appropriately large initial capacity will prevent the overhead
 *  of automatic rehashing.
 *
 */
public class MapPerformance {
    static List<Test<Map<Integer,Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Map<Integer,Integer>>("put") {
            int test(Map<Integer,Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    map.clear();
                    for(int j = 0; j < size; j++)
                        map.put(j, j);
                }
                return loops * size;
            }
        });

        tests.add(new Test<Map<Integer,Integer>>("get") {
            int test(Map<Integer,Integer> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for(int i = 0; i < loops; i++)
                    for(int j = 0; j < span; j++)
                        map.get(j);
                return loops * span;
            }
        });

        tests.add(new Test<Map<Integer,Integer>>("iterate") {
            int test(Map<Integer,Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; i ++) {
                    Iterator it = map.entrySet().iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops * map.size();
            }
        });
    }




    public static void main(String[] args) {
        if(args.length > 0)Tester.defaultParams = TestParam.array(args);

        Tester.run(new TreeMap<Integer,Integer>(), tests);
        Tester.run(new HashMap<Integer,Integer>(), tests);
        Tester.run(new LinkedHashMap<Integer,Integer>(),tests);
        Tester.run(new IdentityHashMap<Integer,Integer>(), tests);
        Tester.run(new WeakHashMap<Integer,Integer>(), tests);
        Tester.run(new Hashtable<Integer,Integer>(), tests);
    }
}