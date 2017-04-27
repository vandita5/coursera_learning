import java.util.Scanner;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long gcd_efficient(int a, int b) {
    if (b == 0) {
      return a;
    }
    int d = a % b;
    return gcd_efficient(b, d);
  }

  private static long lcm_efficient(int a, int b) {
    // a * b = gcd * lcm
    return (((long)a) * ((long)b) / gcd_efficient(a, b));
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_efficient(a, b));
  }
}
