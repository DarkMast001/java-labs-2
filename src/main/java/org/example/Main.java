package org.example;

import org.example.Tasks.*;
import org.example.Tasks.Point.Point;
import org.example.Tasks.Point.PointModify;
import org.example.Tasks.Fabric.Formatter;

import static java.lang.Math.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PointModify p = new PointModify();

        int number = 1;
        while(number != 0) {

            System.out.print("Введите номер задачи 1 - 19 (0 - для выхода): ");
            Scanner in = new Scanner(System.in);
            number = in.nextInt();
            switch (number) {
                case 0:
                    break;
                case 1:
                    int year = 2025;
                    int month = 11;

                    LocalDate date = LocalDate.of(year, month, 1);

                    int daysInMonth = date.lengthOfMonth();

                    System.out.println("Вс Пн Вт Ср Чт Пт Сб");

                    DayOfWeek firstDayOfWeek = date.getDayOfWeek();
                    int spaces = (firstDayOfWeek.getValue() % 7);
                    for (int i = 0; i < spaces; i++) {
                        System.out.print("   ");
                    }

                    for (int day = 1; day <= daysInMonth; day++) {
                        LocalDate currentDate = LocalDate.of(year, month, day);
                        System.out.printf("%3d", day);
                        if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                            System.out.println();
                        }
                    }

                    if (date.withDayOfMonth(daysInMonth).getDayOfWeek() != DayOfWeek.SATURDAY) {
                        System.out.println();
                    }
                    break;
                case 4:
                    IntHolder a = new IntHolder(1);
                    IntHolder b = new IntHolder(2);
                    a.swap(b);
                    System.out.println(a.getNumber());
                    System.out.println(b.getNumber());
                    break;
                case 5:
                    Point p1 = new Point(3, 4).translate(1, 3).scale(0.5);
                    System.out.println("x: " + p1.getX() + " y: " + p1.getY());
                    break;
                case 6:
                    PointModify p2 = new PointModify(3, 4);
                    p2.translate(1, 3);
                    p2.scale(0.5);
                    System.out.println("x: " + p2.getX() + " y: " + p2.getY());
                    break;
                case 9:
                    Car car = new Car(2, 10);
                    car.driveTo(3, 4);

                    System.out.println(car.getFuelLevel());
                    break;
                case 10:
                    ArrayList<Integer> arrList = new ArrayList<>();
                    arrList.add(1);
                    arrList.add(2);
                    arrList.add(3);
                    arrList.add(4);
                    arrList.add(5);
                    System.out.println(RandomNumbers.getRandom(arrList));

                    int[] arr = new int[] {1, 2, 3, 4, 5, 6};
                    System.out.println(RandomNumbers.getRandom(arr));
                    break;
                case 16:
                    Queue q = new Queue();
                    q.pushBack("q");
                    q.pushBack("w");
                    q.pushBack("e");
                    System.out.println(q);
                    q.popFront();
                    System.out.println(q);
                    q.popFront();
                    System.out.println(q);
                    q.popFront();
                    System.out.println(q);

                    break;
                case 17:
                    Queue queue = new Queue();
                    queue.pushBack("q");
                    queue.pushBack("w");
                    queue.pushBack("e");
                    queue.pushBack("r");
                    queue.pushBack("t");
                    queue.pushBack("y");

//                    Queue.Iterator iterator = queue.iterator();
//
//                    while (iterator.hasNext()) {
//                        System.out.println(iterator.next());
//                    }
//
//                    iterator = queue.iterator();
//                    while (iterator.hasNext()) {
//                        String element = iterator.next();
//                        if (element.equals("w")) {
//                            iterator.remove();
//                        }
//                    }
                    queue.popFront();
                    queue.popFront();

                    System.out.println(queue);

                    break;
                case 18:
                    Circle c1 = new Circle(0, 0, 5);
                    Circle c2 = new Circle(6, 0, 5);
                    Circle c3 = new Circle(0, 0, 1);
                    Circle c4 = new Circle(2, 0, 1);
                    Circle c5 = new Circle(0, 0, 1);
                    Circle c6 = new Circle(2, 2, 1);
                    Circle c7 = new Circle(0, 0, 5);

                    List<PointModify> points = Circle.intersections(c1, c2);
                    List<PointModify> points2 = Circle.intersections(c3, c4);
                    List<PointModify> points3 = Circle.intersections(c5, c6);
                    List<PointModify> points4 = Circle.intersections(c5, c1);
                    List<PointModify> points5 = Circle.intersections(c1, c7);

                    System.out.println(points);
                    System.out.println(points2);
                    System.out.println(points3);
                    System.out.println(points4);
                    System.out.println(points5);

//                    if (points != null && points.isEmpty()) {
//                        System.out.println("Окружности не пересекаются");
//                    } else {
//                        System.out.println("Точки пересечения:");
//                        for (PointModify point : points2) {
//                            System.out.println("(" + point.getX() + ", " + point.getY() + ")");
//                        }
//                    }
                    break;
                case 19:
                    Formatter currencyFormatter = Formatter.getCurrencyInstance();
                    Formatter percentFormatter = Formatter.getPercentInstance();

                    double x = 0.1;

                    System.out.println(currencyFormatter.format(x));
                    System.out.println(percentFormatter.format(x));
                    break;
                default:
                    System.out.println("Неверно!");
            }
        }
    }
}