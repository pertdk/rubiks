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
        directions = new ArrayList<>();
        directions.addAll(EnumSet.allOf(Direction.class));
        colors = new ArrayList<>();
        colors.addAll(EnumSet.allOf(Color.class));
    }


    @Test
    void moveLeft() {
        StringBuilder logMessage = new StringBuilder();
        ArrayList<Direction> otherDirections = new ArrayList<>(EnumSet.allOf(Direction.class));
        ArrayList<Color> otherColors = new ArrayList<>(EnumSet.allOf(Color.class));

        int directionNo = 0;
        int colorNo = 0;
        while (directionNo < directions.size() && colorNo < colors.size()) {
            Direction currentDirection = directions.get(directionNo);
            Color currentColor = colors.get(colorNo);
            otherDirections.remove(directionNo);
            otherColors.remove(colorNo);
            logMessage.append(String.format("currentColor: %s currentDirection: %s\n", currentColor, currentDirection));

            CenterPiece centerPiece = new CenterPiece(currentDirection, currentColor);
            Color colorRetrieved = centerPiece.getSurface(currentDirection);
            Assertions.assertEquals(colorRetrieved, currentColor);

            centerPiece.moveLeft();
            int otherDirectionNo = 0;
            int otherColorNo = 0;
            while (otherDirectionNo < otherDirections.size() && otherColorNo < otherColors.size()) {
                Direction otherDirection = otherDirections.get(otherDirectionNo);
                IllegalArgumentException thrown;
                thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> centerPiece.getSurface(otherDirection));
                logMessage.append(String.format("\t-- otherDirection: %s\n", otherDirection));
                Assertions.assertEquals("No such direction set in this piece.", thrown.getMessage());
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