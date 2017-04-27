import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        
        // int temp_m = 0;
        int coins = 0;
        while (m != 0)
        {
          // find if it is greater than 10 if not then greater than 5 if not
          if (m >= 10) {
            coins++;
            m = m - 10;
          }
          else if (m >= 5) {
            coins++;
            m = m - 5;
          }
          else
          {
            coins++;
            m = m - 1;
          }
        }
        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

