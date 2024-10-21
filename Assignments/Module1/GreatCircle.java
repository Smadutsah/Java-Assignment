public class GreatCircle {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Please provide exactly four double values for latitude and longitude.");
            return;
        }

        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);

        double r = 6371.0;
        double a = Math.pow(Math.sin((x2 - x1) / 2), 2) +
                   Math.cos(x1) * Math.cos(x2) * 
                   Math.pow(Math.sin((y2 - y1) / 2), 2);
        double distance = 2 * r * Math.asin(Math.sqrt(a));
        System.out.println(distance + " kilometers");
    }
}
