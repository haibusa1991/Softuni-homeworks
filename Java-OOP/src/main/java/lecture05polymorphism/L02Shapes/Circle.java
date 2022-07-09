package lecture05polymorphism.L02Shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * radius * Math.PI);
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public void calculateArea() {
        super.setArea(radius * radius * Math.PI);
    }
}
