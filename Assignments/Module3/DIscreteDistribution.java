import java.util.Random;

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;

        // Parse the integer values into an array
        int[] a = new int[n];
        int[] cumulativeSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
            cumulativeSum[i + 1] = cumulativeSum[i] + a[i];
        }

        int totalSum = cumulativeSum[n];
        Random random = new Random();

        // Generate m random indices
        for (int i = 0; i < m; i++) {
            int r = random.nextInt(totalSum);
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (r >= cumulativeSum[j] && r < cumulativeSum[j + 1]) {
                    index = j + 1;
                    break;
                }
            }
            System.out.print(index + " ");
        }
        System.out.println();
    }
}
