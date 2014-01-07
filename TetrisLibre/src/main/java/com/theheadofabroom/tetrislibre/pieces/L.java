package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class L extends Piece
{
    public L(Board board_) {
        super(board_);
        img = Board.PieceImages.L;
        shape = new Shape(
                0, 0,
                1, 0,
                2, 0,
                2, 1,
                1, 0
        );
    }
}
