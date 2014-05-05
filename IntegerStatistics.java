/**
 * @author Dan Jinguji, enhanced by Nikita Chrystephan
 * @assignment #6 IntegerStatistics
 * @grading target:challenge
 */

/**
 * The class IntegerStatistics creates, modifies, and manages an array of numbers. 
 * It can perform a variety of computations on the set of numbers contained within.
 */
public class IntegerStatistics {
  
  java.util.Scanner scan;
  //storage for the integers
  int[] storage;
  //storageSize records the number of real data in the set.
  int storageSize;
  
  /**
   * The constructor for IntegerStatistics instantiates the scanner class,
   * the storage array, and the storageSize variable.
   */
  public IntegerStatistics() {
    scan = new java.util.Scanner(System.in);
    storage = new int[10];
    storageSize = 0;
  }
  
  /* This is a method that handles adding data manually to the array.
   * it resizes the array as necessary, and keeps the storageSize variable
   * updated, so "empty" slots aren't accidentally counted as data.
  */
  private void addToStorage(int a) {
    if(storageSize <storage.length) {
      storage[storageSize] = a;
      storageSize++;
    } else { 
      int[] doubleStorage = new int[2*storageSize];
      for(int i =0;i<storageSize;i++) {
        doubleStorage[i] = storage[i];
      }
      storage = doubleStorage;
      storage[storageSize] = a;
      storageSize++;
    }
  }
  
  /*
   * The median method finds the median of values in the array. it calls the
   * sort method before doing anything else, though.
   */
  private double median() {
    storage = sort(storage);
    if(storageSize % 2 == 0) {
      int value0 = storage[storageSize / 2];
      int value1 = storage[(storageSize / 2) +1];
      return (double)(value0) / value1;
    } else {
        return storage[storageSize / 2];
      }
  }
  
  /*
   * The sort method re-arranges the data inside the array to order from least to
   * greatest quantity. This helps the median method do it's job, but doesn't affect
   * any of the other methods, since the order of the data doesn't matter to them.
   * @param integer array
   * @return integer array
   */
  private int[] sort(int[] toSort) {
    for(int i = 0; i < storageSize; i++) {
      for(int j = 0; j < storageSize-1; j++) {
        if(toSort[j+1] < toSort[j]) {
          int temp = toSort[j];
          toSort[j] = toSort[j+1];
          toSort[j+1] = temp;  
        }
        }
    }
    return toSort;
  }
  
  //this is a method that came with the starter code, it prints some lines of text.
  private void showMenu() {
    System.out.println("Menu:");
    System.out.println("   p - Print the list of values");
    System.out.println("   s - Print statistics for the values");
    System.out.println("   f - Fill the list with random values");
    System.out.println("   c - Clear the list of values");
    System.out.println("   h - Print out this menu");
    System.out.println("   x - Exit the program");
  }
  
  /*this is a method that I have updated. It replaces the current array with a
  *fresh, empty array.
  */
  private void clearValues() {
    // empty (zero out) the array
    storage = new int[10];
    storageSize=0;
    System.out.println("The data have been cleared.");
  }
  
  /*
   * This method fills the array with ten random numbers between -10 and 15.
   */
  private void fillList() {
    // fill the array
    storage = new int[10];
    storageSize = 10;
    for(int i = 0; i<storageSize;i++) {
      java.util.Random rand = new java.util.Random();
      storage[i]= rand.nextInt(26) - 10;
    }
    System.out.println("Ten small random* numbers have been entered.");
  }
  
  /*
   * this method prints the values in the current array.
   */
  private void printValues() {
    String pOut = "";
    System.out.print("The values are: [");
    // print the values
    for(int i = 0;i < storageSize;i++) {
      pOut += storage[i]+ ", ";
    }
    pOut = pOut.substring(0,pOut.length() -2) + ".";
    System.out.print(pOut);
    System.out.println("]");
  }
  
  /*
   * this method performs most of the mathematical heavy lifting in the class.
   * it calculates the average, standard deviatioin, median, min, and max 
   * values of the set of data. It also prints and formats the output
   * of those calculations.
   */
  private void printStats() {
    double avg = 0;
    double variance = 0;
    double median = 0;
    int squares = 0;
    int max = 0;
    int min = 0;
    int sum = 0;
    
    for(int i = 0;i<storageSize;i++) {
      if(storage[i] > max) {
        max = storage[i];
      }
      if(storage[i] < min) {
        min = storage[i];
      }
      sum += storage[i];
      squares +=Math.pow(storage[i],2);
    }
    avg = (double) (sum)/storageSize;
    variance = ((double)(squares)/storageSize) - (double) Math.pow(avg,2);
    median = median();
    
    System.out.println("Number of entries: " + storageSize);
    System.out.println("Sum of the values: " + sum);
    System.out.println("Maximum value: " + max);
    System.out.println("Minimum value: " + min);
    System.out.format("Average value: %6.3f ",avg);
    System.out.println("");
    System.out.format("Standard Deviation: %6.3f ",Math.sqrt(variance));
    System.out.println("");
    System.out.format("Median: %6.3f ",median);
    System.out.println("");
  }
  
  /*
   * This method came with the starter code, but it has been modified to accept numeric input
   * and send that numeric input to the addToStorage method, which handles adding data to the
   * array. Otherwise, it mostly does what it always did.
   */
  public void go() {
    System.out.println("Welcome to Simple Statistics Program\n");
    String input ="";
    showMenu();
    do {
      System.out.println("Enter a command or integer value: ");
      if(scan.hasNextInt()) {
        addToStorage(scan.nextInt());
        System.out.println("The value has been added. ");
        continue;
      } else input = scan.next(); 
      if(input.equals("p")) {
        printValues();
      } else if(input.equals("s")) {
        printStats();
      } else if(input.equals("f")) {
        fillList();
      } else if(input.equals("c")) {
        clearValues();
      } else if(input.equals("h")) {
        showMenu();
      } else if(input.equals("x")) {
        // do nothing  
      } else {
        System.out.println("Unrecognized command. Try again.");
        showMenu();
      }
    } while( ! input.equals("x"));
    System.out.println("\nThank you for using the Simple Statistics Program");
  }
  
  /**
   * this is the main method, it instantiates the class and calls the method that prints the menu
   * and asks for input from the user.
   * @param args
   */
  public static void main(String[] args) {
    IntegerStatistics intStat = new IntegerStatistics();
    intStat.go();
  }
  
}
