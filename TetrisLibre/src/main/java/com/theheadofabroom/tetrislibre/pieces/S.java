package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class S extends Piece
{
    public S(Board board_) {
        super(board_);
        img = Board.PieceImages.S;
        shape = new Shape(
                1, 0,
                2, 0,
                2, 1,
                3, 1,
                2, 0
        );
    }
}
