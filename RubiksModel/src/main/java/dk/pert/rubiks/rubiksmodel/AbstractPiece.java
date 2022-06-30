package dk.pert.rubiks.rubiksmodel;

import java.util.HashMap;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

public abstract class AbstractPiece {
    protected HashMap<Direction, Color> surfaces;

    protected AbstractPiece(int noOfSurfaces) throws IllegalArgumentException {
        if (noOfSurfaces < 1 || noOfSurfaces > 3) {
            throw new IllegalArgumentException(String.format("Illegal number of surfaces: %o. Must be 1,2 or 3.", noOfSurfaces));
        }
        this.surfaces = new HashMap<>(noOfSurfaces);
    }

    protected void setSurface(Direction direction, Color color) throws IllegalArgumentException {
        if (surfaces.containsKey(direction)) {
            throw new IllegalArgumentException("A piece can only have one color in each direction");
        }
        if (surfaces.containsValue(color)) {
            throw new IllegalArgumentException("Each direction must have a separate color");
        }
        this.surfaces.put(direction, color);
    }

    public Color getSurface(Direction direction) {
        if (surfaces == null) {
            throw new NullPointerException("this.surfaces is null!");
        }
        if (!surfaces.containsKey(direction)) {
            throw new IllegalArgumentException("No such direction set in this piece.");
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

}
