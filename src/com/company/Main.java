package com.company;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
	    String[] boardPieces = new String[9];
        for (int i = 0; i < boardPieces.length; i++){
            boardPieces[i] = "";
        }
        PrintStream out = new PrintStream(System.out);
        Board board = new Board(out, boardPieces);
        board.drawBoard();
    }
}
