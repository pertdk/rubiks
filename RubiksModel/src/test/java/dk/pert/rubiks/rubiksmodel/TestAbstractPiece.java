package dk.pert.rubiks.rubiksmodel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAbstractPiece {

    @Test
    void testAbstractPieceConstructor() {
        IllegalArgumentException thrown;
        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> new DummyAbstractPiece(0));
        Assertions.assertEquals(String.format(AbstractPiece.ILLEGAL_NUMBER_OF_SURFACES_FORMAT, 0), thrown.getMessage());

        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> new DummyAbstractPiece(4));
        Assertions.assertEquals(String.format(AbstractPiece.ILLEGAL_NUMBER_OF_SURFACES_FORMAT, 4), thrown.getMessage());
    }

    @Test
    void testAbstractPieceSetSurface() {
        IllegalArgumentException allSurfacesAlreadySetException;

        allSurfacesAlreadySetException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(1);
            dummyAbstractPiece.setSurface(Direction.front, Color.front);
            dummyAbstractPiece.setSurface(Direction.front, Color.front);
        });
        Assertions.assertEquals(String.format(AbstractPiece.ALL_SURFACES_ALREADY_SET), allSurfacesAlreadySetException.getMessage());

        IllegalArgumentException onePieceOneColorException;
        onePieceOneColorException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(2);
            dummyAbstractPiece.setSurface(Direction.front, Color.front);
            dummyAbstractPiece.setSurface(Direction.front, Color.back);
        });
        Assertions.assertEquals(String.format(AbstractPiece.ONE_PIECE_ONE_COLOR), onePieceOneColorException.getMessage());


        IllegalArgumentException eachDirSeparateColorException;
        eachDirSeparateColorException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(2);
            dummyAbstractPiece.setSurface(Direction.front, Color.front);
            dummyAbstractPiece.setSurface(Direction.back, Color.front);
        });
        Assertions.assertEquals(String.format(AbstractPiece.EACH_DIR_SEPARATE_COLOR), eachDirSeparateColorException.getMessage());
    }

    @Test
    void testAbstractPieceMoveColor() {
        DummyAbstractPiece dummyAbstractPiece = new DummyAbstractPiece(1);
        dummyAbstractPiece.setSurface(Direction.front, Color.front);

        Color colorRetrieved = dummyAbstractPiece.getSurface(Direction.front);
        Assertions.assertEquals(colorRetrieved, Color.front);

        dummyAbstractPiece.moveColor(Direction.front, Direction.left);
        IllegalArgumentException thrown;

        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> dummyAbstractPiece.getSurface(Direction.front));
        Assertions.assertEquals(String.format(AbstractPiece.NO_SUCH_DIRECTION), thrown.getMessage());

        Color leftRetrieved = dummyAbstractPiece.getSurface(Direction.left);
        Assertions.assertEquals(leftRetrieved, Color.front);

    }
}
