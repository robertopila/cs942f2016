import java.util.Random;

public class ShakerSort {
	//TBD: Comments detailing the code
	public static <T extends Comparable<T>> T[] shakerSort(T[] array) //Shaker sort, generics implementation
	{
		for (int i = 0; i < array.length/2; i++) //A maximum number of length/2 times to loop through the array, since we're sorting through the array in both directions.
		{
			boolean swapState = false;
			for (int j = i; j < array.length - i - 1; j++) //Simple bubble sort-esque comparison and swap, going through the array from left to right
			{
				if (array[j].compareTo(array[j + 1]) == 1) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapState = true;
				}
			}
			for (int j = array.length - 2 - i; j > i; j--) { //Simple bubble sort-esque comparison and swap, going through the array from right to left
				if (array[j].compareTo(array[j - 1]) == -1)
				{
					T temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					swapState = true;
				}
			}
			if (swapState == false)
			{
				break;
			}
		}
		return array;
	}

	public static double[] shakerSort(double[] array) //shaker sort, double implementation
	{
		for (int i = 0; i < array.length/2; i++) //A maximum number of length/2 times to loop through the array, since we're sorting through the array in both directions.
		{
			boolean swapState = false;
			for (int j = i; j < array.length - i - 1; j++) //Simple bubble sort-esque comparison and swap, going through the array from left to right
			{
				if (array[j] > array[j + 1]) {
					double temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapState = true;
				}
			}
			for (int j = array.length - 2 - i; j > i; j--) { //Simple bubble sort-esque comparison and swap, going through the array from right to left
				if (array[j] < array[j - 1])
				{
					double temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					swapState = true;
				}
			}
			if (swapState == false)
			{
				break;
			}
		}
		return array;
	}


	public static void main(String[] arguments) {
		Random randomGenerator = new Random();
		double[] randomDoubles = new double[Math.max(1, randomGenerator.nextInt(25))]; //Math.max to guarantee we have an array of more than one element
		for (int i = 0; i < randomDoubles.length; i++)
		{
			randomDoubles[i] = randomGenerator.nextDouble(); //this will only generate numbers between 0 and 1, but it still shows the efficiency of the sort
		}
		randomDoubles = shakerSort(randomDoubles);
		for (int i = 0; i < randomDoubles.length; i++)
		{
			System.out.print(randomDoubles[i] + " ");
		}
	}

}
