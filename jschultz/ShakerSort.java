import java.util.Arrays;

public class ShakerSort {
	//TBD: Comments detailing the code
	public static <T extends Comparable<T>> T[] shakerSort(T[] array) //Shaker sort, generics implementation
	{
		for (int i = 0; i < array.length/2; i++)
		{
			boolean swapState = false;
			for (int j = i; j < array.length - i - 1; j++)
			{
				if (array[j].compareTo(array[j + 1]) == 1) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapState = true;
				}
			}
			for (int j = array.length - 2 - i; j > i; j--) {
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
		for (int i = 0; i < array.length/2; i++)
		{
			boolean swapState = false;
			for (int j = i; j < array.length - i - 1; j++)
			{
				if (array[j] > array[j + 1]) {
					double temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapState = true;
				}
			}
			for (int j = array.length - 2 - i; j > i; j--) {
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
		double[] randomDoubles = {72, 95, 12, 108, 79, 15, 12.9, 73.2, 72};
		randomDoubles = shakerSort(randomDoubles);
		for (int i = 0; i < randomDoubles.length; i++)
		{
			System.out.print(randomDoubles[i] + " ");
		}
	}

}
