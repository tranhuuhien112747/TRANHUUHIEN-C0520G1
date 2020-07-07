package inheritance.exercise;

public class CircleAndCylinderTest {
    public static void main(String[] args) {
        Circle circle= new Circle();
        System.out.println(circle);
        circle = new Circle(1,"black");
        System.out.println(circle);
        Cylinder cylinder=new Cylinder();
        System.out.println(cylinder);
        cylinder= new Cylinder(2,3,2,"yellow");
        System.out.println(cylinder);
    }
}
