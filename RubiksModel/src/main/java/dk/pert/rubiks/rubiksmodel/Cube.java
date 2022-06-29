package dk.pert.rubiks.rubiksmodel;

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

    private AbstractPiece[][][] pieces;

    private void createCenterPieces() {
        /* Notice all center pieces have exactly two CENTER coordinates */
        pieces[CENTER][CENTER][FRONT] = new CenterPiece(Direction.front, Color.front);
        pieces[LEFT][CENTER][CENTER] = new CenterPiece(Direction.left, Color.left);
        pieces[CENTER][CENTER][BACK] = new CenterPiece(Direction.back, Color.back);
        pieces[RIGHT][CENTER][CENTER] = new CenterPiece(Direction.right, Color.right);
        pieces[CENTER][TOP][CENTER] = new CenterPiece(Direction.up, Color.top);
        pieces[CENTER][BOTTOM][CENTER] = new CenterPiece(Direction.down, Color.bottom);
    }

    private void createEdgePieces() {
        /* Notice all edge pieces have exactly one CENTER coordinate */
        pieces[LEFT][TOP][CENTER] = new EdgePiece(Direction.left, Color.left, Direction.up, Color.top);
        pieces[CENTER][TOP][BACK] = new EdgePiece(Direction.up, Color.top, Direction.back, Color.back);
        pieces[RIGHT][TOP][CENTER] = new EdgePiece(Direction.right, Color.right, Direction.up, Color.top);
        pieces[CENTER][TOP][FRONT] = new EdgePiece(Direction.up, Color.top, Direction.front, Color.front);

        pieces[LEFT][CENTER][FRONT] = new EdgePiece(Direction.left, Color.left, Direction.front, Color.front);
        pieces[LEFT][CENTER][BACK] = new EdgePiece(Direction.left, Color.left, Direction.back, Color.back);
        pieces[RIGHT][CENTER][BACK] = new EdgePiece(Direction.right, Color.right, Direction.back, Color.back);
        pieces[RIGHT][CENTER][FRONT] = new EdgePiece(Direction.right, Color.right, Direction.front, Color.front);

        pieces[LEFT][BOTTOM][CENTER] = new EdgePiece(Direction.left, Color.left, Direction.down, Color.bottom);
        pieces[CENTER][BOTTOM][BACK] = new EdgePiece(Direction.down, Color.bottom, Direction.back, Color.back);
        pieces[RIGHT][BOTTOM][CENTER] = new EdgePiece(Direction.right, Color.right, Direction.down, Color.bottom);
        pieces[CENTER][BOTTOM][FRONT] = new EdgePiece(Direction.down, Color.bottom, Direction.front, Color.front);

    }

    private void createCornerPieces() {
        /* Notice corner pieces does not have any CENTER coordinate */
        pieces[LEFT][TOP][BACK] = new CornerPiece(Direction.left, Color.left, Direction.up, Color.top, Direction.back, Color.back);
        pieces[LEFT][TOP][FRONT] = new CornerPiece(Direction.left, Color.left, Direction.up, Color.top, Direction.front, Color.front);
        pieces[LEFT][BOTTOM][BACK] = new CornerPiece(Direction.left, Color.left, Direction.down, Color.bottom, Direction.back, Color.back);
        pieces[LEFT][BOTTOM][FRONT] = new CornerPiece(Direction.left, Color.left, Direction.down, Color.bottom, Direction.front, Color.front);
        pieces[RIGHT][TOP][BACK] = new CornerPiece(Direction.left, Color.right, Direction.up, Color.top, Direction.back, Color.back);
        pieces[RIGHT][TOP][FRONT] = new CornerPiece(Direction.left, Color.right, Direction.up, Color.top, Direction.front, Color.front);
        pieces[RIGHT][BOTTOM][BACK] = new CornerPiece(Direction.left, Color.right, Direction.down, Color.bottom, Direction.back, Color.back);
        pieces[RIGHT][BOTTOM][FRONT] = new CornerPiece(Direction.left, Color.right, Direction.down, Color.bottom, Direction.front, Color.front);
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
