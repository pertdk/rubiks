package dk.pert.rubiks.rubiksmodel;

import dk.pert.rubiks.rubiksmodel.utils.DummyAbstractPiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AbstractPieceTest {

    @Test
    void testAbstractPieceConstructor() {
        IllegalArgumentException thrown;
        thrown = assertThrows(IllegalArgumentException.class, () -> new DummyAbstractPiece(0));
        assertEquals(String.format(AbstractPiece.ILLEGAL_NUMBER_OF_SURFACES_FORMAT, 0), thrown.getMessage());

        thrown = assertThrows(IllegalArgumentException.class, () -> new DummyAbstractPiece(4));
        assertEquals(String.format(AbstractPiece.ILLEGAL_NUMBER_OF_SURFACES_FORMAT, 4), thrown.getMessage());
    }

    @Test
    void testAbstractPieceSetSurface() {
        IllegalArgumentException allSurfacesAlreadySetException;

        allSurfacesAlreadySetException = assertThrows(IllegalArgumentException.class, () -> {
            DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(1);
            dummyAbstractPiece.setSurface(Direction.front, Color.front);
            dummyAbstractPiece.setSurface(Direction.front, Color.front);
        });
        assertEquals(String.format(AbstractPiece.ALL_SURFACES_ALREADY_SET), allSurfacesAlreadySetException.getMessage());

        IllegalArgumentException onePieceOneColorException;
        onePieceOneColorException = assertThrows(IllegalArgumentException.class, () -> {
            DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(2);
            dummyAbstractPiece.setSurface(Direction.front, Color.front);
            dummyAbstractPiece.setSurface(Direction.front, Color.back);
        });
        assertEquals(String.format(AbstractPiece.ONE_PIECE_ONE_COLOR), onePieceOneColorException.getMessage());


        IllegalArgumentException eachDirSeparateColorException;
        eachDirSeparateColorException = assertThrows(IllegalArgumentException.class, () -> {
            DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(2);
            dummyAbstractPiece.setSurface(Direction.front, Color.front);
            dummyAbstractPiece.setSurface(Direction.back, Color.front);
        });
        assertEquals(String.format(AbstractPiece.EACH_DIR_SEPARATE_COLOR), eachDirSeparateColorException.getMessage());
    }

    @Test
    void testAbstractPieceMoveColor() {
        DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(1);
        dummyAbstractPiece.setSurface(Direction.front, Color.front);

        Color colorRetrieved = dummyAbstractPiece.getSurface(Direction.front);
        assertEquals(colorRetrieved, Color.front);

        dummyAbstractPiece.moveColor(Direction.front, Direction.left);
        IllegalArgumentException thrown;

        thrown = assertThrows(IllegalArgumentException.class, () -> dummyAbstractPiece.getSurface(Direction.front));
        assertEquals(String.format(AbstractPiece.NO_SUCH_DIRECTION), thrown.getMessage());

        Color leftRetrieved = dummyAbstractPiece.getSurface(Direction.left);
        assertEquals(leftRetrieved, Color.front);

    }
}
