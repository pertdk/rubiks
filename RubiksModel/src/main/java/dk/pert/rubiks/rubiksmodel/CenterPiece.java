package dk.pert.rubiks.rubiksmodel;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

public class CenterPiece extends AbstractPiece {

    public CenterPiece(Direction direction, Color color) {
        super(1);
        setSurface(direction, color);
    }

    @Override
    protected void moveLeft() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveLeftInverted() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveRight() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveRightInverted() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveUp() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveUpInverted() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveDown() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveDownInverted() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveFront() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveFrontInverted() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveBack() {
        /* CenterPieces will never move */
    }

    @Override
    protected void moveBackInverted() {
        /* CenterPieces will never move */
    }
}
