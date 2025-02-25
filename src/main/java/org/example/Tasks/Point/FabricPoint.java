package org.example.Tasks.Point;

/**
 * Класс с фабричными методами создания точки в двух видах координат:
 * 1) В декартовых координатах
 * 2) В полярных координатах
 *
 * Пример использования:
 * FabricPoint cartesianPoint = FabricPoint.fromCartesian(3, 4);
 * System.out.println("Декартова точка: " + cartesianPoint);
 *
 *  FabricPoint polarPoint = FabricPoint.fromPolar(5, Math.toRadians(45));
 *  System.out.println("Полярная точка: " + polarPoint);
 */

public class FabricPoint {
    private final double x;
    private final double y;

    private FabricPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static FabricPoint fromCartesian(double x, double y) {
        return new FabricPoint(x, y);
    }

    public static FabricPoint fromPolar(double radius, double angle) {
        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);
        return new FabricPoint(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
