/**
 * @assignment Quiz 11: Word Count
 * @author Dan Jinguji, Nikita Chrystephan
 * The WordCount class has been updated to provide more information about the
 * contents of the text files it scans, using a HashMap, iterator, and printf.
 * Since the class was originally written in a static context, i continued to use
 * the static framework rather than an object oriented one. 
 *
 */
public class WordCount {
  
  //this is a HashMap that stores the words and the number of times they occur in a file.
  private static java.util.HashMap<String, Integer> words = new java.util.HashMap<String, Integer>();
  
  /**
   * The tokenCount method counts the number of tokens in the given string, which
   * in this case will be a file. it also prints out the results and calls the related
   * function that prints out some analysis of the contents of the file.
   * @param text string
   */
  public static void tokenCount(String text) {
    
    java.util.Scanner scan;
    
    // open the file for reading using Scanner
    try {
      scan = new java.util.Scanner(new java.io.File(text));
    } catch(java.io.FileNotFoundException e) {
      System.err.println("Error opening file: " + text);
      return;
    }
    
    // process the file, token by token
    int i = 0;
    while(scan.hasNext()) {
      String token = scan.next();
      mapper(token);
      i ++;
    }
    
    // close the file
    scan.close();
    
    // output statistics
    System.out.println("Token count: " + i);
    readOut();
  }
  
  //the readOut method sifts through the HashMap and prints
  //the keys that appear in significant quantities, along with the
  //value associated with that key.
  private static void readOut() {
    java.util.Set<String> keys = (words.keySet());
    java.util.Iterator<String> iter = keys.iterator();
    while(iter.hasNext()) {
      String nextKey = iter.next();
      if(words.get(nextKey) > 2) {
        //printf is complicated.
        System.out.printf("\t%3d : %s\n", words.get(nextKey), nextKey);
      }
    }
  }
  
  //The mapper method handles adding new keys to the map or updating the associated
  //value associated with the key.
  private static void mapper(String input) {
    String token = input.toLowerCase();
    if(words.containsKey(token)) {
      int newValue = 1 + words.get(token);
      words.put(token, newValue);
    } else words.put(token,1);
  }
  
 /**
  * the main method sends the input file the tokenCount method for analysis.
  * an error is printed if no argument is passed in.
  * @param args a text file is best.
  */
  public static void main(String[] args) {
    if(args.length > 0 ) {
      for(String arg : args) {
        tokenCount(arg);
      }
      
    } else System.err.println("You must provide a file to analyze.");
  } 
  
}