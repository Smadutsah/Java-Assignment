public class GeneralizedHarmonic {
    public static void main(String[] args) {
        // Parse the command-line arguments
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        
        // Initializing the harmonic sum
        double harmonicSum = 0.0;
        
        // Calculating the nth generalized harmonic number of order r
        for (int i = 1; i <= n; i++) {
            harmonicSum += 1.0 / Math.pow(i, r);
        }
        
        // Print the output
        System.out.println(harmonicSum);
    }
}