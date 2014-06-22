package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws IOException {
	    String[] boardPieces = new String[9];
        for (int i = 0; i < boardPieces.length; i++){
            boardPieces[i] = "";
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(System.out);
        Board board = new Board(out, boardPieces);
        Player player = new Player(reader, out, boardPieces, board);
        board.drawBoard();
        player.makeMove();
    }
}
