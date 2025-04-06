package org.GameEngine;

public abstract class Piece {
    String pieceName;
    private Boolean isActive = true;

    public Boolean getStatus(){
        return isActive;
    }

    void setStatus(Boolean flag){
        isActive = flag;
    }

    String getName(){
        return pieceName;
    }

    public abstract Boolean isValidMove(Integer currX, Integer currY, Integer newX, Integer newY);
}