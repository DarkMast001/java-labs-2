package org.example.Tasks;

import org.example.Tasks.Point.PointModify;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс {@code Circle} представляет собой окружность на плоскости.
 * Окружность задаётся центром (точка {@link PointModify}) и радиусом.
 */
public class Circle {
    PointModify centre;
    double radius;

    /**
     * Создаёт окружность с заданным центром и радиусом.
     *
     * @param centre центр окружности (не может быть {@code null}).
     * @param radius радиус окружности (должен быть положительным).
     * @throws IllegalArgumentException если радиус отрицательный или ноль.
     */
    public Circle (PointModify centre, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.centre = centre;
        this.radius = radius;
    }

    /**
     * Создаёт окружность с центром в точке {@code (x, y)} и заданным радиусом.
     *
     * @param x      координата X центра окружности.
     * @param y      координата Y центра окружности.
     * @param radius радиус окружности (должен быть положительным).
     * @throws IllegalArgumentException если радиус отрицательный или ноль.
     */
    public Circle(double x, double y, double radius) {
        this(new PointModify(x, y), radius);
    }

    /**
     * Находит точки пересечения двух окружностей.
     *
     * @param c1 первая окружность.
     * @param c2 вторая окружность.
     * @return список точек пересечения (пустой, если окружности не пересекаются).
     * @throws IllegalArgumentException если окружности совпадают (бесконечно много точек пересечения).
     */
    public static List<PointModify> intersections(Circle c1, Circle c2) {
        List<PointModify> intersections = new ArrayList<>();

        double x1 = c1.centre.getX();
        double y1 = c1.centre.getY();
        double r1 = c1.radius;

        double x2 = c2.centre.getX();
        double y2 = c2.centre.getY();
        double r2 = c2.radius;

        double dx = x2 - x1;
        double dy = y2 - y1;
        double d = Math.sqrt(dx * dx + dy * dy);

        if (d > r1 + r2 || d < Math.abs(r1 - r2)) {
            return intersections;
        } else if (d == 0 && r1 == r2) {
            return getSquadPoints(c1);
        } else if (d == r1 + r2 || d == Math.abs(r1 - r2)) {
            double x = x1 + (dx * r1) / d;
            double y = y1 + (dy * r1) / d;
            intersections.add(new PointModify(x, y));
            return intersections;
        } else {
            // Окружности пересекаются (две точки пересечения)
            double a = (r1 * r1 - r2 * r2 + d * d) / (2 * d);
            double h = Math.sqrt(r1 * r1 - a * a);

            // Точка на прямой между центрами
            double x0 = x1 + (dx * a) / d;
            double y0 = y1 + (dy * a) / d;

            // Смещение от этой точки
            double rx = -dy * (h / d);
            double ry = dx * (h / d);

            // Точки пересечения
            intersections.add(new PointModify(x0 + rx, y0 + ry));
            intersections.add(new PointModify(x0 - rx, y0 - ry));
            return intersections;
        }
    }

    private static List<PointModify> getSquadPoints(Circle circle) {
        List<PointModify> points = new ArrayList<>();

        points.add(new PointModify(circle.centre.getX() + circle.radius, circle.centre.getY()));
        points.add(new PointModify(circle.centre.getX() - circle.radius, circle.centre.getY()));
        points.add(new PointModify(circle.centre.getX(), circle.centre.getY() + circle.radius));
        points.add(new PointModify(circle.centre.getX(), circle.centre.getY() - circle.radius));

        return points;
    }
}
