public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // Create a DP table
        long[][] dp = new long[n + 1][2 * n + 1]; // To accommodate negative k

        // Base case: T(0, 0) = 1
        dp[0][0] = 1;

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = -i; j <= i; j++) {
                dp[i][j + n] = dp[i - 1][j - 1 + n] + dp[i - 1][j + n] + dp[i - 1][j + 1 + n];
            }
        }

        // Return the result
        return dp[n][k + n];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long result = trinomial(n, k);
        System.out.println(result);
    }
}
