package org.GameEngine;

public class Queen extends Piece{

    Queen(String name){
        pieceName = name;
    }

    @Override
    public Boolean isValidMove(Integer currX, Integer currY, Integer newX, Integer newY){
        // logic to check if move to newX, newY is valid from currX, currY
        if(newX < 1 || newX > 8 || newY < 1 || newY > 8)
            return false;
        return currX.intValue() == newX.intValue() || currY.intValue() == newY.intValue() || Math.abs(currX-newX) == Math.abs(currY-newY);
    }

    @Override
    public void makeMove(Integer currX, Integer currY, Integer newX, Integer newY) {

    }
}
