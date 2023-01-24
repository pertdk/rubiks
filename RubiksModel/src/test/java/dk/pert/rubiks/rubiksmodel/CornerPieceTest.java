package dk.pert.rubiks.rubiksmodel;

import org.junit.jupiter.api.Test;

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

    @Test
    void testTurnTopLeftFrontAroundXAxis() {

        Color topColorBefore = topLeftFront.getSurface(Direction.up);
        assertEquals(Color.top, topColorBefore);
        Color leftColorBefore = topLeftFront.getSurface(Direction.left);
        assertEquals(Color.left, leftColorBefore);
        Color frontColorBefore = topLeftFront.getSurface(Direction.front);
        assertEquals(Color.front, frontColorBefore);

        IllegalArgumentException downExceptionBefore = assertThrows(IllegalArgumentException.class, () -> topLeftFront.getSurface(Direction.down));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, downExceptionBefore.getMessage());
        IllegalArgumentException rightExceptionBefore = assertThrows(IllegalArgumentException.class, () -> topLeftFront.getSurface(Direction.right));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, rightExceptionBefore.getMessage());
        IllegalArgumentException backExceptionBefore = assertThrows(IllegalArgumentException.class, () -> topLeftFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionBefore.getMessage());

        /*
        topLeftFront --> frontLeftBottom
         */
        topLeftFront.turnClockwiseAroundXAxis();

        Color frontColorBetween = topLeftFront.getSurface(Direction.front);
        assertEquals(Color.top, frontColorBetween);
        Color leftColorBetween = topLeftFront.getSurface(Direction.left);
        assertEquals(Color.left, leftColorBetween);
        Color bottomColorBetween = topLeftFront.getSurface(Direction.down);
        assertEquals(Color.front, bottomColorBetween);

        IllegalArgumentException upExceptionBetween = assertThrows(IllegalArgumentException.class, () -> topLeftFront.getSurface(Direction.up));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, upExceptionBetween.getMessage());
        IllegalArgumentException rightExceptionBetween = assertThrows(IllegalArgumentException.class, () -> topLeftFront.getSurface(Direction.right));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, rightExceptionBetween.getMessage());
        IllegalArgumentException backExceptionBetween = assertThrows(IllegalArgumentException.class, () -> topLeftFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionBetween.getMessage());

        /*
            frontLeftBottom --> topLeftFront
         */
        topLeftFront.turnCounterClockwiseAroundXAxis();

        Color topColorAfter = topLeftFront.getSurface(Direction.up);
        assertEquals(Color.top, topColorAfter);
        Color leftColorAfter = topLeftFront.getSurface(Direction.left);
        assertEquals(Color.left, leftColorAfter);
        Color frontColorAfter = topLeftFront.getSurface(Direction.front);
        assertEquals(Color.front, frontColorAfter);

        IllegalArgumentException downExceptionAfter = assertThrows(IllegalArgumentException.class, () -> topLeftFront.getSurface(Direction.down));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, downExceptionAfter.getMessage());
        IllegalArgumentException rightExceptionAfter = assertThrows(IllegalArgumentException.class, () -> topLeftFront.getSurface(Direction.right));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, rightExceptionAfter.getMessage());
        IllegalArgumentException backExceptionAfter = assertThrows(IllegalArgumentException.class, () -> topLeftFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionAfter.getMessage());

    }

    @Test
    void testTurnBottomLeftFrontAroundXAxis() {
        Color bottomColorBefore = bottomLeftFront.getSurface(Direction.down);
        assertEquals(Color.bottom, bottomColorBefore);
        Color leftColorBefore = bottomLeftFront.getSurface(Direction.left);
        assertEquals(Color.left, leftColorBefore);
        Color frontColorBefore = bottomLeftFront.getSurface(Direction.front);
        assertEquals(Color.front, frontColorBefore);

        IllegalArgumentException upExceptionBefore = assertThrows(IllegalArgumentException.class, () -> bottomLeftFront.getSurface(Direction.up));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, upExceptionBefore.getMessage());
        IllegalArgumentException rightExceptionBefore = assertThrows(IllegalArgumentException.class, () -> bottomLeftFront.getSurface(Direction.right));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, rightExceptionBefore.getMessage());
        IllegalArgumentException backExceptionBefore = assertThrows(IllegalArgumentException.class, () -> bottomLeftFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionBefore.getMessage());

        /*
            bottomLeftFront --> backLeftDown
         */
        bottomLeftFront.turnClockwiseAroundXAxis();

        Color backColorBetween = bottomLeftFront.getSurface(Direction.back);
        assertEquals(Color.bottom, backColorBetween);
        Color leftColorBetween = bottomLeftFront.getSurface(Direction.left);
        assertEquals(Color.left, leftColorBetween);
        Color bottomColorBetween = bottomLeftFront.getSurface(Direction.down);
        assertEquals(Color.front, bottomColorBetween);

        IllegalArgumentException frontExceptionBetween = assertThrows(IllegalArgumentException.class, () -> bottomLeftFront.getSurface(Direction.front));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, frontExceptionBetween.getMessage());
        IllegalArgumentException rightExceptionBetween = assertThrows(IllegalArgumentException.class, () -> bottomLeftFront.getSurface(Direction.right));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, rightExceptionBetween.getMessage());
        IllegalArgumentException upExceptionBetween = assertThrows(IllegalArgumentException.class, () -> bottomLeftFront.getSurface(Direction.up));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, upExceptionBetween.getMessage());

        /*
            backLeftDown --> bottomLeftFront
         */
        bottomLeftFront.turnCounterClockwiseAroundXAxis();

        Color bottomColorAfter = bottomLeftFront.getSurface(Direction.down);
        assertEquals(Color.bottom, bottomColorAfter);
        Color leftColorAfter = bottomLeftFront.getSurface(Direction.left);
        assertEquals(Color.left, leftColorAfter);
        Color frontColorAfter = bottomLeftFront.getSurface(Direction.front);
        assertEquals(Color.front, frontColorAfter);

        IllegalArgumentException upExceptionAfter = assertThrows(IllegalArgumentException.class, () -> bottomLeftFront.getSurface(Direction.up));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, upExceptionAfter.getMessage());
        IllegalArgumentException rightExceptionAfter = assertThrows(IllegalArgumentException.class, () -> bottomLeftFront.getSurface(Direction.right));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, rightExceptionAfter.getMessage());
        IllegalArgumentException backExceptionAfter = assertThrows(IllegalArgumentException.class, () -> bottomLeftFront.getSurface(Direction.back));
        assertEquals(AbstractPiece.NO_SUCH_DIRECTION, backExceptionAfter.getMessage());
    }

    @Test
    void testTurnTopRightFrontAroundXAxis() {
        Color topColorBefore = topRightFront.getSurface(Direction.up);
        assertEquals(Color.top, topColorBefore);
        Color rightColorBefore = topRightFront.getSurface(Direction.right);
        assertEquals(Color.right, rightColorBefore);
        Color frontColorBefore = topRightFront.getSurface(Direction.front);
        assertEquals(Color.front, frontColorBefore);

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
        topRightFront.turnCounterClockwiseAroundXAxis();

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
        bottomRightFront.turnCounterClockwiseAroundXAxis();

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