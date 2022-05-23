package Utility;

/**
 * @author Chris Nippert
 * @version 1.0
 */

public enum MapObject {
    EMPTY(0, ' '),
    PACMAN_RIGHT(1, '<'), PACMAN_LEFT(2, '>'),
    PACMAN_UP(3, 'v'), PACMAN_DOWN(4, '^'),

    AJAX(5, '0'), JAKE(6, 'D'),
    FINN(7, 'Q'), ELLIE(8, '8'),

    TELEPORT_RIGHT(9, ']'), TELEPORT_LEFT(10, '['),
    TELEPORT_TOP(11, '^'), TELEPORT_BOTTOM(12, 'v'),
    EATGHOST(13, '@'),

    WALL_VERTICAL(14, '|'), WALL_HORIZONTAL(15, '─'),
    WALL_TOP_LEFT(16, '┌'), WALL_TOP_RIGHT(17, '┐'),
    WALL_BOTTOM_LEFT(18, '└'), WALL_BOTTOM_RIGHT(19, '┘'),
    WALL_T_LEFT(20, '├'), WALL_T_RIGHT(21, '┤'),
    WALL_B_LEFT(22, '┬'), WALL_B_RIGHT(23, '┴'),
    WALL_CROSS(24, '┼');

    int id;
    char character;

    MapObject(int id, char character) {
        this.id = id;
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public int getID() {
        return id;
    }

    public static char getCharacterByID(int id) {
        for (MapObject mapObject : MapObject.values()) {
            if (mapObject.getID() == id) {
                return mapObject.getCharacter();
            }
        }
        return '!';
    }

    public static MapObject getMapObjectByID(int id) {
        for (MapObject mapObject : MapObject.values()) {
            if (mapObject.getID() == id) {
                return mapObject;
            }
        }
        return null;
    }
}
