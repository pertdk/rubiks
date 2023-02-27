package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.enums.Color;
import dk.pert.rubiks.rubiksmodel.enums.Direction;

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
        moveColor(Direction.BACK, Direction.UP);
    }

    private void moveUp2Front() {
        moveColor(Direction.UP, Direction.FRONT);
    }

    private void moveFront2Down() {
        moveColor(Direction.FRONT, Direction.DOWN);
    }

    private void moveDown2Back() {
        moveColor(Direction.DOWN, Direction.BACK);
    }

    private void moveBack2Down() {
        moveColor(Direction.BACK, Direction.DOWN);
    }

    private void moveDown2Front() {
        moveColor(Direction.DOWN, Direction.FRONT);
    }

    private void moveFront2Up() {
        moveColor(Direction.FRONT, Direction.UP);
    }

    private void moveUp2Back() {
        moveColor(Direction.UP, Direction.BACK);
    }

    private void moveLeft2Back() {
        moveColor(Direction.LEFT, Direction.BACK);
    }

    private void moveBack2Right() {
        moveColor(Direction.BACK, Direction.RIGHT);
    }

    private void moveRight2Front() {
        moveColor(Direction.RIGHT, Direction.FRONT);
    }

    private void moveFront2Left() {
        moveColor(Direction.LEFT, Direction.UP);
    }

    private void moveLeft2Front() {
        moveColor(Direction.LEFT, Direction.FRONT);
    }

    private void moveFront2Right() {
        moveColor(Direction.FRONT, Direction.RIGHT);
    }

    private void moveRight2Back() {
        moveColor(Direction.RIGHT, Direction.BACK);
    }

    private void moveBack2Left() {
        moveColor(Direction.BACK, Direction.LEFT);
    }

    private void moveUp2Right() {
        moveColor(Direction.UP, Direction.RIGHT);
    }

    private void moveRight2Down() {
        moveColor(Direction.RIGHT, Direction.DOWN);
    }

    private void moveDown2Left() {
        moveColor(Direction.DOWN, Direction.LEFT);
    }

    private void moveLeft2Up() {
        moveColor(Direction.LEFT, Direction.UP);
    }

    private void moveUp2Left() {
        moveColor(Direction.UP, Direction.LEFT);
    }

    private void moveLeft2Down() {
        moveColor(Direction.LEFT, Direction.DOWN);
    }

    private void moveDown2Right() {
        moveColor(Direction.DOWN, Direction.RIGHT);
    }

    private void moveRight2Up() {
        moveColor(Direction.RIGHT, Direction.UP);
    }

    public void turnClockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.BACK)) {
            moveBack2Up();
        } else if (surfaces.containsKey(Direction.UP)) {
            moveUp2Front();
        } else if (surfaces.containsKey(Direction.FRONT)) {
            moveFront2Down();
        } else if (surfaces.containsKey(Direction.DOWN)) {
            moveDown2Back();
        }
    }

    public void turnCounterclockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.BACK)) {
            moveBack2Down();
        } else if (surfaces.containsKey(Direction.DOWN)) {
            moveDown2Front();
        } else if (surfaces.containsKey(Direction.FRONT)) {
            moveFront2Up();
        } else if (surfaces.containsKey(Direction.UP)) {
            moveUp2Back();
        }
    }

    public void turnClockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.LEFT)) {
            moveLeft2Back();
        } else if (surfaces.containsKey(Direction.BACK)) {
            moveBack2Right();
        } else if (surfaces.containsKey(Direction.RIGHT)) {
            moveRight2Front();
        } else if (surfaces.containsKey(Direction.FRONT)) {
            moveFront2Left();
        }
    }

    public void turnCounterclockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.LEFT)) {
            moveLeft2Front();
        } else if (surfaces.containsKey(Direction.FRONT)) {
            moveFront2Right();
        } else if (surfaces.containsKey(Direction.RIGHT)) {
            moveRight2Back();
        } else if (surfaces.containsKey(Direction.BACK)) {
            moveBack2Left();
        }
    }

    public void turnClockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.UP)) {
            moveUp2Right();
        } else if (surfaces.containsKey(Direction.RIGHT)) {
            moveRight2Down();
        } else if (surfaces.containsKey(Direction.DOWN)) {
            moveDown2Left();
        } else if (surfaces.containsKey(Direction.LEFT)) {
            moveLeft2Up();
        }
    }

    public void turnCounterclockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.UP)) {
            moveUp2Left();
        } else if (surfaces.containsKey(Direction.LEFT)) {
            moveLeft2Down();
        } else if (surfaces.containsKey(Direction.DOWN)) {
            moveDown2Right();
        } else if (surfaces.containsKey(Direction.RIGHT)) {
            moveRight2Up();
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
            turnCounterclockwiseAroundZAxis();
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
        if (surfaces.containsKey(Direction.FRONT)) {
            turnCounterclockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveBackInverted() {
        if (surfaces.containsKey(Direction.FRONT)) {
            turnClockwiseAroundZAxis();
        }
    }
}
