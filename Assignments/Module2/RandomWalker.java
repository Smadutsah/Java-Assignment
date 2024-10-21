import java.util.Random;

public class RandomWalker {
    public static void main(String[] args) {
        // Parse the command-line argument
        int r = Integer.parseInt(args[0]);

        // Initialize position and step counter
        int x = 0;
        int y = 0;
        int steps = 0;

        // Create a random number generator
        Random random = new Random();

        // Print the starting position
        System.out.println("(" + x + ", " + y + ")");

        // Simulate the random walk until Manhattan distance is r
        while (Math.abs(x) + Math.abs(y) < r) {
            int direction = random.nextInt(4);
            if (direction == 0) x++;         // move east
            else if (direction == 1) x--;    // move west
            else if (direction == 2) y++;    // move north
            else y--;                        // move south

            // Print the new position and increment step counter
            System.out.println("(" + x + ", " + y + ")");
            steps++;
        }

        // Printing the number of steps taken
        System.out.println("steps = " + steps);
    }
}
