package Utility;

public class Debug {
    private static boolean debug = true;
    public static void print(String s) {
        if(debug) {
            System.out.println(s);
        }
    }
}
