import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner; // Import the Scanner class to read text files

public class Search {
    private ArrayList<String> words;

    public Search() {
        words = new ArrayList<String>();
        try {
            File wordsAplha = new File("words_alpha.txt");
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

    public ArrayList<String> prefix (String prefix) {
        ArrayList<String> newWords = new ArrayList<String>();

        for (String word : this.words) {
            if (word.startsWith(prefix)) {
                newWords.add(word);
            }
        }
        return newWords;

    }

    public ArrayList<String> suffix (String suffix) {
        ArrayList<String> newWords = new ArrayList<String>();

        for (String word : this.words) {
            if (word.endsWith(suffix)) {
                newWords.add(word);
            }
        }
        return newWords;

    }
    public ArrayList<String> containsInOrder (String content) {
        ArrayList<String> newWords = new ArrayList<String>();
        for (String word : this.words) {
            if (word.contains(content)) {
                newWords.add(word);
            }
        }
        return newWords;

    }

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

    public ArrayList<String> contains (String content) {
        ArrayList<String> newWords = new ArrayList<String>();
        ArrayList<String> newWords2 = new ArrayList<String>();
        newWords2.addAll(words);
        HashMap<Character,Integer> map = charCount(content);

        for (String word :this.words){
            HashMap<Character,Integer> wordMap = charCount(word);
            for (Character c :map.keySet()){
                if (!(map.get(c).equals(wordMap.get(c)))){
                    newWords.add(word);
                    break;
                }
            }
        }

        for (String word : newWords){
            newWords2.remove(word);
        }
 

        return newWords2;

    }


    public ArrayList<String> combine (ArrayList<String> array1, ArrayList<String> array2) {
        array1.retainAll(array2);
        return array1;

    }

    public static void main(String[] args) {


        Search search = new Search();
        ArrayList<String> words = search.contains("aaelio");
 

        for (String word : words) {
            System.out.println(word);
        }
    }


}
