package inheritance.exercise;

public class Point2DAnd3DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        point2D=new Point2D(3,4);
        System.out.println(point2D);
        Point3D point3D=new Point3D();
        System.out.println(point3D);
        point3D=new Point3D(5,6,7);
        System.out.println(point3D);
    }
}
