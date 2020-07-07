package inheritance.exercise;

public class Cylinder extends Circle {
    private double with = 1.0;
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double with, double height, double radius, String color) {
        super(radius, color);
        this.height = height;
        this.with = with;
    }

    public double getWith() {
        return with;
    }

    public void setWith(double with) {
        this.with = with;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getPerimeter() {
        return Math.PI * 2 * this.getRadius();
    }
    @Override
    public double getArea() {
        return super.getArea() * 2 + getPerimeter()* height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder is color "+ getColor() +  ", with = "+getWith()+" and height = "+getHeight()+", Area = " +getArea()
                +" ,Volume = "+getVolume();
    }
}
