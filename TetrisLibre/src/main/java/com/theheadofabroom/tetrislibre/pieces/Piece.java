package com.theheadofabroom.tetrislibre.pieces;

import android.graphics.drawable.Drawable;
import com.theheadofabroom.tetrislibre.*;

import java.util.Random;

public abstract class Piece
{
    private final static Random rand = new Random();
    public static Piece next()
    {
        int choice = rand.nextInt(7);
        switch (choice)
        {
            case 0:
                return new I();
            case 1:
                return new J();
            case 2:
                return new L();
            case 3:
                return new O();
            case 4:
                return new S();
            case 5:
                return new T();
            case 6:
                return new Z();
            default:
                throw new UnknownError("Somehow got rand.nextInt(7) returning something not in [0, 1, 2, 3, 4, 5, 6]");
        }
    }

    private TwoDimensionalCoordinate position;

    public Drawable img;
    public Shape shape;

    public Piece()
    {
        position = new TwoDimensionalCoordinate(3, 18);
    }

    private void Scrub()
    {
        for (TwoDimensionalCoordinate segment : shape.GetSegments())
            Board.ClearCell(segment.add(position));
    }

    private void Draw()
    {
        for (TwoDimensionalCoordinate segment : shape.GetSegments())
            Board.AddForegroundCell(segment.add(position), img);
    }
    private void Draw(TwoDimensionalCoordinate new_position)
    {
        Scrub();
        position = new_position;
        Draw();
    }
    private void Draw(Shape new_shape)
    {
        Scrub();
        shape = new_shape;
        Draw();
    }

    private boolean OK(Shape new_shape, TwoDimensionalCoordinate new_coord)
    {
        for (TwoDimensionalCoordinate segment : new_shape.GetSegments())
            if (!Board.Empty(new_coord.add(segment)))
                return false;
        return true;
    }
    private boolean OK(Shape new_shape)
    {
        return OK(new_shape, position);
    }
    private boolean OK(TwoDimensionalCoordinate new_coord)
    {
        return OK(shape, new_coord);
    }
    public final boolean OK()
    {
        return OK(shape, position);
    }

    private boolean Move(TwoDimensionalCoordinate new_position)
    {
        if (! OK(new_position))
        {
            return true;
        }
        else
        {
            Draw(new_position);
            return false;
        }
    }

    private boolean Move(Shape new_shape)
    {
        if (! OK(new_shape))
        {
            return true;
        }
        else
        {
            Draw(new_shape);
            return false;
        }
    }
    public final boolean Down()
    {
        boolean settle = Move(position.add(0, -1));
        if (settle) Board.Settle();
        return settle;
    }
    public final void Rotate()
    {
        Move(shape.rotated());
    }
    public final void Left()
    {
        Move(position.add(-1, 0));
    }
    public final void Right()
    {
        Move(position.add(1, 0));
    }

    public final void ForceDraw() {
        Scrub();
        Draw();
    }
}

