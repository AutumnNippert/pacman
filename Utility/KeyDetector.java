package Utility;

import java.io.Reader;
import java.io.InputStreamReader;

public class KeyDetector{

    protected int i = -1;

    public int init() {
        try{
            while(true) {
                Reader r = new InputStreamReader(System.in);
                i = r.read();
                System.out.println("READING");
                if(i == -1) {
                    continue;
                }
                if(i != -1) {
                    return i;
                }
            }
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
        return -1;
    }
}
