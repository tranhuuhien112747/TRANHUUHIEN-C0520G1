package inheritance.exercise;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {
    }

    public MovablePoint(float x, float y) {
        super(x, y);
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] array = new float[2];
        array[0] = this.xSpeed;
        array[1] = this.ySpeed;
        return array;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", speed = " + "(" + getXSpeed() + " ," + getYSpeed() + ")";
    }

    public MovablePoint move() {
        super.setX(getX() + this.getXSpeed());
        super.setY(getY() + this.getYSpeed());
        return this;
    }
}
