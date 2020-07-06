package oop_object_property.bai_tap;

class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed;
    private boolean on = false;
    private double radius = 5.0;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean On() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {
    }

    public String toString() {
        if (this.On()) {
            return "Fan on, speed = " + this.getSpeed() + " , color is " + this.getColor() + " and radius = "
                    + this.getRadius() + ".";
        } else {
            return "Fan off, speed = " + this.getSpeed() + " , color is " + this.getColor() + " and radius = "
                    + this.getRadius() + ".";
        }
    }

}
public class Fantex{
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan2.setSpeed(Fan.MEDIUM);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println("Fan 1: " + fan1.toString());
        System.out.println("Fan 2: " + fan2.toString());

    }
}
