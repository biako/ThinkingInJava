package tij.container2.filling.generators;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p570-571
 *
 * The key and value fields are made public and final
 * so that Pair becomes a read-only Data Transfer Object (or Messenger).
 *
 */
public class Pair<K, V> {
    // public and final: so that Pair becomes a read-only Data Transfer Object (or Messenger).
    public final K key;
    public final V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }
}