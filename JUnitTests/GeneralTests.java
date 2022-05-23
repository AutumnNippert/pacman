package JUnitTests;
import Utility.*;
import org.junit.Test;

public class GeneralTests {
    @Test
    public void randomDirectionTest() {
        Direction random = Direction.getRandomDirection();
        switch (random) {
            case NORTH:
            case EAST:
            case SOUTH:
            case WEST:
                break;
            default:
                assert (false);
        }
    }
}
