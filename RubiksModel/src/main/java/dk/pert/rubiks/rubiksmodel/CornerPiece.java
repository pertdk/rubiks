package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.enums.Color;
import dk.pert.rubiks.rubiksmodel.enums.Direction;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

public class CornerPiece extends AbstractPiece {

    public CornerPiece(Direction direction1, Color color1, Direction direction2, Color color2, Direction direction3, Color color3) throws IllegalArgumentException {
        super(3);
        setSurface(direction1, color1);
        setSurface(direction2, color2);
        setSurface(direction3, color3);
    }

    private void moveBack2Up() {
        moveColor(Direction.BACK, Direction.UP);
    }

    private void moveFront2Down() {
        moveColor(Direction.FRONT, Direction.DOWN);
    }

    private void moveBack2Down() {
        moveColor(Direction.BACK, Direction.DOWN);
    }

    private void moveFront2Up() {
        moveColor(Direction.FRONT, Direction.UP);
    }

    private void moveFront2Left() {
        moveColor(Direction.FRONT, Direction.LEFT);
    }

    private void moveFront2Right() {
        moveColor(Direction.FRONT, Direction.RIGHT);
    }

    private void moveBack2Right() {
        moveColor(Direction.BACK, Direction.RIGHT);
    }

    private void moveBack2Left() {
        moveColor(Direction.BACK, Direction.LEFT);
    }

    private void moveLeft2Up() {
        moveColor(Direction.LEFT, Direction.UP);
    }

    private void moveRight2Down() {
        moveColor(Direction.RIGHT, Direction.DOWN);
    }

    private void moveLeft2Down() {
        moveColor(Direction.LEFT, Direction.DOWN);
    }

    private void moveRight2Up() {
        moveColor(Direction.RIGHT, Direction.UP);
    }

