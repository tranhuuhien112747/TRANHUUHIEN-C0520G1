package abstract_class_interface.practice;

import abstract_class_interface.practice.animal.Animal;
import abstract_class_interface.practice.animal.Chicken;
import abstract_class_interface.practice.animal.Tiger;
import abstract_class_interface.practice.fruit.Apple;
import abstract_class_interface.practice.fruit.Fruit;
import abstract_class_interface.practice.fruit.Oranger;
import abstract_class_interface.practice.interface_edible.Edible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
            if (animal instanceof Tiger) {
                Edible edible = (Tiger) animal;
                System.out.println(edible.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Oranger();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
