package org.GameEngine;

import java.util.HashMap;
import java.util.Map;

public class ChessEngine {
    private final Player player1;
    private final Player player2;
    private final Board chessBoard;
    private final Rook bRook1;
    private final Rook bRook2;
    private final Rook wRook1;
    private final Rook wRook2;
    private final Knight bKnight1;
    private final Knight bKnight2;
    private final Knight wKnight1;
    private final Knight wKnight2;
    private final Bishop bBishop1;
    private final Bishop bBishop2;
    private final Bishop wBishop1;
    private final Bishop wBishop2;
    private final King bKing;
    private final King wKing;
    private final Queen bQueen;
    private final Queen wQueen;
    private final Pawn wPawns[];
    private final Pawn bPawns[];
    Map<String, Cell> activePieces;


    ChessEngine(){
        player1 = new Player();
        player2 = new Player();
        bRook1 = new Rook("bRook1");
        bRook2 = new Rook("bRook2");
        wRook1 = new Rook("wRook1");
        wRook2 = new Rook("wRook2");
        bKnight1 = new Knight("bKnight1");
        bKnight2 = new Knight("bKnight2");
        wKnight1 = new Knight("wKnight1");
        wKnight2 = new Knight("wKnight2");
        bBishop1 = new Bishop("bBishop1");
        bBishop2 = new Bishop("bBishop2");
        wBishop1 = new Bishop("wBishop1");
        wBishop2 = new Bishop("wBishop2");
        bKing = new King("bKing");
        wKing = new King("wKing");
        wQueen = new Queen("wQueen");
        bQueen = new Queen("bQueen");
        wPawns = new Pawn[8];
        bPawns = new Pawn[8];
        for(int i=0; i<8; i++)
            wPawns[i] = new Pawn("wPawn" + (i+1));
        for(int i=0; i<8; i++)
            bPawns[i] = new Pawn("bPawn" + (i+1));
        chessBoard = new Board(bRook2, bRook1, bKnight1, bKnight2, bBishop1, bBishop2, bPawns, bKing, wKing,
                wQueen, bQueen, wRook2, wRook1, wKnight1, wKnight2, wBishop1, wBishop2, wPawns);

        activePieces = new HashMap<String, Cell>();
        chessBoard.updateActivePieces(activePieces);
    }

    void createPlayer(String name, String colour, Integer idx){
        if(idx == 0) {
            player1.setPlayerName(name);
            player1.setPlayingColour(colour);
        }
        else{
            player2.setPlayerName(name);
            if(player1.getPlayingColour().equalsIgnoreCase("white"))
                player2.setPlayingColour("black");
            else
                player2.setPlayingColour("white");
        }
    }

    void getBoardStatus(){
        chessBoard.getBoard();
    }

    Boolean makeMoveIfValid(String pieceName, Integer newRow, Integer newCol){
        Cell currentCell  = activePieces.get(pieceName);
        Integer currRow = currentCell.getCellX();
        Integer currCol = currentCell.getCellY();
        Piece currentPiece = currentCell.getCurrentPiece();
        if(currentPiece.isValidMove(currRow, currCol, newRow, newCol))
            currentPiece.makeMove(currRow, currCol, newRow, newCol);

        return false;
    }
}
