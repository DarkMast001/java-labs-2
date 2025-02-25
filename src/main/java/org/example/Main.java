package org.example;

import org.example.Tasks.IntHolder;
import org.example.Tasks.Point.Point;
import org.example.Tasks.Point.PointModify;

import static java.lang.Math.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * Пример под static import
         */
        System.out.println(sqrt(pow(3, 2) + pow(2, 2)));

        PointModify p = new PointModify();

        int number = 1;
        while(number != 0) {

            System.out.print("Введите номер задачи 1 - 18 (0 - для выхода): ");
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
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 13:

                    break;
                case 14:

                    break;
                case 15:

                    break;
                case 16:
                    break;
                case 17:

                    break;
                case 18:
                    break;
                default:
                    System.out.println("Неверно!");
            }
        }
    }
}