package tij.generics.genericinterface;

/**
 * Created by Xiaolong on 12/29/2016.
 *
 * Thinking in Java p448-449
 *
 * Example of implementing both Generator and Iterable
 *
 */
public class FibonacciGenerator implements Generator<Integer> {
    private int count = 0;

    public Integer next() {
        return fib(count++);
    }

    private Integer fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        FibonacciGenerator gen = new FibonacciGenerator();
        for (int i = 0; i < 18; i++)
            System.out.print(gen.next() + " ");
    }
}