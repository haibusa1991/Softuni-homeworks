package lecture01WorkingWithAbstraction.L02PointInRectangle;

public class Rectangle {
    private final Point pointA;
    private final Point pointB;

    public Rectangle(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public boolean contains(Point p) {
        return (p.hasGreaterOrEqualX(pointA)
                && p.hasGreaterOrEqualY(pointA)
                && pointB.hasGreaterOrEqualX(p)
                && pointB.hasGreaterOrEqualY(p));
    }
}
