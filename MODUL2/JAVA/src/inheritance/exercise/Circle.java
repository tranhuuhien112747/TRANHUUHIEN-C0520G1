package inheritance.exercise;

public class Circle {
    private double darius = 1.0;
    private String color = "blue";

    public Circle() {

    }

    public Circle(double radius, String color) {
        this.darius = radius;
        this.color = color;
    }

    public double getRadius() {
        return darius;
    }

    public void setDarius(double darius) {
        this.darius = darius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return this.darius * this.darius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius = " + getRadius() + "  which is color " + getColor() + " and area = " + getArea();
    }
}
