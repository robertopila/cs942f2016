package BinarySearchTree;

public class BubbleSortClass {
	private long[] a; 
	private int nElems;

	public BubbleSortClass(int max) 
	{	/*  constructor
			create the array
			start at 0 items 
	 	*/
		a = new long[max]; 
		
		nElems = 0; 
	}
	
	public void insert(long value) 
	{
		/* 	put element into array
		 	insert it
			increment size
		 */
		a[nElems] = value;
		nElems++; 
	}
	
	public void display() // 
	{	/*
			displays array contents
			for each element
			display it
		*/
		for(int j=0; j<nElems; j++) 
			System.out.print(a[j] + " ");
			System.out.println(" ");
	}

	public void bubbleSort()
	{
		/*
		 * outer loop (backward)
		 * inner loop (forward)
		 * out of order?
		 * 
		 * */
		int out, in;
		// 
		for(out = nElems - 1; out > 1; out--) {
			 
			for(in=0; in<out; in++){ 
				
				if( a[in] > a[in+1] ) 
					{
						swap(in, in+1);
					}
				}
			}
		} 
		
		private void swap(int one, int two)
		{
			long temp = a[one];
			a[one] = a[two];
			a[two] = temp;
		}
		
}
