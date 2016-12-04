package discreteMathAlgorithms;
import java.util.*;


public class BubbleSort {

	public static void main(String[] args) {

		//Create array with 10 random int's between 1-100
		int[] arr = new int[10];       
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100 + 1);
		}


		System.out.println("ramdom integer array: " + Arrays.toString(arr));

		System.out.println("sorting...");
		//sort the array
		bubbleSort(arr);
		System.out.println("sorted: " + Arrays.toString(arr));

	}

	public static void bubbleSort(int[] arr) {

		int n = arr.length;
		int temp = 0;

		
		for (int i = 0; i < n; i++) {
			
			/*traverse the array beginning with the "first" element and compare to the "next" element. if "first" element
			  is greater than the "next" element, swap the elements. the "next" element now becomes the element being
			  compared to the remaining elements until another swap occurs or the outer loop begins again.   */
			for (int j = 1; j < (n - i); j++) {
				
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
