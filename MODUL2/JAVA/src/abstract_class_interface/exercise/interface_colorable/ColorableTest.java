package abstract_class_interface.exercise.interface_colorable;

import abstract_class_interface.exercise.Circle;
import abstract_class_interface.exercise.Rectangle;
import abstract_class_interface.exercise.Shape;
import abstract_class_interface.exercise.Square;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] array = new Shape[3];
        array[0] = new Circle(3);
        array[1] = new Rectangle(3, 5);
        array[2] = new Square(6);
        for (Shape shape : array) {
            System.out.println(shape);
            if (shape instanceof Square) {
                Colorable colorable = (Square) shape;
                System.out.println(colorable.howToColor());
                System.out.println();
            }
        }
    }
}
