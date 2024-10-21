import java.util.Scanner;

public class WorldMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the width and height of the canvas
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        // Set up the canvas
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        
        // Read each region
        while (scanner.hasNextLine()) {
            String regionName = scanner.nextLine(); // Read region name
            int vertexCount = scanner.nextInt(); // Read number of vertices

            // Arrays to hold x and y coordinates of the polygon
            double[] x = new double[vertexCount];
            double[] y = new double[vertexCount];

            // Read vertices coordinates
            for (int i = 0; i < vertexCount; i++) {
                x[i] = scanner.nextDouble();
                y[i] = scanner.nextDouble();
            }
            scanner.nextLine(); // Move to the next line for next region

            // Draw the polygon for the region
            StdDraw.polygon(x, y);
        }

        scanner.close();
        
        // Optionally, you can add a title
        StdDraw.text(width / 2, height - 20, "Map of " + "Country/Region Name");
    }
}
