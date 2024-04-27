package dk.pert.rubiks.model.pieces;

import dk.pert.rubiks.model.Surface;
import dk.pert.rubiks.model.enums.Color;
import dk.pert.rubiks.model.enums.Direction;
import dk.pert.rubiks.model.enums.Move;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CornerPieceTest {

    private void testCornerPiece(CornerPiece cornerPiece, Direction @NotNull ... expectations) {
        ArrayList<Direction> directions = new ArrayList<>(List.of(Direction.values()));
        for (Direction expect : expectations) {
            assertTrue(cornerPiece.hasSurface(expect));
            directions.remove(expect);
        }
        for (Direction unexpected : directions) {
            assertFalse(cornerPiece.hasSurface(unexpected));
        }
    }

    private void rotationTest(CornerPiece cornerPiece, Move move, Direction @NotNull ... expectations) {
        testCornerPiece(cornerPiece, expectations[0], expectations[1], expectations[2]);
        for (int i = 3; i < expectations.length; i += 3) {
            cornerPiece.move(move);
            testCornerPiece(cornerPiece, expectations[i], expectations[i + 1], expectations[i + 2]);
        }
        cornerPiece.move(move);
        testCornerPiece(cornerPiece, expectations[0], expectations[1], expectations[2]);
    }

    @Test
    void testWhiteFrontOrangeLeftBlueUp() {
        CornerPiece whiteFrontOrangeLeftBlueUp = new CornerPiece(
                new Surface(Color.WHITE, Direction.FRONT),
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.BLUE, Direction.UP)
        );
        rotationTest(whiteFrontOrangeLeftBlueUp, Move.LEFT,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.DOWN, Direction.LEFT, Direction.FRONT,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.UP, Direction.LEFT, Direction.BACK
        );

        rotationTest(whiteFrontOrangeLeftBlueUp, Move.LEFT_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.UP, Direction.LEFT, Direction.BACK,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.DOWN, Direction.LEFT, Direction.FRONT
        );

        rotationTest(whiteFrontOrangeLeftBlueUp, Move.RIGHT,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP
        );

        rotationTest(whiteFrontOrangeLeftBlueUp, Move.RIGHT_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP
        );

        rotationTest(whiteFrontOrangeLeftBlueUp, Move.BACK,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP
        );
        rotationTest(whiteFrontOrangeLeftBlueUp, Move.BACK_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP
        );
        rotationTest(whiteFrontOrangeLeftBlueUp, Move.BACK,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP
        );
        rotationTest(whiteFrontOrangeLeftBlueUp, Move.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP
        );
        rotationTest(whiteFrontOrangeLeftBlueUp, Move.DOWN_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP
        );

        rotationTest(whiteFrontOrangeLeftBlueUp, Move.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.LEFT, Direction.BACK, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.RIGHT, Direction.FRONT, Direction.UP
        );

        rotationTest(whiteFrontOrangeLeftBlueUp, Move.UP_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.RIGHT, Direction.FRONT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.LEFT, Direction.BACK, Direction.UP
        );
    }

    @Test
    void testWhiteFrontRedRightBlueUp() {
        CornerPiece whiteFrontRedRightBlueUp = new CornerPiece(
                new Surface(Color.WHITE, Direction.FRONT),
                new Surface(Color.RED, Direction.RIGHT),
                new Surface(Color.BLUE, Direction.UP)
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.LEFT,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.LEFT_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.RIGHT,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.UP, Direction.RIGHT, Direction.BACK,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.DOWN, Direction.RIGHT, Direction.FRONT
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.RIGHT_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.DOWN, Direction.RIGHT, Direction.FRONT,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.UP, Direction.RIGHT, Direction.BACK
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.BACK,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.BACK_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.FRONT,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.DOWN, Direction.RIGHT,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.UP, Direction.LEFT
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.FRONT_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.UP, Direction.LEFT,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.DOWN, Direction.RIGHT
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.DOWN_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.LEFT, Direction.FRONT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.RIGHT, Direction.BACK, Direction.UP
        );
        rotationTest(whiteFrontRedRightBlueUp, Move.UP_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.RIGHT, Direction.BACK, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.LEFT, Direction.FRONT, Direction.UP
        );
    }

    @Test
    void testWhiteFrontRedRightGreenDown() {
        CornerPiece whiteFrontRedRightGreenDown = new CornerPiece(
                new Surface(Color.WHITE, Direction.FRONT),
                new Surface(Color.RED, Direction.RIGHT),
                new Surface(Color.GREEN, Direction.DOWN)
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.LEFT,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.LEFT_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.RIGHT,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.UP, Direction.RIGHT, Direction.FRONT,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.DOWN, Direction.RIGHT, Direction.BACK
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.RIGHT_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.DOWN, Direction.RIGHT, Direction.BACK,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.UP, Direction.RIGHT, Direction.FRONT
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.BACK,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.BACK_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.FRONT,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.DOWN, Direction.LEFT,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.UP, Direction.RIGHT
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.FRONT_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.UP, Direction.RIGHT,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.FRONT, Direction.DOWN, Direction.LEFT
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.RIGHT, Direction.BACK, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.LEFT, Direction.FRONT, Direction.DOWN
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.DOWN_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.LEFT, Direction.FRONT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.RIGHT, Direction.BACK, Direction.DOWN
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.UP,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(whiteFrontRedRightGreenDown, Move.UP_INVERTED,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN
        );
    }

    @Test
    void testWhiteFrontOrangeLeftGreenDown() {
        CornerPiece whiteFrontOrangeLeftGreenDown = new CornerPiece(
                new Surface(Color.WHITE, Direction.FRONT),
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.GREEN, Direction.DOWN)
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.LEFT,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.DOWN, Direction.LEFT, Direction.BACK,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.UP, Direction.LEFT, Direction.FRONT
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.LEFT_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.UP, Direction.LEFT, Direction.FRONT,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.DOWN, Direction.LEFT, Direction.BACK
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.RIGHT,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.RIGHT_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.BACK,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.BACK_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.FRONT,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.UP, Direction.LEFT,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.DOWN, Direction.RIGHT
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.FRONT_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.DOWN, Direction.RIGHT,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.FRONT, Direction.UP, Direction.LEFT
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.RIGHT, Direction.FRONT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.LEFT, Direction.BACK, Direction.DOWN
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.DOWN_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.LEFT, Direction.BACK, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.RIGHT, Direction.FRONT, Direction.DOWN
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.UP,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN
        );
        rotationTest(whiteFrontOrangeLeftGreenDown, Move.UP_INVERTED,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN
        );
    }

    @Test
    void testYellowBackOrangeLeftGreenDown() {
        CornerPiece yellowBackOrangeLeftGreenDown = new CornerPiece(
                new Surface(Color.YELLOW, Direction.BACK),
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.GREEN, Direction.DOWN)
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.LEFT,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.UP, Direction.LEFT, Direction.BACK,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.DOWN, Direction.LEFT, Direction.FRONT
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.LEFT_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.DOWN, Direction.LEFT, Direction.FRONT,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.UP, Direction.LEFT, Direction.BACK
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.RIGHT,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.RIGHT_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.BACK,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.DOWN, Direction.RIGHT,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.UP, Direction.LEFT
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.BACK_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.UP, Direction.LEFT,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.DOWN, Direction.RIGHT
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.FRONT,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.FRONT_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.LEFT, Direction.FRONT, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.RIGHT, Direction.BACK, Direction.DOWN
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.DOWN_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.RIGHT, Direction.BACK, Direction.DOWN,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.LEFT, Direction.FRONT, Direction.DOWN
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.UP,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN
        );
        rotationTest(yellowBackOrangeLeftGreenDown, Move.UP_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.LEFT, Direction.DOWN
        );
    }

    @Test
    void testYellowBackOrangeLeftBlueUp() {
        CornerPiece yellowBackOrangeLeftBlueUp = new CornerPiece(
                new Surface(Color.YELLOW, Direction.BACK),
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.BLUE, Direction.UP)
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.LEFT,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.UP, Direction.LEFT, Direction.FRONT,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.DOWN, Direction.LEFT, Direction.BACK
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.LEFT_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.DOWN, Direction.LEFT, Direction.BACK,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.UP, Direction.LEFT, Direction.FRONT
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.RIGHT,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.RIGHT_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.BACK,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.DOWN, Direction.LEFT,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.UP, Direction.RIGHT
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.BACK_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.UP, Direction.RIGHT,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.DOWN, Direction.LEFT
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.FRONT,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.FRONT_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.DOWN,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.DOWN_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.LEFT, Direction.UP
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.UP,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.RIGHT, Direction.BACK, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.LEFT, Direction.FRONT, Direction.UP
        );
        rotationTest(yellowBackOrangeLeftBlueUp, Move.UP_INVERTED,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.LEFT, Direction.FRONT, Direction.UP,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.RIGHT, Direction.BACK, Direction.UP
        );
    }

    @Test
    void testYellowBackRedRightBlueUp() {
        CornerPiece yellowBackRedRightBlueUp = new CornerPiece(
                new Surface(Color.YELLOW, Direction.BACK),
                new Surface(Color.RED, Direction.RIGHT),
                new Surface(Color.BLUE, Direction.UP)
        );
        rotationTest(yellowBackRedRightBlueUp, Move.LEFT,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP
        );
        rotationTest(yellowBackRedRightBlueUp, Move.LEFT_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP
        );
        rotationTest(yellowBackRedRightBlueUp, Move.RIGHT,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.DOWN, Direction.RIGHT, Direction.BACK,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.UP, Direction.RIGHT, Direction.FRONT
        );
        rotationTest(yellowBackRedRightBlueUp, Move.RIGHT_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.UP, Direction.RIGHT, Direction.FRONT,
                Direction.FRONT, Direction.RIGHT, Direction.DOWN,
                Direction.DOWN, Direction.RIGHT, Direction.BACK
        );
        rotationTest(yellowBackRedRightBlueUp, Move.BACK,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.UP, Direction.LEFT,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.DOWN, Direction.RIGHT
        );
        rotationTest(yellowBackRedRightBlueUp, Move.BACK_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.DOWN, Direction.RIGHT,
                Direction.BACK, Direction.LEFT, Direction.DOWN,
                Direction.BACK, Direction.UP, Direction.LEFT
        );
        rotationTest(yellowBackRedRightBlueUp, Move.FRONT,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP
        );
        rotationTest(yellowBackRedRightBlueUp, Move.FRONT_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP
        );
        rotationTest(yellowBackRedRightBlueUp, Move.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP
        );
        rotationTest(yellowBackRedRightBlueUp, Move.DOWN_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP
        );
        rotationTest(yellowBackRedRightBlueUp, Move.UP,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.RIGHT, Direction.FRONT, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.LEFT, Direction.BACK, Direction.UP
        );
        rotationTest(yellowBackRedRightBlueUp, Move.UP_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.UP,
                Direction.LEFT, Direction.BACK, Direction.UP,
                Direction.FRONT, Direction.LEFT, Direction.UP,
                Direction.RIGHT, Direction.FRONT, Direction.UP
        );
    }

    @Test
    void testYellowBackRedRightGreenDown() {
        CornerPiece yellowBackRedRightGreenDown = new CornerPiece(
                new Surface(Color.YELLOW, Direction.BACK),
                new Surface(Color.RED, Direction.RIGHT),
                new Surface(Color.GREEN, Direction.DOWN)
        );
        rotationTest(yellowBackRedRightGreenDown, Move.LEFT,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(yellowBackRedRightGreenDown, Move.LEFT_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(yellowBackRedRightGreenDown, Move.RIGHT,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.DOWN, Direction.RIGHT, Direction.FRONT,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.UP, Direction.RIGHT, Direction.BACK
        );
        rotationTest(yellowBackRedRightGreenDown, Move.RIGHT_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.UP, Direction.RIGHT, Direction.BACK,
                Direction.FRONT, Direction.RIGHT, Direction.UP,
                Direction.DOWN, Direction.RIGHT, Direction.FRONT
        );
        rotationTest(yellowBackRedRightGreenDown, Move.BACK,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.UP, Direction.RIGHT,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.DOWN, Direction.LEFT
        );
        rotationTest(yellowBackRedRightGreenDown, Move.BACK_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.DOWN, Direction.LEFT,
                Direction.BACK, Direction.LEFT, Direction.UP,
                Direction.BACK, Direction.UP, Direction.RIGHT
        );
        rotationTest(yellowBackRedRightGreenDown, Move.FRONT,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(yellowBackRedRightGreenDown, Move.FRONT_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(yellowBackRedRightGreenDown, Move.UP,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(yellowBackRedRightGreenDown, Move.UP_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN
        );
        rotationTest(yellowBackRedRightGreenDown, Move.DOWN,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.LEFT, Direction.BACK, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.RIGHT, Direction.FRONT, Direction.DOWN
        );
        rotationTest(yellowBackRedRightGreenDown, Move.DOWN_INVERTED,
                Direction.BACK, Direction.RIGHT, Direction.DOWN,
                Direction.RIGHT, Direction.FRONT, Direction.DOWN,
                Direction.FRONT, Direction.LEFT, Direction.DOWN,
                Direction.LEFT, Direction.BACK, Direction.DOWN
        );
    }
}
