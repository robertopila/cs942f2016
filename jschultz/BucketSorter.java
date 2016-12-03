import java.util.ArrayList;
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
		// a bit odd, but we take the arraylist of doubles, convert it to an
		// array, sort it, then convert BACK to arraylist
		return DoubleStream.of(ShakerSort.shakerSort(bucket.stream().mapToDouble(Double::doubleValue).toArray()))
				.mapToObj(Double::valueOf).collect(Collectors.toCollection(ArrayList::new));
	}
}