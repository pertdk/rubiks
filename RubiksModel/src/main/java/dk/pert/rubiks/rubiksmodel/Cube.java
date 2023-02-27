package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.enums.Color;
import dk.pert.rubiks.rubiksmodel.enums.Direction;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

public class Cube {
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int TOP = 2;
    public static final int BOTTOM = 0;
    public static final int FRONT = 0;
    public static final int BACK = 2;
    public static final int CENTER = 1;

    private final AbstractPiece[][][] pieces;

    private void createCenterPieces() {
        /* Notice all center pieces have exactly two CENTER coordinates */
        pieces[CENTER][CENTER][FRONT] = new CenterPiece(Direction.FRONT, Color.GREEN);
        pieces[LEFT][CENTER][CENTER] = new CenterPiece(Direction.LEFT, Color.ORANGE);
        pieces[CENTER][CENTER][BACK] = new CenterPiece(Direction.BACK, Color.BLUE);
        pieces[RIGHT][CENTER][CENTER] = new CenterPiece(Direction.RIGHT, Color.RED);
        pieces[CENTER][TOP][CENTER] = new CenterPiece(Direction.UP, Color.WHITE);
        pieces[CENTER][BOTTOM][CENTER] = new CenterPiece(Direction.DOWN, Color.YELLOW);
    }

    private void createEdgePieces() {
        /* Notice all edge pieces have exactly one CENTER coordinate */
        pieces[LEFT][TOP][CENTER] = new EdgePiece(Direction.LEFT, Color.ORANGE, Direction.UP, Color.WHITE);
        pieces[CENTER][TOP][BACK] = new EdgePiece(Direction.UP, Color.WHITE, Direction.BACK, Color.BLUE);
        pieces[RIGHT][TOP][CENTER] = new EdgePiece(Direction.RIGHT, Color.RED, Direction.UP, Color.WHITE);
        pieces[CENTER][TOP][FRONT] = new EdgePiece(Direction.UP, Color.WHITE, Direction.FRONT, Color.GREEN);

        pieces[LEFT][CENTER][FRONT] = new EdgePiece(Direction.LEFT, Color.ORANGE, Direction.FRONT, Color.GREEN);
        pieces[LEFT][CENTER][BACK] = new EdgePiece(Direction.LEFT, Color.ORANGE, Direction.BACK, Color.BLUE);
        pieces[RIGHT][CENTER][BACK] = new EdgePiece(Direction.RIGHT, Color.RED, Direction.BACK, Color.BLUE);
        pieces[RIGHT][CENTER][FRONT] = new EdgePiece(Direction.RIGHT, Color.RED, Direction.FRONT, Color.GREEN);

        pieces[LEFT][BOTTOM][CENTER] = new EdgePiece(Direction.LEFT, Color.ORANGE, Direction.DOWN, Color.YELLOW);
        pieces[CENTER][BOTTOM][BACK] = new EdgePiece(Direction.DOWN, Color.YELLOW, Direction.BACK, Color.BLUE);
        pieces[RIGHT][BOTTOM][CENTER] = new EdgePiece(Direction.RIGHT, Color.RED, Direction.DOWN, Color.YELLOW);
        pieces[CENTER][BOTTOM][FRONT] = new EdgePiece(Direction.DOWN, Color.YELLOW, Direction.FRONT, Color.GREEN);

    }

    private void createCornerPieces() {
        /* Notice corner pieces does not have any CENTER coordinate */
        pieces[LEFT][TOP][BACK] = new CornerPiece(Direction.LEFT, Color.ORANGE, Direction.UP, Color.WHITE, Direction.BACK, Color.BLUE);
        pieces[LEFT][TOP][FRONT] = new CornerPiece(Direction.LEFT, Color.ORANGE, Direction.UP, Color.WHITE, Direction.FRONT, Color.GREEN);
        pieces[LEFT][BOTTOM][BACK] = new CornerPiece(Direction.LEFT, Color.ORANGE, Direction.DOWN, Color.YELLOW, Direction.BACK, Color.BLUE);
        pieces[LEFT][BOTTOM][FRONT] = new CornerPiece(Direction.LEFT, Color.ORANGE, Direction.DOWN, Color.YELLOW, Direction.FRONT, Color.GREEN);
        pieces[RIGHT][TOP][BACK] = new CornerPiece(Direction.LEFT, Color.RED, Direction.UP, Color.WHITE, Direction.BACK, Color.BLUE);
        pieces[RIGHT][TOP][FRONT] = new CornerPiece(Direction.LEFT, Color.RED, Direction.UP, Color.WHITE, Direction.FRONT, Color.GREEN);
        pieces[RIGHT][BOTTOM][BACK] = new CornerPiece(Direction.LEFT, Color.RED, Direction.DOWN, Color.YELLOW, Direction.BACK, Color.BLUE);
        pieces[RIGHT][BOTTOM][FRONT] = new CornerPiece(Direction.LEFT, Color.RED, Direction.DOWN, Color.YELLOW, Direction.FRONT, Color.GREEN);
    }

    public Cube() {
        pieces = new AbstractPiece[3][3][3];
        createCenterPieces();
        createEdgePieces();
        createCornerPieces();
    }

    public AbstractPiece getPiece(int x, int y, int z) {
        return pieces[x][y][z];
    }
}
