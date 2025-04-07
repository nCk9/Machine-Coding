package org.GameEngine;

public class Pawn extends Piece{
    Pawn(String name){
        pieceName = name;
    }

    @Override
    public Boolean isValidMove(Integer currX, Integer currY, Integer newX, Integer newY){
        // logic to check if move to newX, newY is valid from currX, currY
        if(newX < 1 || newX > 8 || newY < 1 || newY > 8)
            return false;
        return newX - currX == 1;
    }

    @Override
    public void makeMove(Integer currX, Integer currY, Integer newX, Integer newY) {

    }
}
