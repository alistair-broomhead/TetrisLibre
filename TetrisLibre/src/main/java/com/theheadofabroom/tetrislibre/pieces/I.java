package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class I extends Piece
{
    public I(Board board_) {
        super(board_);
        img = Board.PieceImages.I;
        shape = new Shape(
                0, 0,
                1, 0,
                2, 0,
                3, 0
        );
    }
}

