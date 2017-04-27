import java.util.*;
import java.lang.Math;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static List<Integer> dynamic_program(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int[] operation = new int[n + 1];
        operation[0] = -1;
        operation[1] = 0;
        for (int i = 2; i <= n; i++) {
            int min_operations = n;
            if (i % 3 == 0) {
                if (operation[i / 3] < min_operations) {
                    min_operations = operation[i / 3];
                }
            }
            if (i % 2 == 0) {
                if (operation[i / 2] < min_operations) {
                    min_operations = operation[i / 2];
                }
            }
            if (operation[i - 1] < min_operations) {
               min_operations = operation[i - 1];  
            }
            operation[i] = min_operations + 1;
        }
        while (n >= 1) {
            sequence.add(n);
            int min_operation_num = n;
            if (n % 3 == 0) {
                if (operation[n / 3] < operation[min_operation_num]) {
                    min_operation_num = n / 3;
                }
            }
            if (n % 2 == 0) {
                if (operation[n / 2] < operation[min_operation_num]) {
                    min_operation_num = n / 2;
                }
            }
            if (operation[n - 1] < operation[min_operation_num]) {
               min_operation_num = n - 1;  
            }
            n = min_operation_num;
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dynamic_program(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

