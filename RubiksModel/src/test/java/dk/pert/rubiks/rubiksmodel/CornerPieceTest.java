package dk.pert.rubiks.rubiksmodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CornerPieceTest {

    private static final CornerPiece topLeftFront = new CornerPiece(Direction.up, Color.top, Direction.left, Color.left, Direction.front, Color.front);
    private static final CornerPiece bottomLeftFront = new CornerPiece(Direction.down, Color.bottom, Direction.left, Color.left, Direction.front, Color.front);
    private static final CornerPiece topRightFront = new CornerPiece(Direction.up, Color.top, Direction.right, Color.right, Direction.front, Color.front);
    private static final CornerPiece bottomRightFront = new CornerPiece(Direction.down, Color.bottom, Direction.right, Color.right, Direction.front, Color.front);
    private static final CornerPiece topLeftBack = new CornerPiece(Direction.up, Color.top, Direction.left, Color.left, Direction.back, Color.back);
    private static final CornerPiece bottomLeftBack = new CornerPiece(Direction.down, Color.bottom, Direction.left, Color.left, Direction.back, Color.back);
    private static final CornerPiece topRightBack = new CornerPiece(Direction.up, Color.top, Direction.right, Color.right, Direction.back, Color.back);
    private static final CornerPiece bottomRightBack = new CornerPiece(Direction.down, Color.bottom, Direction.right, Color.right, Direction.back, Color.back);

    ArrayList<Direction> directions;
    ArrayList<Color> colors;


    private CornerPiece testPiece;
    private ArrayList<Color> testColors = new ArrayList<>(3);
    private ArrayList<Direction> beforeDirections = new ArrayList<>(3);
    private ArrayList<Color> afterColors = new ArrayList<>(3);
    private ArrayList<Direction> afterDirections = new ArrayList<>(3);

    @BeforeEach
    void beforeEach() {
        directions = new ArrayList<>(EnumSet.allOf(Direction.class));
        colors = new ArrayList<>(EnumSet.allOf(Color.class));
    }

    private void testColor(Color color, Direction direction) {
        Color beforeColor = testPiece.getSurface(direction);
        assertEquals(beforeColor, color);
    }

    private void testColors(ArrayList<Color> colors, ArrayList<Direction> directions) {
        testColor(colors.get(0), directions.get(0));
        testColor(colors.get(1), directions.get(1));
        testColor(colors.get(2), directions.get(2));
    }

    private void testNoColor(Direction direction) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testPiece.getSurface(direction));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, exception.getMessage());
    }

    private void testNoColors(ArrayList<Direction> noColorDirections) {
        ArrayList<Direction> noDirections = (ArrayList<Direction>) directions.clone();
        noDirections.removeAll(noColorDirections);
        for (Direction noDirection : noDirections) {
            testNoColor(noDirection);
        }
    }

    private void testTurn(Turn turn, Axis axis) {
        testColors(testColors, beforeDirections);
        testNoColors(beforeDirections);

        testPiece.turn(turn, axis);

        testColors(testColors, afterDirections);
        testNoColors(afterDirections);
    }

    private void swapDirections() {
        ArrayList<Direction> directionsBuffer = beforeDirections;
        beforeDirections = afterDirections;
        afterDirections = directionsBuffer;
    }

    @Test
    void testTurnTopLeftFrontAroundXAxis() {
        testPiece = topLeftFront;
        testColors = new ArrayList<>(Arrays.asList(Color.top, Color.left, Color.front));

        beforeDirections = new ArrayList<>(Arrays.asList(Direction.up, Direction.left, Direction.front));
        afterDirections = new ArrayList<>(Arrays.asList(Direction.front, Direction.left, Direction.down));

        testTurn(Turn.clockWise, Axis.xAxis);
        swapDirections();
        testTurn(Turn.counterClockWise, Axis.xAxis);
    }

    @Test
    void testTurnBottomLeftFrontAroundXAxis() {
        testPiece = bottomLeftFront;
        testColors = new ArrayList<>(Arrays.asList(Color.bottom, Color.left, Color.front));

        beforeDirections = new ArrayList<>(Arrays.asList(Direction.down, Direction.left, Direction.front));
        afterDirections = new ArrayList<>(Arrays.asList(Direction.back, Direction.left, Direction.down));

        testTurn(Turn.clockWise, Axis.xAxis);
        swapDirections();
        testTurn(Turn.counterClockWise, Axis.xAxis);
    }

    @Test
    void testTurnTopRightFrontAroundXAxis() {
        testPiece = topRightFront;
        testColors = new ArrayList<>(Arrays.asList(Color.top, Color.right, Color.front));

        beforeDirections = new ArrayList<>(Arrays.asList(Direction.up, Direction.right, Direction.front));
        afterDirections = new ArrayList<>(Arrays.asList(Direction.back, Direction.right, Direction.up));

        testTurn(Turn.clockWise, Axis.xAxis);
        swapDirections();
        testTurn(Turn.counterClockWise, Axis.xAxis);
    }

    @Test
    void testTurnBottomRightFrontAroundXAxis() {
        testPiece = bottomRightFront;
        testColors = new ArrayList<>(Arrays.asList(Color.bottom, Color.right, Color.front));

        beforeDirections = new ArrayList<>(Arrays.asList(Direction.down, Direction.right, Direction.front));
        afterDirections = new ArrayList<>(Arrays.asList(Direction.front, Direction.right, Direction.up));

        testTurn(Turn.clockWise, Axis.xAxis);
        swapDirections();
        testTurn(Turn.counterClockWise, Axis.xAxis);
    }

    @Test
    void testTurnTopLeftBackAroundXAxis() {
        testPiece = topLeftBack;
        testColors = new ArrayList<>(Arrays.asList(Color.top, Color.left, Color.back));

        beforeDirections = new ArrayList<>(Arrays.asList(Direction.up, Direction.left, Direction.back));
        afterDirections = new ArrayList<>(Arrays.asList(Direction.front, Direction.left, Direction.up));

        testTurn(Turn.clockWise, Axis.xAxis);
        swapDirections();
        testTurn(Turn.counterClockWise, Axis.xAxis);
    }

    @Test
    void moveLeft() {
    }

    @Test
    void moveLeftInverted() {
    }

    @Test
    void moveRight() {
    }

    @Test
    void moveRightInverted() {
    }

    @Test
    void moveUp() {
    }

    @Test
    void moveUpInverted() {
    }

    @Test
    void moveDown() {
    }

    @Test
    void moveDownInverted() {
    }

    @Test
    void moveFront() {
    }

    @Test
    void moveFrontInverted() {
    }

    @Test
    void moveBack() {
    }

    @Test
    void moveBackInverted() {
    }
}