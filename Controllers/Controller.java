package Controllers;
import Utility.*;

/*
 * Abstract Controller Class
 * @author Chris Nippert
 * @version 1.0
 */
public abstract class Controller {

    protected Position pos;
    protected int id;

    /**
     * Constructs the controller.
     *
     */
    public Controller(Utility.Position pos, int id) {
        this.pos = pos;
        this.id = id;
    }

    public abstract Direction getMove();

    /**
     * Moves the controller in the specified direction on the board.
     * @param dir
     */
    public boolean move(Direction dir, Map map) {
        Position dest = new Position(pos.getX(), pos.getY());
        Debug.print("Direction is: " + dir);
        switch (dir) {
            case NORTH:
                dest.setY(pos.getY() - 1);
                break;
            case EAST:
                dest.setX(pos.getX() + 1);
                break;
            case SOUTH:
                dest.setY(pos.getY() + 1);
                break;
            case WEST:
                dest.setX(pos.getX() - 1);
                break;
        }
        if(map.isValidMove(dest)) {
            map.set(pos.getX(), pos.getY(), 0);
            map.set(dest.getX(), dest.getY(), id);
            pos = dest;
            Debug.print("Moved " + dir);
            return true;
        }
        Debug.print("Invalid move");
        return false;
    }

    /**
     * Returns the position of the controller.
     * @return
     */
    public Position getPosition() {
        return pos;
    }

    /**
     * Returns the id of the controller.
     * @return
     */
    public int getID() {
        return id;
    }

    /**
     * Returns the character representation of the controller.
     * @return
     */
    public char getCharacter() {
        return MapObject.getCharacterByID(id);
    }
}