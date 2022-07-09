package lecture05polymorphism.L02Shapes;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(5.0);
        Shape rec = new Rectangle(1.0, 5.0);

        circle.calculateArea();
    }


}
