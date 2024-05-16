import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class SimpleFileReader {
    public static void main(String[] args) throws Exception {
        File file = new File("./text.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;

        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }
}