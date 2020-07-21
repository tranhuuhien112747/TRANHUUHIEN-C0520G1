package ss15_text_file.exercise;

import java.io.*;

public class ReadFileOptional {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/ss15_text_file/exercise/cvs");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                System.out.println("Code = " + data[4] + " =====>  " + data[5]);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
