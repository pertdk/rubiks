package dk.pert.rubiks.rubiksmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

@Getter
@Setter
@AllArgsConstructor
public class Surface {
    private Direction direction;
    private Color color;

    /**
     * Implementation of the Rubik's L-move regarding a surface
     * L-move: Move the left side of the Rubik's cube clockwise
     */
    private void left() {
        switch (direction) {
            case down -> setDirection(Direction.back);
            case back -> setDirection(Direction.up);
            case up -> setDirection(Direction.front);
            case front -> setDirection(Direction.down);
        }
    }

    /**
     * Implementation of the Rubik's Li-move (L-inverted) regarding a surface
     * Li-move: Move the left side of the Rubik's cube counterclockwise
     */
    private void leftInverted() {
        switch (direction) {
            case down -> setDirection(Direction.front);
            case front -> setDirection(Direction.up);
            case up -> setDirection(Direction.back);
            case back -> setDirection(Direction.down);
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
            case down -> setDirection(Direction.left);
            case left -> setDirection(Direction.up);
            case up -> setDirection(Direction.right);
            case right -> setDirection(Direction.down);
        }
    }

    /**
     * Implementation of the Rubik's Fi-move (F-inverted) regarding a surface
     * Fi-move: Move the front side of the Rubik's cube counterclockwise
     */
    private void frontInverted() {
        switch (direction) {
            case down -> setDirection(Direction.right);
            case right -> setDirection(Direction.up);
            case up -> setDirection(Direction.left);
            case left -> setDirection(Direction.down);
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
            case left -> setDirection(Direction.back);
            case back -> setDirection(Direction.right);
            case right -> setDirection(Direction.front);
            case front -> setDirection(Direction.left);
        }
    }

    /**
     * Implementation of the Rubik's Ui-move (U-inverted) regarding a surface
     * Ui-move: Move the top side (up) of the Rubik's cube counterclockwise
     */
    private void upInverted() {
        switch (direction) {
            case left -> setDirection(Direction.front);
            case front -> setDirection(Direction.right);
            case right -> setDirection(Direction.back);
            case back -> setDirection(Direction.left);
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

    public void move(Move move) {
        switch (move) {
            case up -> up();
            case upInverted -> upInverted();
            case down -> down();
            case downInverted -> downInverted();
            case left -> left();
            case leftInverted -> leftInverted();
            case right -> right();
            case rightInverted -> rightInverted();
            case back -> back();
            case backInverted -> backInverted();
            case front -> front();
            case frontInverted -> frontInverted();
        }
    }
}
