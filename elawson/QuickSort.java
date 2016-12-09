package quicksort;

import java.util.Random;

/**
 *
 * @author Eric Lawson
 * This class implements a quick sort algorithm. The algorithm functions as follows:
 * 1. Pick a value to be the pivot, this can be any value in the array, this implementation uses the midpoint rounded down.
 * 2. Set two pointers (array indices) one at the first value of the array, and one at the last value.
 * 3. Advance the low pointer until the value in the array is greater than or equal to the pivot value.
 * 4. Advance the high pointer until the value it points to is less than or equal to the pivot value.
 * 5. if the pointers have not converged, swap the values at each pointer.
 * 6. If both pointers point to a value equal to the pivot, advance one of the pointers to prevent an infinite loop.
 * 
 * These steps are in the setPivot function.
 * 
 * After these steps the pointers should converge on the pivot and all values less than the pivot should be at lower indices,
 * and all values higher should be at higher indices than the pivot. The pivot should be at it's correct position in the
 * final sorted array.
 * 
 * 7. Split the array into two sub-arrays one above the pivot, and one below the pivot. Skip the pivot as it is already in its correct position.
 * 8.  if the sub-array is greater than 1 element repeat steps 1-7 for each sub array.
 * 
 * These  steps are handled by the sort function.
 * 
 * Usage: 
 * This class contains one main class that provides a randomized demonstration of the class. 
 * It has one public static method QuickSort(int[]) which takes an array of integers and sorts them in ascending order. Null and empty arrays are returned as-is since they cannot be sorted.
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            //Generate an array of random size
            Random numbers = new Random();
            int size = numbers.nextInt(20);
            int[] input = new int[size];
            
            //populate array with random values
            for (int j = 0; j < input.length-1; j++)
                input[j] = numbers.nextInt(10);
            System.out.println("Start:");
            printArray(input);
            quickSort(input);
            printArray(input);
        }
    }
        
    public static int[] quickSort(int[] array) {
        if (array != null && array.length > 0)
            sort(array, 0, array.length-1);
        else
            System.out.println("Array cannot be sorted, empty or null.");
        return array;
    }

    private static void sort(int[] array, int startPos, int endPos) {
        
        if (startPos < endPos) {
            int pivotPos = setPivot(array, startPos, endPos);
            
            sort(array, startPos, pivotPos-1);
            sort(array, pivotPos+1, endPos);
        }
    }

    private static int setPivot(int[] array, int low, int high) {
        int pivot = array[(high + low) /2];
        while (low < high) { 
            while (array[low] < pivot)
                low++;
            while (array[high] > pivot)
                high--;
            if (low < high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                if (array[low] == array[high]) {
                    low++;
                }
            }
        }
        return low;
        
    }
    
    public static void printArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.print("\n");
    }
}
