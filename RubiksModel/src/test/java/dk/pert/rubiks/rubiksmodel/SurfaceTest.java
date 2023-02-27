package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.enums.Color;
import dk.pert.rubiks.rubiksmodel.enums.Direction;
import dk.pert.rubiks.rubiksmodel.enums.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SurfaceTest {

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
        assertNotNull(directions);
        ArrayList<Color> colors = generateListOfAllColors();
        assertNotNull(colors);
        generateSurfaceHashMaps(directions, colors);
        assertNotNull(directionSurfaceHashMap);
        assertNotNull(colorSurfaceHashMap);
    }


    private void testSurfaceDidNotChangeDirection(Direction direction, Move move) {
        Surface testSurface = directionSurfaceHashMap.get(direction);
        Direction beforeTestDirection = testSurface.getDirection();
        assertEquals(beforeTestDirection, direction);
        testSurface.move(move);
        Direction afterTestDirection = testSurface.getDirection();
        assertEquals(afterTestDirection, direction);
    }

    private void testSurfaceDidChangeDirection(Direction beforeDirection, Direction afterDirection, Move move) {
        Surface testSurface = directionSurfaceHashMap.get(beforeDirection);
        Direction beforeTestDirection = testSurface.getDirection();
        assertEquals(beforeTestDirection, beforeDirection);
        Assertions.assertNotEquals(beforeDirection, afterDirection);
        testSurface.move(move);
        Direction afterTestDirection = testSurface.getDirection();
        assertEquals(afterTestDirection, afterDirection);
        Assertions.assertNotEquals(afterTestDirection, beforeDirection);
    }

    @Test
    void left() {
        Move leftMove = Move.LEFT;
        testSurfaceDidNotChangeDirection(Direction.LEFT, leftMove);
        testSurfaceDidNotChangeDirection(Direction.RIGHT, leftMove);
        testSurfaceDidChangeDirection(Direction.DOWN, Direction.BACK, leftMove);
        testSurfaceDidChangeDirection(Direction.BACK, Direction.UP, leftMove);
        testSurfaceDidChangeDirection(Direction.UP, Direction.FRONT, leftMove);
        testSurfaceDidChangeDirection(Direction.FRONT, Direction.DOWN, leftMove);
    }

    @Test
    void leftInverted() {
        Move leftInvertedMove = Move.LEFT_INVERTED;
        testSurfaceDidNotChangeDirection(Direction.LEFT, leftInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.RIGHT, leftInvertedMove);
        testSurfaceDidChangeDirection(Direction.DOWN, Direction.FRONT, leftInvertedMove);
        testSurfaceDidChangeDirection(Direction.FRONT, Direction.UP, leftInvertedMove);
        testSurfaceDidChangeDirection(Direction.UP, Direction.BACK, leftInvertedMove);
        testSurfaceDidChangeDirection(Direction.BACK, Direction.DOWN, leftInvertedMove);
    }

    @Test
    void right() {
        Move rightMove = Move.RIGHT;
        testSurfaceDidNotChangeDirection(Direction.RIGHT, rightMove);
        testSurfaceDidNotChangeDirection(Direction.LEFT, rightMove);
        testSurfaceDidChangeDirection(Direction.DOWN, Direction.FRONT, rightMove);
        testSurfaceDidChangeDirection(Direction.FRONT, Direction.UP, rightMove);
        testSurfaceDidChangeDirection(Direction.UP, Direction.BACK, rightMove);
        testSurfaceDidChangeDirection(Direction.BACK, Direction.DOWN, rightMove);
    }

    @Test
    void rightInverted() {
        Move rightInvertedMove = Move.RIGHT_INVERTED;
        testSurfaceDidNotChangeDirection(Direction.RIGHT, rightInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.LEFT, rightInvertedMove);
        testSurfaceDidChangeDirection(Direction.DOWN, Direction.BACK, rightInvertedMove);
        testSurfaceDidChangeDirection(Direction.BACK, Direction.UP, rightInvertedMove);
        testSurfaceDidChangeDirection(Direction.UP, Direction.FRONT, rightInvertedMove);
        testSurfaceDidChangeDirection(Direction.FRONT, Direction.DOWN, rightInvertedMove);
    }

    @Test
    void front() {
        Move frontMove = Move.FRONT;
        testSurfaceDidNotChangeDirection(Direction.FRONT, frontMove);
        testSurfaceDidNotChangeDirection(Direction.BACK, frontMove);
        testSurfaceDidChangeDirection(Direction.DOWN, Direction.LEFT, frontMove);
        testSurfaceDidChangeDirection(Direction.LEFT, Direction.UP, frontMove);
        testSurfaceDidChangeDirection(Direction.UP, Direction.RIGHT, frontMove);
        testSurfaceDidChangeDirection(Direction.RIGHT, Direction.DOWN, frontMove);
    }

    @Test
    void frontInverted() {
        Move frontInvertedMove = Move.FRONT_INVERTED;
        testSurfaceDidNotChangeDirection(Direction.BACK, frontInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.FRONT, frontInvertedMove);
        testSurfaceDidChangeDirection(Direction.DOWN, Direction.RIGHT, frontInvertedMove);
        testSurfaceDidChangeDirection(Direction.RIGHT, Direction.UP, frontInvertedMove);
        testSurfaceDidChangeDirection(Direction.UP, Direction.LEFT, frontInvertedMove);
        testSurfaceDidChangeDirection(Direction.LEFT, Direction.DOWN, frontInvertedMove);
    }

    @Test
    void back() {
        Move backMove = Move.BACK;
        testSurfaceDidNotChangeDirection(Direction.BACK, backMove);
        testSurfaceDidNotChangeDirection(Direction.FRONT, backMove);
        testSurfaceDidChangeDirection(Direction.DOWN, Direction.RIGHT, backMove);
        testSurfaceDidChangeDirection(Direction.RIGHT, Direction.UP, backMove);
        testSurfaceDidChangeDirection(Direction.UP, Direction.LEFT, backMove);
        testSurfaceDidChangeDirection(Direction.LEFT, Direction.DOWN, backMove);
    }

    @Test
    void backInverted() {
        Move backInvertedMove = Move.BACK_INVERTED;
        testSurfaceDidNotChangeDirection(Direction.BACK, backInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.FRONT, backInvertedMove);
        testSurfaceDidChangeDirection(Direction.DOWN, Direction.LEFT, backInvertedMove);
        testSurfaceDidChangeDirection(Direction.LEFT, Direction.UP, backInvertedMove);
        testSurfaceDidChangeDirection(Direction.UP, Direction.RIGHT, backInvertedMove);
        testSurfaceDidChangeDirection(Direction.RIGHT, Direction.DOWN, backInvertedMove);
    }


    @Test
    void up() {
        Move upMove = Move.UP;
        testSurfaceDidNotChangeDirection(Direction.UP, upMove);
        testSurfaceDidNotChangeDirection(Direction.DOWN, upMove);
        testSurfaceDidChangeDirection(Direction.LEFT, Direction.BACK, upMove);
        testSurfaceDidChangeDirection(Direction.BACK, Direction.RIGHT, upMove);
        testSurfaceDidChangeDirection(Direction.RIGHT, Direction.FRONT, upMove);
        testSurfaceDidChangeDirection(Direction.FRONT, Direction.LEFT, upMove);
    }

    @Test
    void upInverted() {
        Move upInvertedMove = Move.UP_INVERTED;
        testSurfaceDidNotChangeDirection(Direction.UP, upInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.DOWN, upInvertedMove);
        testSurfaceDidChangeDirection(Direction.LEFT, Direction.FRONT, upInvertedMove);
        testSurfaceDidChangeDirection(Direction.FRONT, Direction.RIGHT, upInvertedMove);
        testSurfaceDidChangeDirection(Direction.RIGHT, Direction.BACK, upInvertedMove);
        testSurfaceDidChangeDirection(Direction.BACK, Direction.LEFT, upInvertedMove);
    }

    @Test
    void down() {
        Move downMove = Move.DOWN;
        testSurfaceDidNotChangeDirection(Direction.DOWN, downMove);
        testSurfaceDidNotChangeDirection(Direction.UP, downMove);
        testSurfaceDidChangeDirection(Direction.LEFT, Direction.FRONT, downMove);
        testSurfaceDidChangeDirection(Direction.FRONT, Direction.RIGHT, downMove);
        testSurfaceDidChangeDirection(Direction.RIGHT, Direction.BACK, downMove);
        testSurfaceDidChangeDirection(Direction.BACK, Direction.LEFT, downMove);
    }

    @Test
    void downInverted() {
        Move downInvertedMove = Move.DOWN_INVERTED;
        testSurfaceDidNotChangeDirection(Direction.UP, downInvertedMove);
        testSurfaceDidNotChangeDirection(Direction.DOWN, downInvertedMove);
        testSurfaceDidChangeDirection(Direction.LEFT, Direction.BACK, downInvertedMove);
        testSurfaceDidChangeDirection(Direction.BACK, Direction.RIGHT, downInvertedMove);
        testSurfaceDidChangeDirection(Direction.RIGHT, Direction.FRONT, downInvertedMove);
        testSurfaceDidChangeDirection(Direction.FRONT, Direction.LEFT, downInvertedMove);
    }


    @Test
    void colors() {
        Surface testSurface = colorSurfaceHashMap.get(Color.ORANGE);
        Color beforeTestColor = testSurface.getColor();
        assertEquals(beforeTestColor, Color.ORANGE);
        testSurface.setColor(Color.RED);
        Color afterTestColor = testSurface.getColor();
        assertEquals(afterTestColor, Color.RED);
    }

}
