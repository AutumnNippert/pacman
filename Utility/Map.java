package Utility;
import java.util.Scanner;

import Controllers.Controller;
import Controllers.Ghost;
import Controllers.PacMan;

import java.io.FileNotFoundException;
import Utility.*;

/**
 * Map Class
 * 
 * @author Chris Nippert
 * @version 1.0
 */
public class Map {
    private int width;
    private int height;
    private final int[][] map;
    private Controller[] controllers;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        map = new int[width][height];
    }

    public Map(int[][] map) {
        this.map = map;
        this.width = map.length;
        this.height = map[0].length;
    }

    public Map(String file) {
        map = loadMap(file);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int get(int x, int y) {
        return map[x][y];
    }

    public void set(int x, int y, int value) {
        map[x][y] = value;
    }

    public void set(Position position, int value) {
        map[position.getX()][position.getY()] = value;
    }

    public void print() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // print the corresponding id character of the map object
                System.out.print(MapObject.values()[map[x][y]].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    public int[][] loadMap(String file) {
        // scan first 2 numbers in the file for the map width and height
        Scanner sc = null;
        try {
            sc = new Scanner(new java.io.File(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        width = sc.nextInt();
        height = sc.nextInt();
        controllers = new Controller[sc.nextInt()];

        int[][] map = new int[width][height];

        // scan the rest of the file for the map
        int ghostCount = 1; // ghost count starts at 1 because 0 is pacman
        while (sc.hasNext()) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    map[x][y] = sc.nextInt();
                    // check if they are controllers
                    if(map[x][y] == MapObject.PACMAN_DOWN.getID() || map[x][y] == MapObject.PACMAN_UP.getID() || map[x][y] == MapObject.PACMAN_LEFT.getID() || map[x][y] == MapObject.PACMAN_RIGHT.getID()) {
                        controllers[0] = new PacMan(new Position(x, y), map[x][y]);
                    }
                    if(map[x][y] == MapObject.ELLIE.getID() || map[x][y] == MapObject.AJAX.getID() || map[x][y] == MapObject.FINN.getID() || map[x][y] == MapObject.JAKE.getID()) {
                        controllers[ghostCount] = new Ghost(new Position(x, y), map[x][y]);
                        ghostCount++;
                    }
                }
            }
        }
        return map;
    }

    public static boolean matchesID(int x, int[] ids) {
        for (int id : ids) {
            if (x == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidMove(Position endPos) {
        // if the end position is not MapObject.EMPTY or MapObject.TELEPORT, return
        // false
        return (matchesID(map[endPos.getX()][endPos.getY()], new int[] {
                MapObject.EMPTY.getID(),
                MapObject.TELEPORT_RIGHT.getID(),
                MapObject.TELEPORT_LEFT.getID(),
                MapObject.TELEPORT_TOP.getID(),
                MapObject.TELEPORT_BOTTOM.getID(),
                MapObject.EATGHOST.getID()
        }));
    }

    public Controller[] getControllers() {
        return controllers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                sb.append(map[x][y] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}