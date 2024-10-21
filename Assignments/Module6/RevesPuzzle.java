import java.awt.Color;

public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.square(x, y, length / 2);
        StdDraw.setPenColor(new Color(211, 211, 211)); // Light gray
        StdDraw.filledSquare(x, y, length / 2);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        drawSquare(x, y, length);
        draw(n - 1, x - length / 4, y - length / 4, length / 2);
        draw(n - 1, x + length / 4, y - length / 4, length / 2);
        draw(n - 1, x - length / 4, y + length / 4, length / 2);
        draw(n - 1, x + length / 4, y + length / 4, length / 2);
    }

    // Main method
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        draw(n, 0.5, 0.5, 0.5);
    }
}
