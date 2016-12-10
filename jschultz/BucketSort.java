import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BucketSort {
	public static double[] bucketSort(double[] array, int bucketCount) throws InterruptedException, ExecutionException {
		{
			//Only double implementation, generic implementation not really possible
			if (bucketCount <= 0) {
				throw new IllegalArgumentException("Must have one or more buckets");
			}
			double highest = array[0];
			double lowest = array[0];
			for (int i = 1; i < array.length; i++) { //Do an initial pass over the array to find our highest and lowest values
				if (array[i] > highest) {
					highest = array[i];
				}
				if (array[i] < lowest) {
					lowest = array[i];
				}
			}
			double interval = (highest - lowest + 1) / bucketCount; //Determine the interval for each bucket
			ArrayList<Double> buckets[] = new ArrayList[bucketCount]; //Initialize our array of arraylists
			for (int i = 0; i < bucketCount; i++) { //more initialization
				buckets[i] = new ArrayList<Double>();
			}
			for (int i = 0; i < array.length; i++) { //Now we add in the values to the buckets based on the interval
				buckets[(int) ((array[i] - lowest) / interval)].add(array[i]);
			}
			ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); //Set up a thread pool w/ maximum number of threads
			ArrayList<Future<ArrayList<Double>>> futureList = new ArrayList<Future<ArrayList<Double>>>(); //We have to make another list to store our returned arraylists from the threads
			for (int i = 0; i < buckets.length; i++) {
				Callable worker = new BucketSorter(buckets[i]); //Initialize the thread, pass the bucket
				Future<ArrayList<Double>> future = executor.submit(worker); //Sort the bucket, get the future result
				futureList.add(future);
			}
			int position = 0;
			for (int i = 0; i < buckets.length; i++) {
				buckets[i] = futureList.get(i).get(); //Replace the bucket with the sorted bucket
				for (int j = 0; j < buckets[i].size(); j++) { //Go through the original array, replace the values in order
					array[position] = buckets[i].get(j);
					position++;
				}
			}
			return array;
		}
	}

	public static void main(String[] arguments) throws InterruptedException, ExecutionException {
		Random randomGenerator = new Random();
		double[] randomDoubles = new double[Math.max(1, randomGenerator.nextInt(25))]; //Math.max to guarantee we have an array of more than one element
		for (int i = 0; i < randomDoubles.length; i++)
		{
			randomDoubles[i] = randomGenerator.nextDouble(); //this will only generate numbers between 0 and 1, but it still shows the efficiency of the sort
		}
		int bucketCount = randomDoubles.length / (Math.max(2, randomGenerator.nextInt(5))); //prevent division by 0 error from random seed, also guarantees we use more than 1 bucket
		randomDoubles = bucketSort(randomDoubles, bucketCount); //Perform the sort
		System.out.println("Sorted array using " + bucketCount + " buckets and " + Runtime.getRuntime().availableProcessors() + " threads");
		for (int i = 0; i < randomDoubles.length; i++) {
			System.out.print(randomDoubles[i] + " ");
		}
		return;
	}

}
