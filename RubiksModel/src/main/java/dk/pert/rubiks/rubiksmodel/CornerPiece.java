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

    public void turnClockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.down)) {
            Color down = surfaces.get(Direction.down);
            surfaces.remove(Direction.down);
            if (surfaces.containsKey(Direction.front)) {
                moveFront2Down();
            } else if (surfaces.containsKey(Direction.back)) {
                moveBack2Up();
            }
            surfaces.put(Direction.back, down);
        } else if (surfaces.containsKey(Direction.up)) {
            Color up = surfaces.get(Direction.up);
            surfaces.remove(Direction.up);
            if (surfaces.containsKey(Direction.front)) {
                moveFront2Down();
            } else if (surfaces.containsKey(Direction.back)) {
                moveBack2Up();
            }
            surfaces.put(Direction.front, up);
        }
    }


    public void turnCounterClockwiseAroundXAxis() {
        if (surfaces.containsKey(Direction.down)) {
            Color down = surfaces.get(Direction.down);
            surfaces.remove(Direction.down);
            if (surfaces.containsKey(Direction.front)) {
                moveFront2Up();
            } else if (surfaces.containsKey(Direction.back)) {
                moveBack2Down();
            }
            surfaces.put(Direction.front, down);
        } else if (surfaces.containsKey(Direction.up)) {
            Color up = surfaces.get(Direction.up);
            surfaces.remove(Direction.up);
            if (surfaces.containsKey(Direction.front)) {
                moveFront2Up();
            } else if (surfaces.containsKey(Direction.back)) {
                moveBack2Down();
            }
            surfaces.put(Direction.front, up);
        }
    }


    public void turnClockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.left)) {
            Color left = surfaces.get(Direction.left);
            surfaces.remove(Direction.left);
            if (surfaces.containsKey(Direction.front)) {
                moveFront2Left();
            } else if (surfaces.containsKey(Direction.back)) {
                moveBack2Right();
            }
            surfaces.put(Direction.back, left);
        } else if (surfaces.containsKey(Direction.right)) {
            Color right = surfaces.get(Direction.right);
            surfaces.remove(Direction.right);
            if (surfaces.containsKey(Direction.front)) {
                moveFront2Left();
            } else if (surfaces.containsKey(Direction.back)) {
                moveBack2Right();
            }
            surfaces.put(Direction.front, right);
        }
    }

    public void turnCounterClockwiseAroundYAxis() {
        if (surfaces.containsKey(Direction.left)) {
            Color left = surfaces.get(Direction.left);
            surfaces.remove(Direction.left);
            if (surfaces.containsKey(Direction.front)) {
                moveFront2Right();
            } else if (surfaces.containsKey(Direction.back)) {
                moveBack2Left();
            }
            surfaces.put(Direction.front, left);
        } else if (surfaces.containsKey(Direction.right)) {
            Color right = surfaces.get(Direction.right);
            surfaces.remove(Direction.right);
            if (surfaces.containsKey(Direction.front)) {
                moveFront2Right();
            } else if (surfaces.containsKey(Direction.back)) {
                moveBack2Left();
            }
            surfaces.put(Direction.back, right);
        }
    }

    public void turnClockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.up)) {
            Color up = surfaces.get(Direction.up);
            surfaces.remove(Direction.up);
            if (surfaces.containsKey(Direction.left)) {
                moveLeft2Up();
            } else if (surfaces.containsKey(Direction.right)) {
                moveRight2Down();
            }
            surfaces.put(Direction.right, up);
        } else if (surfaces.containsKey(Direction.down)) {
            Color down = surfaces.get(Direction.down);
            surfaces.remove(Direction.down);
            if (surfaces.containsKey(Direction.left)) {
                moveLeft2Up();
            } else if (surfaces.containsKey(Direction.right)) {
                moveRight2Down();
            }
            surfaces.put(Direction.left, down);
        }
    }

    public void turnCounterClockwiseAroundZAxis() {
        if (surfaces.containsKey(Direction.up)) {
            Color up = surfaces.get(Direction.up);
            surfaces.remove(Direction.up);
            if (surfaces.containsKey(Direction.left)) {
                moveLeft2Down();
            } else if (surfaces.containsKey(Direction.right)) {
                moveRight2Up();
            }
            surfaces.put(Direction.left, up);
        } else if (surfaces.containsKey(Direction.down)) {
            Color down = surfaces.get(Direction.down);
            surfaces.remove(Direction.down);
            if (surfaces.containsKey(Direction.left)) {
                moveLeft2Down();
            } else if (surfaces.containsKey(Direction.right)) {
                moveRight2Up();
            }
            surfaces.put(Direction.right, down);
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
            turnCounterClockwiseAroundXAxis();
        }
    }


    @Override
    protected void moveRight() {
        if (surfaces.containsKey(Direction.right)) {
            turnCounterClockwiseAroundXAxis();
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
            turnCounterClockwiseAroundYAxis();
        }
    }

    @Override
    protected void moveDown() {
        if (surfaces.containsKey(Direction.down)) {
            turnCounterClockwiseAroundYAxis();
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
            turnCounterClockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveBack() {
        if (surfaces.containsKey(Direction.back)) {
            turnCounterClockwiseAroundZAxis();
        }
    }

    @Override
    protected void moveBackInverted() {
        if (surfaces.containsKey(Direction.back)) {
            turnClockwiseAroundZAxis();
        }
    }
}
