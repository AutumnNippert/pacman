import Controllers.Controller;
import Utility.Direction;
import Utility.Map;

public class Game {
    Map map;

    public void init(String file) {
        map = new Map(file);
        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            map.print();
            for (Controller c : map.getControllers()) {
                //get a valid direction
                //print out current controllers location
                System.out.println("Current location: " + c.getPosition());
                boolean isValidMove = false;
                while(!isValidMove){
                    System.out.println("Attempting a move");
                    Direction dir = c.getMove();
                    isValidMove = c.move(dir, map);
                }
            }
        }
    }
}
