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

    public static final void Connect(Activity act)
    {
        Board.Connect(act);
        NextPiece.Connect(act);
        Draw();
    }

    public static void Draw()
    {
        if (board != null)
        {
            Piece next = board.getNext();
            if (next != null)
                NextPiece.Replace(next);

            Piece current = board.getCurrent();
            if (current != null)
                current.Render().Draw();
        }
    }

    public static int fall_rate = 1;
    private static int tick_num = 0;

    public static void Tick()
    {
        if (tick_num == 0 || tick_num % fall_rate == 0)
        {
            Down();
        }

        tick_num++;
    }

    public static void Down()
    {
        if (board != null) board.Down();
    }

    public static void Rotate()
    {
        if (board != null) board.Rotate();
    }

    public static void Left()
    {
        if (board != null) board.Left();
    }

    public static void Right()
    {
        if (board != null) board.Right();
    }
}
