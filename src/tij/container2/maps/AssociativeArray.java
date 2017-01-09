package tij.container2.maps;

/**
 * Created by Xiaolong on 1/9/2017.
 *
 * Thinking in Java p598-599
 *
 * Understanding Maps by looking at how an associative array is constructed.
 *
 * An associative array: 2-D array consisting of a key-value pair. It is a fixed-length type of map.
 *
 * The essential methods in an associative array are put( ) and get( ),
 * but for easy display, toString( ) has been overridden to print the key-value pairs.
 *
 * To show that it works, main( ) loads an AssociativeArray with pairs of strings and
 * prints the resulting map, followed by a get( ) of one of the values.
 *
 * To use the get( ) method, you pass in the key that you want it to look up, and it
 * produces the associated value as the result or returns null if it can’t be found.
 * The get( ) method is using what is possibly the least efficient approach imaginable
 * to locate the value: starting at the top of the array and using equals( ) to compare
 * keys. But the point here is simplicity, not efficiency.
 *
 * So the above version is instructive, but it isn’t very efficient and it has a fixed size,
 * which is inflexible. Fortunately, the Maps in java.util do not have these problems and
 * can be substituted into the above example
 *
 *
 *
 */
public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null; // Did not find key
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(": ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");

        try{
            map.put("extra", "object");} // Past the end
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e + "\nToo many objects!");
            }

        System.out.println(map);
        System.out.println("map.get(\"ocean\"): " + map.get("ocean"));
        System.out.println("map.get(\"tree\"): "  + map.get("tree"));
    }
}