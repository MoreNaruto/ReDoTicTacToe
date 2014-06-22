package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by thomasmorris on 6/22/14.
 */
public class PlayerTest {

    private PrintStream mockStream;
    private BufferedReader mockReader;
    private Board board;
    private Player player;


    @Before
    public void setUp(){
        mockStream = mock(PrintStream.class);
        mockReader = mock(BufferedReader.class);
        board = mock(Board.class);
        board.boardPieces = new String[9];
        player = new Player(mockReader, mockStream, board);
    }

    @Test
    public void testPlayer1MakeMove() throws IOException {
        player.player1Turn = true;
        for (int i = 0; i < board.boardPieces.length; i++){
            board.boardPieces[i] = "";
        }
        when(mockReader.readLine()).thenReturn("1");
        player.makeMove();
        verify(mockStream).println(
          "  "+ "X" +"| "+board.boardPieces[1]+" | "+ board.boardPieces[2] +"  \n" +
          "--------\n" +
          "  "+board.boardPieces[3]+"| "+board.boardPieces[4]+" | "+ board.boardPieces[5] +"  \n" +
          "--------\n" +
          "  "+board.boardPieces[6]+"| "+board.boardPieces[7]+" | "+ board.boardPieces[8]);
    }

    @Test
    public void testPlayer2MakeMove() throws IOException {
        player.player1Turn = false;
        when(mockReader.readLine()).thenReturn("1");
        player.makeMove();
        verify(mockStream).println(
             "  "+ "O" +"| "+board.boardPieces[1]+" | "+ board.boardPieces[2] +"  \n" +
             "--------\n" +
             "  "+board.boardPieces[3]+"| "+board.boardPieces[4]+" | "+ board.boardPieces[5] +"  \n" +
             "--------\n" +
             "  "+board.boardPieces[6]+"| "+board.boardPieces[7]+" | "+ board.boardPieces[8]);
    }

    @Test
    public void testLocationAlreadyTaken() throws IOException {
        when(mockReader.readLine()).thenReturn("1");
        player.makeMove();
        verify(mockStream).println("Location already taken");
    }
}
