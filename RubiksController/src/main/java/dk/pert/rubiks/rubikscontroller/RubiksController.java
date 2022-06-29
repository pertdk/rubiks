package dk.pert.rubiks.rubikscontroller;

import dk.pert.rubiks.rubiksmodel.Cube;


/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */


public class RubiksController {

    private static RubiksController instance;
    private Cube cube;

    private RubiksController() {
        cube = new Cube();
    }

    public static RubiksController getInstance() {
        if (instance == null) {
            instance = new RubiksController();
        }
        return instance;
    }

}
