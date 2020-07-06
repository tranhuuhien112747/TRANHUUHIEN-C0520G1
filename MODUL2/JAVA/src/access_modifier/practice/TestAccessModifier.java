package access_modifier.practice;

class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return radius * radius * 3.14;
    }
}
public class TestAccessModifier {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setColor("blue");
        System.out.println("Circle is color " + circle.getColor() + ",area = " + circle.getArea());
    }
}

