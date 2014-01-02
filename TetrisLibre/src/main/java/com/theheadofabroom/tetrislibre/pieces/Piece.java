package com.theheadofabroom.tetrislibre.pieces;

import android.graphics.drawable.Drawable;
import com.theheadofabroom.tetrislibre.*;

import java.util.Random;

public abstract class Piece
{
    private final static Random rand = new Random();
    public static final Piece next(Board board)
    {
        int choice = rand.nextInt(7);
        switch (choice)
        {
            case 0:
                return new I(board);
            case 1:
                return new J(board);
            case 2:
                return new L(board);
            case 3:
                return new O(board);
            case 4:
                return new S(board);
            case 5:
                return new T(board);
            case 6:
                return new Z(board);
            default:
                throw new UnknownError("Somehow got rand.nextInt(7) returning something not in [0, 1, 2, 3, 4, 5, 6]");
        }
    }

    private TwoDimensionalCoordinate position;
    private boolean rendered;

    private Board board;
    private Board board_overlaid;

    public Drawable img;
    public Shape shape;

    public Piece(Board board_)
    {
        position = new TwoDimensionalCoordinate(3, 18);
        board = board_;
        rendered = false;
    }

    public final Board Render()
    {
        if (!rendered)
        {
            board_overlaid = new Board(board);
            Settle(board_overlaid);
        }
        return board_overlaid;
    }

    private boolean ChangeOK(Shape new_shape, TwoDimensionalCoordinate new_coord)
    {
        TwoDimensionalCoordinate[] cells = new_shape.GetSegments();
        for (int i = 0; i < cells.length; ++i)
        {
            TwoDimensionalCoordinate cell = new_coord.add(cells[i]);
            int x = cell.GetX();
            int y = cell.GetY();
            if ( board.grid.containsKey(cell) || x < 0 || x >= 10 || y < 0 )
            {
                return false;
            }
        }
        return true;
    }
    private boolean ChangeOK(Shape new_shape)
    {
        return ChangeOK(new_shape, position);
    }
    private boolean ChangeOK(TwoDimensionalCoordinate new_coord)
    {
        return ChangeOK(shape, new_coord);
    }

    public final void Down()
    {
        TwoDimensionalCoordinate new_position = position.add(0, -1);

        if (! ChangeOK(new_position))
            Settle();
        else
        {
            position = new_position;
            Render().Draw();
        }
    }


    public void Rotate()
    {
        Shape new_shape = shape.rotated();
        if (ChangeOK(new_shape))
        {
            shape = new_shape;
            Render().Draw();
        }
    }

    public void Left()
    {
        TwoDimensionalCoordinate new_position = position.add(-1, 0);

        if (ChangeOK(new_position))
        {
            position = new_position;
            Render().Draw();
        }
    }

    public void Right()
    {
        TwoDimensionalCoordinate new_position = position.add(1, 0);

        if (ChangeOK(new_position))
        {
            position = new_position;
            Render().Draw();
        }
    }


    private final void Settle(Board board_)
    {
        TwoDimensionalCoordinate[] cells = shape.GetSegments();
        for (int i = 0; i < cells.length; i++)
        {
            TwoDimensionalCoordinate cell = position.add(cells[i]);
            board_.grid.put(cell, img);
        }
    }

    public final void Settle()
    {
        Settle(board);
        board.CyclePiece();
        GameState.Draw();
    }

}

