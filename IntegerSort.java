
//Nikita Chrystephan
//Quiz 1: Basic Programming Competence

public class IntegerSort {
//it begins.
	public static void main(String[] args) {
		
	//initializing the array
	int[] theCount = new int[15];
	//filling the array with sequential numbers
	for(int i = 0; i < theCount.length; i++) {
		theCount[i] = 1+ i;
		}
	//this line calls the helper function, passes it the array, and outputs the result
	System.out.println(AddUp(theCount));
	}
	
	//helper function determines qualifying numbers and adds them to the total if they qualify
	static int AddUp(int[] sequence) {
		
		//declaring a variable to store the output before returning it
		int total = 0;
		
		//loop to iterate through the array that was passed in
		for(int i = 0; i < sequence.length; i++) {
		
			//this statement determines if there are remainders when dividing by two or three
			if ((sequence[i] % 2) != 0 || (sequence[i] % 3 == 0)) {
				
				//adds qualifying numbers to the total
			total = total + sequence[i];
		}	
	}
		//returns the resulting value
		return total;
}
}