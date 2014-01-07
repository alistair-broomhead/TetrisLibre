package com.theheadofabroom.tetrislibre;

import com.theheadofabroom.tetrislibre.pieces.*;
import com.theheadofabroom.tetrislibre.*;

public class TwoDimensionalCoordinate {
    private final int x;
    private final int y;

    public int GetX(){ return x; }
    public int GetY(){ return y; }

    private final int hashCodeStored;
    public int hashCode()
    {
        return hashCodeStored;
    }
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        TwoDimensionalCoordinate point = (TwoDimensionalCoordinate) other;
        return (point.x == x && point.y == y);
    }

    public TwoDimensionalCoordinate(int x_coordinate, int y_coordinate){
        x = x_coordinate;
        y = y_coordinate;
        hashCodeStored = x + (100 * y); // x is expected to lie in [-1, 10], y in [-1, 20]
    }

    public TwoDimensionalCoordinate RotatedAbout()
    {
        return new TwoDimensionalCoordinate(y, -x);
    }

    public TwoDimensionalCoordinate RotatedAbout(TwoDimensionalCoordinate origin)
    {
        return subtract(origin).RotatedAbout().add(origin);
    }

    public TwoDimensionalCoordinate add(TwoDimensionalCoordinate other){
        return add(other.GetX(), other.GetY());
    }

    public TwoDimensionalCoordinate add(int x_coordinate, int y_coordinate){
        return new TwoDimensionalCoordinate(x + x_coordinate, y + y_coordinate);
    }

    public TwoDimensionalCoordinate subtract(TwoDimensionalCoordinate other){
        return subtract(other.GetX(), other.GetY());
    }

    public TwoDimensionalCoordinate subtract(int x_coordinate, int y_coordinate){
        return new TwoDimensionalCoordinate(x - x_coordinate, y - y_coordinate);
    }
}
