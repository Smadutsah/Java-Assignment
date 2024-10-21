import java.util.Random;

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        // Create a grid to represent the mines
        boolean[][] mines = new boolean[m][n];
        int[][] counts = new int[m][n];
        Random random = new Random();

        // Place k mines randomly on the grid
        for (int i = 0; i < k; i++) {
            int row, col;
            do {
                row = random.nextInt(m);
                col = random.nextInt(n);
            } while (mines[row][col]); 
            mines[row][col] = true;
        }

        // Count the neighboring mines for each cell
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]) {
                    counts[i][j] = -1;
                    continue;
                }
                int mineCount = 0;
                for (int d = 0; d < 8; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && mines[ni][nj]) {
                        mineCount++;
                    }
                }
                counts[i][j] = mineCount;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]) {
                    System.out.print("*  ");
                } else {
                    System.out.print(counts[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
