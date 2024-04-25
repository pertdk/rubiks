package dk.pert.rubiks.model;

import dk.pert.rubiks.model.enums.Color;
import dk.pert.rubiks.model.enums.Direction;
import dk.pert.rubiks.model.interfaces.IPiece;
import dk.pert.rubiks.model.pieces.CenterPiece;
import dk.pert.rubiks.model.pieces.CornerPiece;
import dk.pert.rubiks.model.pieces.EdgePiece;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

public class Cube {
    private static final int CENTER = 1;
    private static final int LEFT = 0;
    private static final int RIGHT = 2;
    private static final int TOP = 2;
    private static final int BOTTOM = 0;
    private static final int FRONT = 0;
    private static final int BACK = 2;

    private final IPiece[][][] pieces;

    public Cube() {
        pieces = new IPiece[3][3][3];
        createCenterPieces();
        createEdgePieces();
        createCornerPieces();
    }

    private void createCenterPieces() {
        /* Notice all center pieces have exactly two CENTER coordinates */
        pieces[CENTER][CENTER][FRONT] = new CenterPiece(new Surface(Color.GREEN, Direction.FRONT));
        pieces[LEFT][CENTER][CENTER] = new CenterPiece(new Surface(Color.ORANGE, Direction.LEFT));
        pieces[CENTER][CENTER][BACK] = new CenterPiece(new Surface(Color.BLUE, Direction.BACK));
        pieces[RIGHT][CENTER][CENTER] = new CenterPiece(new Surface(Color.RED, Direction.RIGHT));
        pieces[CENTER][TOP][CENTER] = new CenterPiece(new Surface(Color.WHITE, Direction.UP));
        pieces[CENTER][BOTTOM][CENTER] = new CenterPiece(new Surface(Color.YELLOW, Direction.DOWN));
    }

    private void createEdgePieces() {
        /* Notice all edge pieces have exactly one CENTER coordinate */
        pieces[LEFT][TOP][CENTER] = new EdgePiece(
                new Surface(Color.WHITE, Direction.UP),
                new Surface(Color.ORANGE, Direction.LEFT)
        );
        pieces[CENTER][TOP][BACK] = new EdgePiece(
                new Surface(Color.WHITE, Direction.UP),
                new Surface(Color.BLUE, Direction.BACK)
        );
        pieces[RIGHT][TOP][CENTER] = new EdgePiece(
                new Surface(Color.WHITE, Direction.UP),
                new Surface(Color.RED, Direction.RIGHT)
        );
        pieces[CENTER][TOP][FRONT] = new EdgePiece(
                new Surface(Color.WHITE, Direction.UP),
                new Surface(Color.GREEN, Direction.FRONT)
        );

        pieces[LEFT][CENTER][FRONT] = new EdgePiece(
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.GREEN, Direction.FRONT)
        );
        pieces[LEFT][CENTER][BACK] = new EdgePiece(
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.BLUE, Direction.BACK)
        );
        pieces[RIGHT][CENTER][BACK] = new EdgePiece(
                new Surface(Color.RED, Direction.RIGHT),
                new Surface(Color.BLUE, Direction.BACK)
        );
        pieces[RIGHT][CENTER][FRONT] = new EdgePiece(
                new Surface(Color.RED, Direction.RIGHT),
                new Surface(Color.GREEN, Direction.FRONT)
        );

        pieces[LEFT][BOTTOM][CENTER] = new EdgePiece(
                new Surface(Color.YELLOW, Direction.DOWN),
                new Surface(Color.ORANGE, Direction.LEFT)
        );
        pieces[CENTER][BOTTOM][BACK] = new EdgePiece(
                new Surface(Color.YELLOW, Direction.DOWN),
                new Surface(Color.BLUE, Direction.BACK)
        );
        pieces[RIGHT][BOTTOM][CENTER] = new EdgePiece(
                new Surface(Color.YELLOW, Direction.DOWN),
                new Surface(Color.RED, Direction.RIGHT)
        );
        pieces[CENTER][BOTTOM][FRONT] = new EdgePiece(
                new Surface(Color.YELLOW, Direction.DOWN),
                new Surface(Color.GREEN, Direction.FRONT)
        );

    }

    private void createCornerPieces() {
        /* Notice corner pieces does not have any CENTER coordinate */
        pieces[LEFT][TOP][BACK] = new CornerPiece(
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.WHITE, Direction.UP),
                new Surface(Color.BLUE, Direction.BACK)
        );
        pieces[LEFT][TOP][FRONT] = new CornerPiece(
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.WHITE, Direction.UP),
                new Surface(Color.GREEN, Direction.FRONT)
        );
        pieces[LEFT][BOTTOM][BACK] = new CornerPiece(
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.YELLOW, Direction.DOWN),
                new Surface(Color.BLUE, Direction.BACK)
        );
        pieces[LEFT][BOTTOM][FRONT] = new CornerPiece(
                new Surface(Color.ORANGE, Direction.LEFT),
                new Surface(Color.YELLOW, Direction.DOWN),
                new Surface(Color.GREEN, Direction.FRONT)
        );
        pieces[RIGHT][TOP][BACK] = new CornerPiece(
                new Surface(Color.RED, Direction.LEFT),
                new Surface(Color.WHITE, Direction.UP),
                new Surface(Color.BLUE, Direction.BACK)
        );
        pieces[RIGHT][TOP][FRONT] = new CornerPiece(
                new Surface(Color.RED, Direction.LEFT),
                new Surface(Color.WHITE, Direction.UP),
                new Surface(Color.GREEN, Direction.FRONT)
        );
        pieces[RIGHT][BOTTOM][BACK] = new CornerPiece(
                new Surface(Color.RED, Direction.LEFT),
                new Surface(Color.YELLOW, Direction.DOWN),
                new Surface(Color.BLUE, Direction.BACK)
        );
        pieces[RIGHT][BOTTOM][FRONT] = new CornerPiece(
                new Surface(Color.RED, Direction.LEFT),
                new Surface(Color.YELLOW, Direction.DOWN),
                new Surface(Color.GREEN, Direction.FRONT)
        );
    }

    public IPiece getPiece(int x, int y, int z) {
        return pieces[x][y][z];
    }

    public void moveLeft() {
        IPiece[][] leftPieces = pieces[LEFT];
        for (IPiece[] llPieces : leftPieces) {
            for (IPiece lPiece : llPieces) {
                lPiece.moveLeft();
            }
        }
    }
}
