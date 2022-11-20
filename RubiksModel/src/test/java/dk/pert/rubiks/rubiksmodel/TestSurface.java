package dk.pert.rubiks.rubiksmodel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

public class TestSurface {

    private HashMap<Direction, Surface> directionSurfaceHashMap;
    private HashMap<Color, Surface> colorSurfaceHashMap;

    @BeforeEach
    void beforeAll() {
        ArrayList<Direction> directions = new ArrayList<>(EnumSet.allOf(Direction.class));
        ArrayList<Color> colors = new ArrayList<>(EnumSet.allOf(Color.class));
        directionSurfaceHashMap = new HashMap<>();
        colorSurfaceHashMap = new HashMap<>();
        int directionNo = 0;
        int colorNo = 0;
        while (directionNo < directions.size() && colorNo < colors.size()) {
            Direction currentDirection = directions.get(directionNo);
            Color currentColor = colors.get(colorNo);
            Surface surface = new Surface(currentDirection, currentColor);
            directionSurfaceHashMap.put(currentDirection, surface);
            colorSurfaceHashMap.put(currentColor, surface);
            directionNo++;
            colorNo++;
        }
    }

    private void noMoveTest(Direction direction, Move move) {
        Surface testSurface = directionSurfaceHashMap.get(direction);
        Direction beforeTestDirection = testSurface.getDirection();
        Assertions.assertEquals(beforeTestDirection, direction);
        testSurface.move(move);
        Direction afterTestDirection = testSurface.getDirection();
        Assertions.assertEquals(afterTestDirection, direction);
    }

    private void moveTest(Direction beforeDirection, Direction afterDirection, Move move) {
        Surface testSurface = directionSurfaceHashMap.get(beforeDirection);
        Direction beforeTestDirection = testSurface.getDirection();
        Assertions.assertEquals(beforeTestDirection, beforeDirection);
        Assertions.assertNotEquals(beforeDirection, afterDirection);
        testSurface.move(move);
        Direction afterTestDirection = testSurface.getDirection();
        Assertions.assertEquals(afterTestDirection, afterDirection);
        Assertions.assertNotEquals(afterTestDirection, beforeDirection);
    }

    @Test
    void left() {
        Move leftMove = Move.left;
        noMoveTest(Direction.left, leftMove);
        noMoveTest(Direction.right, leftMove);
        moveTest(Direction.down, Direction.back, leftMove);
        moveTest(Direction.back, Direction.up, leftMove);
        moveTest(Direction.up, Direction.front, leftMove);
        moveTest(Direction.front, Direction.down, leftMove);
    }

    @Test
    void leftInverted() {
        Move leftInvertedMove = Move.leftInverted;
        noMoveTest(Direction.left, leftInvertedMove);
        noMoveTest(Direction.right, leftInvertedMove);
        moveTest(Direction.down, Direction.front, leftInvertedMove);
        moveTest(Direction.front, Direction.up, leftInvertedMove);
        moveTest(Direction.up, Direction.back, leftInvertedMove);
        moveTest(Direction.back, Direction.down, leftInvertedMove);
    }

    @Test
    void right() {
        Move rightMove = Move.right;
        noMoveTest(Direction.right, rightMove);
        noMoveTest(Direction.left, rightMove);
        moveTest(Direction.down, Direction.front, rightMove);
        moveTest(Direction.front, Direction.up, rightMove);
        moveTest(Direction.up, Direction.back, rightMove);
        moveTest(Direction.back, Direction.down, rightMove);
    }

    @Test
    void rightInverted() {
        Move rightInvertedMove = Move.rightInverted;
        noMoveTest(Direction.right, rightInvertedMove);
        noMoveTest(Direction.left, rightInvertedMove);
        moveTest(Direction.down, Direction.back, rightInvertedMove);
        moveTest(Direction.back, Direction.up, rightInvertedMove);
        moveTest(Direction.up, Direction.front, rightInvertedMove);
        moveTest(Direction.front, Direction.down, rightInvertedMove);
    }

