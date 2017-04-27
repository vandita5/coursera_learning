import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    
    // private static long getFibonacciHugeEfficient(long n, long m) {
    //     if (n <= 1) {
    //         return n;
    //     }

    //     // ArrayList<long> mod_arr = new ArrayList<long>();
    //     long mod_arr[] = new long[m];
    //     long length_period = 0;
    //     mod_arr.add(0);
    //     mod_arr.add(1);
    //     long previous_fib = 0;
    //     long current_fib = 1;
    //     for (long i = 0; i < n-1; i++ ) {
    //         long temp_fib = previous_fib;
    //         previous_fib = current_fib;
    //         current_fib = previous_fib + temp_fib;
    //         mod_arr.add = current_fib % m;
    //         if ((mod_arr.get((int)i) == 1) && (mod_arr.get((int)i - 1) == 0))
    //         {
    //             length_period = i;
    //         }
    //     }
    //     return mod_arr.get((int)(n % length_period));
    // }

    private static long getFibonacciHugeEfficient(long n, int m) {
        if (n <= 1) {
            return n;
        }

        // ArrayList<long> mod_arr = new ArrayList<long>();
        int mod_arr[] = new int[m];
        int length_period = 0;
        // mod_arr.add(0);
        // mod_arr.add(1);
        mod_arr[0] = 0;
        mod_arr[1] = 1;
        long previous_fib = 0;
        long current_fib = 1;
        for (int i = 0; i < n-1; i++ ) {
            long temp_fib = previous_fib;
            previous_fib = current_fib;
            current_fib = previous_fib + temp_fib;
            mod_arr[i] = (int)(current_fib % m);
            // if ((mod_arr.get((int)i) == 1) && (mod_arr.get((int)i - 1) == 0))
            if ((mod_arr[i] == 1) && ()
            {
                length_period = i;
            }
        }
        return mod_arr.get((int)(n % length_period));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

