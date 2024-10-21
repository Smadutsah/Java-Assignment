import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    private final String name;
    private final int value;
    private final String category;

    // Constructor for Bar
    public Bar(String name, int value, String category) {
        if (name == null || category == null) {
            throw new IllegalArgumentException("Name and category cannot be null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Returns the name of this bar
    public String getName() {
        return name;
    }

    // Returns the value of this bar
    public int getValue() {
        return value;
    }

    // Returns the category of this bar
    public String getCategory() {
        return category;
    }

    // Compare two bars by value
    @Override
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("Argument to compareTo() is null");
        }
        return Integer.compare(this.value, that.value);
    }

    // Sample client
    public static void main(String[] args) {
        // Create an array of 10 bars
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing",     22674, "East Asia");
        bars[1] = new Bar("Cairo",       19850, "Middle East");
        bars[2] = new Bar("Delhi",       27890, "South Asia");
        bars[3] = new Bar("Dhaka",       19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai",      22120, "South Asia");
        bars[6] = new Bar("Osaka",       20409, "East Asia");
        bars[7] = new Bar("São Paulo",   21698, "Latin America");
        bars[8] = new Bar("Shanghai",    25779, "East Asia");
        bars[9] = new Bar("Tokyo",       38194, "East Asia");

        // Sort the bars in ascending order of value
        Arrays.sort(bars);

        // Print the sorted bars
        for (Bar bar : bars) {
            System.out.println(bar.getName() + ": " + bar.getValue() + " (" + bar.getCategory() + ")");
        }
    }
}