    private void turnClockwiseAroundXAxisLeft() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.DOWN)) {
            currentDirection = Direction.DOWN;
            newDirection = Direction.BACK;
        } else {
            currentDirection = Direction.UP;
            newDirection = Direction.FRONT;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.FRONT)) {
            moveFront2Down();
        } else {
            moveBack2Up();
        }
        surfaces.put(newDirection, currentColor);
    }

    private void turnCounterclockwiseAroundXAxisLeft() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.DOWN)) {
            currentDirection = Direction.DOWN;
            newDirection = Direction.FRONT;
        } else {
            currentDirection = Direction.UP;
            newDirection = Direction.BACK;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.FRONT)) {
            moveFront2Up();
        } else {
            moveBack2Down();
        }
        surfaces.put(newDirection, currentColor);
    }

    private void turnClockwiseAroundXAxisRight() {
        turnCounterclockwiseAroundXAxisLeft();
    }

    private void turnCounterclockwiseAroundXAxisRight() {
        turnClockwiseAroundXAxisLeft();
    }


    public void turnClockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.LEFT)) {
            turnClockwiseAroundXAxisLeft();
        } else {
            turnClockwiseAroundXAxisRight();
        }
    }

    public void turnCounterclockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.LEFT)) {
            turnCounterclockwiseAroundXAxisLeft();
        } else {
            turnCounterclockwiseAroundXAxisRight();
        }
    }

    private void turnClockwiseAroundYAxisUp() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.LEFT)) {
            currentDirection = Direction.LEFT;
            newDirection = Direction.BACK;
        } else {
            currentDirection = Direction.RIGHT;
            newDirection = Direction.FRONT;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.FRONT)) {
            moveFront2Left();
        } else {
            moveBack2Right();
        }
        surfaces.put(newDirection, currentColor);
    }

    private void turnCounterclockwiseAroundYAxisUp() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.LEFT)) {
            currentDirection = Direction.LEFT;
            newDirection = Direction.FRONT;
        } else {
            currentDirection = Direction.RIGHT;
            newDirection = Direction.BACK;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.FRONT)) {
            moveFront2Right();
        } else {
            moveBack2Left();
        }
        surfaces.put(newDirection, currentColor);
    }

    private void turnClockwiseAroundYAxisDown() {
        turnCounterclockwiseAroundYAxisUp();
    }

    private void turnCounterclockwiseAroundYAxisDown() {
        turnClockwiseAroundYAxisUp();
    }

    public void turnClockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.UP)) {
            turnClockwiseAroundYAxisUp();
        } else {
            turnClockwiseAroundYAxisDown();
        }
    }

    public void turnCounterclockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.UP)) {
            turnCounterclockwiseAroundYAxisUp();
        } else {
            turnCounterclockwiseAroundYAxisDown();
        }
    }

    private void turnClockwiseAroundZAxisFront() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.UP)) {
            currentDirection = Direction.UP;
            newDirection = Direction.RIGHT;
        } else {
            currentDirection = Direction.DOWN;
            newDirection = Direction.LEFT;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.LEFT)) {
            moveLeft2Up();
        } else {
            moveRight2Down();
        }
        surfaces.put(newDirection, currentColor);
    }

    private void turnCounterclockwiseAroundZAxisFront() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.UP)) {
            currentDirection = Direction.UP;
            newDirection = Direction.LEFT;
        } else {
            currentDirection = Direction.DOWN;
            newDirection = Direction.RIGHT;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.LEFT)) {
            moveLeft2Down();
        } else {
            moveRight2Up();
        }
        surfaces.put(newDirection, currentColor);
    }

    private void turnClockwiseAroundZAxisBack() {
        turnCounterclockwiseAroundZAxisFront();
    }

    private void turnCounterclockwiseAroundZAxisBack() {
        turnClockwiseAroundZAxisFront();
    }

    public void turnClockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.FRONT)) {
            turnClockwiseAroundZAxisFront();
        } else {
            turnClockwiseAroundZAxisBack();
        }
    }

    public void turnCounterclockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.FRONT)) {
            turnCounterclockwiseAroundZAxisFront();
        } else {
            turnCounterclockwiseAroundZAxisBack();
        }
    }

    @Override
    protected void moveLeft() {
        if (surfaces.containsKey(Direction.LEFT)) {
            turnClockwiseAroundXAxis();
        }
    }

    @Override
    protected void moveLeftInverted() {
        if (surfaces.containsKey(Direction.LEFT)) {
            turnCounterclockwiseAroundXAxis();
        }
    }


    @Override
    protected void moveRight() {
        if (surfaces.containsKey(Direction.RIGHT)) {
            turnCounterclockwiseAroundXAxis();
        }
    }

    @Override
    protected void moveRightInverted() {
        if (surfaces.containsKey(Direction.RIGHT)) {
            turnClockwiseAroundXAxis();
        }
    }

    @Override
    protected void moveUp() {
        if (surfaces.containsKey(Direction.UP)) {
            turnClockwiseAroundYAxis();
        }
    }

    @Override
    protected void moveUpInverted() {
        if (surfaces.containsKey(Direction.UP)) {
            turnCounterclockwiseAroundYAxis();
        }
    }

    @Override
    protected void moveDown() {
        if (surfaces.containsKey(Direction.DOWN)) {
            turnCounterclockwiseAroundYAxis();
        }
    }

    @Override
    protected void moveDownInverted() {
        if (surfaces.containsKey(Direction.DOWN)) {
            turnClockwiseAroundYAxis();
        }
    }

    @Override
    protected void moveFront() {
        if (surfaces.containsKey(Direction.FRONT)) {
            turnClockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveFrontInverted() {
        if (surfaces.containsKey(Direction.FRONT)) {
            turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveBack() {
        if (surfaces.containsKey(Direction.BACK)) {
            turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveBackInverted() {
        if (surfaces.containsKey(Direction.BACK)) {
            turnClockwiseAroundZAxis();
        }
    }
}
