import java.util.Random;

public class RandomWalkers {
    public static void main(String[] args) {
        // Parse the command-line arguments
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // Create a random number generator
        Random random = new Random();

        // Variable to accumulate total number of steps across all trials
        long totalSteps = 0;

        // Perform each trial
        for (int t = 0; t < trials; t++) {
            int x = 0;
            int y = 0;
            int steps = 0;

            // Simulate the random walk until Manhattan distance is r
            while (Math.abs(x) + Math.abs(y) < r) {
                int direction = random.nextInt(4);
                if (direction == 0) x++;         // move east
                else if (direction == 1) x--;    // move west
                else if (direction == 2) y++;    // move north
                else y--;                        // move south

                steps++;
            }

            // Add the steps from this trial to the total
            totalSteps += steps;
        }

        // Calculate and print the average number of steps
        double averageSteps = (double) totalSteps / trials;
        System.out.println("average number of steps = " + averageSteps);
    }
}
