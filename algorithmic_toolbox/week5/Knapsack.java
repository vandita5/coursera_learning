import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        return result;
    }

    private static int dynamic_optimalWeight(int W, int[] w) {
      int[][] weight = new int[w.length + 1][W + 1];
      for (int i = 0; i <= w.length; i++) {
        weight[i][0] = 0;
      }
      for (int j = 0; j <= W; j++) {
        weight[0][j] = 0;
      }
      for (int i = 1; i <= w.length; i++) {
        for (int j = 1; j <= W; j++) {
          weight[i][j] = weight[i - 1][j];
          if (w[i - 1] <= j) {
            int val = weight[i-1][j-w[i - 1]] + w[i - 1];
            if (val > weight[i][j]) {
              weight[i][j] = val;
            }
          }
        }
      }
      return weight[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(dynamic_optimalWeight(W, w));
    }
}

