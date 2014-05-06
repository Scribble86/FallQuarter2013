/**
 * 
 * @author Dan Jinguji, Updated by Nikita Chrystephan
 * @assignment 
 * @grading Target: Standard
 * The SieveDriver class manages input and output for the prime number search application.
 */
public class SieveDriver {
  
  private java.util.Scanner scan;
  private Sieve theSieve;
  
  /**
   * The constructor for SieveDriver instantiates the class, a scanner for System.in, 
   * and instantiates a PrimeSieve.
   */
  public SieveDriver() {
    scan = new java.util.Scanner(System.in);
    theSieve = new PrimeSieve();
  }
  
  /**
   * The go method parses input and calls the PrimeSieve class, as well as the other methods in SieveDriver.
   * go also handles input validation for numeric quantities.
   */
  public void go() {
    
    java.util.List<Integer> primes;
    
    int n = getNumber();
    if(n == 0) {
      System.out.println("Thank you for using the Sieve of Eratosthenes.");
    } else if( n < 0) {
      System.out.println("Please enter a positive integer or 0 to exit.");
      go();
    } else if(n < 2 && n > 0) {
      System.out.println("There are no prime numbers less than two.");
      go();
    } else {
      primes = theSieve.getPrimes(n);
      printPrimes(primes);
      go();
    }
  }
   /**
    * the getNumber method handles input from System.in and handles non-numeric input.
    * It returns an integer n.
    * @return int n; the upper bound for testing prime numbers.
    */
  public int getNumber() {
    int n = 0;
    boolean test = true;
    while(test) {
    try {
      System.out.print("Enter the upper bound or 0 to exit: ");
      n = scan.nextInt();
      test = false;
    } catch(java.util.InputMismatchException e) {
      System.out.println("You must enter a numeric value.");
      scan.next();
    }
    }
    return n;
  }
  
// this is the old printPrimes method that was replaced by one that uses Iterator.
//   public void printPrimes(int bound, java.util.List<Integer> list) {
//      System.out.println("The primes up to N are:");
//      for(int i = 0; i < list.size(); i ++) {
//         System.out.print(list.get(i) + " ");
//      }
//      System.out.println();
//      System.out.println();
//   }
  
  /**
   * The printPrimes method accepts an integer list (in this case it will be an ArrayList) and
   * returs nothing. It handles the output from the prime number search. It iterates through items
   * in the list until there are no more items, and prints them to the console.
   * @param list <Integer>; the list of prime numbers that are the result of the sieve.
   */
  public void printPrimes(java.util.List<Integer> list) {
    java.util.Iterator<Integer> iter = list.iterator();
    while(iter.hasNext()) {
      String s = iter.next().toString();
      System.out.print(s + " ");
    }
    System.out.println();
    System.out.println();
    
  }
  
  /**
   * This is the main method. it calls the constructor of the class and the go method that
   * handles input and output and calls all of the related classes and methods.
   * @param args
   */
  public static void main(String[] args) {
    
    new SieveDriver().go();
    
  }
  
}