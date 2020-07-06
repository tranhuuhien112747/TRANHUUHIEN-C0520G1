package access_modifier.homeworks;

public class TestStudentCodeGym {
}
class StudentCodeGym {
    public int id;
    public String name;
    public int dayofbirth;
    public StudentCodeGym(int id,String name, int dayofbirth){
        this.id=id;
        this.name=name;
        this.dayofbirth=dayofbirth;
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

    public int getDayofBirth() {
        return dayofbirth;
    }

    public void setDayofBirth(int dayofbirth) {
        this.dayofbirth = dayofbirth;
    }
}
class StudentCodeGymClass{
 static StudentCodeGym[] studentCodeGyms=new StudentCodeGym[50];
 static {
     for (int i=0;i<studentCodeGyms.length;i++){
         System.out.println(i);
         if ((i>0)){
             boolean check;
         }
     }

 }
}