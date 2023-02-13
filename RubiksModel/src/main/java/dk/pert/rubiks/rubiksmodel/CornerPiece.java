package dk.pert.rubiks.rubiksmodel;

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
        moveColor(Direction.back, Direction.up);
    }

    private void moveFront2Down() {
        moveColor(Direction.front, Direction.down);
    }

    private void moveBack2Down() {
        moveColor(Direction.back, Direction.down);
    }

    private void moveFront2Up() {
        moveColor(Direction.front, Direction.up);
    }

    private void moveFront2Left() {
        moveColor(Direction.front, Direction.left);
    }

    private void moveFront2Right() {
        moveColor(Direction.front, Direction.right);
    }

    private void moveBack2Right() {
        moveColor(Direction.back, Direction.right);
    }

    private void moveBack2Left() {
        moveColor(Direction.back, Direction.left);
    }

    private void moveLeft2Up() {
        moveColor(Direction.left, Direction.up);
    }

    private void moveRight2Down() {
        moveColor(Direction.right, Direction.down);
    }

    private void moveLeft2Down() {
        moveColor(Direction.left, Direction.down);
    }

    private void moveRight2Up() {
        moveColor(Direction.right, Direction.up);
    }

    private void turnClockwiseAroundXAxisLeft() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.down)) {
            currentDirection = Direction.down;
            newDirection = Direction.back;
        } else {
            currentDirection = Direction.up;
            newDirection = Direction.front;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.front)) {
            moveFront2Down();
        } else {
            moveBack2Up();
        }
        surfaces.put(newDirection, currentColor);
    }

    private void turnCounterclockwiseAroundXAxisLeft() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.down)) {
            currentDirection = Direction.down;
            newDirection = Direction.front;
        } else {
            currentDirection = Direction.up;
            newDirection = Direction.back;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.front)) {
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
        if (surfaces.containsKey(Direction.left)) {
            turnClockwiseAroundXAxisLeft();
        } else {
            turnClockwiseAroundXAxisRight();
        }
    }

    public void turnCounterclockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.left)) {
            turnCounterclockwiseAroundXAxisLeft();
        } else {
            turnCounterclockwiseAroundXAxisRight();
        }
    }

    private void turnClockwiseAroundYAxisUp() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.left)) {
            currentDirection = Direction.left;
            newDirection = Direction.back;
        } else {
            currentDirection = Direction.right;
            newDirection = Direction.front;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.front)) {
            moveFront2Left();
        } else {
            moveBack2Right();
        }
        surfaces.put(newDirection, currentColor);
    }

    private void turnCounterclockwiseAroundYAxisUp() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.left)) {
            currentDirection = Direction.left;
            newDirection = Direction.front;
        } else {
            currentDirection = Direction.right;
            newDirection = Direction.back;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.front)) {
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
        if (surfaces.containsKey(Direction.up)) {
            turnClockwiseAroundYAxisUp();
        } else {
            turnClockwiseAroundYAxisDown();
        }
    }

    public void turnCounterclockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.up)) {
            turnCounterclockwiseAroundYAxisUp();
        } else {
            turnCounterclockwiseAroundYAxisDown();
        }
    }

    private void turnClockwiseAroundZAxisFront() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.up)) {
            currentDirection = Direction.up;
            newDirection = Direction.right;
        } else {
            currentDirection = Direction.down;
            newDirection = Direction.left;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.left)) {
            moveLeft2Up();
        } else {
            moveRight2Down();
        }
        surfaces.put(newDirection, currentColor);
    }

    private void turnCounterclockwiseAroundZAxisFront() {
        Direction currentDirection, newDirection;
        if (surfaces.containsKey(Direction.up)) {
            currentDirection = Direction.up;
            newDirection = Direction.left;
        } else {
            currentDirection = Direction.down;
            newDirection = Direction.right;
        }
        Color currentColor = surfaces.get(currentDirection);
        surfaces.remove(currentDirection);
        if (surfaces.containsKey(Direction.left)) {
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
        if (surfaces.containsKey(Direction.front)) {
            turnClockwiseAroundZAxisFront();
        } else {
            turnClockwiseAroundZAxisBack();
        }
    }

    public void turnCounterclockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.front)) {
            turnCounterclockwiseAroundZAxisFront();
        } else {
            turnCounterclockwiseAroundZAxisBack();
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
        if (surfaces.containsKey(Direction.left)) {
            turnCounterclockwiseAroundXAxis();
        }
    }


    @Override
    protected void moveRight() {
        if (surfaces.containsKey(Direction.right)) {
            turnCounterclockwiseAroundXAxis();
        }
    }

    @Override
    protected void moveRightInverted() {
        if (surfaces.containsKey(Direction.right)) {
            turnClockwiseAroundXAxis();
        }
    }

    @Override
    protected void moveUp() {
        if (surfaces.containsKey(Direction.up)) {
            turnClockwiseAroundYAxis();
        }
    }

    @Override
    protected void moveUpInverted() {
        if (surfaces.containsKey(Direction.up)) {
            turnCounterclockwiseAroundYAxis();
        }
    }

    @Override
    protected void moveDown() {
        if (surfaces.containsKey(Direction.down)) {
            turnCounterclockwiseAroundYAxis();
        }
    }

    @Override
    protected void moveDownInverted() {
        if (surfaces.containsKey(Direction.down)) {
            turnClockwiseAroundYAxis();
        }
    }

    @Override
    protected void moveFront() {
        if (surfaces.containsKey(Direction.front)) {
            turnClockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveFrontInverted() {
        if (surfaces.containsKey(Direction.front)) {
            turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveBack() {
        if (surfaces.containsKey(Direction.back)) {
            turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveBackInverted() {
        if (surfaces.containsKey(Direction.back)) {
            turnClockwiseAroundZAxis();
        }
    }
}
