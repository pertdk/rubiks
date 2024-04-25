package dk.pert.rubiks.model.interfaces;

import dk.pert.rubiks.model.enums.Color;
import dk.pert.rubiks.model.enums.Direction;
import dk.pert.rubiks.model.enums.Move;

/**
 * A surface is something that is created with a certain color, and a certain direction.
 * The color of a surface can never be changed, but the direction can.
 * Fx. a green face on an edge piece, will always be green, but depending on how the edge piece is
 * moved around on the cube, it may be pointing up before a certain move, but point right after the move.
 */
public interface ISurface {

    void move(Move move);

    Direction getDirection();

    void setDirection(Direction direction);

    Color getColor();

    @Override
    boolean equals(Object object);
}
