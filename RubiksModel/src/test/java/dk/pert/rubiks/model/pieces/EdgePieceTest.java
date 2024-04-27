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

class EdgePieceTest {

    private void testEdgePiece(EdgePiece edgePiece, Direction @NotNull ... expectations) {
        ArrayList<Direction> directions = new ArrayList<>(List.of(Direction.values()));
        for (Direction expect : expectations) {
            assertTrue(edgePiece.hasSurface(expect));
            directions.remove(expect);
        }
        for (Direction unexpected : directions) {
            assertFalse(edgePiece.hasSurface(unexpected));
        }
    }

    private void rotationTest(EdgePiece edgePiece, Move move, Direction @NotNull ... expectations) {
        testEdgePiece(edgePiece, expectations[0], expectations[1]);
        for (int i = 2; i < expectations.length; i += 2) {
            edgePiece.move(move);
            testEdgePiece(edgePiece, expectations[i], expectations[i + 1]);
        }
        edgePiece.move(move);
        testEdgePiece(edgePiece, expectations[0], expectations[1]);
    }

    @Test
    void testWhiteFrontOrangeLeft() {
        EdgePiece whiteFrontOrangeLeft = new EdgePiece(new Surface(Color.WHITE, Direction.FRONT), new Surface(Color.ORANGE, Direction.LEFT));
        rotationTest(whiteFrontOrangeLeft, Move.LEFT, Direction.FRONT, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.UP, Direction.LEFT);
        rotationTest(whiteFrontOrangeLeft, Move.LEFT_INVERTED, Direction.FRONT, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.DOWN, Direction.LEFT);
        rotationTest(whiteFrontOrangeLeft, Move.RIGHT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteFrontOrangeLeft, Move.RIGHT_INVERTED, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteFrontOrangeLeft, Move.BACK, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteFrontOrangeLeft, Move.BACK_INVERTED, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteFrontOrangeLeft, Move.FRONT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontOrangeLeft, Move.FRONT_INVERTED, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.UP);
        rotationTest(whiteFrontOrangeLeft, Move.DOWN, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteFrontOrangeLeft, Move.DOWN_INVERTED, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteFrontOrangeLeft, Move.UP, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteFrontOrangeLeft, Move.UP_INVERTED, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT);
    }

    @Test
    void testWhiteFrontBlueUp() {
        EdgePiece whiteFrontBlueUp = new EdgePiece(new Surface(Color.WHITE, Direction.FRONT), new Surface(Color.BLUE, Direction.UP));
        rotationTest(whiteFrontBlueUp, Move.LEFT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP);
        rotationTest(whiteFrontBlueUp, Move.LEFT_INVERTED, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP);
        rotationTest(whiteFrontBlueUp, Move.RIGHT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP);
        rotationTest(whiteFrontBlueUp, Move.RIGHT_INVERTED, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP);
        rotationTest(whiteFrontBlueUp, Move.BACK, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP);
        rotationTest(whiteFrontBlueUp, Move.BACK_INVERTED, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP);
        rotationTest(whiteFrontBlueUp, Move.FRONT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteFrontBlueUp, Move.FRONT_INVERTED, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteFrontBlueUp, Move.UP, Direction.FRONT, Direction.UP, Direction.LEFT, Direction.UP, Direction.BACK, Direction.UP, Direction.RIGHT, Direction.UP);
        rotationTest(whiteFrontBlueUp, Move.UP_INVERTED, Direction.FRONT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.BACK, Direction.UP, Direction.LEFT, Direction.UP);
        rotationTest(whiteFrontBlueUp, Move.DOWN, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP);
        rotationTest(whiteFrontBlueUp, Move.DOWN_INVERTED, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP);
    }

