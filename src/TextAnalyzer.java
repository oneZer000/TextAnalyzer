import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

public class TextAnalyzer {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter text:\n");
            String text = in.nextLine();
            analyzeText(text);
        }
    }
    public static void analyzeText(String text){
        int wordCount = countUniqueWords(text);
        String theLongestWord = findLongestWord(text);
        HashMap<Character, Integer> countCharsMap = countChars(text);
        Set<Character> charsSet = countCharsMap.keySet();
        for (Character ch: charsSet){
            int charCount = countCharsMap.get(ch);
            System.out.printf("%c - %d\n", ch, charCount);
        }
        System.out.printf("Количество слов: %d\nСамое длинное слово: %s\n", wordCount, theLongestWord);
        StringBuilder reversedText = reverseText(text);
        System.out.printf("%s\n", reversedText);
    }
    private static int countUniqueWords(String text){
        String[] wordsArray = text.split(" ");
        HashMap<String, Integer> uniqueWords = new HashMap<>();
        for (String word: wordsArray){
            word = word.toLowerCase();
            if (uniqueWords.containsKey(word)){
                int c = uniqueWords.get(word);
                uniqueWords.put(word, c+1);
            }else {
                uniqueWords.put(word, 1);
            }
        }
        return uniqueWords.size();
    }
    private static String findLongestWord(String text){
        String[] wordsArray = text.split(" ");
        String theLongestWord = " ";
        for (String word: wordsArray){
            if (word.length() > theLongestWord.length()){
                theLongestWord = word;
                break;
            }
        }
        return theLongestWord;
    }
    private static HashMap<Character, Integer> countChars(String text){
        char[] charsArray = text.toCharArray();
        HashMap<Character, Integer> charsMap = new HashMap<>();
        for (char ch: charsArray){
            if (charsMap.containsKey(ch)){
                int c = charsMap.get(ch);
                charsMap.put(ch, c+1);
            }else {
                charsMap.put(ch, 1);
            }
        }
        return charsMap;
    }
    private static StringBuilder reverseText(String text){
        StringBuilder textReverser = new StringBuilder(text);
        StringBuilder reversedText = textReverser.reverse();
        return reversedText;
    }
}
