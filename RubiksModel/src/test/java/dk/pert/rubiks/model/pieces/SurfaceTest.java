package dk.pert.rubiks.model.pieces;

import dk.pert.rubiks.model.Surface;
import dk.pert.rubiks.model.enums.Color;
import dk.pert.rubiks.model.enums.Direction;
import dk.pert.rubiks.model.enums.Move;
import dk.pert.rubiks.model.interfaces.IPiece;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SurfaceTest {

    private void rotationTest(@NotNull Surface surface, Move move, Direction @NotNull ... expectations) {
        Direction before = surface.getDirection();
        for (Direction expected : expectations) {
            surface.move(move);
            assertEquals(expected, surface.getDirection());
        }
        surface.move(move);
        assertEquals(before, surface.getDirection());
    }

    @Test
    void testMove() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface orangeLeft = new Surface(Color.ORANGE, Direction.LEFT);
        Surface redRight = new Surface(Color.RED, Direction.RIGHT);
        rotationTest(greenDown, Move.LEFT, Direction.BACK, Direction.UP, Direction.FRONT);
        rotationTest(orangeLeft, Move.LEFT, Direction.LEFT, Direction.LEFT, Direction.LEFT);
        rotationTest(redRight, Move.LEFT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT);
    }

    @Test
    void testMoveLeftInverted() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface orangeLeft = new Surface(Color.ORANGE, Direction.LEFT);
        Surface redRight = new Surface(Color.RED, Direction.RIGHT);
        rotationTest(greenDown, Move.LEFT_INVERTED, Direction.FRONT, Direction.UP, Direction.BACK);
        rotationTest(orangeLeft, Move.LEFT_INVERTED, Direction.LEFT, Direction.LEFT, Direction.LEFT);
        rotationTest(redRight, Move.LEFT_INVERTED, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT);
    }

    @Test
    void testMoveRight() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface orangeLeft = new Surface(Color.ORANGE, Direction.LEFT);
        Surface redRight = new Surface(Color.RED, Direction.RIGHT);
        rotationTest(greenDown, Move.RIGHT, Direction.FRONT, Direction.UP, Direction.BACK);
        rotationTest(orangeLeft, Move.RIGHT, Direction.LEFT, Direction.LEFT, Direction.LEFT);
        rotationTest(redRight, Move.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT);
    }

    @Test
    void testMoveRightInverted() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface orangeLeft = new Surface(Color.ORANGE, Direction.LEFT);
        Surface redRight = new Surface(Color.RED, Direction.RIGHT);
        rotationTest(greenDown, Move.RIGHT_INVERTED, Direction.BACK, Direction.UP, Direction.FRONT);
        rotationTest(orangeLeft, Move.RIGHT_INVERTED, Direction.LEFT, Direction.LEFT, Direction.LEFT);
        rotationTest(redRight, Move.RIGHT_INVERTED, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT);
    }

    @Test
    void testMoveFront() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface yellowBack = new Surface(Color.YELLOW, Direction.BACK);
        Surface whiteFront = new Surface(Color.WHITE, Direction.FRONT);
        rotationTest(greenDown, Move.FRONT, Direction.LEFT, Direction.UP, Direction.RIGHT);
        rotationTest(yellowBack, Move.FRONT, Direction.BACK, Direction.BACK, Direction.BACK);
        rotationTest(whiteFront, Move.FRONT, Direction.FRONT, Direction.FRONT, Direction.FRONT);
    }

    @Test
    void testMoveFrontInverted() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface yellowBack = new Surface(Color.YELLOW, Direction.BACK);
        Surface whiteFront = new Surface(Color.WHITE, Direction.FRONT);
        rotationTest(greenDown, Move.FRONT_INVERTED, Direction.RIGHT, Direction.UP, Direction.LEFT);
        rotationTest(yellowBack, Move.FRONT_INVERTED, Direction.BACK, Direction.BACK, Direction.BACK);
        rotationTest(whiteFront, Move.FRONT_INVERTED, Direction.FRONT, Direction.FRONT, Direction.FRONT);
    }

    @Test
    void testMoveBack() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface yellowBack = new Surface(Color.YELLOW, Direction.BACK);
        Surface whiteFront = new Surface(Color.WHITE, Direction.FRONT);
        rotationTest(greenDown, Move.BACK, Direction.RIGHT, Direction.UP, Direction.LEFT);
        rotationTest(yellowBack, Move.BACK, Direction.BACK, Direction.BACK, Direction.BACK);
        rotationTest(whiteFront, Move.BACK, Direction.FRONT, Direction.FRONT, Direction.FRONT);
    }

    @Test
    void testMoveBackInverted() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface yellowBack = new Surface(Color.YELLOW, Direction.BACK);
        Surface whiteFront = new Surface(Color.WHITE, Direction.FRONT);
        rotationTest(greenDown, Move.BACK_INVERTED, Direction.LEFT, Direction.UP, Direction.RIGHT);
        rotationTest(yellowBack, Move.BACK_INVERTED, Direction.BACK, Direction.BACK, Direction.BACK);
        rotationTest(whiteFront, Move.BACK_INVERTED, Direction.FRONT, Direction.FRONT, Direction.FRONT);
    }

    @Test
    void testMoveUp() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface blueUp = new Surface(Color.BLUE, Direction.UP);
        Surface orangeLeft = new Surface(Color.ORANGE, Direction.LEFT);
        rotationTest(orangeLeft, Move.UP, Direction.BACK, Direction.RIGHT, Direction.FRONT);
        rotationTest(greenDown, Move.UP, Direction.DOWN, Direction.DOWN, Direction.DOWN);
        rotationTest(blueUp, Move.UP, Direction.UP, Direction.UP, Direction.UP);
    }

    @Test
    void testMoveUpInverted() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface blueUp = new Surface(Color.BLUE, Direction.UP);
        Surface orangeLeft = new Surface(Color.ORANGE, Direction.LEFT);
        rotationTest(orangeLeft, Move.UP_INVERTED, Direction.FRONT, Direction.RIGHT, Direction.BACK);
        rotationTest(greenDown, Move.UP_INVERTED, Direction.DOWN, Direction.DOWN, Direction.DOWN);
        rotationTest(blueUp, Move.UP_INVERTED, Direction.UP, Direction.UP, Direction.UP);
    }

    @Test
    void testMoveDown() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface blueUp = new Surface(Color.BLUE, Direction.UP);
        Surface orangeLeft = new Surface(Color.ORANGE, Direction.LEFT);
        rotationTest(orangeLeft, Move.DOWN, Direction.FRONT, Direction.RIGHT, Direction.BACK);
        rotationTest(greenDown, Move.DOWN, Direction.DOWN, Direction.DOWN, Direction.DOWN);
        rotationTest(blueUp, Move.DOWN, Direction.UP, Direction.UP, Direction.UP);
    }

    @Test
    void testMoveDownInverted() {
        Surface greenDown = new Surface(Color.GREEN, Direction.DOWN);
        Surface blueUp = new Surface(Color.BLUE, Direction.UP);
        Surface orangeLeft = new Surface(Color.ORANGE, Direction.LEFT);

        rotationTest(orangeLeft, Move.DOWN_INVERTED, Direction.BACK, Direction.RIGHT, Direction.FRONT);
        rotationTest(greenDown, Move.DOWN_INVERTED, Direction.DOWN, Direction.DOWN, Direction.DOWN);
        rotationTest(blueUp, Move.DOWN_INVERTED, Direction.UP, Direction.UP, Direction.UP);
    }


    @Test
    void testEquals() {
        Surface greenDown1 = new Surface(Color.GREEN, Direction.DOWN);
        Surface greenDown2 = new Surface(Color.GREEN, Direction.DOWN);
        IPiece piece = Mockito.mock(IPiece.class);

        assertEquals(greenDown1, greenDown1);
        assertNotEquals(greenDown1, null);
        //noinspection SimplifiableAssertion,EqualsBetweenInconvertibleTypes
        assertFalse(greenDown1.equals(piece));
        assertEquals(greenDown1, greenDown2);
    }

}