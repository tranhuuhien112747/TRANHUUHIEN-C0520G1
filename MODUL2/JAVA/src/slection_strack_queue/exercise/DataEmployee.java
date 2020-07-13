package slection_strack_queue.exercise;

/**
 * [Optional] [Bài tập] Tổ chức dữ liệu hợp lý - Demerging sử dụng Queue.
 */
public class DataEmployee implements Comparable<DataEmployee> {
    private String name;
    private String dayOfBirth;
    private String sex;

    public DataEmployee() {
    }

    public DataEmployee(String name, String dayOfBirth, String sex) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Name = " + this.getName() + ", DayofBirth = " + this.getDayOfBirth() + ", Sex = " + this.getSex();
    }

    @Override
    public int compareTo(DataEmployee o) {
        return this.getDayOfBirth().compareTo(o.getDayOfBirth());
    }
}
