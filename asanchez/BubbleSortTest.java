package discreteMathAlgorithms;
import static org.junit.Assert.*;
import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void testSort() {
		int[] arr = {5, 7, 3, 4, 1, 9, 10, 0, 55, 33, 1072};
		
		BubbleSort.bubbleSort(arr);
		//after the array is sorted, 0 should be at index 0
		assertTrue(arr[0] == 0);
	}
}
