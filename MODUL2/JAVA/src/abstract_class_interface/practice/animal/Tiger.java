package abstract_class_interface.practice.animal;

import abstract_class_interface.practice.interface_edible.Edible;

public class Tiger extends Animal implements Edible {

    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howToEat() {
        return "kakakakakakakak";
    }
}
