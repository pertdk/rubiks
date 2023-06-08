package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.enums.Color;
import dk.pert.rubiks.rubiksmodel.enums.Direction;
import dk.pert.rubiks.rubiksmodel.enums.Move;
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
    void testWhiteUpOrangeLeft() {
        EdgePiece whiteUpOrangeLeft = new EdgePiece(new Surface(Color.WHITE, Direction.UP), new Surface(Color.ORANGE, Direction.LEFT));
        rotationTest(whiteUpOrangeLeft, Move.LEFT, Direction.UP, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.BACK, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.LEFT_INVERTED, Direction.UP, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.FRONT, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.RIGHT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.RIGHT_INVERTED, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.BACK, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.BACK_INVERTED, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.FRONT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.FRONT_INVERTED, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.DOWN, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.DOWN_INVERTED, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpOrangeLeft, Move.UP, Direction.UP, Direction.LEFT, Direction.UP, Direction.BACK, Direction.UP, Direction.RIGHT, Direction.UP, Direction.FRONT);
        rotationTest(whiteUpOrangeLeft, Move.UP_INVERTED, Direction.UP, Direction.LEFT, Direction.UP, Direction.FRONT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.BACK);
    }

    @Test
    void testWhiteUpBlueBack() {
        EdgePiece whiteUpBlueBack = new EdgePiece(new Surface(Color.WHITE, Direction.UP), new Surface(Color.BLUE, Direction.BACK));
        rotationTest(whiteUpBlueBack, Move.LEFT, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(whiteUpBlueBack, Move.LEFT_INVERTED, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(whiteUpBlueBack, Move.RIGHT, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(whiteUpBlueBack, Move.RIGHT_INVERTED, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(whiteUpBlueBack, Move.BACK, Direction.UP, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(whiteUpBlueBack, Move.BACK_INVERTED, Direction.UP, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(whiteUpBlueBack, Move.FRONT, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(whiteUpBlueBack, Move.FRONT_INVERTED, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(whiteUpBlueBack, Move.UP, Direction.UP, Direction.BACK, Direction.UP, Direction.RIGHT, Direction.UP, Direction.FRONT, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpBlueBack, Move.UP_INVERTED, Direction.UP, Direction.BACK, Direction.UP, Direction.LEFT, Direction.UP, Direction.FRONT, Direction.UP, Direction.RIGHT);
        rotationTest(whiteUpBlueBack, Move.DOWN, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(whiteUpBlueBack, Move.DOWN_INVERTED, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK, Direction.UP, Direction.BACK);
    }

    @Test
    void testWhiteUpRedRight() {
        EdgePiece whiteUpRedRight = new EdgePiece(new Surface(Color.WHITE, Direction.UP), new Surface(Color.RED, Direction.RIGHT));
        rotationTest(whiteUpRedRight, Move.LEFT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT);
        rotationTest(whiteUpRedRight, Move.LEFT_INVERTED, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT);
        rotationTest(whiteUpRedRight, Move.RIGHT, Direction.UP, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
        rotationTest(whiteUpRedRight, Move.RIGHT_INVERTED, Direction.UP, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.BACK, Direction.RIGHT);
        rotationTest(whiteUpRedRight, Move.BACK, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT);
        rotationTest(whiteUpRedRight, Move.BACK_INVERTED, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT);
        rotationTest(whiteUpRedRight, Move.FRONT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT);
        rotationTest(whiteUpRedRight, Move.FRONT_INVERTED, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT);
        rotationTest(whiteUpRedRight, Move.UP, Direction.UP, Direction.RIGHT, Direction.UP, Direction.FRONT, Direction.UP, Direction.LEFT, Direction.UP, Direction.BACK);
        rotationTest(whiteUpRedRight, Move.UP_INVERTED, Direction.UP, Direction.RIGHT, Direction.UP, Direction.BACK, Direction.UP, Direction.LEFT, Direction.UP, Direction.FRONT);
        rotationTest(whiteUpRedRight, Move.DOWN, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT);
        rotationTest(whiteUpRedRight, Move.DOWN_INVERTED, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.RIGHT);
    }

    @Test
    void testWhiteUpGreenFront() {
        EdgePiece whiteUpGreenFront = new EdgePiece(new Surface(Color.WHITE, Direction.UP), new Surface(Color.GREEN, Direction.FRONT));
        rotationTest(whiteUpGreenFront, Move.LEFT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT);
        rotationTest(whiteUpGreenFront, Move.LEFT_INVERTED, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT);
        rotationTest(whiteUpGreenFront, Move.RIGHT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT);
        rotationTest(whiteUpGreenFront, Move.RIGHT_INVERTED, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT);
        rotationTest(whiteUpGreenFront, Move.BACK, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT);
        rotationTest(whiteUpGreenFront, Move.BACK_INVERTED, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT);
        rotationTest(whiteUpGreenFront, Move.FRONT, Direction.UP, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.LEFT, Direction.FRONT);
        rotationTest(whiteUpGreenFront, Move.FRONT_INVERTED, Direction.UP, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
        rotationTest(whiteUpGreenFront, Move.UP, Direction.UP, Direction.FRONT, Direction.UP, Direction.LEFT, Direction.UP, Direction.BACK, Direction.UP, Direction.RIGHT);
        rotationTest(whiteUpGreenFront, Move.UP_INVERTED, Direction.UP, Direction.FRONT, Direction.UP, Direction.RIGHT, Direction.UP, Direction.BACK, Direction.UP, Direction.LEFT);
        rotationTest(whiteUpGreenFront, Move.DOWN, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT);
        rotationTest(whiteUpGreenFront, Move.DOWN_INVERTED, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.UP, Direction.FRONT);
    }

    @Test
    void testOrangeLeftGreenFront() {
        EdgePiece orangeLeftGreenFront = new EdgePiece(new Surface(Color.ORANGE, Direction.LEFT), new Surface(Color.GREEN, Direction.FRONT));
        rotationTest(orangeLeftGreenFront, Move.LEFT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftGreenFront, Move.LEFT_INVERTED, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftGreenFront, Move.RIGHT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT);
        rotationTest(orangeLeftGreenFront, Move.RIGHT_INVERTED, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT);
        rotationTest(orangeLeftGreenFront, Move.BACK, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT);
        rotationTest(orangeLeftGreenFront, Move.BACK_INVERTED, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT);
        rotationTest(orangeLeftGreenFront, Move.FRONT, Direction.LEFT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.DOWN, Direction.FRONT);
        rotationTest(orangeLeftGreenFront, Move.FRONT_INVERTED, Direction.LEFT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.UP, Direction.FRONT);
        rotationTest(orangeLeftGreenFront, Move.UP, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT);
        rotationTest(orangeLeftGreenFront, Move.UP_INVERTED, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT);
        rotationTest(orangeLeftGreenFront, Move.DOWN, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT);
        rotationTest(orangeLeftGreenFront, Move.DOWN_INVERTED, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.FRONT);
    }

    @Test
    void testOrangeLeftBlueBack() {
        EdgePiece orangeLeftBlueBack = new EdgePiece(new Surface(Color.ORANGE, Direction.LEFT), new Surface(Color.BLUE, Direction.BACK));
        rotationTest(orangeLeftBlueBack, Move.LEFT, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.DOWN);
        rotationTest(orangeLeftBlueBack, Move.LEFT_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.UP);
        rotationTest(orangeLeftBlueBack, Move.RIGHT, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftBlueBack, Move.RIGHT_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftBlueBack, Move.BACK, Direction.LEFT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(orangeLeftBlueBack, Move.BACK_INVERTED, Direction.LEFT, Direction.BACK, Direction.UP, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(orangeLeftBlueBack, Move.FRONT, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftBlueBack, Move.FRONT_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftBlueBack, Move.UP, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftBlueBack, Move.UP_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftBlueBack, Move.DOWN, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(orangeLeftBlueBack, Move.DOWN_INVERTED, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.BACK);
    }

    @Test
    void testRedRightBlueBack() {
        EdgePiece redRightBlueBack = new EdgePiece(new Surface(Color.RED, Direction.RIGHT), new Surface(Color.BLUE, Direction.BACK));
        rotationTest(redRightBlueBack, Move.LEFT, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightBlueBack, Move.LEFT_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightBlueBack, Move.RIGHT, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.UP);
        rotationTest(redRightBlueBack, Move.RIGHT_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightBlueBack, Move.BACK, Direction.RIGHT, Direction.BACK, Direction.UP, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(redRightBlueBack, Move.BACK_INVERTED, Direction.RIGHT, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.UP, Direction.BACK);
        rotationTest(redRightBlueBack, Move.FRONT, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightBlueBack, Move.FRONT_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightBlueBack, Move.UP, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightBlueBack, Move.UP_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightBlueBack, Move.DOWN, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(redRightBlueBack, Move.DOWN_INVERTED, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.BACK);
    }

    @Test
    void testRedRightGreenFront() {
        EdgePiece redRightGreenFront = new EdgePiece(new Surface(Color.RED, Direction.RIGHT), new Surface(Color.GREEN, Direction.FRONT));
        rotationTest(redRightGreenFront, Move.LEFT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
        rotationTest(redRightGreenFront, Move.LEFT_INVERTED, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
        rotationTest(redRightGreenFront, Move.RIGHT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.DOWN);
        rotationTest(redRightGreenFront, Move.RIGHT_INVERTED, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.UP);
        rotationTest(redRightGreenFront, Move.BACK, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
        rotationTest(redRightGreenFront, Move.BACK_INVERTED, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
        rotationTest(redRightGreenFront, Move.FRONT, Direction.RIGHT, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.UP, Direction.FRONT);
        rotationTest(redRightGreenFront, Move.FRONT_INVERTED, Direction.RIGHT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.DOWN, Direction.FRONT);
        rotationTest(redRightGreenFront, Move.UP, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
        rotationTest(redRightGreenFront, Move.UP_INVERTED, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
        rotationTest(redRightGreenFront, Move.DOWN, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
        rotationTest(redRightGreenFront, Move.DOWN_INVERTED, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
    }

    @Test
    void testYellowDownOrangeLeft() {
        EdgePiece yellowDownOrangeLeft = new EdgePiece(new Surface(Color.YELLOW, Direction.DOWN), new Surface(Color.ORANGE, Direction.LEFT));
        rotationTest(yellowDownOrangeLeft, Move.LEFT, Direction.DOWN, Direction.LEFT, Direction.BACK, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.FRONT, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.LEFT_INVERTED, Direction.DOWN, Direction.LEFT, Direction.FRONT, Direction.LEFT, Direction.UP, Direction.LEFT, Direction.BACK, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.RIGHT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.RIGHT_INVERTED, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.BACK, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.BACK_INVERTED, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.FRONT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.FRONT_INVERTED, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.UP, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.UP_INVERTED, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.LEFT);
        rotationTest(yellowDownOrangeLeft, Move.DOWN, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.BACK);
        rotationTest(yellowDownOrangeLeft, Move.DOWN_INVERTED, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.FRONT);
    }

    @Test
    void testYellowDownBlueBack() {
        EdgePiece yellowDownBlueBack = new EdgePiece(new Surface(Color.YELLOW, Direction.DOWN), new Surface(Color.BLUE, Direction.BACK));
        rotationTest(yellowDownBlueBack, Move.LEFT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.LEFT_INVERTED, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.RIGHT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.RIGHT_INVERTED, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.BACK, Direction.DOWN, Direction.BACK, Direction.RIGHT, Direction.BACK, Direction.UP, Direction.BACK, Direction.LEFT, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.BACK_INVERTED, Direction.DOWN, Direction.BACK, Direction.LEFT, Direction.BACK, Direction.UP, Direction.BACK, Direction.RIGHT, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.FRONT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.FRONT_INVERTED, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.UP, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.UP_INVERTED, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.BACK);
        rotationTest(yellowDownBlueBack, Move.DOWN, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.RIGHT);
        rotationTest(yellowDownBlueBack, Move.DOWN_INVERTED, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.LEFT);
    }

    @Test
    void testYellowDownRedRight() {
        EdgePiece yellowDownRedRight = new EdgePiece(new Surface(Color.YELLOW, Direction.DOWN), new Surface(Color.RED, Direction.RIGHT));
        rotationTest(yellowDownRedRight, Move.LEFT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.LEFT_INVERTED, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.FRONT, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.BACK, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.RIGHT_INVERTED, Direction.DOWN, Direction.RIGHT, Direction.BACK, Direction.RIGHT, Direction.UP, Direction.RIGHT, Direction.FRONT, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.BACK, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.BACK_INVERTED, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.FRONT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.FRONT_INVERTED, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.UP, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.UP_INVERTED, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        rotationTest(yellowDownRedRight, Move.DOWN, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.FRONT);
        rotationTest(yellowDownRedRight, Move.DOWN_INVERTED, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.BACK);
    }

    @Test
    void testYellowDownGreenFront() {
        EdgePiece yellowDownGreenFront = new EdgePiece(new Surface(Color.YELLOW, Direction.DOWN), new Surface(Color.GREEN, Direction.FRONT));
        rotationTest(yellowDownGreenFront, Move.LEFT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT);
        rotationTest(yellowDownGreenFront, Move.LEFT_INVERTED, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT);
        rotationTest(yellowDownGreenFront, Move.RIGHT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT);
        rotationTest(yellowDownGreenFront, Move.RIGHT_INVERTED, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT);
        rotationTest(yellowDownGreenFront, Move.BACK, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT);
        rotationTest(yellowDownGreenFront, Move.BACK_INVERTED, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.FRONT);
        rotationTest(yellowDownGreenFront, Move.FRONT, Direction.DOWN, Direction.FRONT, Direction.LEFT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.RIGHT, Direction.FRONT);
        rotationTest(yellowDownGreenFront, Move.FRONT_INVERTED, Direction.DOWN, Direction.FRONT, Direction.RIGHT, Direction.FRONT, Direction.UP, Direction.FRONT, Direction.LEFT, Direction.FRONT);
        rotationTest(yellowDownGreenFront, Move.DOWN, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.LEFT);
        rotationTest(yellowDownGreenFront, Move.DOWN_INVERTED, Direction.DOWN, Direction.FRONT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.BACK, Direction.DOWN, Direction.RIGHT);
    }

}