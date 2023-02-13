package dk.pert.rubiks.rubiksmodel;

import java.util.HashMap;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

public abstract class AbstractPiece {
    public static final String ILLEGAL_NUMBER_OF_SURFACES_FORMAT = "Illegal number of surfaces: %o. Must be 1,2 or 3.";
    public static final String ALL_SURFACES_ALREADY_SET = "All surfaces are already set.";
    public static final String ONE_PIECE_ONE_COLOR = "A piece can only have one color in each direction.";
    public static final String EACH_DIR_SEPARATE_COLOR = "Each direction must have a separate color.";
    public static final String NO_SUCH_DIRECTION = "No such direction set in this piece.";
    protected int noOfSurfaces;
    protected HashMap<Direction, Color> surfaces;

    protected AbstractPiece(int noOfSurfaces) throws IllegalArgumentException {
        setNoOfSurfaces(noOfSurfaces);
        initSurfaces();
    }

    private int getNoOfSurfaces() {
        return this.noOfSurfaces;
    }

    private void setNoOfSurfaces(int noOfSurfaces) {
        if (noOfSurfaces < 1 || noOfSurfaces > 3) {
            throw new IllegalArgumentException(String.format(ILLEGAL_NUMBER_OF_SURFACES_FORMAT, noOfSurfaces));
        }
        this.noOfSurfaces = noOfSurfaces;
    }

    private void initSurfaces() {
        this.surfaces = new HashMap<>(this.noOfSurfaces);
    }

    protected void setSurface(Direction direction, Color color) throws IllegalArgumentException {
        if (surfaces.size() == getNoOfSurfaces()) {
            throw new IllegalArgumentException(ALL_SURFACES_ALREADY_SET);
        }
        if (surfaces.containsKey(direction)) {
            throw new IllegalArgumentException(ONE_PIECE_ONE_COLOR);
        }
        if (surfaces.containsValue(color)) {
            throw new IllegalArgumentException(EACH_DIR_SEPARATE_COLOR);
        }
        this.surfaces.put(direction, color);
    }

    public Color getSurface(Direction direction) {
        if (!surfaces.containsKey(direction)) {
            throw new IllegalArgumentException(NO_SUCH_DIRECTION);
        }
        return surfaces.get(direction);
    }

    protected void moveColor(Direction before, Direction after) {
        Color color = surfaces.get(before);
        surfaces.remove(before);
        surfaces.put(after, color);
    }

    protected abstract void moveLeft();

    protected abstract void moveLeftInverted();

    protected abstract void moveRight();

    protected abstract void moveRightInverted();

    protected abstract void moveUp();

    protected abstract void moveUpInverted();

    protected abstract void moveDown();

    protected abstract void moveDownInverted();

    protected abstract void moveFront();

    protected abstract void moveFrontInverted();

    protected abstract void moveBack();

    protected abstract void moveBackInverted();

    public abstract void turnClockwiseAroundXAxis();

    public abstract void turnCounterclockwiseAroundXAxis();

    public abstract void turnClockwiseAroundYAxis();

    public abstract void turnCounterclockwiseAroundYAxis();

    public abstract void turnClockwiseAroundZAxis();

    public abstract void turnCounterclockwiseAroundZAxis();

    public void move(Move move) {
        switch (move) {
            case left -> moveLeft();
            case leftInverted -> moveLeftInverted();
            case right -> moveRight();
            case rightInverted -> moveRightInverted();
            case up -> moveUp();
            case upInverted -> moveUpInverted();
            case down -> moveDown();
            case downInverted -> moveDownInverted();
            case front -> moveFront();
            case frontInverted -> moveFrontInverted();
            case back -> moveBack();
            case backInverted -> moveBackInverted();
        }
    }

    public void turnClockwiseAround(Axis axis) {
        switch (axis) {
            case xAxis -> turnClockwiseAroundXAxis();
            case yAxis -> turnClockwiseAroundYAxis();
            case zAxis -> turnClockwiseAroundZAxis();
        }
    }

    public void turnCounterClockwiseAround(Axis axis) {
        switch (axis) {
            case xAxis -> turnCounterclockwiseAroundXAxis();
            case yAxis -> turnCounterclockwiseAroundYAxis();
            case zAxis -> turnCounterclockwiseAroundZAxis();
        }
    }

    public void turn(Turn turn, Axis axis) {
        switch (turn) {
            case clockWise -> turnClockwiseAround(axis);
            case counterClockWise -> turnCounterClockwiseAround(axis);
        }
    }

}
