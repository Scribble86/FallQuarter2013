/**
 * 
 * @author scribble
 * @assignment 9: sieve of Eratosthenes
 * @grading target: Standard
 * PrimeSieve is the class I wrote to implement the Sieve interface. It seems like it works.
 */
public class PrimeSieve implements Sieve {
  
 /**
  * This is a zero-parameter constructor for PrimeSieve. It only exists because the
  * constructor for the driver constructs this class.
  */
  public PrimeSieve(){
    getPrimes(0);
  }
  /**
   * The getPrimes class accepts an integer. It returns an ArrayList containing all of the 
   * prime numbers that are less than or equal to the number number specified.
   * @param int n; the end point to stop calculating for prime numbers.
   * @return ArrayList 
   */
  public java.util.List<java.lang.Integer> getPrimes(int n) {
    java.util.ArrayList<Integer> primeList = new java.util.ArrayList<Integer>();
    java.util.ArrayList<Integer> numberList = new java.util.ArrayList<Integer>();
    for(int i = 2; i <= n; i++) {
      numberList.add(i);
    }
    int m =(int) Math.sqrt(n);
    for(int i = 0; i < m; i++) {
      primeList.add(numberList.get(0));
      numberList.remove(0);
      for(int j = 0; j < numberList.size(); j++) {
        if(numberList.get(j) % primeList.get(i) == 0) {
          numberList.remove(j);
        }
      }
    }
    for(int k = 0; k < numberList.size(); k++) {
    primeList.add(numberList.get(k));
    }
    return primeList;
  }
}