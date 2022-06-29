package dk.pert.rubiks.rubiksmodel;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

public class CornerPiece extends AbstractPiece {

    public CornerPiece(Direction direction1, Color color1, Direction direction2, Color color2, Direction direction3, Color color3)
        throws IllegalArgumentException {
        super(3);
        setSurface(direction1, color1);
        setSurface(direction2, color2);
        setSurface(direction3, color3);
    }

    public void turnClockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.down)) {
            Color down = surfaces.get(Direction.down);
            surfaces.remove(Direction.down);
            if (surfaces.containsKey(Direction.front)) {
                Color front = surfaces.get(Direction.front);
                surfaces.remove(Direction.front);
                surfaces.put(Direction.down, front);
            } else if (surfaces.containsKey(Direction.back)) {
                Color back = surfaces.get(Direction.back);
                surfaces.remove(Direction.back);
                surfaces.put(Direction.up, back);
            }
            surfaces.put(Direction.back, down);
        }
    }

    @Override
    protected void moveLeft() {
        if (surfaces.containsKey(Direction.left)) {
            turnClockwiseAroundXAxis();
        }
    }

    @Override
    protected void moveLeftInverted() {
    }


    @Override
    protected void moveRight() {

    }

    @Override
    protected void moveRightInverted() {

    }

    @Override
    protected void moveUp() {

    }

    @Override
    protected void moveUpInverted() {

    }

    @Override
    protected void moveDown() {

    }

    @Override
    protected void moveDownInverted() {

    }

    @Override
    protected void moveFront() {

    }

    @Override
    protected void moveFrontInverted() {

    }

    @Override
    protected void moveBack() {

    }

    @Override
    protected void moveBackInverted() {

    }
}
