public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long inversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }

        for (int i = 0; i < n; i++) {
            if (k <= 0) break;
            // Maximum number of inversions we can create by swapping adjacent elements
            long maxInversions = (n - i - 1);
            if (k > maxInversions) {
                // Swap elements to create the maximum number of inversions
                for (int j = i; j < n && k > 0; j++) {
                    // Perform a swap
                    int temp = permutation[j];
                    permutation[j] = permutation[j + 1];
                    permutation[j + 1] = temp;
                    k--;
                }
            }
        }
        return permutation;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] permutation = generate(n, k);
        for (int value : permutation) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
