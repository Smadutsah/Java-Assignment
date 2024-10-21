public class HelloGoodbye {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide exactly two names.");
            return;
        }
        
        String Name1 = args[0];
        String Name2 = args[1];
        
        System.out.println("Hello " + Name1 + " and " + Name2 + ".");
        System.out.println("Goodbye " + Name2 + " and " + Name1 + ".");
    }
}
