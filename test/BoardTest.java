import com.company.Board;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by thomasmorris on 6/22/14.
 */
public class BoardTest {

    private PrintStream mockStream;
    private Board board;

    @Before
    public void setUp(){
        mockStream = mock(PrintStream.class);
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

}
