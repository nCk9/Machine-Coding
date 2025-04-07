package org.GameEngine;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Map;

public class Board {
    Cell[][] board;

    Board(Rook bRook2, Rook bRook1, Knight bKnight1, Knight bKnight2, Bishop bBishop1, Bishop bBishop2, Pawn[] bPawns, King bKing, King wKing, Queen wQueen, Queen bQueen, Rook wRook2, Rook wRook1, Knight wKnight1, Knight wKnight2, Bishop wBishop1, Bishop wBishop2, Pawn[] wPawns){
        board = new Cell[9][9];
        Integer cellCol = 1;
        for(int i=1; i<9; i++){
            cellCol ^= 1;
            for(int j=1; j<9; j++){
                Cell currCell = new Cell();
                currCell.setCellColour(cellCol.toString());
                currCell.setCellX(i);
                currCell.setCellY(j);
                board[i][j] = currCell;
                cellCol ^= 1;
            }
        }

        board[1][1].setCurrentPiece(bRook1);
        board[1][8].setCurrentPiece(bRook2);
        board[1][2].setCurrentPiece(bKnight1);
        board[1][7].setCurrentPiece(bKnight2);
        board[1][3].setCurrentPiece(bBishop1);
        board[1][6].setCurrentPiece(bBishop2);
        board[1][4].setCurrentPiece(bKing);
        board[1][5].setCurrentPiece(bQueen);
        for(int j=1; j<9; j++)
            board[2][j].setCurrentPiece(bPawns[j-1]);

        board[8][1].setCurrentPiece(wRook1);
        board[8][8].setCurrentPiece(wRook2);
        board[8][2].setCurrentPiece(wKnight1);
        board[8][7].setCurrentPiece(wKnight2);
        board[8][3].setCurrentPiece(wBishop1);
        board[8][6].setCurrentPiece(wBishop2);
        board[8][4].setCurrentPiece(wKing);
        board[8][5].setCurrentPiece(wQueen);
        for(int j=1; j<9; j++)
            board[7][j].setCurrentPiece(wPawns[j-1]);


    }

    public void updateActivePieces(Map<String, Cell> activePieces){

        for(int i=1; i<9; i++)
            for(int j=1; j<9; j++){
                if(board[i][j].getCurrentPiece() != null &&  board[i][j].getCurrentPiece().getStatus())
                    activePieces.put(board[i][j].getCurrentPiece().getName(), board[i][j]);
            }
    }

    void getBoard(){
        for(int i=1; i<9; i++){
            for(int j=1; j<9; j++){
                System.out.print(board[i][j].getCellColour() + "(" + board[i][j].getCellX() + ", " + board[i][j].getCellY() + ")");
                if(board[i][j].getCurrentPiece() != null)
                    System.out.print(board[i][j].getCurrentPiece().getName());

                System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
}
