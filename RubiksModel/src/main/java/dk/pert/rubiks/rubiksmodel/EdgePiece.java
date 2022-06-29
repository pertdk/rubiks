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

    private void turnClockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.back)) {
            Color color = surfaces.get(Direction.back);
            surfaces.remove(Direction.back);
            surfaces.put(Direction.up, color);
        } else if (surfaces.containsKey(Direction.up)) {
            Color color = surfaces.get(Direction.up);
            surfaces.remove(Direction.up);
            surfaces.put(Direction.front, color);
        } else if (surfaces.containsKey(Direction.front)) {
            Color color = surfaces.get(Direction.front);
            surfaces.remove(Direction.front);
            surfaces.put(Direction.down, color);
        } else if (surfaces.containsKey(Direction.down)) {
            Color color = surfaces.get(Direction.down);
            surfaces.remove(Direction.down);
            surfaces.put(Direction.back, color);
        }
    }

    private void turnCounterclockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.back)) {
            Color color = surfaces.get(Direction.back);
            surfaces.remove(Direction.back);
            surfaces.put(Direction.down, color);
        } else if (surfaces.containsKey(Direction.down)) {
            Color color = surfaces.get(Direction.down);
            surfaces.remove(Direction.down);
            surfaces.put(Direction.front, color);
        } else if (surfaces.containsKey(Direction.front)) {
            Color color = surfaces.get(Direction.front);
            surfaces.remove(Direction.front);
            surfaces.put(Direction.up, color);
        } else if (surfaces.containsKey(Direction.up)) {
            Color color = surfaces.get(Direction.up);
            surfaces.remove(Direction.up);
            surfaces.put(Direction.back, color);
        }
    }

    private void turnClockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.left)) {
            Color color = surfaces.get(Direction.left);
            surfaces.remove(Direction.left);
            surfaces.put(Direction.back, color);
        } else if (surfaces.containsKey(Direction.back)) {
            Color color = surfaces.get(Direction.back);
            surfaces.remove(Direction.back);
            surfaces.put(Direction.right, color);
        } else if (surfaces.containsKey(Direction.right)) {
            Color color = surfaces.get(Direction.right);
            surfaces.remove(Direction.right);
            surfaces.put(Direction.front, color);
        } else if (surfaces.containsKey(Direction.front)) {
            Color color = surfaces.get(Direction.front);
            surfaces.remove(Direction.front);
            surfaces.put(Direction.left, color);
        }
    }

    private void turnCounterclockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.left)) {
            Color color = surfaces.get(Direction.left);
            surfaces.remove(Direction.left);
            surfaces.put(Direction.front, color);
        } else if (surfaces.containsKey(Direction.front)) {
            Color color = surfaces.get(Direction.front);
            surfaces.remove(Direction.front);
            surfaces.put(Direction.right, color);
        } else if (surfaces.containsKey(Direction.right)) {
            Color color = surfaces.get(Direction.right);
            surfaces.remove(Direction.right);
            surfaces.put(Direction.back, color);
        } else if (surfaces.containsKey(Direction.back)) {
            Color color = surfaces.get(Direction.back);
            surfaces.remove(Direction.back);
            surfaces.put(Direction.left, color);
        }
    }

    private void turnClockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.up)) {
            Color color = surfaces.get(Direction.up);
            surfaces.remove(Direction.up);
            surfaces.put(Direction.right, color);
        } else if (surfaces.containsKey(Direction.right)) {
            Color color = surfaces.get(Direction.right);
            surfaces.remove(Direction.right);
            surfaces.put(Direction.down, color);
        } else if (surfaces.containsKey(Direction.down)) {
            Color color = surfaces.get(Direction.down);
            surfaces.remove(Direction.down);
            surfaces.put(Direction.left, color);
        } else if (surfaces.containsKey(Direction.left)) {
            Color color = surfaces.get(Direction.left);
            surfaces.remove(Direction.left);
            surfaces.put(Direction.up, color);
        }
    }

    private void turnCounterclockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.up)) {
            Color color = surfaces.get(Direction.up);
            surfaces.remove(Direction.up);
            surfaces.put(Direction.left, color);
        } else if (surfaces.containsKey(Direction.left)) {
            Color color = surfaces.get(Direction.left);
            surfaces.remove(Direction.left);
            surfaces.put(Direction.down, color);
        } else if (surfaces.containsKey(Direction.down)) {
            Color color = surfaces.get(Direction.down);
            surfaces.remove(Direction.down);
            surfaces.put(Direction.right, color);
        } else if (surfaces.containsKey(Direction.right)) {
            Color color = surfaces.get(Direction.right);
            surfaces.remove(Direction.right);
            surfaces.put(Direction.up, color);
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
