package inheritance.exercise;

public class Point extends Point2D {
    public Point() {
    }

    public Point(float x, float y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "Point is  " + " ( " + getX() + " , " + getY() + " )";
    }
}