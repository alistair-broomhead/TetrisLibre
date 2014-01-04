package com.theheadofabroom.tetrislibre;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.theheadofabroom.tetrislibre.pieces.Piece;

import java.util.HashMap;
import java.util.Iterator;

public class Board{

    private Piece current;
    public Piece getCurrent() {
        return current;
    }

    private Piece next;
    public Piece getNext() {
        return next;
    }

    public void CyclePiece()
    {
        if (next == null) next = Piece.next(this);

        current = next;
        next = Piece.next(this);
    }

    public HashMap<TwoDimensionalCoordinate, Drawable> grid;

    private static ImageView[][] BoardCells;
    
    public static void Connect(Activity act)
    {
        BoardCells = new ImageView[][]{
                {
                        (ImageView) act.findViewById(R.id.board_0_0),
                        (ImageView) act.findViewById(R.id.board_0_1),
                        (ImageView) act.findViewById(R.id.board_0_2),
                        (ImageView) act.findViewById(R.id.board_0_3),
                        (ImageView) act.findViewById(R.id.board_0_4),
                        (ImageView) act.findViewById(R.id.board_0_5),
                        (ImageView) act.findViewById(R.id.board_0_6),
                        (ImageView) act.findViewById(R.id.board_0_7),
                        (ImageView) act.findViewById(R.id.board_0_8),
                        (ImageView) act.findViewById(R.id.board_0_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_1_0),
                        (ImageView) act.findViewById(R.id.board_1_1),
                        (ImageView) act.findViewById(R.id.board_1_2),
                        (ImageView) act.findViewById(R.id.board_1_3),
                        (ImageView) act.findViewById(R.id.board_1_4),
                        (ImageView) act.findViewById(R.id.board_1_5),
                        (ImageView) act.findViewById(R.id.board_1_6),
                        (ImageView) act.findViewById(R.id.board_1_7),
                        (ImageView) act.findViewById(R.id.board_1_8),
                        (ImageView) act.findViewById(R.id.board_1_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_2_0),
                        (ImageView) act.findViewById(R.id.board_2_1),
                        (ImageView) act.findViewById(R.id.board_2_2),
                        (ImageView) act.findViewById(R.id.board_2_3),
                        (ImageView) act.findViewById(R.id.board_2_4),
                        (ImageView) act.findViewById(R.id.board_2_5),
                        (ImageView) act.findViewById(R.id.board_2_6),
                        (ImageView) act.findViewById(R.id.board_2_7),
                        (ImageView) act.findViewById(R.id.board_2_8),
                        (ImageView) act.findViewById(R.id.board_2_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_3_0),
                        (ImageView) act.findViewById(R.id.board_3_1),
                        (ImageView) act.findViewById(R.id.board_3_2),
                        (ImageView) act.findViewById(R.id.board_3_3),
                        (ImageView) act.findViewById(R.id.board_3_4),
                        (ImageView) act.findViewById(R.id.board_3_5),
                        (ImageView) act.findViewById(R.id.board_3_6),
                        (ImageView) act.findViewById(R.id.board_3_7),
                        (ImageView) act.findViewById(R.id.board_3_8),
                        (ImageView) act.findViewById(R.id.board_3_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_4_0),
                        (ImageView) act.findViewById(R.id.board_4_1),
                        (ImageView) act.findViewById(R.id.board_4_2),
                        (ImageView) act.findViewById(R.id.board_4_3),
                        (ImageView) act.findViewById(R.id.board_4_4),
                        (ImageView) act.findViewById(R.id.board_4_5),
                        (ImageView) act.findViewById(R.id.board_4_6),
                        (ImageView) act.findViewById(R.id.board_4_7),
                        (ImageView) act.findViewById(R.id.board_4_8),
                        (ImageView) act.findViewById(R.id.board_4_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_5_0),
                        (ImageView) act.findViewById(R.id.board_5_1),
                        (ImageView) act.findViewById(R.id.board_5_2),
                        (ImageView) act.findViewById(R.id.board_5_3),
                        (ImageView) act.findViewById(R.id.board_5_4),
                        (ImageView) act.findViewById(R.id.board_5_5),
                        (ImageView) act.findViewById(R.id.board_5_6),
                        (ImageView) act.findViewById(R.id.board_5_7),
                        (ImageView) act.findViewById(R.id.board_5_8),
                        (ImageView) act.findViewById(R.id.board_5_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_6_0),
                        (ImageView) act.findViewById(R.id.board_6_1),
                        (ImageView) act.findViewById(R.id.board_6_2),
                        (ImageView) act.findViewById(R.id.board_6_3),
                        (ImageView) act.findViewById(R.id.board_6_4),
                        (ImageView) act.findViewById(R.id.board_6_5),
                        (ImageView) act.findViewById(R.id.board_6_6),
                        (ImageView) act.findViewById(R.id.board_6_7),
                        (ImageView) act.findViewById(R.id.board_6_8),
                        (ImageView) act.findViewById(R.id.board_6_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_7_0),
                        (ImageView) act.findViewById(R.id.board_7_1),
                        (ImageView) act.findViewById(R.id.board_7_2),
                        (ImageView) act.findViewById(R.id.board_7_3),
                        (ImageView) act.findViewById(R.id.board_7_4),
                        (ImageView) act.findViewById(R.id.board_7_5),
                        (ImageView) act.findViewById(R.id.board_7_6),
                        (ImageView) act.findViewById(R.id.board_7_7),
                        (ImageView) act.findViewById(R.id.board_7_8),
                        (ImageView) act.findViewById(R.id.board_7_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_8_0),
                        (ImageView) act.findViewById(R.id.board_8_1),
                        (ImageView) act.findViewById(R.id.board_8_2),
                        (ImageView) act.findViewById(R.id.board_8_3),
                        (ImageView) act.findViewById(R.id.board_8_4),
                        (ImageView) act.findViewById(R.id.board_8_5),
                        (ImageView) act.findViewById(R.id.board_8_6),
                        (ImageView) act.findViewById(R.id.board_8_7),
                        (ImageView) act.findViewById(R.id.board_8_8),
                        (ImageView) act.findViewById(R.id.board_8_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_9_0),
                        (ImageView) act.findViewById(R.id.board_9_1),
                        (ImageView) act.findViewById(R.id.board_9_2),
                        (ImageView) act.findViewById(R.id.board_9_3),
                        (ImageView) act.findViewById(R.id.board_9_4),
                        (ImageView) act.findViewById(R.id.board_9_5),
                        (ImageView) act.findViewById(R.id.board_9_6),
                        (ImageView) act.findViewById(R.id.board_9_7),
                        (ImageView) act.findViewById(R.id.board_9_8),
                        (ImageView) act.findViewById(R.id.board_9_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_10_0),
                        (ImageView) act.findViewById(R.id.board_10_1),
                        (ImageView) act.findViewById(R.id.board_10_2),
                        (ImageView) act.findViewById(R.id.board_10_3),
                        (ImageView) act.findViewById(R.id.board_10_4),
                        (ImageView) act.findViewById(R.id.board_10_5),
                        (ImageView) act.findViewById(R.id.board_10_6),
                        (ImageView) act.findViewById(R.id.board_10_7),
                        (ImageView) act.findViewById(R.id.board_10_8),
                        (ImageView) act.findViewById(R.id.board_10_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_11_0),
                        (ImageView) act.findViewById(R.id.board_11_1),
                        (ImageView) act.findViewById(R.id.board_11_2),
                        (ImageView) act.findViewById(R.id.board_11_3),
                        (ImageView) act.findViewById(R.id.board_11_4),
                        (ImageView) act.findViewById(R.id.board_11_5),
                        (ImageView) act.findViewById(R.id.board_11_6),
                        (ImageView) act.findViewById(R.id.board_11_7),
                        (ImageView) act.findViewById(R.id.board_11_8),
                        (ImageView) act.findViewById(R.id.board_11_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_12_0),
                        (ImageView) act.findViewById(R.id.board_12_1),
                        (ImageView) act.findViewById(R.id.board_12_2),
                        (ImageView) act.findViewById(R.id.board_12_3),
                        (ImageView) act.findViewById(R.id.board_12_4),
                        (ImageView) act.findViewById(R.id.board_12_5),
                        (ImageView) act.findViewById(R.id.board_12_6),
                        (ImageView) act.findViewById(R.id.board_12_7),
                        (ImageView) act.findViewById(R.id.board_12_8),
                        (ImageView) act.findViewById(R.id.board_12_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_13_0),
                        (ImageView) act.findViewById(R.id.board_13_1),
                        (ImageView) act.findViewById(R.id.board_13_2),
                        (ImageView) act.findViewById(R.id.board_13_3),
                        (ImageView) act.findViewById(R.id.board_13_4),
                        (ImageView) act.findViewById(R.id.board_13_5),
                        (ImageView) act.findViewById(R.id.board_13_6),
                        (ImageView) act.findViewById(R.id.board_13_7),
                        (ImageView) act.findViewById(R.id.board_13_8),
                        (ImageView) act.findViewById(R.id.board_13_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_14_0),
                        (ImageView) act.findViewById(R.id.board_14_1),
                        (ImageView) act.findViewById(R.id.board_14_2),
                        (ImageView) act.findViewById(R.id.board_14_3),
                        (ImageView) act.findViewById(R.id.board_14_4),
                        (ImageView) act.findViewById(R.id.board_14_5),
                        (ImageView) act.findViewById(R.id.board_14_6),
                        (ImageView) act.findViewById(R.id.board_14_7),
                        (ImageView) act.findViewById(R.id.board_14_8),
                        (ImageView) act.findViewById(R.id.board_14_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_15_0),
                        (ImageView) act.findViewById(R.id.board_15_1),
                        (ImageView) act.findViewById(R.id.board_15_2),
                        (ImageView) act.findViewById(R.id.board_15_3),
                        (ImageView) act.findViewById(R.id.board_15_4),
                        (ImageView) act.findViewById(R.id.board_15_5),
                        (ImageView) act.findViewById(R.id.board_15_6),
                        (ImageView) act.findViewById(R.id.board_15_7),
                        (ImageView) act.findViewById(R.id.board_15_8),
                        (ImageView) act.findViewById(R.id.board_15_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_16_0),
                        (ImageView) act.findViewById(R.id.board_16_1),
                        (ImageView) act.findViewById(R.id.board_16_2),
                        (ImageView) act.findViewById(R.id.board_16_3),
                        (ImageView) act.findViewById(R.id.board_16_4),
                        (ImageView) act.findViewById(R.id.board_16_5),
                        (ImageView) act.findViewById(R.id.board_16_6),
                        (ImageView) act.findViewById(R.id.board_16_7),
                        (ImageView) act.findViewById(R.id.board_16_8),
                        (ImageView) act.findViewById(R.id.board_16_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_17_0),
                        (ImageView) act.findViewById(R.id.board_17_1),
                        (ImageView) act.findViewById(R.id.board_17_2),
                        (ImageView) act.findViewById(R.id.board_17_3),
                        (ImageView) act.findViewById(R.id.board_17_4),
                        (ImageView) act.findViewById(R.id.board_17_5),
                        (ImageView) act.findViewById(R.id.board_17_6),
                        (ImageView) act.findViewById(R.id.board_17_7),
                        (ImageView) act.findViewById(R.id.board_17_8),
                        (ImageView) act.findViewById(R.id.board_17_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_18_0),
                        (ImageView) act.findViewById(R.id.board_18_1),
                        (ImageView) act.findViewById(R.id.board_18_2),
                        (ImageView) act.findViewById(R.id.board_18_3),
                        (ImageView) act.findViewById(R.id.board_18_4),
                        (ImageView) act.findViewById(R.id.board_18_5),
                        (ImageView) act.findViewById(R.id.board_18_6),
                        (ImageView) act.findViewById(R.id.board_18_7),
                        (ImageView) act.findViewById(R.id.board_18_8),
                        (ImageView) act.findViewById(R.id.board_18_9)
                },
                {
                        (ImageView) act.findViewById(R.id.board_19_0),
                        (ImageView) act.findViewById(R.id.board_19_1),
                        (ImageView) act.findViewById(R.id.board_19_2),
                        (ImageView) act.findViewById(R.id.board_19_3),
                        (ImageView) act.findViewById(R.id.board_19_4),
                        (ImageView) act.findViewById(R.id.board_19_5),
                        (ImageView) act.findViewById(R.id.board_19_6),
                        (ImageView) act.findViewById(R.id.board_19_7),
                        (ImageView) act.findViewById(R.id.board_19_8),
                        (ImageView) act.findViewById(R.id.board_19_9)
                }
        };

        PieceImages.I = act.getResources().getDrawable(R.drawable.i);
        PieceImages.J = act.getResources().getDrawable(R.drawable.j);
        PieceImages.L = act.getResources().getDrawable(R.drawable.l);
        PieceImages.S = act.getResources().getDrawable(R.drawable.s);
        PieceImages.Z = act.getResources().getDrawable(R.drawable.z);
        PieceImages.O = act.getResources().getDrawable(R.drawable.o);
        PieceImages.T = act.getResources().getDrawable(R.drawable.t);
    }

