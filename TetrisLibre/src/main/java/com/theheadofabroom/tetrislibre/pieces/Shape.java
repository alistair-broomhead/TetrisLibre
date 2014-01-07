package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class Shape {

    private final TwoDimensionalCoordinate p0;
    private final TwoDimensionalCoordinate p1;
    private final TwoDimensionalCoordinate p2;
    private final TwoDimensionalCoordinate p3;
    private final TwoDimensionalCoordinate origin;

    public TwoDimensionalCoordinate[] GetSegments()
    {
        return new TwoDimensionalCoordinate[]{p0, p1, p2, p3};
    }

    public Shape(int x0, int y0,
                 int x1, int y1,
                 int x2, int y2,
                 int x3, int y3,
                 int xo, int yo)
    {
        p0 = new TwoDimensionalCoordinate(x0, y0);
        p1 = new TwoDimensionalCoordinate(x1, y1);
        p2 = new TwoDimensionalCoordinate(x2, y2);
        p3 = new TwoDimensionalCoordinate(x3, y3);
        origin = new TwoDimensionalCoordinate(xo, yo);
    }

    private Shape(TwoDimensionalCoordinate p0_,
                  TwoDimensionalCoordinate p1_,
                  TwoDimensionalCoordinate p2_,
                  TwoDimensionalCoordinate p3_,
                  TwoDimensionalCoordinate origin__)
    {
        p0 = p0_;
        p1 = p1_;
        p2 = p2_;
        p3 = p3_;
        origin = origin__;
    }

    public Shape rotated()
    {
        return new Shape(
                p0.RotatedAbout(origin),
                p1.RotatedAbout(origin),
                p2.RotatedAbout(origin),
                p3.RotatedAbout(origin),
                origin
                );
    }
}
