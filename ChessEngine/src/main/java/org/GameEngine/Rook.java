package org.GameEngine;

public class Rook extends Piece{

    Rook(String name){
        pieceName = name;
    }

    @Override
    public Boolean isValidMove(Integer currX, Integer currY, Integer newX, Integer newY) {
        //add logic to check if move to newX, newY is valid from currX, currY
        return true;
    }
}
