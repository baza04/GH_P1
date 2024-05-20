import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Compressor {
    public static String srcPath = "./resources/input.txt";
    public static String dstPath = "./resources/output.sc";
    private static HashMap <String, Integer> dict;

    // // init
    // private Compressor() {
    // }

    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new FileReader(new File(srcPath)));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(dstPath)));
            dict = new HashMap<>(); // init this
    
            String allFileStr = "";
            String str = "";
    
            while ((str = br.readLine()) != null) {
                allFileStr += str + " \\n "; // replace "\\n" after decompress
                System.out.println(str);
                // bw.write(str.substring(0,1)+"\n");
            }
    
            String compressedText = compress(allFileStr);
            // write compressed txt to file
            bw.write(compressedText);
            
            String Text = compress(allFileStr);
            // String compressedText = "";
            
            // close buffered reader & writer;
            br.close();
            bw.close();
    }

    public static String compress(String input) {
        String compressedText = "";
        Integer wordIndex = 0;

        String[] words = input.split("\\s+");
        

        for (String word : words) {
            if (!dict.containsKey(word)) {
                dict.put(word, wordIndex);
                wordIndex++;
            }

            Integer key = dict.get(word);
            compressedText += key+" ";
        }

        return compressedText.substring(0, compressedText.length()-1);
    }
}
