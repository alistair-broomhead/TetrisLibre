package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class Z extends Piece
{
    public Z(Board board_) {
        super(board_);
        img = Board.PieceImages.Z;
        shape = new Shape(
                3, 0,
                2, 0,
                2, 1,
                1, 1
        );
    }
}
