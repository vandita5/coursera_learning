// import java.util.Scanner;

// public class Fibonacci_last_digit {
//   private static long calc_fib(int n) {
// // define an array and then start storing stuff to it
//     long fib_arr[] = new long[n + 1];
//     if(n < 2) {
//       return n;
//     }
//     fib_arr[0] = 0;
//     fib_arr[1] = 1;
//     for( int i = 2; i < fib_arr.length; i++) {
//       fib_arr[i] = fib_arr[i-1] + fib_arr[i-2];
//     }
//     return fib_arr[n];
//   }

//   public static void main(String args[]) {
//     Scanner in = new Scanner(System.in);
//     int n = in.nextInt();

//     System.out.println(calc_fib(n));
//   }
// }

import java.util.Scanner;

public class Fibonacci_last_digit {
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

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));
  }
}