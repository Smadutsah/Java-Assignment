import java.util.ArrayList;
import java.util.List;

public class BarChart {
    private String title;
    private String xAxisLabel;
    private String dataSource;
    private String caption;
    private List<Bar> bars;

    // Creates a bar chart with the given title, x-axis label, and data source.
    public BarChart(String title, String xAxisLabel, String dataSource) {
        this.title = title;
        this.xAxisLabel = xAxisLabel;
        this.dataSource = dataSource;
        this.bars = new ArrayList<>();
    }

    // Sets the caption of this bar chart.
    public void setCaption(String caption) {
        this.caption = caption;
    }

    // Adds a bar (name, value, category) to this bar chart.
    public void add(String name, int value, String category) {
        Bar bar = new Bar(name, value, category);
        bars.add(bar);
    }

    // Remove all of the bars from this bar chart.
    public void reset() {
        bars.clear();
    }

    // Draws this bar chart to standard draw.
    public void draw() {
        // This method is supposed to use StdDraw for graphical representation.
        // Here, we'll simulate the output as text.
        
        System.out.println("Title: " + title);
        System.out.println("X-Axis: " + xAxisLabel);
        System.out.println("Data Source: " + dataSource);
        System.out.println("Caption: " + caption);
        System.out.println("\nBars:");
        
        for (Bar bar : bars) {
            System.out.printf("%-15s %10d %s\n", bar.getName(), bar.getValue(), bar.getCategory());
        }
    }

    // Sample client to demonstrate the BarChart class
    public static void main(String[] args) {
        // create the bar chart
        String title = "The 10 most populous cities";
        String xAxis = "Population (thousands)";
        String source = "Source: United Nations";
        BarChart chart = new BarChart(title, xAxis, source);
        chart.setCaption("2018");

        // add the bars to the bar chart
        chart.add("Tokyo",       38194, "East Asia");
        chart.add("Delhi",       27890, "South Asia");
        chart.add("Shanghai",    25779, "East Asia");
        chart.add("Beijing",     22674, "East Asia");
        chart.add("Mumbai",      22120, "South India");
        chart.add("São Paulo",   21698, "Latin America");
        chart.add("Mexico City", 21520, "Latin America");
        chart.add("Osaka",       20409, "East Asia");
        chart.add("Cairo",       19850, "Middle East");
        chart.add("Dhaka",       19633, "South Asia");

        // draw the bar chart
        chart.draw();
    }
}
