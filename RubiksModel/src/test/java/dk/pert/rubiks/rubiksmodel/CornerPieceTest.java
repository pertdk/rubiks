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


    @BeforeEach
    void beforeEach() {
        directions = new ArrayList<>(EnumSet.allOf(Direction.class));
        colors = new ArrayList<>(EnumSet.allOf(Color.class));
    }

    private void _givenCornerPiece_whenDirection_thenColor(CornerPiece cornerPiece, Color color, Direction direction) {
        Color beforeColor = cornerPiece.getSurface(direction);
        assertEquals(beforeColor, color);
    }

    private void _givenCornerPiece_whenDirections_thenColors(CornerPiece cornerPiece, ArrayList<Color> colors, ArrayList<Direction> directions) {
        _givenCornerPiece_whenDirection_thenColor(cornerPiece, colors.get(0), directions.get(0));
        _givenCornerPiece_whenDirection_thenColor(cornerPiece, colors.get(1), directions.get(1));
        _givenCornerPiece_whenDirection_thenColor(cornerPiece, colors.get(2), directions.get(2));
    }

    private void _givenCornerPiece_whenDirection_thenThrowIllegalArgumentException(CornerPiece cornerPiece, Direction direction) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cornerPiece.getSurface(direction));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, exception.getMessage());
    }

    private void _givenCornerPiece_whenDirections_thenThrowIllegalArgumentExceptions(CornerPiece cornerPiece, ArrayList<Direction> directions) {
        for (Direction direction : directions) {
            _givenCornerPiece_whenDirection_thenThrowIllegalArgumentException(cornerPiece, direction);
        }
    }

    private void _givenCornerPiece_whenSetDirections_thenOtherDirectionsThrowsIllegalArgumentException(CornerPiece cornerPiece, ArrayList<Direction> coloredDirections) {
        ArrayList<Direction> unsetDirections = (ArrayList<Direction>) directions.clone();
        unsetDirections.removeAll(coloredDirections);
        _givenCornerPiece_whenDirections_thenThrowIllegalArgumentExceptions(cornerPiece, unsetDirections);
    }

    private void _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(CornerPiece cornerPiece, Turn turn, Axis axis, ArrayList<Color> colors, ArrayList<Direction> before, ArrayList<Direction> after) {
        _givenCornerPiece_whenDirections_thenColors(cornerPiece, colors, before);
        _givenCornerPiece_whenSetDirections_thenOtherDirectionsThrowsIllegalArgumentException(cornerPiece, before);

        cornerPiece.turn(turn, axis);

        _givenCornerPiece_whenDirections_thenColors(cornerPiece, colors, after);
        _givenCornerPiece_whenSetDirections_thenOtherDirectionsThrowsIllegalArgumentException(cornerPiece, after);
    }


    private void _givenCornerPiece_whenTurnedAroundXAxis_then_ColorsBeforeDirections_AfterDirections(CornerPiece cornerPiece, ArrayList<Color> colors, ArrayList<Direction> before, ArrayList<Direction> after) {
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.clockWise, Axis.xAxis, colors, before, after);
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.counterClockWise, Axis.xAxis, colors, after, before);
    }

    private void _givenCornerPiece_whenTurnedAroundYAxis_then_ColorsBeforeDirections_AfterDirections(CornerPiece cornerPiece, ArrayList<Color> colors, ArrayList<Direction> before, ArrayList<Direction> after) {
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.clockWise, Axis.yAxis, colors, before, after);
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.counterClockWise, Axis.yAxis, colors, after, before);
    }

    private void _givenCornerPiece_whenTurnedAroundZAxis_then_ColorsBeforeDirections_AfterDirections(CornerPiece cornerPiece, ArrayList<Color> colors, ArrayList<Direction> before, ArrayList<Direction> after) {
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.clockWise, Axis.zAxis, colors, before, after);
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.counterClockWise, Axis.zAxis, colors, after, before);
    }

    private void _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(CornerPiece cornerPiece, ArrayList<Color> colors, ArrayList<Direction> before, ArrayList<Direction> xDirections, ArrayList<Direction> yDirections, ArrayList<Direction> zDirections) {
        _givenCornerPiece_whenTurnedAroundXAxis_then_ColorsBeforeDirections_AfterDirections(cornerPiece, colors, before, xDirections);
        _givenCornerPiece_whenTurnedAroundYAxis_then_ColorsBeforeDirections_AfterDirections(cornerPiece, colors, before, yDirections);
        _givenCornerPiece_whenTurnedAroundZAxis_then_ColorsBeforeDirections_AfterDirections(cornerPiece, colors, before, zDirections);
    }

    @Test
    void testTurnTopLeftFront() {
        ArrayList<Color> topLeftFrontColors = new ArrayList<>(Arrays.asList(Color.top, Color.left, Color.front));
        ArrayList<Direction> topLeftFrontDirections = new ArrayList<>(Arrays.asList(Direction.up, Direction.left, Direction.front));

        ArrayList<Direction> topLeftFrontXDirections = new ArrayList<>(Arrays.asList(Direction.front, Direction.left, Direction.down));
        ArrayList<Direction> topLeftFrontYDirections = new ArrayList<>(Arrays.asList(Direction.up, Direction.back, Direction.left));
        ArrayList<Direction> topLeftFrontZDirections = new ArrayList<>(Arrays.asList(Direction.right, Direction.up, Direction.front));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(topLeftFront, topLeftFrontColors, topLeftFrontDirections, topLeftFrontXDirections, topLeftFrontYDirections, topLeftFrontZDirections);
    }

    @Test
    void testTurnTopRightFront() {
        ArrayList<Color> topRightFrontColors = new ArrayList<>(Arrays.asList(Color.top, Color.right, Color.front));
        ArrayList<Direction> topRightFrontDirections = new ArrayList<>(Arrays.asList(Direction.up, Direction.right, Direction.front));

        ArrayList<Direction> topRightFrontXDirections = new ArrayList<>(Arrays.asList(Direction.back, Direction.right, Direction.up));
        ArrayList<Direction> topRightFrontYDirections = new ArrayList<>(Arrays.asList(Direction.up, Direction.front, Direction.left));
        ArrayList<Direction> topRightFrontZDirections = new ArrayList<>(Arrays.asList(Direction.right, Direction.down, Direction.front));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(topRightFront, topRightFrontColors, topRightFrontDirections, topRightFrontXDirections, topRightFrontYDirections, topRightFrontZDirections);
    }

    @Test
    void testTurnBottomRightFront() {
        ArrayList<Color> bottomRightFrontColors = new ArrayList<>(Arrays.asList(Color.bottom, Color.right, Color.front));
        ArrayList<Direction> bottomRightFrontDirections = new ArrayList<>(Arrays.asList(Direction.down, Direction.right, Direction.front));

        ArrayList<Direction> bottomRightFrontXDirections = new ArrayList<>(Arrays.asList(Direction.front, Direction.right, Direction.up));
        ArrayList<Direction> bottomRightFrontYDirections = new ArrayList<>(Arrays.asList(Direction.down, Direction.back, Direction.right));
        ArrayList<Direction> bottomRightFrontZDirections = new ArrayList<>(Arrays.asList(Direction.left, Direction.down, Direction.front));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(bottomRightFront, bottomRightFrontColors, bottomRightFrontDirections, bottomRightFrontXDirections, bottomRightFrontYDirections, bottomRightFrontZDirections);
    }

    @Test
    void testTurnBottomLeftFront() {
        ArrayList<Color> bottomLeftFrontColors = new ArrayList<>(Arrays.asList(Color.bottom, Color.left, Color.front));
        ArrayList<Direction> bottomLeftFrontDirections = new ArrayList<>(Arrays.asList(Direction.down, Direction.left, Direction.front));

        ArrayList<Direction> bottomLeftFrontXDirections = new ArrayList<>(Arrays.asList(Direction.back, Direction.left, Direction.down));
        ArrayList<Direction> bottomLeftFrontYDirections = new ArrayList<>(Arrays.asList(Direction.down, Direction.front, Direction.right));
        ArrayList<Direction> bottomLeftFrontZDirections = new ArrayList<>(Arrays.asList(Direction.left, Direction.up, Direction.front));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(bottomLeftFront, bottomLeftFrontColors, bottomLeftFrontDirections, bottomLeftFrontXDirections, bottomLeftFrontYDirections, bottomLeftFrontZDirections);

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
