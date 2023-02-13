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


        IllegalArgumentException downExceptionBefore = assertThrows(IllegalArgumentException.class, () -> topRightFront.getSurface(Direction.down));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, downExceptionBefore.getMessage());
        IllegalArgumentException leftExceptionBefore = assertThrows(IllegalArgumentException.class, () -> topRightFront.getSurface(Direction.left));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, leftExceptionBefore.getMessage());
        IllegalArgumentException backExceptionBefore = assertThrows(IllegalArgumentException.class, () -> topRightFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionBefore.getMessage());

        /*
            topRightFront --> frontRightDown
         */
        topRightFront.turnClockwiseAroundXAxis();

        Color frontColorBetween = topRightFront.getSurface(Direction.front);
        assertEquals(Color.top, frontColorBetween);
        Color rightColorBetween = topRightFront.getSurface(Direction.right);
        assertEquals(Color.right, rightColorBetween);
        Color bottomColorBetween = topRightFront.getSurface(Direction.down);
        assertEquals(Color.front, bottomColorBetween);

        IllegalArgumentException backExceptionBetween = assertThrows(IllegalArgumentException.class, () -> topRightFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionBetween.getMessage());
        IllegalArgumentException leftExceptionBetween = assertThrows(IllegalArgumentException.class, () -> topRightFront.getSurface(Direction.left));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, leftExceptionBetween.getMessage());
        IllegalArgumentException upExceptionBetween = assertThrows(IllegalArgumentException.class, () -> topRightFront.getSurface(Direction.up));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, upExceptionBetween.getMessage());

        /*
            frontRightDown --> topRightFront
         */
        topRightFront.turnCounterclockwiseAroundXAxis();

        Color topColorAfter = topRightFront.getSurface(Direction.up);
        assertEquals(Color.top, topColorAfter);
        Color rightColorAfter = topRightFront.getSurface(Direction.right);
        assertEquals(Color.right, rightColorAfter);
        Color frontColorAfter = topRightFront.getSurface(Direction.front);
        assertEquals(Color.front, frontColorAfter);

        IllegalArgumentException downExceptionAfter = assertThrows(IllegalArgumentException.class, () -> topRightFront.getSurface(Direction.down));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, downExceptionAfter.getMessage());
        IllegalArgumentException leftExceptionAfter = assertThrows(IllegalArgumentException.class, () -> topRightFront.getSurface(Direction.left));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, leftExceptionAfter.getMessage());
        IllegalArgumentException backExceptionAfter = assertThrows(IllegalArgumentException.class, () -> topRightFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionAfter.getMessage());

    }

    @Test
    void testTurnBottomRightFrontAroundXAxis() {
        Color bottomColorBefore = bottomRightFront.getSurface(Direction.down);
        assertEquals(Color.bottom, bottomColorBefore);
        Color rightColorBefore = bottomRightFront.getSurface(Direction.right);
        assertEquals(Color.right, rightColorBefore);
        Color frontColorBefore = bottomRightFront.getSurface(Direction.front);
        assertEquals(Color.front, frontColorBefore);

        IllegalArgumentException upExceptionBefore = assertThrows(IllegalArgumentException.class, () -> bottomRightFront.getSurface(Direction.up));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, upExceptionBefore.getMessage());
        IllegalArgumentException leftExceptionBefore = assertThrows(IllegalArgumentException.class, () -> bottomRightFront.getSurface(Direction.left));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, leftExceptionBefore.getMessage());
        IllegalArgumentException backExceptionBefore = assertThrows(IllegalArgumentException.class, () -> bottomRightFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionBefore.getMessage());

        /*
            bottomRightFront --> backRightDown
         */
        bottomRightFront.turnClockwiseAroundXAxis();

        Color backColorBetween = bottomRightFront.getSurface(Direction.back);
        assertEquals(Color.bottom, backColorBetween);
        Color rightColorBetween = bottomRightFront.getSurface(Direction.right);
        assertEquals(Color.right, rightColorBetween);
        Color bottomColorBetween = bottomRightFront.getSurface(Direction.down);
        assertEquals(Color.front, bottomColorBetween);

        IllegalArgumentException frontExceptionBetween = assertThrows(IllegalArgumentException.class, () -> bottomRightFront.getSurface(Direction.front));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, frontExceptionBetween.getMessage());
        IllegalArgumentException leftExceptionBetween = assertThrows(IllegalArgumentException.class, () -> bottomRightFront.getSurface(Direction.left));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, leftExceptionBetween.getMessage());
        IllegalArgumentException upExceptionBetween = assertThrows(IllegalArgumentException.class, () -> bottomRightFront.getSurface(Direction.up));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, upExceptionBetween.getMessage());

        /*
            frontRightDown --> bottomRightFront
         */
        bottomRightFront.turnCounterclockwiseAroundXAxis();

        Color bottomColorAfter = bottomRightFront.getSurface(Direction.down);
        assertEquals(Color.bottom, bottomColorAfter);
        Color rightColorAfter = bottomRightFront.getSurface(Direction.right);
        assertEquals(Color.right, rightColorAfter);
        Color frontColorAfter = bottomRightFront.getSurface(Direction.front);
        assertEquals(Color.front, frontColorAfter);

        IllegalArgumentException upExceptionAfter = assertThrows(IllegalArgumentException.class, () -> bottomRightFront.getSurface(Direction.up));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, upExceptionAfter.getMessage());
        IllegalArgumentException leftExceptionAfter = assertThrows(IllegalArgumentException.class, () -> bottomRightFront.getSurface(Direction.left));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, leftExceptionAfter.getMessage());
        IllegalArgumentException backExceptionAfter = assertThrows(IllegalArgumentException.class, () -> bottomRightFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionAfter.getMessage());


    }

    @Test
    void turnClockwiseAroundYAxis() {
    }

    @Test
    void turnCounterClockwiseAroundYAxis() {
    }

    @Test
    void turnClockwiseAroundZAxis() {
    }

    @Test
    void turnCounterClockwiseAroundZAxis() {
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