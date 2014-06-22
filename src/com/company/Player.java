package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by thomasmorris on 6/22/14.
 */
public class Player {

    private BufferedReader reader;
    private PrintStream out;
    private String[] boardPieces;
    private Board board;
    public boolean player1Turn = true;

    public Player(BufferedReader reader, PrintStream out, String[] boardPieces, Board board){
        this.boardPieces = boardPieces;
        this.reader = reader;
        this.out = out;
        this.board = board;

    }

    public void makeMove() throws IOException {
        out.print("Enter a number between 1-9: ");
        int place = Integer.parseInt(reader.readLine());
        boardPieces[place-1] = "X";
        board.drawBoard();
    }
}
