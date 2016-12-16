package BinarySearchTree;

import java.util.Random;

public class BSTDemo {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		BinarySearchTree emptyTree = new BinarySearchTree();
	   int numbers[] = {21,32,29,64,33,23,99,10,2,9,77,8};
	   int treeNumbers[] = {4,88,9,35,9,1,34,21,46,87,99,77,100,3,33};
	   int secondSet[] = new int[15];
	   //using a random method to generated random numbers to use in the array an store them
	   Random rad = new Random();
	   int maxSize = 100; // array size
	   BubbleSortClass array; // reference to array
	   System.out.println("Demo 1: ");
	   array = new BubbleSortClass(maxSize); // create the array
	  for(Integer i : numbers)
	  {
		  array.insert(i);
	  }
	// display items
	  System.out.println("");
		System.out.println("Unsorted");
	   array.display();
	   System.out.println("");
	   System.out.println("Bubble Sorted");
	   array.bubbleSort();
	   array.display();
				System.out.println("");
				System.out.println("Demo 2: ");
				System.out.println("The first binary three: ");
				
				for(Integer i : treeNumbers)
				{
						tree.insert(i);
						System.out.println( i + " ");
				}
				System.out.println("The tree being sorted in order");
				tree.order();
				System.out.println("The tree being sorted in pre-order");
				tree.preorder();
				System.out.println("The tree being sorted in post-order");
				tree.postorder();
				System.out.println("Is the tree empty: " + tree.isEmpty());
				System.out.println("Finding the max value in the tree: " + tree.maxValue());
				System.out.println("Finding the min value in the tree: " + tree.minValue());
				System.out.println("Fiding the number 33 in the tree: ");
				Node found = tree.find(33);
				if(found != null)
				{
					System.out.println("Found: ");
					found.displayNode();
					System.out.println("\n");
				}
				else
				{
					System.out.println("Not found: ");
					System.out.println("\n");
				}
				System.out.println();
				System.out.println("The second binary tree using a random number generator: ");
				for(int j = 0; j <secondSet.length ; j++)
				{
					secondSet[j] =rad.nextInt(15);
				}
				for(Integer a : secondSet)
				{
						emptyTree.insert(a);
						System.out.println( a + " ");
				}
				System.out.println("The tree being sorted in order");
				emptyTree.order();
				System.out.println("The tree being sorted in pre-order");
				emptyTree.preorder();
				System.out.println("The tree being sorted in post-order");
				emptyTree.postorder();
				System.out.println("Is the tree empty: " + emptyTree.isEmpty());
				System.out.println("Finding the max value in the tree: " + emptyTree.maxValue());
				System.out.println("Finding the min value in the tree: " + emptyTree.minValue());
				System.out.println("Fiding the number 12 in the tree: ");
				Node foundTwo = emptyTree.find(12);
				if(foundTwo != null)
				{
					System.out.println("Found: ");
					foundTwo.displayNode();
					System.out.println("\n");
				}
				else
				{
					System.out.println("Not found ");
					System.out.println("\n");
				}
}
	
}
