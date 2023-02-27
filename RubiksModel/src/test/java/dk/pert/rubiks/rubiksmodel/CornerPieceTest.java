package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.enums.Axis;
import dk.pert.rubiks.rubiksmodel.enums.Color;
import dk.pert.rubiks.rubiksmodel.enums.Direction;
import dk.pert.rubiks.rubiksmodel.enums.Turn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CornerPieceTest {

    private static final CornerPiece topLeftFront = new CornerPiece(Direction.UP, Color.WHITE, Direction.LEFT, Color.ORANGE, Direction.FRONT, Color.GREEN);
    private static final CornerPiece bottomLeftFront = new CornerPiece(Direction.DOWN, Color.YELLOW, Direction.LEFT, Color.ORANGE, Direction.FRONT, Color.GREEN);
    private static final CornerPiece topRightFront = new CornerPiece(Direction.UP, Color.WHITE, Direction.RIGHT, Color.RED, Direction.FRONT, Color.GREEN);
    private static final CornerPiece bottomRightFront = new CornerPiece(Direction.DOWN, Color.YELLOW, Direction.RIGHT, Color.RED, Direction.FRONT, Color.GREEN);
    private static final CornerPiece topLeftBack = new CornerPiece(Direction.UP, Color.WHITE, Direction.LEFT, Color.ORANGE, Direction.BACK, Color.BLUE);
    private static final CornerPiece bottomLeftBack = new CornerPiece(Direction.DOWN, Color.YELLOW, Direction.LEFT, Color.ORANGE, Direction.BACK, Color.BLUE);
    private static final CornerPiece topRightBack = new CornerPiece(Direction.UP, Color.WHITE, Direction.RIGHT, Color.RED, Direction.BACK, Color.BLUE);
    private static final CornerPiece bottomRightBack = new CornerPiece(Direction.DOWN, Color.YELLOW, Direction.RIGHT, Color.RED, Direction.BACK, Color.BLUE);

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
        @SuppressWarnings("unchecked")
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
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.CLOCK_WISE, Axis.X, colors, before, after);
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.COUNTER_CLOCK_WISE, Axis.X, colors, after, before);
    }

    private void _givenCornerPiece_whenTurnedAroundYAxis_then_ColorsBeforeDirections_AfterDirections(CornerPiece cornerPiece, ArrayList<Color> colors, ArrayList<Direction> before, ArrayList<Direction> after) {
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.CLOCK_WISE, Axis.Y, colors, before, after);
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.COUNTER_CLOCK_WISE, Axis.Y, colors, after, before);
    }

    private void _givenCornerPiece_whenTurnedAroundZAxis_then_ColorsBeforeDirections_AfterDirections(CornerPiece cornerPiece, ArrayList<Color> colors, ArrayList<Direction> before, ArrayList<Direction> after) {
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.CLOCK_WISE, Axis.Z, colors, before, after);
        _givenCornerPiece_whenTurnTurnedAroundAxis_thenColorsBeforeDirectionsAfterDirections(cornerPiece, Turn.COUNTER_CLOCK_WISE, Axis.Z, colors, after, before);
    }

    private void _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(CornerPiece cornerPiece, ArrayList<Color> colors, ArrayList<Direction> before, ArrayList<Direction> xDirections, ArrayList<Direction> yDirections, ArrayList<Direction> zDirections) {
        _givenCornerPiece_whenTurnedAroundXAxis_then_ColorsBeforeDirections_AfterDirections(cornerPiece, colors, before, xDirections);
        _givenCornerPiece_whenTurnedAroundYAxis_then_ColorsBeforeDirections_AfterDirections(cornerPiece, colors, before, yDirections);
        _givenCornerPiece_whenTurnedAroundZAxis_then_ColorsBeforeDirections_AfterDirections(cornerPiece, colors, before, zDirections);
    }

    @Test
    void testTurnTopLeftFront() {
        ArrayList<Color> topLeftFrontColors = new ArrayList<>(Arrays.asList(Color.WHITE, Color.ORANGE, Color.GREEN));
        ArrayList<Direction> topLeftFrontDirections = new ArrayList<>(Arrays.asList(Direction.UP, Direction.LEFT, Direction.FRONT));

        ArrayList<Direction> topLeftFrontXDirections = new ArrayList<>(Arrays.asList(Direction.FRONT, Direction.LEFT, Direction.DOWN));
        ArrayList<Direction> topLeftFrontYDirections = new ArrayList<>(Arrays.asList(Direction.UP, Direction.BACK, Direction.LEFT));
        ArrayList<Direction> topLeftFrontZDirections = new ArrayList<>(Arrays.asList(Direction.RIGHT, Direction.UP, Direction.FRONT));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(topLeftFront, topLeftFrontColors, topLeftFrontDirections, topLeftFrontXDirections, topLeftFrontYDirections, topLeftFrontZDirections);
    }

    @Test
    void testTurnTopRightFront() {
        ArrayList<Color> topRightFrontColors = new ArrayList<>(Arrays.asList(Color.WHITE, Color.RED, Color.GREEN));
        ArrayList<Direction> topRightFrontDirections = new ArrayList<>(Arrays.asList(Direction.UP, Direction.RIGHT, Direction.FRONT));

        ArrayList<Direction> topRightFrontXDirections = new ArrayList<>(Arrays.asList(Direction.BACK, Direction.RIGHT, Direction.UP));
        ArrayList<Direction> topRightFrontYDirections = new ArrayList<>(Arrays.asList(Direction.UP, Direction.FRONT, Direction.LEFT));
        ArrayList<Direction> topRightFrontZDirections = new ArrayList<>(Arrays.asList(Direction.RIGHT, Direction.DOWN, Direction.FRONT));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(topRightFront, topRightFrontColors, topRightFrontDirections, topRightFrontXDirections, topRightFrontYDirections, topRightFrontZDirections);
    }

    @Test
    void testTurnBottomRightFront() {
        ArrayList<Color> bottomRightFrontColors = new ArrayList<>(Arrays.asList(Color.YELLOW, Color.RED, Color.GREEN));
        ArrayList<Direction> bottomRightFrontDirections = new ArrayList<>(Arrays.asList(Direction.DOWN, Direction.RIGHT, Direction.FRONT));

        ArrayList<Direction> bottomRightFrontXDirections = new ArrayList<>(Arrays.asList(Direction.FRONT, Direction.RIGHT, Direction.UP));
        ArrayList<Direction> bottomRightFrontYDirections = new ArrayList<>(Arrays.asList(Direction.DOWN, Direction.BACK, Direction.RIGHT));
        ArrayList<Direction> bottomRightFrontZDirections = new ArrayList<>(Arrays.asList(Direction.LEFT, Direction.DOWN, Direction.FRONT));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(bottomRightFront, bottomRightFrontColors, bottomRightFrontDirections, bottomRightFrontXDirections, bottomRightFrontYDirections, bottomRightFrontZDirections);
    }

    @Test
    void testTurnBottomLeftFront() {
        ArrayList<Color> bottomLeftFrontColors = new ArrayList<>(Arrays.asList(Color.YELLOW, Color.ORANGE, Color.GREEN));
        ArrayList<Direction> bottomLeftFrontDirections = new ArrayList<>(Arrays.asList(Direction.DOWN, Direction.LEFT, Direction.FRONT));

        ArrayList<Direction> bottomLeftFrontXDirections = new ArrayList<>(Arrays.asList(Direction.BACK, Direction.LEFT, Direction.DOWN));
        ArrayList<Direction> bottomLeftFrontYDirections = new ArrayList<>(Arrays.asList(Direction.DOWN, Direction.FRONT, Direction.RIGHT));
        ArrayList<Direction> bottomLeftFrontZDirections = new ArrayList<>(Arrays.asList(Direction.LEFT, Direction.UP, Direction.FRONT));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(bottomLeftFront, bottomLeftFrontColors, bottomLeftFrontDirections, bottomLeftFrontXDirections, bottomLeftFrontYDirections, bottomLeftFrontZDirections);

    }

    @Test
    void testTurnTopLeftBack() {
        ArrayList<Color> topLeftBackColors = new ArrayList<>(Arrays.asList(Color.WHITE, Color.ORANGE, Color.BLUE));
        ArrayList<Direction> topLeftBackDirections = new ArrayList<>(Arrays.asList(Direction.UP, Direction.LEFT, Direction.BACK));

        ArrayList<Direction> topLeftBackXDirections = new ArrayList<>(Arrays.asList(Direction.FRONT, Direction.LEFT, Direction.UP));
        ArrayList<Direction> topLeftBackYDirections = new ArrayList<>(Arrays.asList(Direction.UP, Direction.BACK, Direction.RIGHT));
        ArrayList<Direction> topLeftBackZDirections = new ArrayList<>(Arrays.asList(Direction.LEFT, Direction.DOWN, Direction.BACK));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(topLeftBack, topLeftBackColors, topLeftBackDirections, topLeftBackXDirections, topLeftBackYDirections, topLeftBackZDirections);
    }

    @Test
    void testTurnTopRightBack() {
        ArrayList<Color> topRightBackColors = new ArrayList<>(Arrays.asList(Color.WHITE, Color.RED, Color.BLUE));
        ArrayList<Direction> topRightBackDirections = new ArrayList<>(Arrays.asList(Direction.UP, Direction.RIGHT, Direction.BACK));

        ArrayList<Direction> topRightBackXDirections = new ArrayList<>(Arrays.asList(Direction.BACK, Direction.RIGHT, Direction.DOWN));
        ArrayList<Direction> topRightBackYDirections = new ArrayList<>(Arrays.asList(Direction.UP, Direction.FRONT, Direction.RIGHT));
        ArrayList<Direction> topRightBackZDirections = new ArrayList<>(Arrays.asList(Direction.LEFT, Direction.UP, Direction.BACK));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(topRightBack, topRightBackColors, topRightBackDirections, topRightBackXDirections, topRightBackYDirections, topRightBackZDirections);
    }

    @Test
    void testTurnBottomRightBack() {
        ArrayList<Color> bottomRightBackColors = new ArrayList<>(Arrays.asList(Color.YELLOW, Color.RED, Color.BLUE));
        ArrayList<Direction> bottomRightBackDirections = new ArrayList<>(Arrays.asList(Direction.DOWN, Direction.RIGHT, Direction.BACK));

        ArrayList<Direction> bottomRightBackXDirections = new ArrayList<>(Arrays.asList(Direction.FRONT, Direction.RIGHT, Direction.DOWN));
        ArrayList<Direction> bottomRightBackYDirections = new ArrayList<>(Arrays.asList(Direction.DOWN, Direction.BACK, Direction.LEFT));
        ArrayList<Direction> bottomRightBackZDirections = new ArrayList<>(Arrays.asList(Direction.RIGHT, Direction.UP, Direction.BACK));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(bottomRightBack, bottomRightBackColors, bottomRightBackDirections, bottomRightBackXDirections, bottomRightBackYDirections, bottomRightBackZDirections);
    }

    @Test
    void testTurnBottomLeftBack() {
        ArrayList<Color> bottomLeftBackColors = new ArrayList<>(Arrays.asList(Color.YELLOW, Color.ORANGE, Color.BLUE));
        ArrayList<Direction> bottomLeftBackDirections = new ArrayList<>(Arrays.asList(Direction.DOWN, Direction.LEFT, Direction.BACK));

        ArrayList<Direction> bottomLeftBackXDirections = new ArrayList<>(Arrays.asList(Direction.BACK, Direction.LEFT, Direction.UP));
        ArrayList<Direction> bottomLeftBackYDirections = new ArrayList<>(Arrays.asList(Direction.DOWN, Direction.FRONT, Direction.LEFT));
        ArrayList<Direction> bottomLeftBackZDirections = new ArrayList<>(Arrays.asList(Direction.RIGHT, Direction.DOWN, Direction.BACK));

        _givenCornerPiece_whenTurnedAroundAllAxis_thenColorsXDirectionsYDirectionsZDirections(bottomLeftBack, bottomLeftBackColors, bottomLeftBackDirections, bottomLeftBackXDirections, bottomLeftBackYDirections, bottomLeftBackZDirections);

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
