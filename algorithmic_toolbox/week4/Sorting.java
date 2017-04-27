import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static void swap(int[] a, int x, int y) {
      int temp = a[x];
      a[x] = a[y];
      a[y] = temp;
    }

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
      int[] m = {l, l};
      // System.out.println("for a[l] " + a[l]);
      for (int i = l + 1; i <= r; i++) {
          if (a[i] < a[l]) {
            m[0]++;
            swap(a, i, m[0]);
            m[1]++;
            if (m[0] != m[1]) {
              swap(a, i, m[1]);              
            }

            
          }
          else if (a[i] == a[l]) {
              m[1]++;
              swap(a, i, m[1]);
          }
          // System.out.println("for i " + i + " m[0] " + m[0] + " m[1] " + m[1]);
          // for (int j = l; j <= r; j++) {
          //   System.out.print(a[j] + " ");
          // }
          // System.out.print("\r\n");
      }
      swap(a, l, m[0]);
      // System.out.println("for last swap ");
      // for (int j = l; j <= r; j++) {
      //   System.out.print(a[j] + " ");
      // }
      // System.out.println("Partition 3 l " + l + " r " + r);
      // for (int i = l; i <= r; i++) {
      //   System.out.print(a[i] + " ");
      // }
      // System.out.println("\r\n" + " m[0] " + m[0] + " m[1] " + m[1]);
      return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
      while (l < r) {
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int m[] = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        l = m[1] + 1;
      }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

