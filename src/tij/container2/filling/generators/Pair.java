package tij.container2.filling.generators;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p570-571
 */
public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }
}