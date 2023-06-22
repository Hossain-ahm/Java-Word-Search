import java.util.ArrayList;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Search search = new Search();
    ArrayList<String> list = new ArrayList<String>();

    Scanner myObj = new Scanner(System.in);

    boolean end = true;
    // a while to run to choose what function
    while (end) {
      System.out.println("choosen function: ");
      String choosenFunction = myObj.nextLine();
      //while loop ends if end is input
      if (choosenFunction.equals("end")){
        end = false;

      }
      else{
        boolean clear = true;
        System.out.println("contents: ");
        String contents = myObj.nextLine();  
        //generates list of words based on the function and contents of the input
        if (choosenFunction.equals("prefix")){
          list = search.prefix(contents);
        }
        if (choosenFunction.equals("suffix")){
          list = search.suffix(contents);
        }
        if (choosenFunction.equals("contains")){
          list = search.contains(contents);
        }
        if (choosenFunction.equals("contains in order")){
          list = search.containsInOrder(contents);
        }
        if (choosenFunction.equals("pool")){
          list = search.pool(contents);
        }
        if (choosenFunction.equals("clear")){
          clear = false;
        }
        search.printArrayList(list);

      while(clear){
        //another while loop to further combine the list with other functions
        System.out.println("add new function or clear: ");
        choosenFunction = myObj.nextLine();
        if (choosenFunction.equals("clear")){
          clear = false;
          break;
        }
        System.out.println("contents: ");
        contents = myObj.nextLine(); 
        if (choosenFunction.equals("prefix")){
          list = search.combine(list,search.prefix(contents));
        }
        if (choosenFunction.equals("suffix")){
          list = search.combine(list,search.suffix(contents));
        }
        if (choosenFunction.equals("contains")){
          list = search.combine(list,search.contains(contents));
        }
        if (choosenFunction.equals("contains in order")){
          list = search.combine(list,search.containsInOrder(contents));
        }
        if (choosenFunction.equals("pool")){
          list = search.combine(list,search.pool(contents));
        }
        search.printArrayList(list);

      }

    }

  }
  }

}