package discreteMathAlgorithms;
import static org.junit.Assert.*;
import org.junit.Test;
public class BinarySearchTest {

	
	@Test
	public void testSearch() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//the binary search function should return 5 for the index
		//of the element 6 in the array and therefore the test should
		//pass
		assertTrue(BinarySearch.binarySearch(arr, 6) == 5);
	}

}
