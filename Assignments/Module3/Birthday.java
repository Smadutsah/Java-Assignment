import java.util.Random;

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        Random random = new Random();

        // Array to store the results of the trials
        int[] count = new int[n];
        int[] occurrences = new int[n + 1];

        for (int t = 0; t < trials; t++) {
            boolean[] hasBirthday = new boolean[n];
            int people = 0;

            while (true) {
                int birthday = random.nextInt(n);
                people++;

                if (hasBirthday[birthday]) {
                    occurrences[people]++;
                    break;
                }
                hasBirthday[birthday] = true;
            }
        }

        // Calculate and print the results
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += occurrences[i];
            double fraction = (double) total / trials;
            System.out.println(i + "\t" + occurrences[i] + "\t" + fraction);

            if (fraction >= 0.5) {
                break;
            }
        }
    }
}
