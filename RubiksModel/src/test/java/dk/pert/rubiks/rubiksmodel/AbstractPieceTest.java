package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.enums.Color;
import dk.pert.rubiks.rubiksmodel.enums.Direction;
import dk.pert.rubiks.rubiksmodel.utils.DummyAbstractPiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AbstractPieceTest {

    @Test
    void testConstructionOfAbstractPieceWithZeroSurfacesThrowsIllegalNumberOfSurfacesFormatException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new DummyAbstractPiece(0));
        assertEquals(String.format(AbstractPiece.ILLEGAL_NUMBER_OF_SURFACES_FORMAT, 0), thrown.getMessage());
    }

    @Test
    void testConstructionOfAbstractPieceWithOneSurfaceCreatesAbstractPieceObject() {
        AbstractPiece abstractPiece = assertDoesNotThrow(() -> new DummyAbstractPiece(1));
        assertEquals(AbstractPiece.class, abstractPiece.getClass().getSuperclass());
    }

    @Test
    void testConstructionOfAbstractPieceWithOneSurfaceCreatesAbstractPieceObjectWithOneSurface() {
        AbstractPiece abstractPiece = assertDoesNotThrow(() -> new DummyAbstractPiece(1));
        assertEquals(1, abstractPiece.noOfSurfaces);
    }

    @Test
    void testConstructionOfAbstractPieceWith2SurfaceCreatesAbstractPieceObject() {
        AbstractPiece abstractPiece = assertDoesNotThrow(() -> new DummyAbstractPiece(2));
        assertEquals(AbstractPiece.class, abstractPiece.getClass().getSuperclass());
    }

    @Test
    void testConstructionOfAbstractPieceWithTwoSurfacesCreatesAbstractPieceObjectWithTwoSurfaces() {
        AbstractPiece abstractPiece = assertDoesNotThrow(() -> new DummyAbstractPiece(2));
        assertEquals(2, abstractPiece.noOfSurfaces);
    }

    @Test
    void testConstructionOfAbstractPieceWith3SurfaceCreatesAbstractPieceObject() {
        AbstractPiece abstractPiece = assertDoesNotThrow(() -> new DummyAbstractPiece(3));
        assertEquals(AbstractPiece.class, abstractPiece.getClass().getSuperclass());
    }

    @Test
    void testConstructionOfAbstractPieceWithThreeSurfacesCreatesAbstractPieceObjectWithThreeSurfaces() {
        AbstractPiece abstractPiece = assertDoesNotThrow(() -> new DummyAbstractPiece(3));
        assertEquals(3, abstractPiece.noOfSurfaces);
    }

    @Test
    void testConstructionOfAbstractPieceWith4SurfacesThrowsIllegalNumberOfSurfacesFormatException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new DummyAbstractPiece(4));
        assertEquals(String.format(AbstractPiece.ILLEGAL_NUMBER_OF_SURFACES_FORMAT, 4), thrown.getMessage());
    }

    @Test
    void testAttemptToSetSameColorForAlreadyColoredSurfaceThrowsAllSurfacesAlreadySetException() {
        DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(1);
        dummyAbstractPiece.setSurface(Direction.FRONT, Color.GREEN);
        IllegalArgumentException allSurfacesAlreadySetException = assertThrows(IllegalArgumentException.class,
                () -> dummyAbstractPiece.setSurface(Direction.FRONT, Color.GREEN)
        );
        assertEquals(String.format(AbstractPiece.ALL_SURFACES_ALREADY_SET), allSurfacesAlreadySetException.getMessage());
    }

    @Test
    void testAttemptToSetNewColorForAlreadyColoredSurfaceThrowsOnePieceOneColorException() {
        DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(2);
        dummyAbstractPiece.setSurface(Direction.FRONT, Color.GREEN);

        IllegalArgumentException onePieceOneColorException = assertThrows(IllegalArgumentException.class,
                () -> dummyAbstractPiece.setSurface(Direction.FRONT, Color.BLUE)
        );
        assertEquals(String.format(AbstractPiece.ONE_PIECE_ONE_COLOR), onePieceOneColorException.getMessage());

    }

    @Test
    void testAttemptToUseSameColorForOtherDirectionThrowsEachDirSeparateColorException() {
        DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(2);
        dummyAbstractPiece.setSurface(Direction.FRONT, Color.GREEN);
        IllegalArgumentException eachDirSeparateColorException = assertThrows(IllegalArgumentException.class,
                () -> dummyAbstractPiece.setSurface(Direction.BACK, Color.GREEN)
        );
        assertEquals(String.format(AbstractPiece.EACH_DIR_SEPARATE_COLOR), eachDirSeparateColorException.getMessage());
    }

    @Test
    void testColorSetForDirectionHasThatColor() {
        DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(1);
        dummyAbstractPiece.setSurface(Direction.FRONT, Color.GREEN);
        assertEquals(Color.GREEN, dummyAbstractPiece.getSurface(Direction.FRONT));
    }

    @Test
    void testAbstractPieceMoveColor() {
        DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(1);
        dummyAbstractPiece.setSurface(Direction.FRONT, Color.GREEN);

        Color colorRetrieved = dummyAbstractPiece.getSurface(Direction.FRONT);
        assertEquals(colorRetrieved, Color.GREEN);

        dummyAbstractPiece.moveColor(Direction.FRONT, Direction.LEFT);
        IllegalArgumentException thrown;

        thrown = assertThrows(IllegalArgumentException.class, () -> dummyAbstractPiece.getSurface(Direction.FRONT));
        assertEquals(String.format(AbstractPiece.NO_SUCH_DIRECTION), thrown.getMessage());

        Color leftRetrieved = dummyAbstractPiece.getSurface(Direction.LEFT);
        assertEquals(leftRetrieved, Color.GREEN);

    }
}
