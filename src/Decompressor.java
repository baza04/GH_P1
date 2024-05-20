import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Decompressor {
    public static String srcPath = "../resources/output.sc";
    public static String dstPath = "../resources/readable.txt";

    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new FileReader(new File(srcPath)));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(dstPath)));
    
            // String allFileStr = "";
            // String str = "";
    
            // while ((str = br.readLine()) != null) {
            //     allFileStr += str;
            //     System.out.println(str);
            //     bw.write(str.substring(0,1)+"\n");
            // }
    
            // String compressedText = compress(allFileStr);
            // // String compressedText = "";
            
            // // write compressed txt to file
            // bw.write(compressedText);
    
            // close buffered reader & writer;
            br.close();
            bw.close();
    }

    public static String decompress(String input) {
        String compressedText = "";

        HashMap <String, Integer> dict = new HashMap<>(null);
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
