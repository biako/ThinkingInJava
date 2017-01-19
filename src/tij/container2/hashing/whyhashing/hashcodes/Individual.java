package tij.container2.hashing.whyhashing.hashcodes;

/**
 * Created by Xiaolong on 1/19/2017.
 * <p>
 * Thinking in Java p614-615
 */
public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Individual(String name) { this.name = name; }

    // ‘name’ is optional:
    public Individual() {}

    public String toString() {
        return getClass().getSimpleName() +
                (name == null ? "" : " " + name);
    }

    public long id() { return id; }

    public boolean equals(Object o) {
        return o instanceof Individual &&
                id == ((Individual)o).id;
    }

    public int hashCode() {
        int result = 17;
        if(name != null)
            result = 37 * result + name.hashCode();
        result = 37 * result + (int)id;
        return result;
    }


    // The compareTo( ) method has a hierarchy of comparisons, so that it will
    // produce a sequence that is sorted first by actual type, then by name if
    // there is one, and finally falls back to creation order.
    public int compareTo(Individual arg) {
        // Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);

        if(firstCompare != 0)
            return firstCompare;

        if(name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if(secondCompare != 0)
                return secondCompare;
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}
