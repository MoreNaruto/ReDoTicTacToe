package com.company;

import java.io.PrintStream;

/**
 * Created by thomasmorris on 6/22/14.
 */
public class Board {

    private PrintStream out;
    public String[] boardPieces;

    public Board(PrintStream out, String[] boardPieces){
        this.out = out;
        this.boardPieces = boardPieces;
    }

    public void drawBoard(){
        out.println(
                "  "+boardPieces[0]+"| "+boardPieces[1]+" | "+ boardPieces[2] +"  \n" +
                "--------\n" +
                "  "+boardPieces[3]+"| "+boardPieces[4]+" | "+ boardPieces[5] +"  \n" +
                "--------\n" +
                "  "+boardPieces[6]+"| "+boardPieces[7]+" | "+ boardPieces[8]);

    }

    public void placePlayerPiece(int place, String playerPiece){

        boardPieces[place-1] = playerPiece;
        drawBoard();
    }

    public boolean isAlreadyOccupied(int placement) {
        if(boardPieces[placement-1].equals("")){
            return false;
        }
        return true;
    }
}
