package ss15_text_file.exercise;

import java.io.*;
import java.util.ArrayList;

import java.util.List;

/**
 * [Bài tập] Copy file text
 */

public class CopyFileText {
    public static void main(String[] args) {
        try {
            File file = new File("E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\ss15_text_file\\exercise\\SourceFile");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter("src/ss15_text_file/exercise/TargetFile");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
//            List<String> list = new ArrayList<>();
//            while ((line = bufferedReader.readLine()) != null) {
//                list.add(line);
//            }
//            for (int i = 0; i < list.size(); i++) {
//                bufferedWriter.write(list.get(i));
//                bufferedWriter.write("\n");
//            }
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
            }
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
