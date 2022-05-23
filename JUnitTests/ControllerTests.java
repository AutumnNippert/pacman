package JUnitTests;
import Controllers.*;
import Utility.*;
import org.junit.Test;

public class ControllerTests {
    @Test
    public void ajaxMoveTest() {
        Controller ajax = new Ghost(new Position(0, 0), MapObject.AJAX.getID());
        Direction dir = ajax.getMove();
        assert (dir != null);
    }
}
