package Utility;

import java.util.Random;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public static Direction getRandomDirection() {
        Debug.print("Getting random direction");
        int random = randInt(0, 3);
        switch (random) {
            case 0:
                return NORTH;
            case 1:
                return EAST;
            case 2:
                return SOUTH;
            case 3:
                return WEST;
            default:
                return NORTH;
        }
    }
    //generate rand num between min and max inclusive
    private static int randInt(int min, int max) {;
        return new Random().nextInt((max - min) + 1) + min;
    }
}