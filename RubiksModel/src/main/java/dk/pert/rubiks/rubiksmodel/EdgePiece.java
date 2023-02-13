package dk.pert.rubiks.rubiksmodel;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

public class EdgePiece extends AbstractPiece {

    public EdgePiece(Direction direction1, Color color1, Direction direction2, Color color2) {
        super(2);
        setSurface(direction1, color1);
        setSurface(direction2, color2);
    }

    private void moveBack2Up() {
        moveColor(Direction.back, Direction.up);
    }

    private void moveUp2Front() {
        moveColor(Direction.up, Direction.front);
    }

    private void moveFront2Down() {
        moveColor(Direction.front, Direction.down);
    }

    private void moveDown2Back() {
        moveColor(Direction.down, Direction.back);
    }

    private void moveBack2Down() {
        moveColor(Direction.back, Direction.down);
    }

    private void moveDown2Front() {
        moveColor(Direction.down, Direction.front);
    }

    private void moveFront2Up() {
        moveColor(Direction.front, Direction.up);
    }

    private void moveUp2Back() {
        moveColor(Direction.up, Direction.back);
    }

    private void moveLeft2Back() {
        moveColor(Direction.left, Direction.back);
    }

    private void moveBack2Right() {
        moveColor(Direction.back, Direction.right);
    }

    private void moveRight2Front() {
        moveColor(Direction.right, Direction.front);
    }

    private void moveFront2Left() {
        moveColor(Direction.left, Direction.up);
    }

    private void moveLeft2Front() {
        moveColor(Direction.left, Direction.front);
    }

    private void moveFront2Right() {
        moveColor(Direction.front, Direction.right);
    }

    private void moveRight2Back() {
        moveColor(Direction.right, Direction.back);
    }

    private void moveBack2Left() {
        moveColor(Direction.back, Direction.left);
    }

    private void moveUp2Right() {
        moveColor(Direction.up, Direction.right);
    }

    private void moveRight2Down() {
        moveColor(Direction.right, Direction.down);
    }

    private void moveDown2Left() {
        moveColor(Direction.down, Direction.left);
    }

    private void moveLeft2Up() {
        moveColor(Direction.left, Direction.up);
    }

    private void moveUp2Left() {
        moveColor(Direction.up, Direction.left);
    }

    private void moveLeft2Down() {
        moveColor(Direction.left, Direction.down);
    }

    private void moveDown2Right() {
        moveColor(Direction.down, Direction.right);
    }

    private void moveRight2Up() {
        moveColor(Direction.right, Direction.up);
    }

    public void turnClockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.back)) {
            moveBack2Up();
        } else if (surfaces.containsKey(Direction.up)) {
            moveUp2Front();
        } else if (surfaces.containsKey(Direction.front)) {
            moveFront2Down();
        } else if (surfaces.containsKey(Direction.down)) {
            moveDown2Back();
        }
    }

    public void turnCounterclockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.back)) {
            moveBack2Down();
        } else if (surfaces.containsKey(Direction.down)) {
            moveDown2Front();
        } else if (surfaces.containsKey(Direction.front)) {
            moveFront2Up();
        } else if (surfaces.containsKey(Direction.up)) {
            moveUp2Back();
        }
    }

    public void turnClockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.left)) {
            moveLeft2Back();
        } else if (surfaces.containsKey(Direction.back)) {
            moveBack2Right();
        } else if (surfaces.containsKey(Direction.right)) {
            moveRight2Front();
        } else if (surfaces.containsKey(Direction.front)) {
            moveFront2Left();
        }
    }

    public void turnCounterclockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.left)) {
            moveLeft2Front();
        } else if (surfaces.containsKey(Direction.front)) {
            moveFront2Right();
        } else if (surfaces.containsKey(Direction.right)) {
            moveRight2Back();
        } else if (surfaces.containsKey(Direction.back)) {
            moveBack2Left();
        }
    }

    public void turnClockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.up)) {
            moveUp2Right();
        } else if (surfaces.containsKey(Direction.right)) {
            moveRight2Down();
        } else if (surfaces.containsKey(Direction.down)) {
            moveDown2Left();
        } else if (surfaces.containsKey(Direction.left)) {
            moveLeft2Up();
        }
    }

    public void turnCounterclockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.up)) {
            moveUp2Left();
        } else if (surfaces.containsKey(Direction.left)) {
            moveLeft2Down();
        } else if (surfaces.containsKey(Direction.down)) {
            moveDown2Right();
        } else if (surfaces.containsKey(Direction.right)) {
            moveRight2Up();
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
            turnCounterclockwiseAroundZAxis();
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
        if (surfaces.containsKey(Direction.front)) {
            turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveBackInverted() {
        if (surfaces.containsKey(Direction.front)) {
            turnClockwiseAroundZAxis();
        }
    }
}
