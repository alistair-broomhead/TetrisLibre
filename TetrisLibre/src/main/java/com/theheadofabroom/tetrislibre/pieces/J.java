package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class J extends Piece
{
    public J() {
        super();
        img = Board.PieceImages.J;
        shape = new Shape(
                1, 1,
                1, 0,
                2, 0,
                3, 0
        );
    }
}
