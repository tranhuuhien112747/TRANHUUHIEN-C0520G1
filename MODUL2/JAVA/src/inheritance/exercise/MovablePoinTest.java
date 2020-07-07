package inheritance.exercise;

public class MovablePoinTest {
    public static void main(String[] args) {
        Point point=new Point();
        System.out.println(point);
        point =new Point(2,2);
        System.out.println(point);
        MovablePoint movablePoint=new MovablePoint();
        System.out.println(movablePoint);
        movablePoint=new MovablePoint(4,4);
        System.out.println(movablePoint);
        movablePoint =new MovablePoint(3,3,6,6);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
        movablePoint.setXSpeed(2);
        movablePoint.setYSpeed(2);
        movablePoint.move();
        System.out.println(movablePoint);

    }
}
