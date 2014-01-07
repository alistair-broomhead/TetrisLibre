package com.theheadofabroom.tetrislibre.pieces;

import com.theheadofabroom.tetrislibre.*;

public class Shape {

    private TwoDimensionalCoordinate p0;
    private TwoDimensionalCoordinate p1;
    private TwoDimensionalCoordinate p2;
    private TwoDimensionalCoordinate p3;

    public TwoDimensionalCoordinate[] GetSegments()
    {
        return new TwoDimensionalCoordinate[]{p0, p1, p2, p3};
    }

    public void SetSegments(TwoDimensionalCoordinate s0,
                            TwoDimensionalCoordinate s1,
                            TwoDimensionalCoordinate s2,
                            TwoDimensionalCoordinate s3)
    {
        assert s0.GetX() > 0;
        assert s0.GetY() > 0;
        assert s1.GetX() > 0;
        assert s1.GetY() > 0;
        assert s2.GetX() > 0;
        assert s2.GetY() > 0;
        assert s3.GetX() > 0;
        assert s3.GetY() > 0;
        p0 = s0;
        p1 = s1;
        p2 = s2;
        p3 = s3;
    }

    public Shape(int x0, int y0,
                 int x1, int y1,
                 int x2, int y2,
                 int x3, int y3)
    {
        SetSegments(new TwoDimensionalCoordinate(x0, y0),
                    new TwoDimensionalCoordinate(x1, y1),
                    new TwoDimensionalCoordinate(x2, y2),
                    new TwoDimensionalCoordinate(x3, y3));
    }

    public Shape(TwoDimensionalCoordinate p0_,
                 TwoDimensionalCoordinate p1_,
                 TwoDimensionalCoordinate p2_,
                 TwoDimensionalCoordinate p3_)
    {
        SetSegments(p0_, p1_, p2_, p3_);
    }

    public Shape rotated()
    {
        TwoDimensionalCoordinate sum = p0.add(p1.add(p2.add(p3)));
        TwoDimensionalCoordinate origin = new TwoDimensionalCoordinate(sum.GetX()/4, sum.GetY()/4);

        return new Shape(
                p0.RotatedAbout(origin),
                p1.RotatedAbout(origin),
                p2.RotatedAbout(origin),
                p3.RotatedAbout(origin)
                );
    }
}
