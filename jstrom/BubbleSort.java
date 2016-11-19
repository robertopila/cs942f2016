// BUBBLE SORT IMPLEMENTATION
// by Jeff Strom
// ID#882747361
import java.util.Scanner;

public class BubbleSort
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		//Initializing arrays
		int[] arr;
		arr = new int[5];
						
		for(int b=0; b<5 ; b++)
		{
		System.out.print("Enter integer for array to be sorted: ");
		arr[b] = keyboard.nextInt();
		}
		System.out.print("\n");
		
	//this is bubble sort
		for(int q = 0; q<5; q++)
			{
				for(int b = 0; b<5; b++)
					{
						if (arr[q] > arr[b] && q!=b)
						{
							if(b>q)
							{
							//case 1 -- switch order of index b and q values
							int savedata = arr[b];
							arr[b] = arr[q];
							arr[q] = savedata;
							}
							if(q>b)
							{
							//case 2 -- don't change order of indices
							}
						}
					}
			}

		
		//Print out sorted array:
		System.out.println("\n========\nSorted values: ");
		
		for(int q = 0; q<5; q++)
		{
			System.out.print(arr[q]);
			if((q+1)!=5)
			{
				System.out.print(", ");
			}
		}
			
		keyboard.close();
	}	
}
	
	
	