    @Test
    void testWhiteFrontRedRight() {
        EdgePiece whiteFrontRedRight = new EdgePiece(new Surface(Color.WHITE, Direction.FRONT), new Surface(Color.RED, Direction.RIGHT));
        rotationTest(whiteFrontRedRight, Move.LEFT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteFrontRedRight, Move.LEFT_INVERTED, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteFrontRedRight, Move.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        rotationTest(whiteFrontRedRight, Move.RIGHT_INVERTED, Direction.FRONT, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.UP, Direction.RIGHT);
        rotationTest(whiteFrontRedRight, Move.BACK, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteFrontRedRight, Move.BACK_INVERTED, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteFrontRedRight, Move.FRONT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.UP);
        rotationTest(whiteFrontRedRight, Move.FRONT_INVERTED, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontRedRight, Move.UP, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteFrontRedRight, Move.UP_INVERTED, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteFrontRedRight, Move.DOWN, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteFrontRedRight, Move.DOWN_INVERTED, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
    }

    @Test
    void testWhiteFrontGreenDown() {
        EdgePiece whiteFrontGreenDown = new EdgePiece(new Surface(Color.WHITE, Direction.FRONT), new Surface(Color.GREEN, Direction.DOWN));
        rotationTest(whiteFrontGreenDown, Move.LEFT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontGreenDown, Move.LEFT_INVERTED, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontGreenDown, Move.RIGHT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontGreenDown, Move.RIGHT_INVERTED, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontGreenDown, Move.BACK, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontGreenDown, Move.BACK_INVERTED, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontGreenDown, Move.FRONT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteFrontGreenDown, Move.FRONT_INVERTED, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteFrontGreenDown, Move.UP, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontGreenDown, Move.UP_INVERTED, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
        rotationTest(whiteFrontGreenDown, Move.DOWN, Direction.FRONT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.LEFT, Direction.DOWN);
        rotationTest(whiteFrontGreenDown, Move.DOWN_INVERTED, Direction.FRONT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
    }

    @Test
    void testOrangeLeftBlueUp() {
        EdgePiece orangeLeftBlueUp = new EdgePiece(new Surface(Color.ORANGE, Direction.LEFT), new Surface(Color.BLUE, Direction.UP));
        rotationTest(orangeLeftBlueUp, Move.LEFT, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftBlueUp, Move.LEFT_INVERTED, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.FRONT);
        rotationTest(orangeLeftBlueUp, Move.RIGHT, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftBlueUp, Move.RIGHT_INVERTED, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftBlueUp, Move.BACK, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftBlueUp, Move.BACK_INVERTED, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftBlueUp, Move.FRONT, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftBlueUp, Move.FRONT_INVERTED, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftBlueUp, Move.UP, Direction.LEFT, Direction.UP, Direction.BACK, Direction.UP, Direction.RIGHT, Direction.UP, Direction.FRONT, Direction.UP);
        rotationTest(orangeLeftBlueUp, Move.UP_INVERTED, Direction.LEFT, Direction.UP, Direction.FRONT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.BACK, Direction.UP);
        rotationTest(orangeLeftBlueUp, Move.DOWN, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftBlueUp, Move.DOWN_INVERTED, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP);
    }

    @Test
    void testOrangeLeftYellowBack() {
        EdgePiece orangeLeftYellowBack = new EdgePiece(new Surface(Color.ORANGE, Direction.LEFT), new Surface(Color.YELLOW, Direction.BACK));
        rotationTest(orangeLeftYellowBack, Move.LEFT, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftYellowBack, Move.LEFT_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftYellowBack, Move.RIGHT, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftYellowBack, Move.RIGHT_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftYellowBack, Move.BACK, Direction.LEFT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(orangeLeftYellowBack, Move.BACK_INVERTED, Direction.LEFT, Direction.BACK, Direction.UP, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(orangeLeftYellowBack, Move.FRONT, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftYellowBack, Move.FRONT_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftYellowBack, Move.UP, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftYellowBack, Move.UP_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftYellowBack, Move.DOWN, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftYellowBack, Move.DOWN_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
    }

    @Test
    void testOrangeLeftGreenDown() {
        EdgePiece orangeLeftGreenDown = new EdgePiece(new Surface(Color.ORANGE, Direction.LEFT), new Surface(Color.GREEN, Direction.DOWN));
        rotationTest(orangeLeftGreenDown, Move.LEFT, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.FRONT);
        rotationTest(orangeLeftGreenDown, Move.LEFT_INVERTED, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftGreenDown, Move.RIGHT, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftGreenDown, Move.RIGHT_INVERTED, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftGreenDown, Move.BACK, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftGreenDown, Move.BACK_INVERTED, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftGreenDown, Move.FRONT, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftGreenDown, Move.FRONT_INVERTED, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftGreenDown, Move.UP, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftGreenDown, Move.UP_INVERTED, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftGreenDown, Move.DOWN, Direction.LEFT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.BACK, Direction.DOWN);
        rotationTest(orangeLeftGreenDown, Move.DOWN_INVERTED, Direction.LEFT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
    }


    @Test
    void testRedRightBlueUp() {
        EdgePiece redRightBlueUp = new EdgePiece(new Surface(Color.RED, Direction.RIGHT), new Surface(Color.BLUE, Direction.UP));
        rotationTest(redRightBlueUp, Move.LEFT, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP);
        rotationTest(redRightBlueUp, Move.LEFT_INVERTED, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP);
        rotationTest(redRightBlueUp, Move.RIGHT, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.FRONT);
        rotationTest(redRightBlueUp, Move.RIGHT_INVERTED, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightBlueUp, Move.BACK, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP);
        rotationTest(redRightBlueUp, Move.BACK_INVERTED, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP);
        rotationTest(redRightBlueUp, Move.FRONT, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP);
        rotationTest(redRightBlueUp, Move.FRONT_INVERTED, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP);
        rotationTest(redRightBlueUp, Move.UP, Direction.RIGHT, Direction.UP, Direction.FRONT, Direction.UP, Direction.LEFT, Direction.UP, Direction.BACK, Direction.UP);
        rotationTest(redRightBlueUp, Move.UP_INVERTED, Direction.RIGHT, Direction.UP, Direction.BACK, Direction.UP, Direction.LEFT, Direction.UP, Direction.FRONT, Direction.UP);
        rotationTest(redRightBlueUp, Move.DOWN, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP);
        rotationTest(redRightBlueUp, Move.DOWN_INVERTED, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP);
    }


    @Test
    void testRedRightYellowBack() {
        EdgePiece redRightYellowBack = new EdgePiece(new Surface(Color.RED, Direction.RIGHT), new Surface(Color.YELLOW, Direction.BACK));
        rotationTest(redRightYellowBack, Move.LEFT, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightYellowBack, Move.LEFT_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightYellowBack, Move.RIGHT, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.UP);
        rotationTest(redRightYellowBack, Move.RIGHT_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightYellowBack, Move.BACK, Direction.RIGHT, Direction.BACK, Direction.UP, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(redRightYellowBack, Move.BACK_INVERTED, Direction.RIGHT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(redRightYellowBack, Move.FRONT, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightYellowBack, Move.FRONT_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightYellowBack, Move.UP, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightYellowBack, Move.UP_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightYellowBack, Move.DOWN, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightYellowBack, Move.DOWN_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
    }

    @Test
    void testRedRightGreenDown() {
        EdgePiece redRightGreenDown = new EdgePiece(new Surface(Color.RED, Direction.RIGHT), new Surface(Color.GREEN, Direction.DOWN));
        rotationTest(redRightGreenDown, Move.LEFT, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightGreenDown, Move.LEFT_INVERTED, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightGreenDown, Move.RIGHT, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightGreenDown, Move.RIGHT_INVERTED, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.FRONT);
        rotationTest(redRightGreenDown, Move.BACK, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightGreenDown, Move.BACK_INVERTED, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightGreenDown, Move.FRONT, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightGreenDown, Move.FRONT_INVERTED, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightGreenDown, Move.UP, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightGreenDown, Move.UP_INVERTED, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightGreenDown, Move.DOWN, Direction.RIGHT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.FRONT, Direction.DOWN);
        rotationTest(redRightGreenDown, Move.DOWN_INVERTED, Direction.RIGHT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.BACK, Direction.DOWN);

    }

    @Test
    void testYellowBackBlueUp() {
        EdgePiece yellowBackBlueUp = new EdgePiece(new Surface(Color.YELLOW, Direction.BACK), new Surface(Color.BLUE, Direction.UP));
        rotationTest(yellowBackBlueUp, Move.LEFT, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP);
        rotationTest(yellowBackBlueUp, Move.LEFT_INVERTED, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP);
        rotationTest(yellowBackBlueUp, Move.RIGHT, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP);
        rotationTest(yellowBackBlueUp, Move.RIGHT_INVERTED, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP);
        rotationTest(yellowBackBlueUp, Move.BACK, Direction.BACK, Direction.UP, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.RIGHT);
        rotationTest(yellowBackBlueUp, Move.BACK_INVERTED, Direction.BACK, Direction.UP, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.LEFT);
        rotationTest(yellowBackBlueUp, Move.FRONT, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP);
        rotationTest(yellowBackBlueUp, Move.FRONT_INVERTED, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP);
        rotationTest(yellowBackBlueUp, Move.UP, Direction.BACK, Direction.UP, Direction.RIGHT, Direction.UP, Direction.FRONT, Direction.UP, Direction.LEFT, Direction.UP);
        rotationTest(yellowBackBlueUp, Move.UP_INVERTED, Direction.BACK, Direction.UP, Direction.LEFT, Direction.UP, Direction.FRONT, Direction.UP, Direction.RIGHT, Direction.UP);
        rotationTest(yellowBackBlueUp, Move.DOWN, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP);
        rotationTest(yellowBackBlueUp, Move.DOWN_INVERTED, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP);
    }


    @Test
    void testYellowBackGreenDown() {
        EdgePiece yellowBackGreenDown = new EdgePiece(new Surface(Color.YELLOW, Direction.BACK), new Surface(Color.GREEN, Direction.DOWN));
        rotationTest(yellowBackGreenDown, Move.LEFT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN);
        rotationTest(yellowBackGreenDown, Move.LEFT_INVERTED, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN);
        rotationTest(yellowBackGreenDown, Move.RIGHT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN);
        rotationTest(yellowBackGreenDown, Move.RIGHT_INVERTED, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN);
        rotationTest(yellowBackGreenDown, Move.BACK, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.UP, Direction.BACK, Direction.LEFT);
        rotationTest(yellowBackGreenDown, Move.BACK_INVERTED, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.UP, Direction.BACK, Direction.RIGHT);
        rotationTest(yellowBackGreenDown, Move.FRONT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN);
        rotationTest(yellowBackGreenDown, Move.FRONT_INVERTED, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN);
        rotationTest(yellowBackGreenDown, Move.UP, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN);
        rotationTest(yellowBackGreenDown, Move.UP_INVERTED, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN);
        rotationTest(yellowBackGreenDown, Move.DOWN, Direction.BACK, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.RIGHT, Direction.DOWN);
        rotationTest(yellowBackGreenDown, Move.DOWN_INVERTED, Direction.BACK, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.LEFT, Direction.DOWN);
    }

}