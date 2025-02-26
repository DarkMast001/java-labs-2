package org.example.Tasks;

import org.example.Tasks.Point.PointModify;
import static java.lang.Math.*;

/**
 * Класс {@code Car} представляет собой модель автомобиля, который может перемещаться
 * в двумерном пространстве и расходовать топливо в зависимости от пройденного расстояния.
 * <p>
 * Автомобиль имеет текущие координаты, уровень топлива в баке и расход топлива на километр.
 * </p>
 */
public class Car {
    /**
     * Координаты текущего положения машины. Единица измерения - км.
     */
    private PointModify coordinates;

    /**
     * Уровень топлива в баке. Единица измерения - литры.
     */
    private double fuelLevel;

    /**
     * Расход топлива в км/л.
     */
    private double fuelConsumption;

    /**
     * Приватный конструктор для предотвращения создания экземпляров класса без параметров.
     */
    private Car() {

    }

    /**
     * Создает новый автомобиль с указанным расходом топлива и начальным уровнем топлива.
     *
     * @param fuelConsumption расход топлива в км/л.
     * @param fuelLevel начальный уровень топлива в баке в литрах.
     */
    public Car(double fuelConsumption, double fuelLevel) {
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        coordinates = new PointModify(0, 0);
    }

    /**
     * Устанавливает уровень топлива в баке.
     *
     * @param fuelLevel новый уровень топлива в литрах.
     */
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    /**
     * Возвращает текущие координаты автомобиля.
     *
     * @return текущие координаты автомобиля.
     */
    public PointModify getCoordinates() {
        return coordinates;
    }

    /**
     * Возвращает текущий уровень топлива в баке.
     *
     * @return текущий уровень топлива в литрах.
     */
    public double getFuelLevel() {
        return fuelLevel;
    }

    /**
     * Возвращает расход топлива автомобиля.
     *
     * @return расход топлива в км/л.
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Вычисляет расстояние между двумя точками в двумерном пространстве.
     *
     * @param point1 первая точка.
     * @param point2 вторая точка.
     * @return расстояние между точками в километрах.
     */
    private double countDistance(PointModify point1, PointModify point2) {
        return sqrt(pow(point2.getX() - point1.getX(), 2) + pow(point2.getY() - point1.getY(), 2));
    }

    /**
     * Проверяет, достаточно ли топлива для преодоления указанного расстояния.
     *
     * @param distance расстояние, которое необходимо преодолеть.
     * @return {@code true}, если топлива достаточно, иначе {@code false}.
     */
    private boolean isFuelEnough(double distance) {
        double availableDistance = fuelLevel / fuelConsumption;
        return availableDistance >= distance;
    }

    /**
     * Перемещает автомобиль в указанные координаты, если топлива достаточно.
     * Если топлива недостаточно, выводит сообщение об ошибке.
     *
     * @param newPoint новые координаты, в которые необходимо переместиться.
     */
    public void driveTo(PointModify newPoint) {
        double distance = countDistance(coordinates, newPoint);
        if (isFuelEnough(distance)) {
            coordinates.translate(newPoint.getX(), newPoint.getY());
            fuelLevel -= distance * fuelConsumption;
        }
        else
            System.out.println("В баке не хватит топлива, чтобы поехать в заданные координаты");
    }

    /**
     * Перемещает автомобиль в указанные координаты (x, y), если топлива достаточно.
     * Если топлива недостаточно, выводит сообщение об ошибке.
     *
     * @param x координата X новой точки.
     * @param y координата Y новой точки.
     */
    public void driveTo(double x, double y) {
        driveTo(new PointModify(x, y));
    }
}