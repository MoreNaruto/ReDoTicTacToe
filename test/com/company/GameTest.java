package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by thomasmorris on 6/22/14.
 */
public class GameTest {

    private Game game;
    private PrintStream mockStream;
    private Board board;

    @Before
    public void setUp(){
        mockStream = mock(PrintStream.class);
        board = mock(Board.class);
        game = new Game(mockStream, board);
    }


    @Test
    public void shouldbeDrawWhenBoardisFull() throws IOException {
        when(board.boardFull()).thenReturn(true);
        game.gameOverByDraw();
        verify(mockStream).println("Game is a draw");
    }

    @Test
    public void shouldBePlayer1WinWhenGameHasWinner(){
        when(board.hasWinner()).thenReturn(true);
        game.gameOverByWinner("X");
        verify(mockStream).println("Player 1 Wins!");
    }

    @Test
    public void shouldBePlayer2WinWhenGameHasWinner(){
        when(board.hasWinner()).thenReturn(true);
        game.gameOverByWinner("O");
        verify(mockStream).println("Player 2 Wins!");
    }
}
