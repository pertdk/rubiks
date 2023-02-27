package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.enums.Color;
import dk.pert.rubiks.rubiksmodel.enums.Direction;
import dk.pert.rubiks.rubiksmodel.enums.Move;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CenterPieceTest {

    private static final Logger LOGGER = Logger.getLogger(CenterPieceTest.class);

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
            assertEquals(colorRetrieved, currentColor);

            centerPiece.move(move);
            Color movedColor = centerPiece.getSurface(currentDirection);
            assertEquals(movedColor, currentColor);

            int otherDirectionNo = 0;
            int otherColorNo = 0;
            while (otherDirectionNo < otherDirections.size() && otherColorNo < otherColors.size()) {
                Direction otherDirection = otherDirections.get(otherDirectionNo);
                IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> centerPiece.getSurface(otherDirection));
                logMessage.append(String.format("\t-- otherDirection: %s\n", otherDirection));
                assertEquals(AbstractPiece.NO_SUCH_DIRECTION, thrown.getMessage());
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
        move(Move.LEFT);
    }

    @Test
    void moveLeftInverted() {
        move(Move.LEFT_INVERTED);
    }

    @Test
    void moveRight() {
        move(Move.RIGHT);
    }

    @Test
    void moveRightInverted() {
        move(Move.RIGHT_INVERTED);
    }

    @Test
    void moveUp() {
        move(Move.UP);
    }

    @Test
    void moveUpInverted() {
        move(Move.UP_INVERTED);
    }

    @Test
    void moveDown() {
        move(Move.DOWN);
    }

    @Test
    void moveDownInverted() {
        move(Move.DOWN_INVERTED);
    }

    @Test
    void moveFront() {
        move(Move.FRONT);
    }

    @Test
    void moveFrontInverted() {
        move(Move.FRONT_INVERTED);
    }

    @Test
    void moveBack() {
        move(Move.BACK);
    }

    @Test
    void moveBackInverted() {
        move(Move.BACK_INVERTED);
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
            assertEquals(colorRetrieved, currentColor);

            IllegalArgumentException thrownCurrent;
            thrownCurrent = assertThrows(IllegalArgumentException.class, () -> centerPiece.setSurface(currentDirection, currentColor));
            assertEquals(AbstractPiece.ALL_SURFACES_ALREADY_SET, thrownCurrent.getMessage());

            int otherDirectionNo = 0;
            int otherColorNo = 0;
            while (otherDirectionNo < otherDirections.size() && otherColorNo < otherColors.size()) {
                Direction otherDirection = otherDirections.get(otherDirectionNo);
                Color otherColor = otherColors.get(otherColorNo);
                IllegalArgumentException thrownOther;
                thrownOther = assertThrows(IllegalArgumentException.class, () -> centerPiece.setSurface(otherDirection, otherColor));
                logMessage.append(String.format("\t-- otherDirection: %s\n", otherDirection));
                assertEquals(AbstractPiece.ALL_SURFACES_ALREADY_SET, thrownOther.getMessage());
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