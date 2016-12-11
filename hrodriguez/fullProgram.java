import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class fullProgram {
	
	static int SHELLCOMPARISONS = 0;
	static int EXCHANGECOMPARISONS = 0;
	static int BUBBLECOMPARISONS = 0;
	
	static int SSWAP = 0;
	static int ESWAP = 0;
	static int BSWAP = 0;

	public static void main(String[] args) {

		//creating an array of doubles with random grades between 0 and 100
		//I use clone in the array so that I don't have to use a loop for this demo
		//double unorderedTestGrades[] = {79, 86.4, 34, 99, 68.9, 92.3, 94.5, 91.4, 97};
		
		Scanner keyboard = new Scanner(System.in);
		int numberOfTests = 0;
		
		
		System.out.println("Please enter the number of tests there were: " );
		numberOfTests = keyboard.nextInt();										//only integers should be typed in or an error will occur
		
		double[] unorderedTestGrades = new double[numberOfTests];
		
		double wholeNum = 0;
		double remainder = 0;
		double randomNumber = 0;
		Random rand = new Random();
		
		for(int testmaker = 0; testmaker < numberOfTests; testmaker++){
			
			wholeNum = rand.nextInt(100) + 1;			//will produce a whole number
			remainder = (rand.nextInt(9)+1);			//will produce a number between .1 and .9 to add to the whole number
			remainder = remainder/10;
			randomNumber = wholeNum + remainder;
			
			unorderedTestGrades[testmaker] = randomNumber;
		}
		
		
		
		double unorderedTestGradesForExchange[] = unorderedTestGrades.clone();		
		double unorderedTestGradesForBubble[] = unorderedTestGrades.clone();
		
		//I use Arrays.toString("myarrayname") to display the elements in the array in this program to avoid excessive loops
		System.out.println("These are the unsorted test grades: "  + "\n");
		System.out.println(Arrays.toString(unorderedTestGrades));						
		
		shellSort(unorderedTestGrades);
		
		System.out.println("These are the rearranged test grades from Shell: ");
		System.out.println(Arrays.toString(unorderedTestGrades));
		
		System.out.println("\n" + "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n" + "******************************************************");
		
		System.out.println("These are the unsorted test grades going into exchange sort: ");
		System.out.println(Arrays.toString(unorderedTestGradesForExchange));
		exchangeSort(unorderedTestGradesForExchange);
		
		System.out.println("These are the rearranged test grades from Exchange: " );
		System.out.println(Arrays.toString(unorderedTestGradesForExchange));
		
		
		System.out.println("\n" + "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n" + "******************************************************");
		
		BubbleSort(unorderedTestGradesForBubble);
		
		//this will display the comparisons for each sort method
				
		
		System.out.println("Shell sort comparisons are: " + SHELLCOMPARISONS);
		System.out.println("Exchange sort comparisons: " + EXCHANGECOMPARISONS);
		System.out.println("Bubble sort comparisons: " + BUBBLECOMPARISONS);
		
		System.out.println("\n" + "Shell sort swaps are: " + SSWAP);
		System.out.println("Exchange sort swaps: " + ESWAP);
		System.out.println("Bubble sort swaps: " + BSWAP);
		
	}
	
	static public double[] shellSort(double[] gradesInput)
	{
		int indexOfRightNumber;
		int outer;
	    double numberOnRightToSwap;
	    int comparisonsInShell = 0;
	 
	    int gap = 1;
	    while (gap <= gradesInput.length / 3) 
	    {		//in our case, the length is 9, so the gap will have to be <=3
	      gap = gap * 3 + 1;						//since gap was declared as 1, and 1<=3, then gap becomes 4 due to this line
	      
	    }
	    while (gap > 0) 
	    {							//gap = 4 > 0
	      for (outer = gap; outer < gradesInput.length; outer++) 
	      {		//outer = gap = 4; outer = 4 < 9; outer++
	        numberOnRightToSwap = gradesInput[outer];									//numberOnRightToSwap = first element in the array, which is 79
	        indexOfRightNumber = outer;												//indexOfRightNumber becomes outer
	 
	        System.out.println("Gap is: "  + gap);
	        System.out.println("Number on left                               " + gradesInput[indexOfRightNumber - gap]);
	        																	//can also use gradesInput[outer - gap]
	        System.out.println("Right number that it might get swapped with: " + numberOnRightToSwap);
	        System.out.println("Index of left number:  " + (indexOfRightNumber-gap));
	        System.out.println("Index of right number: " + indexOfRightNumber);
	        
	        
	        System.out.println("Array before swapping: " + Arrays.toString(gradesInput));
	        
	        //In this while loop, if the left number is bigger than the right number, they get switched
	        //this is where the swapping actually happens
	        while (indexOfRightNumber > gap - 1 && gradesInput[indexOfRightNumber - gap] >= numberOnRightToSwap)
	        { 
	          gradesInput[indexOfRightNumber] = gradesInput[indexOfRightNumber - gap];
	          indexOfRightNumber -= gap;
	          
	          SSWAP++;
	        }
	        comparisonsInShell++;//I make the comparison count increase outside of the while loop because even though
	        					 //		the two elements may not swap, they are still being compared
	        gradesInput[indexOfRightNumber] = numberOnRightToSwap;
	        
				System.out.println("Swapped array:         " + Arrays.toString(gradesInput));
				System.out.println("-----------------------------------" + "\n");
			}
			gap = (gap - 1) / 3;
			System.out.println(
					"******************************************************************************* new gap is:  "
							+ gap);

		}
		System.out.println("This will show when the gap is 0. Meaning that the sorting is complete");
		System.out.println("Number of comparisons in shell sort: " + comparisonsInShell);
		SHELLCOMPARISONS = comparisonsInShell;

		return gradesInput;

	}


	static public double[] exchangeSort(double[] gradesInput) {

		int comparisonsInExchange = 0;
		System.out.println("This is the inside of exchangeSort.");
		System.out.println("The elements in the array representing initial test grades are: " 
				+ "\n" + Arrays.toString(gradesInput));
		System.out.println(" ");

		double temp;																//temp is the placeholder used to swap the elements
		for (int i = 0; i < gradesInput.length - 1; i++)							//this for loop shifts the position of the left element
		{
			for (int j = i + 1; j < gradesInput.length; j++) {						//this for loop shifts the position of the right element
			 																		
			 																		 
			 																		 /*
			 																		 *this if statement checks if the left element is bigger than the right element
																					 *if you run the program, you will notice that the only arrays that are displayed
																					 *are the ones where "leftElement">"rightElement", therefore they get swapped.
																					 * However, the for loop compares the element in index i with every element to the right
																					 * and places the smallest from the entire array to the left
																					 */
					if (gradesInput[i] > gradesInput[j]) {					
				
					System.out.println("Index for element on left: " + i);
					System.out.println("Index for element on right: " + j);
					System.out.println("Element on left: " + gradesInput[i]);
					System.out.println("Element on right: " + gradesInput[j]);
					System.out.println("Loop: " + i);
					
					System.out.println("Array before swapping: " + Arrays.toString(gradesInput));
					
					temp = gradesInput[i];					//here, a temporary variable is given the value of the left element
					gradesInput[i] = gradesInput[j];		//then, the left element is now assigned the value of the right element
					gradesInput[j] = temp;					//finally, the right element is given what was originally the left element's value

					ESWAP++;
					
				}//this is the end of the if loop
				comparisonsInExchange++;
			}//this is the end of the right element shift iterations for the given value of i; i changes to i+1

			//this prints the array in every iteration
			System.out.println("Array after swapping:  " + Arrays.toString(gradesInput));

		}//this is the end of all the iterations

		System.out.println("Number of comparisons in shell sort: " + comparisonsInExchange);
		EXCHANGECOMPARISONS = comparisonsInExchange;

		return gradesInput;
	}

	public static void BubbleSort( double [ ] num )
	{
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     double temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < num.length -1;  j++ )
	            {
	            	BUBBLECOMPARISONS++;
	                   if ( num[ j ] < num[j+1] )   // change to > for ascending sort
	                   {
	                	   BSWAP++;
	                           temp = num[ j ];                //swap elements
	                           num[ j ] = num[ j+1 ];
	                           num[ j+1 ] = temp;
	                          flag = true;              //shows a swap occurred  
	                  } 
	            } 
	      } 
	} 
	
}
