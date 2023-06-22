import java.util.ArrayList;


public class Main {
  public static void main(String[] args) {
    Search search = new Search();
    System.out.println("Hello World");
    ArrayList<String> list = new ArrayList<String>();
    list = search.pool("hbslrmodiact");
    list = search.combine(list, search.prefix("c"));
    search.printArrayList(list);

  }


}