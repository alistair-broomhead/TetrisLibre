package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class I extends Piece
{
    public I() {
        super();
        img = Board.PieceImages.I;
        shape = new Shape(
                0, 0,
                1, 0,
                2, 0,
                3, 0
        );
    }
}

