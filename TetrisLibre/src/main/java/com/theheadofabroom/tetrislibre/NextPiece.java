package com.theheadofabroom.tetrislibre;

import android.app.Activity;
import android.widget.ImageView;
import com.theheadofabroom.tetrislibre.pieces.*;

public final class NextPiece
{
    public static ImageView[][] grid;
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
        if (grid == null) return;

        for (ImageView[] row : grid)
            for (ImageView aRow : row)
                aRow.setImageResource(android.R.color.transparent);

        if (piece == null) return;

        for (TwoDimensionalCoordinate cell : piece.shape.GetSegments())
            grid[cell.GetY()][cell.GetX()].setImageDrawable(piece.img);

    }

    static {}
}
