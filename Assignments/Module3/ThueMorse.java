public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // Generate the Thue-Morse sequence up to the required length
        int length = n;
        int[] thueMorse = new int[length];
        for (int i = 1; i < length; i++) {
            thueMorse[i] = 1 - thueMorse[i / 2];
        }

        // Create the n-by-n pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thueMorse[i] == thueMorse[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
