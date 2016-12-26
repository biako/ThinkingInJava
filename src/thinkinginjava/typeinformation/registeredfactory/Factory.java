package thinkinginjava.typeinformation.registeredfactory;

/**
 * Created by Xiaolong on 12/26/2016.
 *
 * The allows create() to return a different type for each implementation of Factory. This
 * also makes use of covariant return types.
 *
 */
public interface Factory<T> {
    T create();
}


