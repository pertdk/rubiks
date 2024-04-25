package dk.pert.rubiks.model.pieces;

import dk.pert.rubiks.model.Surface;
import dk.pert.rubiks.model.enums.Color;
import dk.pert.rubiks.model.enums.Direction;
import dk.pert.rubiks.model.interfaces.ISurface;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static dk.pert.rubiks.model.interfaces.ErrorMessages.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractPieceTest {

    @Test
    public void testAbstractPieceConstructor() {
        assertDoesNotThrow(() -> {
            new DefaultPiece(getValidSurfaces());
        });
    }

    @Test
    public void testAbstractPieceConstructorNoSurfaces() {
        ISurface[] surfaces = new ISurface[0];
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new DefaultPiece(surfaces));
        assertEquals(String.format(ILLEGAL_NUMBER_OF_SURFACES_FORMAT, surfaces.length), e.getMessage());
    }

    @Test
    public void testAbstractPieceConstructorTooManySurfaces() {
        ISurface[] surfaces = new ISurface[4];
        surfaces[0] = new Surface(Color.BLUE, Direction.BACK);
        surfaces[1] = new Surface(Color.ORANGE, Direction.DOWN);
        surfaces[2] = new Surface(Color.GREEN, Direction.LEFT);
        surfaces[3] = new Surface(Color.YELLOW, Direction.BACK);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new DefaultPiece(surfaces));
        assertEquals(String.format(ILLEGAL_NUMBER_OF_SURFACES_FORMAT, surfaces.length), e.getMessage());
    }

    @Test
    public void testAbstractPieceConstructorDuplicateColor() {
        ISurface[] surfaces = new ISurface[3];
        surfaces[0] = new Surface(Color.BLUE, Direction.BACK);
        surfaces[1] = new Surface(Color.ORANGE, Direction.DOWN);
        surfaces[2] = new Surface(Color.BLUE, Direction.LEFT);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new DefaultPiece(surfaces));
        assertEquals(NO_DUPLICATE_COLORS, e.getMessage());
    }

    @Test
    public void testAbstractPieceConstructorDuplicateDirection() {
        ISurface[] surfaces = new ISurface[3];
        surfaces[0] = new Surface(Color.BLUE, Direction.BACK);
        surfaces[1] = new Surface(Color.ORANGE, Direction.DOWN);
        surfaces[2] = new Surface(Color.GREEN, Direction.BACK);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new DefaultPiece(surfaces));
        assertEquals(NO_DUPLICATE_DIRECTIONS, e.getMessage());
    }


    private ISurface[] getValidSurfaces() {
        ISurface[] surfaces = new ISurface[3];
        surfaces[0] = new Surface(Color.BLUE, Direction.BACK);
        surfaces[1] = new Surface(Color.ORANGE, Direction.DOWN);
        surfaces[2] = new Surface(Color.GREEN, Direction.LEFT);
        return surfaces;
    }

    @Test
    public void testMoveSurface() {
        DefaultPiece defaultPiece = new DefaultPiece(getValidSurfaces());
        assertDoesNotThrow(() -> defaultPiece.moveSurface(Direction.RIGHT, Direction.FRONT));
    }


    private static class DefaultPiece extends AbstractPiece {

        public DefaultPiece(@NotNull ISurface... surfaces) throws IllegalArgumentException {
            super(surfaces);
        }
    }
}