package model;

public class Student {
    private String id;
    private String name;
    private int age;
    private String card_id;

    public Student() {
    }

    public Student(String id, String name, int age, String card_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.card_id = card_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}
