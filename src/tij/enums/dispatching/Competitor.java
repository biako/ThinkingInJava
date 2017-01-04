package tij.enums.dispatching;

/**
 * Created by Xiaolong on 1/4/2017.
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}