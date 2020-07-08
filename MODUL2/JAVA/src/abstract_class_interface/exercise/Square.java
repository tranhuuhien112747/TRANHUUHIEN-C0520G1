package abstract_class_interface.exercise;

import abstract_class_interface.exercise.interface_colorable.Colorable;
import inheritance.practice.Rectangle;

public class Square extends Shape implements Colorable,Resizeable {
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getAre() {
        return this.side * this.side;
    }

    @Override
    public String toString() {
        return "Square { " +
                " side = " + side + ", Area = "+getAre()+
                " } ";
    }

    @Override
    public String howToColor() {
        return "Color all four sides....";
    }

    @Override
    public void resize(double percent) {
        this.side=this.side*percent;
    }
}
