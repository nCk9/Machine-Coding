package org.GameEngine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    String cellColour;
    Piece currentPiece =  null;
    Integer cellX;
    Integer cellY;
}
