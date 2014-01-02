package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class O extends Piece
{
    public O(Board board_) {
        super(board_);
        img = Board.PieceImages.O;
        shape = new Shape(
                1, 0,
                1, 1,
                2, 0,
                2, 1
        );
    }
}
