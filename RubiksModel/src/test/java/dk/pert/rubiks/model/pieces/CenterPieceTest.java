package dk.pert.rubiks.model.pieces;

import dk.pert.rubiks.model.Surface;
import dk.pert.rubiks.model.enums.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CenterPieceTest {


    private void testMove(@NotNull CenterPiece centerPiece, Direction currentDirection, Move move) {
        ArrayList<Direction> directions = new ArrayList<>(List.of(Direction.values()));
        directions.remove(currentDirection);
        assertTrue(centerPiece.hasSurface(currentDirection));
        for (int i = 0; i < 4; i++) {
            centerPiece.move(move);
            assertTrue(centerPiece.hasSurface(currentDirection));
            for (Direction other : directions) {
                assertFalse(centerPiece.hasSurface(other));
            }
        }
    }

    private void testTurn(CenterPiece centerPiece, Direction currentDirection, Turn turn, Axis axis) {
        ArrayList<Direction> directions = new ArrayList<>(List.of(Direction.values()));
        directions.remove(currentDirection);
        assertTrue(centerPiece.hasSurface(currentDirection));
        for (int i = 0; i < 4; i++) {
            centerPiece.turn(turn, axis);
            assertTrue(centerPiece.hasSurface(currentDirection));
            for (Direction other : directions) {
                assertFalse(centerPiece.hasSurface(other));
            }
        }

    }

    @Test
    void testMoves() {
        CenterPiece whiteFront = new CenterPiece(new Surface(Color.WHITE, Direction.FRONT));
        CenterPiece orangeLeft = new CenterPiece(new Surface(Color.ORANGE, Direction.LEFT));
        CenterPiece greenDown = new CenterPiece(new Surface(Color.GREEN, Direction.DOWN));
        CenterPiece blueUp = new CenterPiece(new Surface(Color.BLUE, Direction.UP));
        CenterPiece redRight = new CenterPiece(new Surface(Color.RED, Direction.RIGHT));
        CenterPiece yellowBack = new CenterPiece(new Surface(Color.YELLOW, Direction.BACK));

        ArrayList<Move> moves = new ArrayList<>(List.of(Move.values()));
        for (Move move : moves) {
            testMove(greenDown, Direction.DOWN, move);
            testMove(orangeLeft, Direction.LEFT, move);
            testMove(blueUp, Direction.UP, move);
            testMove(redRight, Direction.RIGHT, move);
            testMove(whiteFront, Direction.FRONT, move);
            testMove(yellowBack, Direction.BACK, move);
        }

    }

    @Test
    void testTurns() {
        CenterPiece whiteFront = new CenterPiece(new Surface(Color.WHITE, Direction.FRONT));
        CenterPiece orangeLeft = new CenterPiece(new Surface(Color.ORANGE, Direction.LEFT));
        CenterPiece greenDown = new CenterPiece(new Surface(Color.GREEN, Direction.DOWN));
        CenterPiece blueUp = new CenterPiece(new Surface(Color.BLUE, Direction.UP));
        CenterPiece redRight = new CenterPiece(new Surface(Color.RED, Direction.RIGHT));
        CenterPiece yellowBack = new CenterPiece(new Surface(Color.YELLOW, Direction.BACK));

        ArrayList<Turn> turns = new ArrayList<>(List.of(Turn.values()));
        ArrayList<Axis> axises = new ArrayList<>(List.of(Axis.values()));
        for (Turn turn : turns) {
            for (Axis axis : axises) {
                testTurn(greenDown, Direction.DOWN, turn, axis);
                testTurn(orangeLeft, Direction.LEFT, turn, axis);
                testTurn(blueUp, Direction.UP, turn, axis);
                testTurn(redRight, Direction.RIGHT, turn, axis);
                testTurn(whiteFront, Direction.FRONT, turn, axis);
                testTurn(yellowBack, Direction.BACK, turn, axis);
            }
        }

    }

}