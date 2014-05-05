
//Nikita Chrystephan
//Quiz 1: Basic Programming Competence

public class FizzBuzz {
//it begins.
	public static void main(String[] args) {
		int total = 0;
		boolean newLine = false;
	//initializing the array
	int[] theCount = new int[15];
	//filling the array with sequential numbers
	for(int i = 0; i < theCount.length; i++) {
		theCount[i] = 1+ i;
		}
	//starting a loop to process the array
	for(int i = 0; i < theCount.length; i++) {
	
	//System.out.println(theCount[i]);
	
	//this if adds to the total if the number is odd or a multiple of three
	if (isOdd(theCount[i]) || isMultipleOfThree(theCount[i])) {
		total = total +theCount[i];
	}
	if(isOdd(theCount[i])) {
		System.out.print("Fizz");
		newLine = true;
	}
	if(isMultipleOfThree(theCount[i])) {
		System.out.print("Buzz");
		newLine = true;
	}
	if (newLine == true) {
		System.out.print(" " + theCount[i] + "\n");
		newLine = false;
	}
	}
	System.out.println("The eligible numbers add up to: " + total);
	}
	
	//I created a function to tell me if a number is odd
	private static boolean isOdd(int currentNumber)  {
		if(currentNumber % 2 == 0) {
			return false;
		}
		else return true;
	}
	
	//I created a function to tell me if a number is a multiple of three
	private static boolean isMultipleOfThree(int currentNumber) {
	if(currentNumber % 3 == 0) {
		return true;
	}
	else return false;
	}
	}