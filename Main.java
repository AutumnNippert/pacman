import java.io.IOException;

/**
 * Main Class
 * 
 * @author Chris Nippert
 * @version 1.0
 */
public class Main {
    /**
     * Main Method
     * 
     * @param args
     */
    public static void main(String[] args) {
        // try {
        //     poc();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        Game game = new Game();
        game.init("Maps/map1.txt");
    }

    // Doesn't work for some reason
    // sadge
    public static void poc() throws IOException {
        char c = 0;
        System.out.println("Started");
        Process p = Runtime.getRuntime().exec("IntegratedCode/BufferlessKeyPress");
        try {
            p.waitFor();
            c = (char)p.exitValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c);

    }
}