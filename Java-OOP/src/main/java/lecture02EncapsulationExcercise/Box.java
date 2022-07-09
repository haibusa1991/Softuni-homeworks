package lecture02EncapsulationExcercise;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength(double length) {
        validateInput(length, "Length");
        this.length = length;
    }

    public void setWidth(double width) {
        validateInput(width, "Width");
        this.width = width;
    }

    public void setHeight(double height) {
        validateInput(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return length * width * 2
                + width * height * 2
                + length * height * 2;
    }

    public double calculateLateralSurfaceArea() {
        return width * height * 2
                + length * height * 2;
    }


    public double calculateVolume() {
        return width * height * length;
    }

    private void validateInput(double dimension, String dimensionType) {
        if (dimension <= 0) {
            throw new IllegalArgumentException(dimensionType + " cannot be zero or negative.");
        }

    }
}
