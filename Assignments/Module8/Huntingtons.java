public class Huntingtons {

    // Returns the maximum number of consecutive repeats of "CAG" in the DNA string.
    public static int maxRepeats(String dna) {
        int maxCount = 0;
        int currentCount = 0;
        String repeat = "CAG";

        for (int i = 0; i <= dna.length() - 3; i++) {
            if (dna.substring(i, i + 3).equals(repeat)) {
                currentCount++;
                i += 2; // Move index forward to the end of the current "CAG"
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                currentCount = 0;
            }
        }

        return Math.max(maxCount, currentCount);
    }

    // Returns a copy of the string with all whitespace removed.
    public static String removeWhitespace(String s) {
        return s.replace(" ", "").replace("\t", "").replace("\n", "");
    }

    // Returns a diagnosis based on the maximum number of CAG repeats.
    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 0 && maxRepeats <= 9) {
            return "not human";
        } else if (maxRepeats >= 10 && maxRepeats <= 35) {
            return "normal";
        } else if (maxRepeats >= 36 && maxRepeats <= 39) {
            return "high risk";
        } else if (maxRepeats >= 40 && maxRepeats <= 180) {
            return "Huntington's";
        } else {
            return "not human";
        }
    }

    // Sample client
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Huntingtons <filename>");
            return;
        }

        // Read DNA sequence from file
        In in = new In(args[0]);
        String dna = in.readAll();
        
        // Remove any whitespace
        dna = removeWhitespace(dna);
        
        // Count the number of CAG repeats
        int maxRepeats = maxRepeats(dna);
        
        // Print medical diagnosis
        System.out.println("max repeats = " + maxRepeats);
        System.out.println(diagnose(maxRepeats));
    }
}
