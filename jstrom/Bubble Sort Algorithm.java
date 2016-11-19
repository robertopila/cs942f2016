// by Jeff Strom
// ID#882747361
import java.util.Scanner;

public class arrays
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		//Initializing array
		int[] arr;
		arr = new int[5];
			
		for(int b=0; b<5 ; b++)
		{
		System.out.print("Enter integer for array: ");
		arr[b] = keyboard.nextInt();
		}
		
		System.out.print("\n");
		
		//=========================
		//Compare size of arrays and create a new array
		//containing the elements they share in common.
		
		int counter=5;		//the arrrays are length==5 here
		int[] compare;
		compare = new int[5];
		
		for(int p = 0; p<counter; p++)
		{
			for(int q = 0; q<5; q++)
			{

				compare[p] = arr[p];
				arr[p] = Integer.MIN_VALUE;		//will make the value in arr into its 
									//maximum  negative value to avoid it being 
									//double counted.  This is assuming no user inputs the max
									//negative value, which is unlikely (but not impossible).
									//I would have used a NaN value here, but in Java int doesn't
									//allow NaN or infinite values.
			}
		}
		
		//System.out.println(counter);   //DEBUG CODE
		
	//this is the bubble sort algorithm
	//==================================
	int complement_length = 5;
	for(int q = 0; q<counter; q++)
	{
		for(int b = 0; b<counter; b++)
			{
				if (compare[q] > compare[b] && q!=b)
				{
					if(b>q)
					{
						//case 1 -- switch order of index b and q values
						int savedata = compare[b];
						compare[b] = compare[q];
						compare[q] = savedata;
					}
					if(q>b)
					{
						//case 2 -- don't change order of indices
				}
			}
		}
	}

		
		
		//Print out sorted array:
		System.out.println("\n========\nSorted values in both arrays: ");
		
		for(int q = 0; q<counter; q++)
		{
			System.out.print(compare[q]);
			if((q+1)!=counter)
			{
				System.out.print(", ");
			}
		}
			
		keyboard.close();
	}	
}
	
	
	