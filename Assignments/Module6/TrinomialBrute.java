public class TrinomialBrute {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // Base case: T(0, 0) = 1
        if (n == 0 && k == 0) {
            return 1;
        }
        // Out of bounds
        if (k < -n || k > n) {
            return 0;
        }
        // Recursive relation
        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long result = trinomial(n, k);
        System.out.println(result);
    }
}
