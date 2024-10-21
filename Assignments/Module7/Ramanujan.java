import java.util.HashSet;

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        HashSet<Long> cubes = new HashSet<>();
        for (long a = 1; a * a * a < n; a++) {
            for (long b = a + 1; b * b * b < n; b++) {
                long sum = a * a * a + b * b * b;
                if (sum == n) {
                    if (cubes.contains(sum)) {
                        return true;
                    }
                    cubes.add(sum);
                }
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