    public static class PieceImages
    {
        public static Drawable I;
        public static Drawable J;
        public static Drawable L;
        public static Drawable S;
        public static Drawable Z;
        public static Drawable O;
        public static Drawable T;
    }

    public Board()
    {
        grid = new HashMap<TwoDimensionalCoordinate, Drawable>();
    }

    public Board(Board other)
    {
        grid = new HashMap<TwoDimensionalCoordinate, Drawable>();

        int num_keys = other.grid.keySet().size();
        Iterator<TwoDimensionalCoordinate> iter_keys = other.grid.keySet().iterator();
        for (int i = 0; i < num_keys; i++)
        {
            TwoDimensionalCoordinate key = iter_keys.next();
            Drawable value = other.grid.get(key);
            grid.put(key, value);
        }
    }

    public void Draw()
    {
        // draw the board
        for (ImageView[] row : BoardCells) {
            for (ImageView view : row) {
                view.setImageResource(android.R.color.transparent);
            }
        }

        for (TwoDimensionalCoordinate cell : grid.keySet()) {
            int x = cell.GetX();
            int y = cell.GetY();

            // if somehow the piece has a segment above the board, ignore it
            if (y >= BoardCells.length) continue;

            Drawable img = grid.get(cell);
            BoardCells[y][x].setImageDrawable(img);
        }
    }

}
