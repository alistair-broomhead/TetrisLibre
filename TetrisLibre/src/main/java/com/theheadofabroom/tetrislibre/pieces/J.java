package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class J extends Piece
{
    public J(Board board_) {
        super(board_);
        img = Board.PieceImages.J;
        shape = new Shape(
                1, 1,
                1, 0,
                2, 0,
                3, 0,
                2, 0
        );
    }
}
