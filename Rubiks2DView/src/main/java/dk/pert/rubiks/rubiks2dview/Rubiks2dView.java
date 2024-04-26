package dk.pert.rubiks.rubiks2dview;

import dk.pert.rubiks.rubikscontroller.RubiksController;

/**
 * Place description here.
 *
 * @author PET@nykredit.dk
 */

public class Rubiks2dView {


    public static void main(String[] args) {
        RubiksController rubiksController = RubiksController.getInstance();

        System.out.println(rubiksController.get2DTextual());
/*
    BBB
    BBB
    BBB
OOO WWW RRR
OOO WWW RRR
OOO WWW RRR
    GGG
    GGG
    GGG
    YYY
    YYY
    YYY
 */

        rubiksController.rotateLeft();

        System.out.println(rubiksController.get2DTextual());
/*
    YBB
    YBB
    YBB
OOO BWW RRR
OOO BWW RRR
OOO BWW RRR
    WGG
    WGG
    WGG
    GYY
    GYY
    GYY
 */


    }
}
