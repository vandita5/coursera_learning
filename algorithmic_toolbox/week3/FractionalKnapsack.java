import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double value_per_unit[] = new double[values.length];
        int max_value_per_unit_idx = 0;
        //write your code here
        // calculate values per unit
        // System.out.println("value_per_unit");
        // DecimalFormat df = new DecimalFormat("#.0000");
        for (int i = 0; i < values.length; i++) {
            value_per_unit[i] = ((double) values[i]) / ((double) weights[i]);
            // System.out.println(df.format(value_per_unit[i]));
        }
        // loop until capacity is not zero
        while(capacity != 0) {
            // find max value of value per unit in the array
            for (int j = 0; j < values.length; j++) {
                if (value_per_unit[j] > value_per_unit[max_value_per_unit_idx]) {
                    max_value_per_unit_idx = j;
                }
            }
            // System.out.println("max_value_per_unit_idx");
            // System.out.println(max_value_per_unit_idx);
            // find max between capacity and weight of max value per unit item
            int val_add = Math.min(capacity, weights[max_value_per_unit_idx]);
            // System.out.println("val_add");
            // System.out.println(val_add);
            value += ((double)val_add * value_per_unit[max_value_per_unit_idx]);
            // System.out.println("value ");
            // System.out.println(value);
            capacity -= val_add;
            // weights[max_value_per_unit_idx] -= val_add;
            // values[max_value_per_unit_idx] -= ((double)val_add * value_per_unit[max_value_per_unit_idx]);
            value_per_unit[max_value_per_unit_idx] = 0;
            max_value_per_unit_idx = 0;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        // System.out.println("n "+n);
        // System.out.println("capacity "+capacity);
        // for (int i = 0; i < n; i++) {
        //     System.out.println(values[i]);
        //     System.out.println(weights[i]);
        // }
        DecimalFormat df = new DecimalFormat("#.####");
// df.setRoundingMode(RoundingMode.CEILING);
// for (Number n : Arrays.asList(12, 123.12345, 0.23, 0.1, 2341234.212431324)) {
//     Double d = n.doubleValue();
//     System.out.println(df.format(d));
// }
        System.out.println(df.format(getOptimalValue(capacity, values, weights)));
    }
} 
