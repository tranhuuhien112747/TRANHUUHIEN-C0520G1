package ss16_io_binary_file_serialization.exercise;

import java.io.*;


public class CopyFileBinary {
    public static void main(String[] args) {
        try {
            File file = new File("src/ss16_io_binary_file_serialization/exercise/file1");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream("src/ss16_io_binary_file_serialization/exercise/file2.txt");
            int len;
            byte[] data = new byte[1024];
            while ((len = inputStream.read(data)) > 0) {
                outputStream.write(data, 0, len);
            }
            System.out.println("Success");
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
