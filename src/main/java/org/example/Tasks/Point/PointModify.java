package org.example.Tasks.Point;

public class PointModify {
    private double x;
    private double y;

    public PointModify() {
        x = 0;
        y = 0;
    }

    public PointModify(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void scale(double value) {
        this.x *= value;
        this.y *= value;
    }

    @Override
    public String toString() {
        return "PointModify{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
