package dk.pert.rubiks.model.interfaces;

public interface ErrorMessages {
    String ILLEGAL_NUMBER_OF_SURFACES_FORMAT = "Illegal number of surfaces: %o. Must be 1,2 or 3.";
    String NO_DUPLICATE_COLORS = "A piece can't contain multiple surfaces of the same color.";
    String NO_DUPLICATE_DIRECTIONS = "A piece can't contain multiple surfaces pointing tin ehe same direction.";
}
