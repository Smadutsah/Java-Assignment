import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        
        // Frequency map to count occurrences of each integer
        Map<Integer, Integer> frequency = new HashMap<>();
        int totalCount = 0;

        // Read integers from standard input
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num >= 1 && num <= m) {
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
                totalCount++;
            }
        }
        scanner.close();

        // Calculate Shannon entropy
        double entropy = 0.0;
        for (int i = 1; i <= m; i++) {
            if (frequency.containsKey(i)) {
                double pi = (double) frequency.get(i) / totalCount;
                entropy += pi * (Math.log(pi) / Math.log(2)); // log base 2
            }
        }
        entropy = -entropy; // H = -sum(pilog2(pi))

        // Print the result with 4 digits after the decimal point
        System.out.printf("%.4f%n", entropy);
    }
}
