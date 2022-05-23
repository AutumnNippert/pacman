package Controllers;
import Utility.*;
public class Ghost extends Controller{
    private MapObject type;
    public Ghost(Position pos, int id) {
        super(pos, id);
        type = MapObject.getMapObjectByID(id);
        Debug.print("Init ghost of type " + type.toString());
    }

    public Direction getMove() {
        if(type == MapObject.AJAX) {
            //Select a random Direction
            return Direction.getRandomDirection();
        }
        return null;
    }
}
