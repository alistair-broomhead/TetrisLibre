package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class T extends Piece
{
    public T() {
        super();
        img = Board.PieceImages.T;
        shape = new Shape(
                1, 0,
                2, 0,
                2, 1,
                3, 0
        );

    }
}
