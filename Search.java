import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner; // Import the Scanner class to read text files

public class Search {
    private ArrayList<String> words;//An arraylist that will hold all words

    public Search() {
        words = new ArrayList<String>();
        try {
            //Read a text file that contains all the words and add them to the arraylist
            File wordsAplha = new File("wordlist.txt");
            Scanner reader = new Scanner(wordsAplha);
            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                words.add(word);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //this function will return all words that begin with a given string
    public ArrayList<String> prefix (String prefix) {
        ArrayList<String> newWords = new ArrayList<String>();

        for (String word : this.words) {
            if (word.startsWith(prefix)) {
                newWords.add(word);
            }
        }
        return newWords;

    }

    //this function will return all words that ends with a given string
    public ArrayList<String> suffix (String suffix) {
        ArrayList<String> newWords = new ArrayList<String>();

        for (String word : this.words) {
            if (word.endsWith(suffix)) {
                newWords.add(word);
            }
        }
        return newWords;

    }

    //this function will return all words that contains a given string
    public ArrayList<String> containsInOrder (String content) {
        ArrayList<String> newWords = new ArrayList<String>();
        for (String word : this.words) {
            if (word.contains(content)) {
                newWords.add(word);
            }
        }
        return newWords;

    }

    // a function that will return a hash map that counts the number of occrence of the characters in
    public HashMap<Character,Integer> charCount (String content) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for (int i = 0; i<content.length(); i++) {
            if (map.containsKey(content.charAt(i))) {
                map.put(content.charAt(i), map.get(content.charAt(i))+1);
            }else{
                map.put(content.charAt(i), 1);
            }

        }
        return map;
    }

    //a function that will returns word that can be made from a pool of letters
    public ArrayList<String> pool (String content) {
        ArrayList<String> newWords = new ArrayList<String>();
        HashMap<Character,Integer> map = charCount(content);

        for (String word :this.words){
            HashMap<Character,Integer> wordMap = charCount(word);

            boolean canMakeCurrentWord = true;
            for (Character c : wordMap.keySet()){
                int currentWordCharCount = wordMap.get(c);
                int letterCharCount = 0;
                if (map.containsKey(c)){
                    letterCharCount = map.get(c);
                }
                if (currentWordCharCount > letterCharCount){
                    canMakeCurrentWord = false;
                    break;
                }
            }
            if (canMakeCurrentWord){
                newWords.add(word);
            }
        }

        return newWords;
    }

    //a function that will returns word that must contain the given letter
    public ArrayList<String> contains (String content) {
        ArrayList<String> newWords = new ArrayList<String>();
        HashMap<Character,Integer> map = charCount(content);

        for (String word :this.words){
            HashMap<Character,Integer> wordMap = charCount(word);

            boolean canMakeCurrentWord = true;
            for (Character c : map.keySet()){
                int currentWordCharCount = 0;
                int letterCharCount = map.get(c);
                if (wordMap.containsKey(c)){
                    currentWordCharCount = wordMap.get(c);
                }
                if (currentWordCharCount < letterCharCount){
                    canMakeCurrentWord = false;
                    break;
                }
            }
            if (canMakeCurrentWord){
                newWords.add(word);
            }
        }

        return newWords;
    }

    public ArrayList<String> exactLength(int len) {
        ArrayList<String> newWords = new ArrayList<String>();
        for (String word : this.words) {
            if (word.length() == len){
                newWords.add(word);
            }

        }

        return newWords;
    }
    public ArrayList<String> lessLength(int len) {
        ArrayList<String> newWords = new ArrayList<String>();
        for (String word : this.words) {
            if (word.length() <= len){
                newWords.add(word);
            }

        }

        return newWords;
    }
    public ArrayList<String> greaterLength(int len) {
        ArrayList<String> newWords = new ArrayList<String>();
        for (String word : this.words) {
            if (word.length() >= len){
                newWords.add(word);
            }

        }

        return newWords;
    }

    //this combine two list of words returning the same words they both contain
    public ArrayList<String> combine (ArrayList<String> array1, ArrayList<String> array2) {
        array1.retainAll(array2);
        return array1;

    }

    public void printArrayList(ArrayList<String> arrayList) {
        for (String word : arrayList) {
            System.out.println(word);
        }
    }

}
