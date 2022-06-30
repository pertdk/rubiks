# Rubik's Cube Simulator

This is my version of a Rubiks Cube Simulator. The sole purpose of this project is for me (pert) to fool around with
Java concepts.

## Breaking down the Rubiks Cube

In this project, when I'm talking about a Rubik's cube, I'm referring to a 3x3 cube. A cube have 6 faces of which you
can only view 1-3 at a time. A 3x3 cube is a cube where each of the 6 faces is divided into 3x3 surfaces.

The following pictures are of my standard (3x3) Rubik's.

![Blue, White, Orange](src/main/resources/Rubiks%20-%20Blue-White-Orange.png)
![Red, Blue, Yellow](src/main/resources/Rubiks%20-%20Red-Blue-Yellow.png)
![White, Red, Green](src/main/resources/Rubiks%20-%20White-Red-Green.png)

Imagine a solved Rubik's Cube with the white face in front, the orange face to the left, blue face up, red face right,
green face down, and yellow face in the back. For the purpose of my Rubik's Cube model, I'm going to consider this the
starting point of any Rubik's Cube.

### Center pieces

If you ever disassembled a Rubik's Cube, you'll know that there's a stem with 6 center pieces on it. These 6 center
pieces have a surface with exactly one color, and can't be moved in relation to each other. Sure, you can rotate the
stem around, but in the case of my Rubik's Cube, the white center piece will always be opposite the yellow center piece,
the orange always opposite the red, and the blue opposite the green. No matter how much you twist and turn the Rubik's
Cube, you cannot change the center pieces position in relation to each other.

![Center pieces](src/main/resources/Center%20pieces.png)

Hence, from my model's perspective, you cannot rotate a Rubik's Cube. You can look at it from different angles (like
moving a camera around the cube), but the white center piece is always front, the orange center piece always left, blue
center piece is up, red center piece is right, green center piece is down, and yellow center piece is back.

There are exactly 6 center pieces with of each their own color, corresponding to the faces of a cube.

### Positions (Coordinates)

For convenience, the Rubik's Cube is thought of as consisting of 3x3x3 smaller cubes (but there's actually no smaller
cube in the absolute center of the Rubik's Cube). The absolute center of the Rubik's cube is considered to be in (0,0,0)
in a three-dimensional coordinate system. The white center pieces is then positioned in (0,0,-1). Opposite the white
center pieces is the yellow center piece in (0,0,1). The orange center piece is in (-1,0,0) and opposite is the red
center piece in (1,0,0). The blue center piece is in (0,1,0) and opposite is the green center piece in (0,-1,0). Notice
for all center pieces, two of three coordinates are 0.

1. White: (0,0,-1)
2. Yellow: (0,0,1)
3. Orange: (-1,0,0)
4. Red: (1,0,0)
5. Green: (0,-1,0)
6. Blue: (0,1,0)

### Edge pieces

Next to the center pieces are edge pieces. An edge piece have exactly two surfaces with different colors. Each color
corresponding to a center piece. To the left of the white center piece toward the orange center piece is an edge piece
with the colors white and orange. To the right of the white center piece towards the red center piece is an edge piece
with the colors white and red, and so on, and so forth.

It follows that for a solved Rubik's Cube there must be exactly one edge piece, with the colors orange and white, and
that edge piece must be in a certain position, likewise there's exactly one edge piece, with the colors white and red,
and that edge pieces must be in a certain position too, each and every edge piece has exactly two colors, and one
correct position. If any edge piece is not in its correct position, the cube cannot be solved.

Notice that for all edge pieces one, and only one of two coordinates are 0.

01. Orange-White: (-1,0,-1)
02. Blue-White: (0,1,-1)
03. Red-White: (1,0,-1)
04. Green-White: (0,-1,-1)
05. Orange-Blue: (-1,1,0)
06. Blue-Red: (1,1,0)
07. Orange-Green: (-1,-1,0)
08. Red-Green: (1,-1,0)
09. Blue-Yellow: (0,1,1)
10. Orange-Yellow: (-1,0,1)
11. Red-Yellow: (1,0,1)
12. Green-Yellow: (0,-1,1)

### Corner pieces

The last type of piece is a corner piece. Corner pieces are next to edge pieces, and each corner piece have exactly
three surfaces, with three different colors, each color corresponding to the color of a center piece. The corner piece
above the orange-white edge piece, have the colors orange, white, and blue. The corner pieces below the orange-white
edge piece have the colors orange, white and green. Just as with edge piece, there's exactly one corner piece for each
corner, and each corner pieces must be in a certain position for a Rubik's Cube to be considered solved.

Notice that for all corner pieces no coordinates are 0.

1. Orange-Blue-White: (-1,1,-1)
2. Red-Blue-White: (1,1,-1)
3. Orange-Green-White: (-1,-1,-1)
4. Red-Green-White: (1,-1,-1)
5. Orange-Blue-Yellow: (-1,1,1)
6. Red-Blue-Yellow: (1,1,1)
7. Orange-Green-Yellow: (-1,-1,1)
8. Red-Green-Yellow: (1,-1,1)

### Number of Pieces

So there are exactly

- 6 center pieces, each with one surface,
- 12 edge pieces, each with two surfaces and
- 8 corner pieces, each with three surfaces

Giving a total of 26 pieces and 54 surfaces.

