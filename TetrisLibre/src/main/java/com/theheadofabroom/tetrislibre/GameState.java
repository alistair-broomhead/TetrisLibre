package com.theheadofabroom.tetrislibre;

import android.app.Activity;

import com.theheadofabroom.tetrislibre.pieces.Piece;

public final class GameState
{
    private static Board board;

    static
    {
        board = new Board();
    }

    public static void Connect(Activity act)
    {
        Board.Connect(act);
        NextPiece.Connect(act);
        Draw();
    }

    private static Piece getCurrent()
    {
        if (board != null)
            return board.getCurrent();
        return null;
    }

    private static Piece getNext()
    {
        if (board != null)
            return board.getNext();
        return null;
    }

    public static void Draw()
    {
        Piece next = getNext();
        if (next != null)
            NextPiece.Replace(next);

        Piece current = getCurrent();
        if (current == null)
            board.CyclePiece();
        else
            current.Render().Draw();
    }

    public static boolean Down()
    {
        // returns whether the game has ended
        Piece current = getCurrent();

        return current != null && current.Down() && !getCurrent().OK();
    }

    public static void Rotate()
    {
        Piece current = getCurrent();
        if (current != null)
            current.Rotate();
    }

    public static void Left()
    {
        Piece current = getCurrent();
        if (current != null)
            current.Left();
    }

    public static void Right()
    {
        Piece current = getCurrent();
        if (current != null)
            current.Right();
    }
}
