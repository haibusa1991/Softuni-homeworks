package lecture04;

import java.awt.*;
import java.util.Scanner;

public class ME03LongerLine {
    public static void main(String[] args) {

        Point[] points = getInputPoints();

        double line1Length = getLineLength(points[0], points[1]);
        double line2Length = getLineLength(points[2], points[3]);

        if (line1Length >= line2Length) {
            printLine(points[0], points[1]);
        } else {
            printLine(points[2], points[3]);

        }
    }

    public static double getLineLength(Point p1, Point p2) {

        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    public static double getDistanceToCenter(Point p) {
        return Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2));
    }

    public static void printCoordinates(Point p) {
        System.out.printf("(%.0f, %.0f)", p.getX(), p.getY());
    }

    public static Point[] getInputPoints() {
        Scanner scanner = new Scanner(System.in);
        Point[] arr = new Point[4];

        for (int i = 0; i < 4; i++) {
            arr[i] = new Point(0, 0);
            arr[i].x = Integer.parseInt(scanner.nextLine());
            arr[i].y = Integer.parseInt(scanner.nextLine());
        }
        return arr;
    }

    public static void printLine(Point p1, Point p2) {
        if (getDistanceToCenter(p1) < getDistanceToCenter(p2)) {
            printCoordinates(p1);
            printCoordinates(p2);
        } else {
            printCoordinates(p2);
            printCoordinates(p1);
        }
    }
}
