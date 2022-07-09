package lecture01WorkingWithAbstraction.L02PointInRectangle;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int[] coordinates) {
        this.x = coordinates[0];
        this.y = coordinates[1];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasGreaterOrEqualX(Point p) {
        return this.x >= p.x;
    }

    public boolean hasGreaterOrEqualY(Point p) {
        return this.y >= p.getY();
    }
}
