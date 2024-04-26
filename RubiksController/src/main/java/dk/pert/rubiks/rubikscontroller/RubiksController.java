package dk.pert.rubiks.rubikscontroller;

import dk.pert.rubiks.model.Cube;
import dk.pert.rubiks.model.enums.Direction;


/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */


public class RubiksController {

    private static RubiksController instance;
    private final Cube cube;

    private RubiksController() {
        cube = new Cube();
    }

    public static RubiksController getInstance() {
        if (instance == null) {
            instance = new RubiksController();
        }
        return instance;
    }

    public void rotateLeft() {
        cube.rotateLeft();
    }

    public String get2DTextual() {
        return "    " +
                cube.getPiece(Cube.LEFT, Cube.TOP, Cube.BACK).getSurface(Direction.UP).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.TOP, Cube.BACK).getSurface(Direction.UP).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.TOP, Cube.BACK).getSurface(Direction.UP).getColor().toString() +
                "    \n    " +
                cube.getPiece(Cube.LEFT, Cube.TOP, Cube.CENTER).getSurface(Direction.UP).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.TOP, Cube.CENTER).getSurface(Direction.UP).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.TOP, Cube.CENTER).getSurface(Direction.UP).getColor().toString() +
                "    \n    " +
                cube.getPiece(Cube.LEFT, Cube.TOP, Cube.FRONT).getSurface(Direction.UP).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.TOP, Cube.FRONT).getSurface(Direction.UP).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.TOP, Cube.FRONT).getSurface(Direction.UP).getColor().toString() +
                "\n" +
                cube.getPiece(Cube.LEFT, Cube.TOP, Cube.BACK).getSurface(Direction.LEFT).getColor().toString() +
                cube.getPiece(Cube.LEFT, Cube.TOP, Cube.CENTER).getSurface(Direction.LEFT).getColor().toString() +
                cube.getPiece(Cube.LEFT, Cube.TOP, Cube.FRONT).getSurface(Direction.LEFT).getColor().toString() +
                " " +
                cube.getPiece(Cube.LEFT, Cube.TOP, Cube.FRONT).getSurface(Direction.FRONT).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.TOP, Cube.FRONT).getSurface(Direction.FRONT).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.TOP, Cube.FRONT).getSurface(Direction.FRONT).getColor().toString() +
                " " +
                cube.getPiece(Cube.RIGHT, Cube.TOP, Cube.FRONT).getSurface(Direction.RIGHT).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.TOP, Cube.CENTER).getSurface(Direction.RIGHT).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.TOP, Cube.BACK).getSurface(Direction.RIGHT).getColor().toString() +
                "\n" +
                cube.getPiece(Cube.LEFT, Cube.CENTER, Cube.BACK).getSurface(Direction.LEFT).getColor().toString() +
                cube.getPiece(Cube.LEFT, Cube.CENTER, Cube.CENTER).getSurface(Direction.LEFT).getColor().toString() +
                cube.getPiece(Cube.LEFT, Cube.CENTER, Cube.FRONT).getSurface(Direction.LEFT).getColor().toString() +
                " " +
                cube.getPiece(Cube.LEFT, Cube.CENTER, Cube.FRONT).getSurface(Direction.FRONT).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.CENTER, Cube.FRONT).getSurface(Direction.FRONT).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.CENTER, Cube.FRONT).getSurface(Direction.FRONT).getColor().toString() +
                " " +
                cube.getPiece(Cube.RIGHT, Cube.CENTER, Cube.FRONT).getSurface(Direction.RIGHT).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.CENTER, Cube.CENTER).getSurface(Direction.RIGHT).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.CENTER, Cube.BACK).getSurface(Direction.RIGHT).getColor().toString() +
                "\n" +
                cube.getPiece(Cube.LEFT, Cube.BOTTOM, Cube.BACK).getSurface(Direction.LEFT).getColor().toString() +
                cube.getPiece(Cube.LEFT, Cube.BOTTOM, Cube.CENTER).getSurface(Direction.LEFT).getColor().toString() +
                cube.getPiece(Cube.LEFT, Cube.BOTTOM, Cube.FRONT).getSurface(Direction.LEFT).getColor().toString() +
                " " +
                cube.getPiece(Cube.LEFT, Cube.BOTTOM, Cube.FRONT).getSurface(Direction.FRONT).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.BOTTOM, Cube.FRONT).getSurface(Direction.FRONT).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.BOTTOM, Cube.FRONT).getSurface(Direction.FRONT).getColor().toString() +
                " " +
                cube.getPiece(Cube.RIGHT, Cube.BOTTOM, Cube.FRONT).getSurface(Direction.RIGHT).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.BOTTOM, Cube.CENTER).getSurface(Direction.RIGHT).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.BOTTOM, Cube.BACK).getSurface(Direction.RIGHT).getColor().toString() +
                "\n    " +
                cube.getPiece(Cube.LEFT, Cube.BOTTOM, Cube.FRONT).getSurface(Direction.DOWN).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.BOTTOM, Cube.FRONT).getSurface(Direction.DOWN).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.BOTTOM, Cube.FRONT).getSurface(Direction.DOWN).getColor().toString() +
                "    \n    " +
                cube.getPiece(Cube.LEFT, Cube.BOTTOM, Cube.CENTER).getSurface(Direction.DOWN).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.BOTTOM, Cube.CENTER).getSurface(Direction.DOWN).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.BOTTOM, Cube.CENTER).getSurface(Direction.DOWN).getColor().toString() +
                "    \n    " +
                cube.getPiece(Cube.LEFT, Cube.BOTTOM, Cube.BACK).getSurface(Direction.DOWN).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.BOTTOM, Cube.BACK).getSurface(Direction.DOWN).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.BOTTOM, Cube.BACK).getSurface(Direction.DOWN).getColor().toString() +
                "    \n    " +
                cube.getPiece(Cube.LEFT, Cube.BOTTOM, Cube.BACK).getSurface(Direction.BACK).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.BOTTOM, Cube.BACK).getSurface(Direction.BACK).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.BOTTOM, Cube.BACK).getSurface(Direction.BACK).getColor().toString() +
                "    \n    " +
                cube.getPiece(Cube.LEFT, Cube.CENTER, Cube.BACK).getSurface(Direction.BACK).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.CENTER, Cube.BACK).getSurface(Direction.BACK).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.CENTER, Cube.BACK).getSurface(Direction.BACK).getColor().toString() +
                "    \n    " +
                cube.getPiece(Cube.LEFT, Cube.TOP, Cube.BACK).getSurface(Direction.BACK).getColor().toString() +
                cube.getPiece(Cube.CENTER, Cube.TOP, Cube.BACK).getSurface(Direction.BACK).getColor().toString() +
                cube.getPiece(Cube.RIGHT, Cube.TOP, Cube.BACK).getSurface(Direction.BACK).getColor().toString();
    }

}
