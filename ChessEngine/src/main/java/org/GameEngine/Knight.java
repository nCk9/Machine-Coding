package org.GameEngine;

public class Knight extends Piece{

    Knight(String name){
        pieceName = name;
    }

    @Override
    public Boolean isValidMove(Integer currX, Integer currY, Integer newX, Integer newY){
        // logic to check if move to newX, newY is valid from currX, currY
        if(newX < 1 || newX > 8 || newY < 1 || newY > 8)
            return false;
        return (Math.abs(newX-currX) == 2 && Math.abs(newY - currY) == 1) || (Math.abs(newX-currX) == 1 && Math.abs(newY - currY) == 2);
    }

    @Override
    public void makeMove(Integer currX, Integer currY, Integer newX, Integer newY) {

    }
}
