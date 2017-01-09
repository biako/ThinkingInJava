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