    @Test
    void front() {
        Move frontMove = Move.front;
        noMoveTest(Direction.front, frontMove);
        noMoveTest(Direction.back, frontMove);
        moveTest(Direction.down, Direction.left, frontMove);
        moveTest(Direction.left, Direction.up, frontMove);
        moveTest(Direction.up, Direction.right, frontMove);
        moveTest(Direction.right, Direction.down, frontMove);
    }

    @Test
    void frontInverted() {
        Move frontInvertedMove = Move.frontInverted;
        noMoveTest(Direction.back, frontInvertedMove);
        noMoveTest(Direction.front, frontInvertedMove);
        moveTest(Direction.down, Direction.right, frontInvertedMove);
        moveTest(Direction.right, Direction.up, frontInvertedMove);
        moveTest(Direction.up, Direction.left, frontInvertedMove);
        moveTest(Direction.left, Direction.down, frontInvertedMove);
    }

    @Test
    void back() {
        Move backMove = Move.back;
        noMoveTest(Direction.back, backMove);
        noMoveTest(Direction.front, backMove);
        moveTest(Direction.down, Direction.right, backMove);
        moveTest(Direction.right, Direction.up, backMove);
        moveTest(Direction.up, Direction.left, backMove);
        moveTest(Direction.left, Direction.down, backMove);
    }

    @Test
    void backInverted() {
        Move backInvertedMove = Move.backInverted;
        noMoveTest(Direction.back, backInvertedMove);
        noMoveTest(Direction.front, backInvertedMove);
        moveTest(Direction.down, Direction.left, backInvertedMove);
        moveTest(Direction.left, Direction.up, backInvertedMove);
        moveTest(Direction.up, Direction.right, backInvertedMove);
        moveTest(Direction.right, Direction.down, backInvertedMove);
    }


    @Test
    void up() {
        Move upMove = Move.up;
        noMoveTest(Direction.up, upMove);
        noMoveTest(Direction.down, upMove);
        moveTest(Direction.left, Direction.back, upMove);
        moveTest(Direction.back, Direction.right, upMove);
        moveTest(Direction.right, Direction.front, upMove);
        moveTest(Direction.front, Direction.left, upMove);
    }

    @Test
    void upInverted() {
        Move upInvertedMove = Move.upInverted;
        noMoveTest(Direction.up, upInvertedMove);
        noMoveTest(Direction.down, upInvertedMove);
        moveTest(Direction.left, Direction.front, upInvertedMove);
        moveTest(Direction.front, Direction.right, upInvertedMove);
        moveTest(Direction.right, Direction.back, upInvertedMove);
        moveTest(Direction.back, Direction.left, upInvertedMove);
    }

    @Test
    void down() {
        Move downMove = Move.down;
        noMoveTest(Direction.down, downMove);
        noMoveTest(Direction.up, downMove);
        moveTest(Direction.left, Direction.front, downMove);
        moveTest(Direction.front, Direction.right, downMove);
        moveTest(Direction.right, Direction.back, downMove);
        moveTest(Direction.back, Direction.left, downMove);
    }

    @Test
    void downInverted() {
        Move downInvertedMove = Move.downInverted;
        noMoveTest(Direction.up, downInvertedMove);
        noMoveTest(Direction.down, downInvertedMove);
        moveTest(Direction.left, Direction.back, downInvertedMove);
        moveTest(Direction.back, Direction.right, downInvertedMove);
        moveTest(Direction.right, Direction.front, downInvertedMove);
        moveTest(Direction.front, Direction.left, downInvertedMove);
    }

    @Test
    void colors() {
        Surface testSurface = colorSurfaceHashMap.get(Color.left);
        Color beforeTestColor = testSurface.getColor();
        Assertions.assertEquals(beforeTestColor, Color.left);
        testSurface.setColor(Color.right);
        Color afterTestColor = testSurface.getColor();
        Assertions.assertEquals(afterTestColor, Color.right);
    }

}
