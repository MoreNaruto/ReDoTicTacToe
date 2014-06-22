import com.company.Board;
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
public class BoardTest {

    private PrintStream mockStream;
    private BufferedReader mockReader;
    private Board board;

    @Before
    public void setUp(){
        mockStream = mock(PrintStream.class);
        mockReader = mock(BufferedReader.class);
        board = new Board(mockStream);
    }
    @Test
    public void testDrawBoard(){
        board.drawBoard();
        verify(mockStream).println(
                "  |  |  \n" +
                "--------\n" +
                "  |  |  \n" +
                "--------\n" +
                "  |  |  " );
    }

    @Test
    public void testPlayer1MakeMove() throws IOException {
        when(mockReader.readLine()).thenReturn("1");
        verify(mockStream).println(
                " X|  |  \n" +
                "--------\n" +
                "  |  |  \n" +
                "--------\n" +
                "  |  |  "
        );
    }

}
