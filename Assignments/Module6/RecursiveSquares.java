public class RevesPuzzle {

    // Recursive method to solve Reve's puzzle
    public static void reves(int n, char source, char target, char auxiliary1, char auxiliary2) {
        if (n == 0) return;

        // Find the largest k
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        // Move k smallest discs to auxiliary1
        reves(k, source, auxiliary1, auxiliary2, target);
        // Move remaining discs to target
        hanoi(n - k, source, target, auxiliary1);
        // Move k smallest discs to target
        reves(k, auxiliary1, target, source, auxiliary2);
    }

    // Recursive method for the 3-pole Towers of Hanoi
    private static void hanoi(int n, char source, char target, char auxiliary) {
        if (n == 0) return;
        hanoi(n - 1, source, auxiliary, target);
        System.out.printf("Move disc %d from %c to %c%n", n, source, target);
        hanoi(n - 1, auxiliary, target, source);
    }

    // Main method
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, 'A', 'D', 'B', 'C'); // A -> start, D -> target, B and C -> auxiliary
    }
}
