package dk.pert.rubiks.model.enums;

/**
 * Represents the possible colors of surfaces in the Rubik's cube.
 * These are named after the traditional colors of a classic 3x3 Rubik's cube,
 * but it is just names of colors.
 * One could think of them as virtual colors, and any library user is free
 * to render these virtual colors however they see fit.
 *
 * @author PET@nykredit.dk
 */

public enum Color {
    GREEN('G'),
    BLUE('B'),
    ORANGE('O'),
    RED('R'),
    WHITE('W'),
    YELLOW('Y');

    private final char color;

    Color(char color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.valueOf(this.color);
    }


}