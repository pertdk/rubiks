package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.enums.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static dk.pert.rubiks.rubiksmodel.ErrorMessages.*;

/**
 * AbstractPiece is parent to all types of pieces in the Rubik's Cube.
 * The AbstractPiece class contains attributes and methods that are common to all types of pieces,
 * and implements some default methods for the IPiece interface
 *
 * @author PET@nykredit.dk
 */

public abstract class AbstractPiece implements IPiece {
    protected List<ISurface> surfaces;

    protected AbstractPiece(ISurface @NotNull ... surfaces) throws IllegalArgumentException {
        checkNumberOfSurfaces(surfaces);
        checkUniqueColors(surfaces);
        checkUniqueDirections(surfaces);
        this.surfaces = Arrays.stream(surfaces).toList();
    }

    private static void checkNumberOfSurfaces(ISurface @NotNull ... surfaces) {
        if (surfaces.length < 1 || surfaces.length > 3) {
            throw new IllegalArgumentException(String.format(ILLEGAL_NUMBER_OF_SURFACES_FORMAT, surfaces.length));
        }
    }

    private static void checkUniqueColors(ISurface @NotNull ... surfaces) {
        for (Color color : Color.values()) {
            if (Arrays.stream(surfaces).filter(surface -> surface.getColor() == color).count() > 1) {
                throw new IllegalArgumentException(NO_DUPLICATE_COLORS);
            }
        }
    }

    private static void checkUniqueDirections(ISurface @NotNull ... surfaces) {
        for (Direction direction : Direction.values()) {
            if (Arrays.stream(surfaces).filter(surface -> surface.getDirection() == direction).count() > 1) {
                throw new IllegalArgumentException(NO_DUPLICATE_DIRECTIONS);
            }
        }
    }


    @Override
    public ISurface getSurface(Direction direction) {
        return surfaces.stream()
                .filter(surface -> direction.equals(surface.getDirection()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean hasSurface(Direction direction) {
        return (this.getSurface(direction) != null);
    }

    /**
     * For simplicity's sake, it's just ignored if a nonexistent surface is attempted moved
     */
    @Override
    public void moveSurface(Direction before, Direction after) {
        ISurface surface = getSurface(before);
        if (surface != null) {
            surface.setDirection(after);
        }
    }

    @Override
    public void turnClockwiseAroundXAxis() {
        moveSurface(Direction.BACK, Direction.DOWN);
        moveSurface(Direction.DOWN, Direction.FRONT);
        moveSurface(Direction.FRONT, Direction.UP);
        moveSurface(Direction.UP, Direction.BACK);
    }

    @Override
    public void turnCounterclockwiseAroundXAxis() {
        moveSurface(Direction.BACK, Direction.UP);
        moveSurface(Direction.UP, Direction.FRONT);
        moveSurface(Direction.FRONT, Direction.DOWN);
        moveSurface(Direction.DOWN, Direction.BACK);
    }

    @Override
    public void turnClockwiseAroundYAxis() {
        moveSurface(Direction.LEFT, Direction.BACK);
        moveSurface(Direction.BACK, Direction.RIGHT);
        moveSurface(Direction.RIGHT, Direction.FRONT);
        moveSurface(Direction.FRONT, Direction.LEFT);
    }

    @Override
    public void turnCounterclockwiseAroundYAxis() {
        moveSurface(Direction.LEFT, Direction.FRONT);
        moveSurface(Direction.FRONT, Direction.RIGHT);
        moveSurface(Direction.RIGHT, Direction.BACK);
        moveSurface(Direction.BACK, Direction.LEFT);
    }

    @Override
    public void turnClockwiseAroundZAxis() {
        moveSurface(Direction.UP, Direction.RIGHT);
        moveSurface(Direction.RIGHT, Direction.DOWN);
        moveSurface(Direction.DOWN, Direction.LEFT);
        moveSurface(Direction.LEFT, Direction.UP);
    }

    @Override
    public void turnCounterclockwiseAroundZAxis() {
        moveSurface(Direction.UP, Direction.LEFT);
        moveSurface(Direction.LEFT, Direction.DOWN);
        moveSurface(Direction.DOWN, Direction.RIGHT);
        moveSurface(Direction.RIGHT, Direction.UP);
    }

    @Override
    public void moveLeft() {
        if (hasSurface(Direction.LEFT)) {
            turnClockwiseAroundXAxis();
        }
    }

    @Override
    public void moveLeftInverted() {
        if (hasSurface(Direction.LEFT)) {
            turnCounterclockwiseAroundXAxis();
        }
    }

    @Override
    public void moveRight() {
        if (hasSurface(Direction.RIGHT)) {
            turnCounterclockwiseAroundXAxis();
        }
    }

    @Override
    public void moveRightInverted() {
        if (hasSurface(Direction.RIGHT)) {
            turnClockwiseAroundXAxis();
        }
    }

    @Override
    public void moveUp() {
        if (hasSurface(Direction.UP)) {
            turnClockwiseAroundYAxis();
        }
    }


    @Override
    public void moveUpInverted() {
        if (hasSurface(Direction.UP)) {
            turnCounterclockwiseAroundYAxis();
        }
    }

    @Override
    public void moveDown() {
        if (hasSurface(Direction.DOWN)) {
            turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    public void moveDownInverted() {
        if (hasSurface(Direction.DOWN)) {
            turnClockwiseAroundYAxis();
        }
    }

    @Override
    public void moveFront() {
        if (hasSurface(Direction.FRONT)) {
            turnClockwiseAroundZAxis();
        }
    }

    @Override
    public void moveFrontInverted() {
        if (hasSurface(Direction.FRONT)) {
            turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    public void moveBack() {
        if (hasSurface(Direction.FRONT)) {
            turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    public void moveBackInverted() {
        if (hasSurface(Direction.FRONT)) {
            turnClockwiseAroundZAxis();
        }
    }


    @Override
    public void move(Move move) {
        switch (move) {
            case LEFT -> moveLeft();
            case LEFT_INVERTED -> moveLeftInverted();
            case RIGHT -> moveRight();
            case RIGHT_INVERTED -> moveRightInverted();
            case UP -> moveUp();
            case UP_INVERTED -> moveUpInverted();
            case DOWN -> moveDown();
            case DOWN_INVERTED -> moveDownInverted();
            case FRONT -> moveFront();
            case FRONT_INVERTED -> moveFrontInverted();
            case BACK -> moveBack();
            case BACK_INVERTED -> moveBackInverted();
        }
    }

    @Override
    public void turnClockwiseAround(Axis axis) {
        switch (axis) {
            case X -> turnClockwiseAroundXAxis();
            case Y -> turnClockwiseAroundYAxis();
            case Z -> turnClockwiseAroundZAxis();
        }
    }

    @Override
    public void turnCounterClockwiseAround(Axis axis) {
        switch (axis) {
            case X -> turnCounterclockwiseAroundXAxis();
            case Y -> turnCounterclockwiseAroundYAxis();
            case Z -> turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    public void turn(Turn turn, Axis axis) {
        switch (turn) {
            case CLOCK_WISE -> turnClockwiseAround(axis);
            case COUNTER_CLOCK_WISE -> turnCounterClockwiseAround(axis);
        }
    }

}
