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
    public boolean gameOver= false;

    private Board board;
    private Game game;
    public boolean player1Turn = true;

    public Player(BufferedReader reader, PrintStream out, Board board, Game game){

        this.game = game;
        this.reader = reader;
        this.out = out;
        this.board = board;

    }

    public void makeMove() throws IOException {
        while(!game.gameOverByDraw()) {

            out.print("Enter a number between 1-9: ");
            int place = Integer.parseInt(reader.readLine());

            if (board.isAlreadyOccupied(place)) {
                out.println("Location already taken\n");

            }
            if (player1Turn) {
                board.placePlayerPiece(place, "X");
                if(game.gameOverByWinner("X")){
                    break;
                }
                player1Turn = false;
            } else {
                board.placePlayerPiece(place, "O");
                if(game.gameOverByWinner("O")){
                    break;
                }
                player1Turn = true;
            }

        }

    }

}
