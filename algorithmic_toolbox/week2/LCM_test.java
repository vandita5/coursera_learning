import java.util.Scanner;
import java.util.Random;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static int gcd_efficient(int a, int b) {
    if (b == 0) {
      return a;
    }
    int d = a % b;
    return gcd_efficient(b, d);
  }

  private static long lcm_efficient(int a, int b) {
    // a * b = gcd * lcm
    return ((a * b) / (gcd_efficient(a, b)));
  }

  public static void main(String args[]) {
    // Scanner scanner = new Scanner(System.in);
    // int a = scanner.nextInt();
    // int b = scanner.nextInt();

    // System.out.println("lcm " + lcm_naive(a, b));
    // System.out.println("lcm " + lcm_efficient(a, b));
    // System.out.println("gcd " + gcd_efficient(a, b));

    while (true) {
      Random rand = new Random();
      int a = rand.nextInt(10000) + 1;
      int b = rand.nextInt(10000) + 1;
      long result1 = lcm_naive(a, b);
      long result2 = lcm_efficient(a, b);
      if (result1 == result2) {
        System.out.println("OK");
      }
      else {
        System.out.println("mismatch for " + a + " " + b + "\r\nresult naive " + result1 + "\r\nresult efficient " + result2);
        break;
      }      
    }

  }
}
