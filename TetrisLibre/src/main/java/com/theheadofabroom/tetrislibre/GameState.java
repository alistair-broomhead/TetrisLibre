package com.theheadofabroom.tetrislibre;

import android.app.Activity;

import com.theheadofabroom.tetrislibre.pieces.Piece;

public final class GameState
{
    static
    {}

    public static void Connect(Activity act)
    {
        Board.Connect(act);
        NextPiece.Connect(act);
        Board.ForceFullRedraw();
    }

    public static boolean Down()
    {
        // returns whether the game has ended
        Piece current = Board.getCurrent();

        boolean settled = current != null && current.Down();
        if (settled)
            if (Board.getNext().OK()) Board.CyclePiece();
            else return true;
        return false;
    }

    public static void Rotate()
    {
        Piece current = Board.getCurrent();
        if (current != null)
            current.Rotate();
    }

    public static void Left()
    {
        Piece current = Board.getCurrent();
        if (current != null)
            current.Left();
    }

    public static void Right()
    {
        Piece current = Board.getCurrent();
        if (current != null)
            current.Right();
    }
}
