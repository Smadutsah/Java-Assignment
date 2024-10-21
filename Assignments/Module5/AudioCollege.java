import java.util.Arrays;

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * alpha;
        }
        return result;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int maxLength = Math.max(a.length, b.length);
        double[] result = new double[maxLength];
        for (int i = 0; i < maxLength; i++) {
            double sampleA = (i < a.length) ? a[i] : 0.0;
            double sampleB = (i < b.length) ? b[i] : 0.0;
            result[i] = sampleA + sampleB;
        }
        return result;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int) Math.floor(a.length / alpha);
        double[] result = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            result[i] = a[(int) Math.floor(i * alpha)];
        }
        return result;
    }

    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args) {
        // Read WAV files
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] dialup = StdAudio.read("dialup.wav");

        // Create audio collage using various effects
        double[] collage1 = amplify(beatbox, 1.5); // Amplify beatbox
        double[] collage2 = reverse(buzzer); // Reverse buzzer
        double[] collage3 = merge(collage1, collage2); // Merge beatbox and reversed buzzer
        double[] collage4 = mix(collage3, chimes); // Mix previous collage with chimes
        double[] collage5 = changeSpeed(cow, 1.5); // Change speed of cow sound
        double[] finalCollage = merge(collage4, collage5); // Merge with cow sound

        // Play final audio collage
        StdAudio.play(finalCollage);
    }
}
