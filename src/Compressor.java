import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Compressor {
    public static String srcPath = "./resources/input.txt";
    public static String dstPath = "./resources/output.sc";
    public static String dst2Path = "./resources/readable.txt";
    private static HashMap <String, Integer> dict;
    private static HashMap <String, String> dictRev;

    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new FileReader(new File(srcPath)));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(dstPath)));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(new File(dst2Path)));
            
            dict = new HashMap<>();
            dictRev = new HashMap<>();
    
            String allFileStr = "";
            String str = "";
    
            while ((str = br.readLine()) != null) {
                allFileStr += str + " \\n "; // replace "\\n" after decompress
                System.out.println(str);
            }
    
            String compressedText = compress(allFileStr);
            // write compressed txt to file
            bw.write(compressedText);
            

            String decompressedText = decompress(compressedText);
            bw2.write(decompressedText);
            
            // close buffered reader & writer;
            br.close();
            bw.close();
            bw2.close();
    }

    public static String compress(String input) {
        String compressedText = "";
        Integer wordIndex = 0;

        String[] words = input.split("\\s+");

        for (String word : words) {
            if (!dict.containsKey(word)) {
                dict.put(word, wordIndex);
                dictRev.put(wordIndex+"", word);
                wordIndex++;
            }

            Integer key = dict.get(word);
            compressedText += key+" ";
        }

        return compressedText.substring(0, compressedText.length()-1);
    }

    public static String decompress(String input) {
        String result = "";

        String[] keys = input.split("\\s+");

        for (String key : keys) {
            if (!dictRev.containsKey(key)) {
                continue;
            }

            String word = dictRev.get(key);
            result += word + " ";
        }

        result = result.replace(" \\n ", "\n");

        return result.substring(0, result.length()-1);
    }
}
