import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFile01TextAnalyzer {
    public static void main(String[] args) {
        String fileName = "TextFile.txt";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            StringBuilder text = new StringBuilder();
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine()).append(" ");
            }
            String fullText = text.toString().trim();

            // Count words
            String[] words = fullText.split("\\s+");
            int wordCount = words.length;
            System.out.println("Number of words: " + wordCount);

            // Count sentences
            int sentenceCount = 0;
            for (int i = 0; i < fullText.length(); i++) {
                char c = fullText.charAt(i);
                if (c == '.' || c == '!' || c == '?') {
                    sentenceCount++;
                }
            }
            System.out.println("Number of sentences: " + sentenceCount);

            // Convert to uppercase
            String uppercaseText = fullText.toUpperCase();
            System.out.println("Uppercase text: " + uppercaseText);

            // Find the longest word
            String longestWord = "";
            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            System.out.println("Longest word: " + longestWord);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
    }
}
