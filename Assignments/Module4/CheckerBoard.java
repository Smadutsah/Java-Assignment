
public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n); // Set the scale of the drawing window

        // Draw the checkerboard
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Determine the color based on the position
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                // Draw the square
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
