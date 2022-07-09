package lecture05polymorphism.L02Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;


    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.height * 2 + this.width * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.height * this.width);
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }
}
