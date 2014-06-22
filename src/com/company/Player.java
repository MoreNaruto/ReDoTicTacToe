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

    private Board board;
    public boolean player1Turn = true;

    public Player(BufferedReader reader, PrintStream out, Board board){

        this.reader = reader;
        this.out = out;
        this.board = board;

    }

    public void makeMove() throws IOException {
        if (board.boardFull()){
            out.println("Game is a draw");
            return;
        }
        out.print("Enter a number between 1-9: ");
        int place = Integer.parseInt(reader.readLine());

        if (board.isAlreadyOccupied(place)){
            out.println("Location already taken\n");
            makeMove();
        }
        if (player1Turn) {
            board.placePlayerPiece(place, "X");
            player1Turn = false;
        } else {
            board.placePlayerPiece(place, "O");
            player1Turn = true;
        }

    }
}
