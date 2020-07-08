package access_modifier.homeworks;

public class StudentCodeGym {
    private int id;
    private String name;
    private String dayofbirth;

    public StudentCodeGym(int id, String name, String dayofbirth) {
        this.id = id;
        this.name = name;
        this.dayofbirth = dayofbirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayofBirth() {
        return dayofbirth;
    }

    public void setDayofBirth(String dayofbirth) {
        this.dayofbirth = dayofbirth;
    }
}

