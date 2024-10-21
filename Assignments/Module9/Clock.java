public class Clock {
    private int hours;
    private int minutes;

    // Constructor with hours and minutes
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Invalid time");
        }
        this.hours = h;
        this.minutes = m;
    }

    // Constructor from a string in the format HH:MM
    public Clock(String s) {
        if (!s.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Invalid time format");
        }

        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Invalid time");
        }

        this.hours = h;
        this.minutes = m;
    }

    // String representation of the clock time
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Check if this clock time is earlier than another clock time
    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours) return true;
        if (this.hours == that.hours && this.minutes < that.minutes) return true;
        return false;
    }

    // Add one minute to the current time
    public void tic() {
        if (minutes == 59) {
            minutes = 0;
            hours = (hours + 1) % 24;
        } else {
            minutes++;
        }
    }

    // Add delta minutes to the current time
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Delta must be non-negative");
        }
        int totalMinutes = hours * 60 + minutes + delta;
        hours = (totalMinutes / 60) % 24;
        minutes = totalMinutes % 60;
    }

    // Sample client
    public static void main(String[] args) {
        // Create clocks
        Clock clock1 = new Clock(13, 45);
        Clock clock2 = new Clock("12:30");

        // Display clocks
        System.out.println("Clock 1: " + clock1);
        System.out.println("Clock 2: " + clock2);

        // Check which is earlier
        System.out.println("Clock 1 is earlier than Clock 2: " + clock1.isEarlierThan(clock2));

        // Advance time
        clock1.tic();
        System.out.println("Clock 1 after tic: " + clock1);
        
        clock2.toc(60);
        System.out.println("Clock 2 after 60 minutes: " + clock2);
    }
}
