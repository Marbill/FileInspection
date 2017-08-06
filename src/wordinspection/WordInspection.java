package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* @author marbi */
public class WordInspection {

    private File file;

    public WordInspection(File file) throws Exception {
        this.file = file;
    }

    private String getFile() {
        Scanner reader = null;
        String content = "";
        try {
            reader = new Scanner(file, "UTF-8");
            while (reader.hasNextLine()) {
                content += reader.nextLine() + '\n';
            }
        } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
        } finally {
            reader.close();
            return content;
        }

    }

    public int wordCount() {
        String[] fileAsString = getFile().split("\n");

        return fileAsString.length;
    }

    public List<String> wordsContainingZ() {
        List<String> zWords = new ArrayList<String>();
        String[] fileAsString = getFile().split("\n");

        for (String word : fileAsString) {
            if (word.contains("z")) {
                zWords.add(word);
            }
        }

        return zWords;
    }

    public List<String> wordsEndingInL() {
        String[] fileAsString = getFile().split("\n");
        List<String> wordsL = new ArrayList<String>();

        for (String word : fileAsString) {
            if (word.charAt(word.length() - 1) == 'l') {
                wordsL.add(word);
            }
        }

        return wordsL;
    }

    public List<String> palindromes() {
        String[] fileAsString = getFile().split("\n");
        List<String> palWords = new ArrayList<String>();

        for (String word : fileAsString) {
            String reverse = new StringBuffer(word).reverse().toString();
            if (word.equals(reverse)) {
                palWords.add(word);
            }
        }

        return palWords;
    }

    public List<String> wordsWhichContainAllVowels() {
        String[] fileAsString = getFile().split("\n");
        List<String> vowels = new ArrayList<String>();

        for (String word : fileAsString) {
            if (word.contains("a") && word.contains("e") && word.contains("i") && word.contains("o") && word.contains("u")
                    && word.contains("y") && word.contains("ä") && word.contains("ö")) {
                vowels.add(word);
            }
        }

        return vowels;
    }
}
