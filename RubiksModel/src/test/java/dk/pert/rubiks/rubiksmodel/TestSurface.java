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

    private ArrayList<Direction> generateListOfAllDirections() {
        return new ArrayList<>(EnumSet.allOf(Direction.class));
    }

    private ArrayList<Color> generateListOfAllColors() {
        return new ArrayList<>(EnumSet.allOf(Color.class));
    }

    private void generateSurfaceHashMaps(ArrayList<Direction> directions, ArrayList<Color> colors) {
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

    @BeforeEach
    void beforeAll() {
        ArrayList<Direction> directions = generateListOfAllDirections();
        ArrayList<Color> colors = generateListOfAllColors();
        generateSurfaceHashMaps(directions, colors);
    }


    private void testSurfaceDidNotChangeDirection(Direction direction, Move move) {
        Surface testSurface = directionSurfaceHashMap.get(direction);
        Direction beforeTestDirection = testSurface.getDirection();
        Assertions.assertEquals(beforeTestDirection, direction);
        testSurface.move(move);
        Direction afterTestDirection = testSurface.getDirection();
        Assertions.assertEquals(afterTestDirection, direction);
    }

    private void testSurfaceDidChangeDirection(Direction beforeDirection, Direction afterDirection, Move move) {
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
        testSurfaceDidNotChangeDirection(Direction.left, leftMove);
        testSurfaceDidNotChangeDirection(Direction.right, leftMove);
        testSurfaceDidChangeDirection(Direction.down, Direction.back, leftMove);
        testSurfaceDidChangeDirection(Direction.back, Direction.up, leftMove);
        testSurfaceDidChangeDirection(Direction.up, Direction.front, leftMove);
        testSurfaceDidChangeDirection(Direction.front, Direction.down, leftMove);
    }

    @Test
    void leftInverted() {
        Move leftInvertedMove = Move.leftInverted;
        testSurfaceDidNotChangeDirection(Direction.left, leftInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.right, leftInvertedMove);
        testSurfaceDidChangeDirection(Direction.down, Direction.front, leftInvertedMove);
        testSurfaceDidChangeDirection(Direction.front, Direction.up, leftInvertedMove);
        testSurfaceDidChangeDirection(Direction.up, Direction.back, leftInvertedMove);
        testSurfaceDidChangeDirection(Direction.back, Direction.down, leftInvertedMove);
    }

    @Test
    void right() {
        Move rightMove = Move.right;
        testSurfaceDidNotChangeDirection(Direction.right, rightMove);
        testSurfaceDidNotChangeDirection(Direction.left, rightMove);
        testSurfaceDidChangeDirection(Direction.down, Direction.front, rightMove);
        testSurfaceDidChangeDirection(Direction.front, Direction.up, rightMove);
        testSurfaceDidChangeDirection(Direction.up, Direction.back, rightMove);
        testSurfaceDidChangeDirection(Direction.back, Direction.down, rightMove);
    }

    @Test
    void rightInverted() {
        Move rightInvertedMove = Move.rightInverted;
        testSurfaceDidNotChangeDirection(Direction.right, rightInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.left, rightInvertedMove);
        testSurfaceDidChangeDirection(Direction.down, Direction.back, rightInvertedMove);
        testSurfaceDidChangeDirection(Direction.back, Direction.up, rightInvertedMove);
        testSurfaceDidChangeDirection(Direction.up, Direction.front, rightInvertedMove);
        testSurfaceDidChangeDirection(Direction.front, Direction.down, rightInvertedMove);
    }

    @Test
    void front() {
        Move frontMove = Move.front;
        testSurfaceDidNotChangeDirection(Direction.front, frontMove);
        testSurfaceDidNotChangeDirection(Direction.back, frontMove);
        testSurfaceDidChangeDirection(Direction.down, Direction.left, frontMove);
        testSurfaceDidChangeDirection(Direction.left, Direction.up, frontMove);
        testSurfaceDidChangeDirection(Direction.up, Direction.right, frontMove);
        testSurfaceDidChangeDirection(Direction.right, Direction.down, frontMove);
    }

    @Test
    void frontInverted() {
        Move frontInvertedMove = Move.frontInverted;
        testSurfaceDidNotChangeDirection(Direction.back, frontInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.front, frontInvertedMove);
        testSurfaceDidChangeDirection(Direction.down, Direction.right, frontInvertedMove);
        testSurfaceDidChangeDirection(Direction.right, Direction.up, frontInvertedMove);
        testSurfaceDidChangeDirection(Direction.up, Direction.left, frontInvertedMove);
        testSurfaceDidChangeDirection(Direction.left, Direction.down, frontInvertedMove);
    }

    @Test
    void back() {
        Move backMove = Move.back;
        testSurfaceDidNotChangeDirection(Direction.back, backMove);
        testSurfaceDidNotChangeDirection(Direction.front, backMove);
        testSurfaceDidChangeDirection(Direction.down, Direction.right, backMove);
        testSurfaceDidChangeDirection(Direction.right, Direction.up, backMove);
        testSurfaceDidChangeDirection(Direction.up, Direction.left, backMove);
        testSurfaceDidChangeDirection(Direction.left, Direction.down, backMove);
    }

    @Test
    void backInverted() {
        Move backInvertedMove = Move.backInverted;
        testSurfaceDidNotChangeDirection(Direction.back, backInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.front, backInvertedMove);
        testSurfaceDidChangeDirection(Direction.down, Direction.left, backInvertedMove);
        testSurfaceDidChangeDirection(Direction.left, Direction.up, backInvertedMove);
        testSurfaceDidChangeDirection(Direction.up, Direction.right, backInvertedMove);
        testSurfaceDidChangeDirection(Direction.right, Direction.down, backInvertedMove);
    }


    @Test
    void up() {
        Move upMove = Move.up;
        testSurfaceDidNotChangeDirection(Direction.up, upMove);
        testSurfaceDidNotChangeDirection(Direction.down, upMove);
        testSurfaceDidChangeDirection(Direction.left, Direction.back, upMove);
        testSurfaceDidChangeDirection(Direction.back, Direction.right, upMove);
        testSurfaceDidChangeDirection(Direction.right, Direction.front, upMove);
        testSurfaceDidChangeDirection(Direction.front, Direction.left, upMove);
    }

    @Test
    void upInverted() {
        Move upInvertedMove = Move.upInverted;
        testSurfaceDidNotChangeDirection(Direction.up, upInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.down, upInvertedMove);
        testSurfaceDidChangeDirection(Direction.left, Direction.front, upInvertedMove);
        testSurfaceDidChangeDirection(Direction.front, Direction.right, upInvertedMove);
        testSurfaceDidChangeDirection(Direction.right, Direction.back, upInvertedMove);
        testSurfaceDidChangeDirection(Direction.back, Direction.left, upInvertedMove);
    }

    @Test
    void down() {
        Move downMove = Move.down;
        testSurfaceDidNotChangeDirection(Direction.down, downMove);
        testSurfaceDidNotChangeDirection(Direction.up, downMove);
        testSurfaceDidChangeDirection(Direction.left, Direction.front, downMove);
        testSurfaceDidChangeDirection(Direction.front, Direction.right, downMove);
        testSurfaceDidChangeDirection(Direction.right, Direction.back, downMove);
        testSurfaceDidChangeDirection(Direction.back, Direction.left, downMove);
    }

    @Test
    void downInverted() {
        Move downInvertedMove = Move.downInverted;
        testSurfaceDidNotChangeDirection(Direction.up, downInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.down, downInvertedMove);
        testSurfaceDidChangeDirection(Direction.left, Direction.back, downInvertedMove);
        testSurfaceDidChangeDirection(Direction.back, Direction.right, downInvertedMove);
        testSurfaceDidChangeDirection(Direction.right, Direction.front, downInvertedMove);
        testSurfaceDidChangeDirection(Direction.front, Direction.left, downInvertedMove);
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
