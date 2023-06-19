import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
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


}
