package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by thomasmorris on 6/22/14.
 */
public class BoardTest {

    private PrintStream mockStream;
    private BufferedReader mockReader;
    private Board board;
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
    }
    @Test
    public void shouldDrawBoard(){

        board.drawBoard();
        verify(mockStream).println(
                "  " + boardPieces[0] + "| " + boardPieces[1] + " | " + boardPieces[2] + "  \n" +
                "--------\n" +
                "  " + boardPieces[3] + "| " + boardPieces[4] + " | " + boardPieces[5] + "  \n" +
                "--------\n" +
                "  " + boardPieces[6] + "| " + boardPieces[7] + " | " + boardPieces[8]);
    }

    @Test
    public void testPlaceHasValueAfterUserInput(){
        board.placePlayerPiece(1, "X");
        assertEquals(boardPieces[0], "X");
    }

    @Test
    public void testForBoardSpaceOccupied(){
        board.placePlayerPiece(1, "X");
        assertEquals(board.isAlreadyOccupied(1), true);

    }

    @Test
    public void shouldHaveFullBoardWhenAllPlacesHavePieces(){
        for (int i = 0; i < boardPieces.length; i++){
            boardPieces[i] = "X";
        }
        assertEquals(board.boardFull(), true);
    }

    @Test
    public void shouldHaveWinnerWhenTopRowFilledWithSame(){
        boardPieces[0] = "X";
        boardPieces[1] = "X";
        boardPieces[2] = "X";
        assertEquals(board.hasWinner(), true);
    }



}
