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
    public static final int CENTER = 1;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int TOP = 2;
    public static final int BOTTOM = 0;
    public static final int FRONT = 0;
    public static final int BACK = 2;

    /* Center pieces */
    private final IPiece whiteCenter = new CenterPiece(new Surface(Color.WHITE, Direction.FRONT));
    private final IPiece orangeCenter = new CenterPiece(new Surface(Color.ORANGE, Direction.LEFT));
    private final IPiece greenCenter = new CenterPiece(new Surface(Color.GREEN, Direction.DOWN));
    private final IPiece blueCenter = new CenterPiece(new Surface(Color.BLUE, Direction.UP));
    private final IPiece redCenter = new CenterPiece(new Surface(Color.RED, Direction.RIGHT));
    private final IPiece yellowCenter = new CenterPiece(new Surface(Color.YELLOW, Direction.BACK));

    /* Edge pieces */
    private final IPiece orangeBlueEdge = new EdgePiece(
            new Surface(Color.ORANGE, Direction.LEFT),
            new Surface(Color.BLUE, Direction.UP)
    );

    private final IPiece orangeWhiteEdge = new EdgePiece(
            new Surface(Color.ORANGE, Direction.LEFT),
            new Surface(Color.WHITE, Direction.FRONT)
    );
    private final IPiece orangeYellowEdge = new EdgePiece(
            new Surface(Color.ORANGE, Direction.LEFT),
            new Surface(Color.YELLOW, Direction.BACK)
    );
    private final IPiece orangeGreenEdge = new EdgePiece(
            new Surface(Color.ORANGE, Direction.LEFT),
            new Surface(Color.GREEN, Direction.DOWN)
    );

    private final IPiece redBlueEdge = new EdgePiece(
            new Surface(Color.RED, Direction.RIGHT),
            new Surface(Color.BLUE, Direction.UP)
    );
    private final IPiece redYellowEdge = new EdgePiece(
            new Surface(Color.RED, Direction.RIGHT),
            new Surface(Color.YELLOW, Direction.BACK)
    );
    private final IPiece redWhiteEdge = new EdgePiece(
            new Surface(Color.RED, Direction.RIGHT),
            new Surface(Color.WHITE, Direction.FRONT)
    );
    private final IPiece redGreenEdge = new EdgePiece(
            new Surface(Color.RED, Direction.RIGHT),
            new Surface(Color.GREEN, Direction.DOWN)
    );
    private final IPiece yellowBlueEdge = new EdgePiece(
            new Surface(Color.YELLOW, Direction.BACK),
            new Surface(Color.BLUE, Direction.UP)
    );
    private final IPiece whiteBlueEdge = new EdgePiece(
            new Surface(Color.WHITE, Direction.FRONT),
            new Surface(Color.BLUE, Direction.UP)
    );
    private final IPiece yellowGreenEdge = new EdgePiece(
            new Surface(Color.YELLOW, Direction.BACK),
            new Surface(Color.GREEN, Direction.DOWN)
    );
    private final IPiece whiteGreenEdge = new EdgePiece(
            new Surface(Color.WHITE, Direction.FRONT),
            new Surface(Color.GREEN, Direction.DOWN)
    );
    private final IPiece orangeWhiteBlueCorner = new CornerPiece(
            new Surface(Color.ORANGE, Direction.LEFT),
            new Surface(Color.WHITE, Direction.FRONT),
            new Surface(Color.BLUE, Direction.UP)
    );
    private final IPiece orangeWhiteGreenCorner = new CornerPiece(
            new Surface(Color.ORANGE, Direction.LEFT),
            new Surface(Color.WHITE, Direction.FRONT),
            new Surface(Color.GREEN, Direction.DOWN)
    );
    private final IPiece orangeYellowBlueCorner = new CornerPiece(
            new Surface(Color.ORANGE, Direction.LEFT),
            new Surface(Color.YELLOW, Direction.BACK),
            new Surface(Color.BLUE, Direction.UP)
    );
    private final IPiece orangeYellowGreenCorner = new CornerPiece(
            new Surface(Color.ORANGE, Direction.LEFT),
            new Surface(Color.YELLOW, Direction.BACK),
            new Surface(Color.GREEN, Direction.DOWN)
    );
    private final IPiece redWhiteBlueCorner = new CornerPiece(
            new Surface(Color.RED, Direction.RIGHT),
            new Surface(Color.WHITE, Direction.FRONT),
            new Surface(Color.BLUE, Direction.UP)
    );
    private final IPiece redWhiteGreenCorner = new CornerPiece(
            new Surface(Color.RED, Direction.RIGHT),
            new Surface(Color.WHITE, Direction.FRONT),
            new Surface(Color.GREEN, Direction.DOWN)
    );
    private final IPiece redYellowBlueCorner = new CornerPiece(
            new Surface(Color.RED, Direction.RIGHT),
            new Surface(Color.YELLOW, Direction.BACK),
            new Surface(Color.BLUE, Direction.UP)
    );
    private final IPiece redYellowGreenCorner = new CornerPiece(
            new Surface(Color.RED, Direction.RIGHT),
            new Surface(Color.YELLOW, Direction.BACK),
            new Surface(Color.GREEN, Direction.DOWN)
    );
    private final IPiece[][][] pieces;

    public Cube() {
        pieces = new IPiece[3][3][3];
        createCenterPieces();
        createEdgePieces();
        createCornerPieces();
    }

    private void createCenterPieces() {
        /* Notice all center pieces have exactly two CENTER coordinates */
        /* white face in front, the orange face to the left, blue face up, red face right,
        green face down, and yellow face in the back */

        /* White  front */
        pieces[CENTER][CENTER][FRONT] = whiteCenter;
        /* Orange left */
        pieces[LEFT][CENTER][CENTER] = orangeCenter;
        /* Blue up */
        pieces[CENTER][TOP][CENTER] = blueCenter;
        /* Red right */
        pieces[RIGHT][CENTER][CENTER] = redCenter;
        /* Green down */
        pieces[CENTER][BOTTOM][CENTER] = greenCenter;
        /* Yellow back */
        pieces[CENTER][CENTER][BACK] = yellowCenter;
    }

    private void createEdgePieces() {
        /* Notice all edge pieces have exactly one CENTER coordinate */
        pieces[LEFT][TOP][CENTER] = orangeBlueEdge;
        pieces[LEFT][CENTER][FRONT] = orangeWhiteEdge;
        pieces[LEFT][CENTER][BACK] = orangeYellowEdge;
        pieces[LEFT][BOTTOM][CENTER] = orangeGreenEdge;

        pieces[RIGHT][TOP][CENTER] = redBlueEdge;
        pieces[RIGHT][CENTER][BACK] = redYellowEdge;
        pieces[RIGHT][CENTER][FRONT] = redWhiteEdge;
        pieces[RIGHT][BOTTOM][CENTER] = redGreenEdge;

        pieces[CENTER][TOP][BACK] = yellowBlueEdge;
        pieces[CENTER][TOP][FRONT] = whiteBlueEdge;
        pieces[CENTER][BOTTOM][BACK] = yellowGreenEdge;
        pieces[CENTER][BOTTOM][FRONT] = whiteGreenEdge;
    }

    private void createCornerPieces() {
        /* Notice corner pieces does not have any CENTER coordinate */
        pieces[LEFT][TOP][BACK] = orangeYellowBlueCorner;
        pieces[LEFT][TOP][FRONT] = orangeWhiteBlueCorner;
        pieces[LEFT][BOTTOM][BACK] = orangeYellowGreenCorner;
        pieces[LEFT][BOTTOM][FRONT] = orangeWhiteGreenCorner;
        pieces[RIGHT][TOP][BACK] = redYellowBlueCorner;
        pieces[RIGHT][TOP][FRONT] = redWhiteBlueCorner;
        pieces[RIGHT][BOTTOM][BACK] = redYellowGreenCorner;
        pieces[RIGHT][BOTTOM][FRONT] = redWhiteGreenCorner;
    }

    public IPiece getPiece(int x, int y, int z) {
        return pieces[x][y][z];
    }

    public void rotateLeft() {
        IPiece leftTopFrontCorner = pieces[LEFT][TOP][FRONT];
        pieces[LEFT][TOP][FRONT] = pieces[LEFT][TOP][BACK];
        pieces[LEFT][TOP][FRONT].moveLeft();
        pieces[LEFT][TOP][BACK] = pieces[LEFT][BOTTOM][BACK];
        pieces[LEFT][TOP][BACK].moveLeft();
        pieces[LEFT][BOTTOM][BACK] = pieces[LEFT][BOTTOM][FRONT];
        pieces[LEFT][BOTTOM][BACK].moveLeft();
        pieces[LEFT][BOTTOM][FRONT] = leftTopFrontCorner;
        pieces[LEFT][BOTTOM][FRONT].moveLeft();

        IPiece leftTopCenterEdge = pieces[LEFT][TOP][CENTER];
        pieces[LEFT][TOP][CENTER] = pieces[LEFT][CENTER][BACK];
        pieces[LEFT][TOP][CENTER].moveLeft();
        pieces[LEFT][CENTER][BACK] = pieces[LEFT][BOTTOM][CENTER];
        pieces[LEFT][CENTER][BACK].moveLeft();
        pieces[LEFT][BOTTOM][CENTER] = pieces[LEFT][CENTER][FRONT];
        pieces[LEFT][BOTTOM][CENTER].moveLeft();
        pieces[LEFT][CENTER][FRONT] = leftTopCenterEdge;
        pieces[LEFT][CENTER][FRONT].moveLeft();

    }


}
