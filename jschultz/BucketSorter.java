import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class BucketSorter implements Callable<ArrayList> {
	private ArrayList<Double> bucket;

	BucketSorter(ArrayList<Double> bucket) {
		this.bucket = bucket;
	}

	@Override
	public ArrayList call() throws Exception {
		//We take the arraylist, convert to array of Double type, call the generic shakerSort, then convert back to ArrayList.
		return new ArrayList<Double>(Arrays.asList(ShakerSort.shakerSort(bucket.toArray(new Double[bucket.size()]))));
	}
}