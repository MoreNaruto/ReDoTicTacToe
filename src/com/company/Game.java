package com.company;

import java.io.PrintStream;

/**
 * Created by thomasmorris on 6/22/14.
 */
public class Game {

    private Board board;
    private PrintStream out;
    public Game(PrintStream out, Board board){
        this.out = out;
        this.board = board;
    }

    public boolean gameOverByDraw(){
        if (board.boardFull()){
            out.println("Game is a draw");
            return true;
        }
        return false;
    }

    public boolean gameOverByWinner(String playerPiece) {
        if (board.hasWinner()){
            if(playerPiece.equals("X")){
                out.println("Player 1 Wins!");
                return true;
            } else {
                out.println("Player 2 Wins!");
                return true;
            }
        }
        return false;
    }
}
