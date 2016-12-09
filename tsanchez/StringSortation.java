//This program alphabetically sorts a list of strings that are in a text file.  
//The exchange sort algorithm and compareToIgnoreCase() method are used to accomplish this.
//The sorted strings are then written into a text file.
//The unsorted text file and sorted text file must be in the same folder where the java file is located. 

import java.util.*;
import java.io.*;

public class StringSortation
{
	public static void exchangeSort(String[]x, int size)
	{
		String temp;
		for (int i=0; i<size-1; i++)
		{
			for (int j=i+1; j<size; j++)
			{
				if(x[i].compareToIgnoreCase(x[j])>0)
				{
					temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
		}
	}
	public static void main(String[]args)throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the name of the text file to sort: ");
		String unsortedStrings = keyboard.next();
		File inputFile = new File(unsortedStrings);
		if (!inputFile.exists())
		{
			System.out.println("The file " +inputFile+ " does not exist");
			System.exit(0);
		}
		System.out.print("Enter the name of file to output sorted strings: ");
		String sortedStrings = keyboard.next();
		File outputFile = new File(sortedStrings);
		if (!outputFile.exists())
		{
			System.out.println("The file " +outputFile+ " does not exist");
			System.exit(0);
		}
		Scanner inputReader = new Scanner(inputFile);
		PrintWriter outputWriter = new PrintWriter(outputFile);
			int sizeOfArray, numOfEntries;
			System.out.print("Please enter the size of the array: ");
			sizeOfArray = keyboard.nextInt();
			String [] stringArray  = new String [sizeOfArray];
			numOfEntries = sizeOfArray;
			for (int i=0; i<sizeOfArray; i++)
			{
				if (!inputReader.hasNext())
				{
					numOfEntries = (i);
					break;
				}
				else
				{
					stringArray[i] = inputReader.next();
				}
			}
			exchangeSort(stringArray, numOfEntries);
			outputWriter.println("The alphabetized list is: ");
			for (int i=0; i<numOfEntries; i++)
			{
				outputWriter.println(stringArray[i]);
			}
			inputReader.close();
			outputWriter.close();
	}
} 