package com.theheadofabroom.tetrislibre;

import android.app.Activity;
import android.widget.ImageView;
import com.theheadofabroom.tetrislibre.pieces.*;

public final class NextPiece
{
    public static ImageView[][] grid;

    private static boolean initialised = false;
    public static void Connect(Activity act)
    {
        grid = new ImageView[][]{
                {
                        (ImageView) act.findViewById(R.id.np10),
                        (ImageView) act.findViewById(R.id.np11),
                        (ImageView) act.findViewById(R.id.np12),
                        (ImageView) act.findViewById(R.id.np13)
                },
                {
                        (ImageView) act.findViewById(R.id.np00),
                        (ImageView) act.findViewById(R.id.np01),
                        (ImageView) act.findViewById(R.id.np02),
                        (ImageView) act.findViewById(R.id.np03)
                }
        };
    }
    public static void Replace(Piece piece)
    {
        for (int y = 0; y < grid.length; ++y)
        {
            ImageView[] row = grid[y];
            for (int x = 0; x < row.length; ++x)
            {
                row[x].setImageResource(android.R.color.transparent);
            }
        }
        TwoDimensionalCoordinate[] cells = piece.shape.GetSegments();
        for (int i = 0; i < cells.length; i++)
        {
            TwoDimensionalCoordinate cell = cells[i];
            grid[cell.GetY()][cell.GetX()].setImageDrawable(piece.img);
        }
    }

    static {}
}
