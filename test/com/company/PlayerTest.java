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
    private String[] boardPieces;

    @Before
    public void setUp(){
        boardPieces = new String[9];
        for (int i = 0; i < boardPieces.length; i++){
            boardPieces[i] = "";
        }
        mockStream = mock(PrintStream.class);
        mockReader = mock(BufferedReader.class);
        board = new Board(mockStream, boardPieces);
        player = new Player(mockReader, mockStream, board);
    }

    @Test
    public void testPlayer1MakeMove() throws IOException {
        player.player1Turn = true;

        when(mockReader.readLine()).thenReturn("1");
        player.makeMove();
        verify(mockStream).println(
          "  "+ "X" +"| "+boardPieces[1]+" | "+ boardPieces[2] +"  \n" +
          "--------\n" +
          "  "+boardPieces[3]+"| "+boardPieces[4]+" | "+ boardPieces[5] +"  \n" +
          "--------\n" +
          "  "+boardPieces[6]+"| "+boardPieces[7]+" | "+ boardPieces[8]);
    }

    @Test
    public void testPlayer2MakeMove() throws IOException {
        player.player1Turn = false;
        when(mockReader.readLine()).thenReturn("1");
        player.makeMove();
        verify(mockStream).println(
             "  "+ "O" +"| "+boardPieces[1]+" | "+ boardPieces[2] +"  \n" +
             "--------\n" +
             "  "+boardPieces[3]+"| "+boardPieces[4]+" | "+ boardPieces[5] +"  \n" +
             "--------\n" +
             "  "+boardPieces[6]+"| "+boardPieces[7]+" | "+ boardPieces[8]);
    }

    @Test
    public void testLocationAlreadyTaken() throws IOException {
        Board mockBoard = mock(Board.class);
        Player testPlayer = new Player(mockReader, mockStream, mockBoard);
        when(mockBoard.isAlreadyOccupied(1)).thenReturn(true);
        when(mockReader.readLine()).thenReturn("1");
        testPlayer.makeMove();
        verify(mockStream).println("Location already taken");
    }
}
