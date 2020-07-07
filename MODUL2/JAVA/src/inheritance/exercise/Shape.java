package inheritance.exercise;

public class Shape {
    private double size1 = 1.0;
    private double size2 = 1.0;
    private double size = 1.0;
    private String color = "Blue";
    public Shape(){

    }

    public Shape(double size, double size1, double size2) {
        this.size=size;
        this.size1=size1;
        this.size2=size2;
    }

    public double getSize1() {
        return size1;
    }

    public void setSize1(double size1) {
        this.size1 = size1;
    }

    public double getSize2() {
        return size2;
    }

    public void setSize2(double size2) {
        this.size2 = size2;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "A Shape with color is " + getColor() + ", three sides Triangle are size1 = " + getSize() + ", size2 = "
                + getSize1() + ", size3 = " + getSize2();
    }
}
