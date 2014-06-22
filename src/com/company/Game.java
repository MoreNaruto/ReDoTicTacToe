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

    public boolean gameOver(){
        if (board.boardFull()){
            out.println("Game is a draw");
            return true;
        }
        return false;
    }
}
