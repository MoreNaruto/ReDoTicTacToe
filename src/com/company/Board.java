package com.company;

import java.io.PrintStream;

/**
 * Created by thomasmorris on 6/22/14.
 */
public class Board {

    private PrintStream out;

    public Board(PrintStream out){
        this.out = out;
    }

    public void drawBoard(){
        out.println(
                "  |  |  \n" +
                "--------\n" +
                "  |  |  \n" +
                "--------\n" +
                "  |  |  " );

    }
}
