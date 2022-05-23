package JUnitTests;
import Utility.*;
import org.junit.Test;

public class MapTests {

    @Test
    public void matchesIDTest() {
        int[] ids = {
                MapObject.EMPTY.getID(),
                MapObject.TELEPORT_RIGHT.getID(),
                MapObject.TELEPORT_LEFT.getID(),
                MapObject.TELEPORT_TOP.getID(),
                MapObject.TELEPORT_BOTTOM.getID(),
                MapObject.EATGHOST.getID()
        };
        assert (Map.matchesID(MapObject.EMPTY.getID(), ids));
        assert (Map.matchesID(MapObject.TELEPORT_RIGHT.getID(), ids));
        assert (Map.matchesID(MapObject.TELEPORT_LEFT.getID(), ids));
        assert (Map.matchesID(MapObject.TELEPORT_TOP.getID(), ids));
        assert (Map.matchesID(MapObject.TELEPORT_BOTTOM.getID(), ids));
        assert (Map.matchesID(MapObject.EATGHOST.getID(), ids));
    }

    @Test
    public void isValidMoveTest() {
        Map map = new Map(new int[][] {
                {0, 1, 0, 0, 0}, 
                {0, 1, 0, 1, 0}
        });
        assert (map.isValidMove(new Position(0, 0)));
        assert (!map.isValidMove(new Position(0, 1)));
        assert (!map.isValidMove(new Position(1, 1)));
    }

}
