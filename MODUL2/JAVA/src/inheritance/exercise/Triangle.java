package inheritance.exercise;

public class Triangle extends Shape {
    private double height = 1.0;

    public Triangle() {

    }

    public Triangle(double size, double size1, double size2, double height) {
        super(size, size1, size2);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return (this.height * getSize2()) / 2;
    }

    public double getPerimeter() {
        return getSize() + getSize1() + getSize2();
    }

    @Override
    public String toString() {
        return super.toString() + ", height = " + getHeight() + ", Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }
}
