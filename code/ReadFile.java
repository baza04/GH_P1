import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

class SimpleFileReader {
    public static void main(String[] args) throws Exception {
        String srcPath = "./input.txt";
        String dstPath = "./output.txt";
        File inputFile = new File(srcPath);
        File outputFile = new File(dstPath);

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        String allFileStr = "";
        String str = "";

        while ((str = br.readLine()) != null) {
            allFileStr += str;
            System.out.println(str);
            bw.write(str.substring(0,1)+"\n");
        }

        String compressedText = compressor(allFileStr);
        
        // write compressed txt to file
        bw.write(compressedText);

        br.close();
        bw.close();
    }

    public static String compressor(String input) {
        String result = "";
        String[] words = input.split(" ");

        Integer wordIndex = 0;
        HashMap<String, Integer> dictionary = new HashMap<String, Integer>();

        for (Integer i = 0; i < words.length; i++) {
            dictionary.containsValue(words[i])
        }

        return result;
    }
}