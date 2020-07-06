package access_modifier.practice;

public class StaticProperty {
    public static void main(String[] args) {

        Car car1 = new Car("Mazda 2", "Skyactiv 3");

        System.out.println(Car.numberOfCars +"\t" +car1.getName());

        Car car2 = new Car("civid", "Skyactiv 6");

        System.out.println(Car.numberOfCars + "\t" +car2.getName());
        Car car3 = new Car("Mazda 3", "Skyactiv 6");

        System.out.println(Car.numberOfCars + "\t" +car3.getName());
        Car car4 = new Car("audio", "Skyactiv 6");

        System.out.println(Car.numberOfCars + "\t" +car4.getName());
        Car car5 = new Car("huynh dai", "Skyactiv 6");

        System.out.println(Car.numberOfCars +"\t" + car5.getName());
        Car car6 = new Car("Cx 5", "Skyactiv 6");

        System.out.println(Car.numberOfCars +"\t" + car6.getName());

    }
}

class Car {

    private String name;
    private String engine;

    public static int numberOfCars;

    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;
    }

    public String getEngine() {
        return engine;
    }

    public String getName() {
        return name;
    }
}
