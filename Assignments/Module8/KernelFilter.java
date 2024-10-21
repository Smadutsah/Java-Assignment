public class KernelFilter {

    // Apply a kernel to a given picture
    private static Picture applyKernel(Picture picture, double[][] kernel) {
        int width = picture.width();
        int height = picture.height();
        Picture result = new Picture(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int[] newColor = new int[3]; // [r, g, b]
                
                // Apply the kernel to each color component
                for (int i = 0; i < 3; i++) {
                    double value = 0.0;
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int nx = (x + dx + width) % width;
                            int ny = (y + dy + height) % height;
                            value += kernel[dx + 1][dy + 1] * getComponent(picture.get(nx, ny), i);
                        }
                    }
                    newColor[i] = clamp((int) Math.round(value));
                }
                
                result.set(x, y, new Color(newColor[0], newColor[1], newColor[2]));
            }
        }

        return result;
    }

    // Returns a new picture that applies the identity filter.
    public static Picture identity(Picture picture) {
        double[][] kernel = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies a Gaussian blur filter.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = {
            {1 / 16.0, 1 / 8.0, 1 / 16.0},
            {1 / 8.0, 1 / 4.0, 1 / 8.0},
            {1 / 16.0, 1 / 8.0, 1 / 16.0}
        };
        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies a sharpen filter.
    public static Picture sharpen(Picture picture) {
        double[][] kernel = {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
        };
        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies a Laplacian filter.
    public static Picture laplacian(Picture picture) {
        double[][] kernel = {
            {-1, -1, -1},
            {-1, 8, -1},
            {-1, -1, -1}
        };
        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies an emboss filter.
    public static Picture emboss(Picture picture) {
        double[][] kernel = {
            {-2, -1, 0},
            {-1, 1, 1},
            {0, 1, 2}
        };
        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies a motion blur filter.
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = new double[9][9];
        for (int i = 0; i < 9; i++) {
            kernel[i][i] = 1.0 / 9.0;
        }
        return applyKernel(picture, kernel);
    }

    private static int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }

    private static int getComponent(Color color, int component) {
        switch (component) {
            case 0: return color.getRed();
            case 1: return color.getGreen();
            case 2: return color.getBlue();
            default: throw new IllegalArgumentException("Invalid component");
        }
    }

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        identity(picture).save("identity.png");
        gaussian(picture).save("gaussian.png");
        sharpen(picture).save("sharpen.png");
        laplacian(picture).save("laplacian.png");
        emboss(picture).save("emboss.png");
        motionBlur(picture).save("motionblur.png");
    }
}
