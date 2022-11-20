package dk.pert.rubiks.rubiksmodel;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;


class TestCenterPiece {

    private static final Logger LOGGER = Logger.getLogger(TestCenterPiece.class);

    ArrayList<Direction> directions;
    ArrayList<Color> colors;

    @BeforeEach
    void beforeEach() {
        directions = new ArrayList<>(EnumSet.allOf(Direction.class));
        colors = new ArrayList<>(EnumSet.allOf(Color.class));
    }


    void move(Move move) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append(String.format("Move: %s\n", move));

        ArrayList<Direction> otherDirections = new ArrayList<>(EnumSet.allOf(Direction.class));
        ArrayList<Color> otherColors = new ArrayList<>(EnumSet.allOf(Color.class));

        int directionNo = 0;
        int colorNo = 0;

        while (directionNo < directions.size() && colorNo < colors.size()) {
            Direction currentDirection = directions.get(directionNo);
            Color currentColor = colors.get(colorNo);
            otherDirections.remove(directionNo);
            otherColors.remove(colorNo);

            logMessage.append(String.format("currentDirection: %s currentColor: %s\n", currentDirection, currentColor));

            CenterPiece centerPiece = new CenterPiece(currentDirection, currentColor);
            Color colorRetrieved = centerPiece.getSurface(currentDirection);
            Assertions.assertEquals(colorRetrieved, currentColor);

            centerPiece.move(move);
            Color movedColor = centerPiece.getSurface(currentDirection);
            Assertions.assertEquals(movedColor, currentColor);

            int otherDirectionNo = 0;
            int otherColorNo = 0;
            while (otherDirectionNo < otherDirections.size() && otherColorNo < otherColors.size()) {
                Direction otherDirection = otherDirections.get(otherDirectionNo);
                IllegalArgumentException thrown;
                thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> centerPiece.getSurface(otherDirection));
                logMessage.append(String.format("\t-- otherDirection: %s\n", otherDirection));
                Assertions.assertEquals(AbstractPiece.NO_SUCH_DIRECTION, thrown.getMessage());
                otherDirectionNo++;
                otherColorNo++;
            }

            otherDirections.add(directionNo, currentDirection);
            otherColors.add(colorNo, currentColor);
            directionNo++;
            colorNo++;
        }
        LOGGER.info(logMessage);
    }

    @Test
    void moveLeft() {
        move(Move.left);
    }

    @Test
    void moveLeftInverted() {
        move(Move.leftInverted);
    }

    @Test
    void moveRight() {
        move(Move.right);
    }

    @Test
    void moveRightInverted() {
        move(Move.rightInverted);
    }

    @Test
    void moveUp() {
        move(Move.up);
    }

    @Test
    void moveUpInverted() {
        move(Move.upInverted);
    }

    @Test
    void moveDown() {
        move(Move.down);
    }

    @Test
    void moveDownInverted() {
        move(Move.downInverted);
    }

    @Test
    void moveFront() {
        move(Move.front);
    }

    @Test
    void moveFrontInverted() {
        move(Move.frontInverted);
    }

    @Test
    void moveBack() {
        move(Move.back);
    }

    @Test
    void moveBackInverted() {
        move(Move.backInverted);
    }

    @Test
    void setSurface() {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("setSurface");

        ArrayList<Direction> otherDirections = new ArrayList<>(EnumSet.allOf(Direction.class));
        ArrayList<Color> otherColors = new ArrayList<>(EnumSet.allOf(Color.class));

        int directionNo = 0;
        int colorNo = 0;

        while (directionNo < directions.size() && colorNo < colors.size()) {
            Direction currentDirection = directions.get(directionNo);
            Color currentColor = colors.get(colorNo);
            otherDirections.remove(directionNo);
            otherColors.remove(colorNo);

            logMessage.append(String.format("currentDirection: %s currentColor: %s\n", currentDirection, currentColor));

            CenterPiece centerPiece = new CenterPiece(currentDirection, currentColor);
            Color colorRetrieved = centerPiece.getSurface(currentDirection);
            Assertions.assertEquals(colorRetrieved, currentColor);

            IllegalArgumentException thrownCurrent;
            thrownCurrent = Assertions.assertThrows(IllegalArgumentException.class, () -> centerPiece.setSurface(currentDirection, currentColor));
            Assertions.assertEquals(AbstractPiece.ALL_SURFACES_ALREADY_SET, thrownCurrent.getMessage());

            int otherDirectionNo = 0;
            int otherColorNo = 0;
            while (otherDirectionNo < otherDirections.size() && otherColorNo < otherColors.size()) {
                Direction otherDirection = otherDirections.get(otherDirectionNo);
                Color otherColor = otherColors.get(otherColorNo);
                IllegalArgumentException thrownOther;
                thrownOther = Assertions.assertThrows(IllegalArgumentException.class, () -> centerPiece.setSurface(otherDirection, otherColor));
                logMessage.append(String.format("\t-- otherDirection: %s\n", otherDirection));
                Assertions.assertEquals(AbstractPiece.ALL_SURFACES_ALREADY_SET, thrownOther.getMessage());
                otherDirectionNo++;
                otherColorNo++;
            }

            otherDirections.add(directionNo, currentDirection);
            otherColors.add(colorNo, currentColor);
            directionNo++;
            colorNo++;
        }
        LOGGER.info(logMessage);

    }
}