package Controllers;
import Utility.*;
import java.util.Scanner;
public class PacMan extends Controller{
    public PacMan(Position pos , int id) {
        super(pos, id);
    }

    public Direction getMove() {
        //display a menu for the user to choose a direction
        System.out.println("Choose a direction:");
        System.out.println("1. North");
        System.out.println("2. East");
        System.out.println("3. South");
        System.out.println("4. West");
    
        //get the user's input
        //int input = new KeyDetector().init();

        //get the user input
        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();
        scn.nextLine();


        //return the corresponding direction
        switch (input) {
            case 1:
                return Direction.NORTH;
            case 2:
                return Direction.EAST;
            case 3:
                return Direction.SOUTH;
            case 4:
                return Direction.WEST;
            default:
                return null;
        }
    }
}