public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Constructor for ColorHSB
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) {
            throw new IllegalArgumentException("Invalid HSB values");
        }
        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    // String representation of the color
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Check if the color is grayscale
    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    // Calculate the squared distance to another color
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("ColorHSB object is null");
        }

        int hueDiff = Math.min((this.hue - that.hue) * (this.hue - that.hue),
                               (360 - Math.abs(this.hue - that.hue)) * (360 - Math.abs(this.hue - that.hue)));
        int satDiff = (this.saturation - that.saturation) * (this.saturation - that.saturation);
        int brightDiff = (this.brightness - that.brightness) * (this.brightness - that.brightness);
        return hueDiff + satDiff + brightDiff;
    }

    // Sample client
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB inputColor = new ColorHSB(h, s, b);

        String closestColorName = null;
        ColorHSB closestColor = null;
        int minDistance = Integer.MAX_VALUE;

        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int hue = StdIn.readInt();
            int saturation = StdIn.readInt();
            int brightness = StdIn.readInt();
            ColorHSB color = new ColorHSB(hue, saturation, brightness);

            int distance = inputColor.distanceSquaredTo(color);
            if (distance < minDistance) {
                minDistance = distance;
                closestColorName = colorName;
                closestColor = color;
            }
        }

        System.out.println(closestColorName + " " + closestColor);
    }
}
