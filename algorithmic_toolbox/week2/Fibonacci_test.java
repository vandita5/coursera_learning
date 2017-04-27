// import java.util.Scanner;
import java.util.Random;

public class Fibonacci_test {
  private static int calc_fib(int n) {
    int digit_arr[] = new int[n + 1];
    if (n < 2) {
      return n;
    }
    digit_arr[0] = 0;
    digit_arr[1] = 1;
    for (int i = 2; i < digit_arr.length; i++) {
      digit_arr[i] = (digit_arr[i - 1] + digit_arr[i - 2]) % 10;      
    }
    return digit_arr[n];
  }
  private static int calc_fib_efficient(int n) {
// define an array and then start storing stuff to it
    long fib_arr[] = new long[n + 1];
    if(n < 2) {
      return n;
    }
    fib_arr[0] = 0;
    fib_arr[1] = 1;
    for( int i = 2; i < fib_arr.length; i++) {
      fib_arr[i] = fib_arr[i-1] + fib_arr[i-2];
    }
    return ((int)(fib_arr[n] % 10));
  }
  public static void main(String args[]) {
    while (true) {
      Random rand = new Random();
      int n = rand.nextInt(100);
      int result1 = calc_fib(n);
      int result2 = calc_fib_efficient(n);
      if (result1 == result2) {
        System.out.println("OK");
      }
      else {
        System.out.println("mismatch for " + n + "\r\nresult naive " + result1 + "\r\nresult efficient " + result2);
        break;
      }      
    }

    // Scanner in = new Scanner(System.in);
    // int n = in.nextInt();

    // System.out.println(calc_fib(n));
  }
}
