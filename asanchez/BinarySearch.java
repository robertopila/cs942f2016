package discreteMathAlgorithms;

public class BinarySearch {

	public static void main(String[] args) {
		
		//Create an array of unsorted integers 
		int[] arr = {5, 7, 3, 4, 1, 9, 10, 0, 55, 33, 1072};
		
		
		//search for the index of the int "7"
		int index = binarySearch(arr, 7);
		
		System.out.println(index);
	}
	
	public static int binarySearch(int[] arr, int x) {
		
		//sort the array
		BubbleSort.bubbleSort(arr);
		
		int low = 0;
		int high = arr.length -1;
		
		int middle;
		
		
		//search for the index of int x in the array
		while (low <= high) {
		
			//this will be an index that splits the array into two
			middle = (low+high) / 2;
			
			/*if the element at "middle" index is greater than "x", now 
			 * search the first half that the array was split into, and 
			this half will also now be split into two*/
			if (Integer.compare(arr[middle], x) > 0) high = middle - 1;
			
			/*if element at "middle" index is less than x, search the 
			 * second half that the array was split into, and this half 
			 * will also now be split into two*/
			else if (Integer.compare(arr[middle], x) < 0) low = middle +1;
			
			/*this will return "middle" if element at "middle" index
			is equal to x*/
			else return middle;	
		}
		return -1;
	}

}
