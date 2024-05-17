import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

class SimpleFileReader {
    public static void main(String[] args) throws Exception {
        String srcPath = "./input.txt";
        String dstPath = "./output.txt";
        File inputFile = new File(srcPath);
        File outputFile = new File(dstPath);

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        String str = "";

        while ((str = br.readLine()) != null) {
            System.out.println(str);
            bw.write(str.substring(0,1)+"\n");
        }

        bw.close();
    }
}