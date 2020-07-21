package text.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTest {
    public static void main(String[] args) {
        try{
            FileWriter fileWriter=new FileWriter("Hien.txt");
            fileWriter.write("hello");
            fileWriter.append("hien");
            fileWriter.write("\n kakaka");
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
