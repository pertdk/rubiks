package dk.pert.rubiks.model;

import dk.pert.rubiks.model.enums.Color;
import dk.pert.rubiks.model.enums.Direction;
import dk.pert.rubiks.model.enums.Move;
import dk.pert.rubiks.model.interfaces.ISurface;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

@Getter
@Setter
public class Surface implements ISurface {
    /**
     * A surface should be created with a color, that is then never changed.
     */
    private final Color color;
    /**
     * A surface should be created with a direction. The direction of the surface can change.
     */
    private Direction direction;

    public Surface(Color color, Direction direction) {
        this.color = color;
        this.direction = direction;
    }

    /**
     * Implementation of the Rubik's L-move regarding a surface
     * L-move: Move the left side of the Rubik's cube clockwise
     */
    private void left() {
        switch (direction) {
            case DOWN -> setDirection(Direction.BACK);
            case BACK -> setDirection(Direction.UP);
            case UP -> setDirection(Direction.FRONT);
            case FRONT -> setDirection(Direction.DOWN);
        }
    }

    /**
     * Implementation of the Rubik's Li-move (L-inverted) regarding a surface
     * Li-move: Move the left side of the Rubik's cube counterclockwise
     */
    private void leftInverted() {
        switch (direction) {
            case DOWN -> setDirection(Direction.FRONT);
            case FRONT -> setDirection(Direction.UP);
            case UP -> setDirection(Direction.BACK);
            case BACK -> setDirection(Direction.DOWN);
        }
    }

    /**
     * Implementation of the Rubik's R-move regarding a surface
     * R-move: Move the right side of the Rubik's cube clockwise
     */
    private void right() {
        leftInverted();
    }

    /**
     * Implementation of the Rubik's Ri-move (R-inverted) regarding a surface
     * Ri-move: Move the right side of the Rubik's cube counterclockwise
     */
    private void rightInverted() {
        left();
    }

    /**
     * Implementation of the Rubik's F-move regarding a surface
     * F-move: Move the front side of the Rubik's cube clockwise
     */
    private void front() {
        switch (direction) {
            case DOWN -> setDirection(Direction.LEFT);
            case LEFT -> setDirection(Direction.UP);
            case UP -> setDirection(Direction.RIGHT);
            case RIGHT -> setDirection(Direction.DOWN);
        }
    }

    /**
     * Implementation of the Rubik's Fi-move (F-inverted) regarding a surface
     * Fi-move: Move the front side of the Rubik's cube counterclockwise
     */
    private void frontInverted() {
        switch (direction) {
            case DOWN -> setDirection(Direction.RIGHT);
            case RIGHT -> setDirection(Direction.UP);
            case UP -> setDirection(Direction.LEFT);
            case LEFT -> setDirection(Direction.DOWN);
        }
    }

    /**
     * Implementation of the Rubik's B-move regarding a surface
     * B-move: Move the back side of the Rubik's cube clockwise
     */
    private void back() {
        frontInverted();
    }

    /**
     * Implementation of the Rubik's Bi-move (B-inverted) regarding a surface
     * Bi-move: Move the back side of the Rubik's cube counterclockwise
     */
    private void backInverted() {
        front();
    }

    /**
     * Implementation of the Rubik's U-move regarding a surface
     * U-move: Move the top (up) side of the Rubik's cube clockwise
     */
    private void up() {
        switch (direction) {
            case LEFT -> setDirection(Direction.BACK);
            case BACK -> setDirection(Direction.RIGHT);
            case RIGHT -> setDirection(Direction.FRONT);
            case FRONT -> setDirection(Direction.LEFT);
        }
    }

    /**
     * Implementation of the Rubik's Ui-move (U-inverted) regarding a surface
     * Ui-move: Move the top side (up) of the Rubik's cube counterclockwise
     */
    private void upInverted() {
        switch (direction) {
            case LEFT -> setDirection(Direction.FRONT);
            case FRONT -> setDirection(Direction.RIGHT);
            case RIGHT -> setDirection(Direction.BACK);
            case BACK -> setDirection(Direction.LEFT);
        }
    }

    /**
     * Implementation of the Rubik's D-move regarding a surface
     * D-move: Move the lower (down) side of the Rubik's cube clockwise
     */
    private void down() {
        upInverted();
    }

    /**
     * Implementation of the Rubik's Di-move (Down-inverted) regarding a surface
     * Di-move: Move the lower side (down) of the Rubik's cube counterclockwise
     */
    private void downInverted() {
        up();
    }

    @Override
    public void move(Move move) {
        switch (move) {
            case UP -> up();
            case UP_INVERTED -> upInverted();
            case DOWN -> down();
            case DOWN_INVERTED -> downInverted();
            case LEFT -> left();
            case LEFT_INVERTED -> leftInverted();
            case RIGHT -> right();
            case RIGHT_INVERTED -> rightInverted();
            case BACK -> back();
            case BACK_INVERTED -> backInverted();
            case FRONT -> front();
            default -> frontInverted();
        }
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Surface surface = (Surface) object;
        return Objects.equals(getColor(), surface.getColor());
    }
}
