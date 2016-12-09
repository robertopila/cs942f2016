/*
 Heap Sort:

The most important aspect of the heap sort is the definition of a heap. A heap is a binary tree where the value contained by the parent node is greater than the child nodes.

An array can be read as a binary tree by assuming that for any index i, the child nodes are at i*2+1 and i*2+2. So if you have a parent at index 0, the children are at index 1 and 2. For a parent at index 10 the children are at 21 and 22. This leaves no nodes unused.

The heap algorithm is based around the sift function. The sift function is used both to turn the array into a heap initially and to repair the heap each time a sorted value is extracted from the heap. It works as follows:
1. Receive as parameters the array, the index of the parent node, and the index of the end of the tree (not always the array)
2. Find the indices of the children at i*2+1 and i*2+2.
3. Compare the value of the first child with the value parent, and save the index of the larger node.
4. Compare the value of the child node with the value saved in step 3, and save the index of the higher value.
5. If the index saved in step 4 is not the parent node, then swap the value at that index with the value of the parent.
Step 5 repairs the parent node so that it satisfies the heap requirement that the parent have a higher value than it's child nodes.
6. If the parent node was swapped then the sift function must be applied to the child node which it swapped with, repeating until a node is not swapped, or the end of the tree is reached.

The sort algorithm works as follows:
1. Find the index of the last parent node, for an array of size n this will be at floor(n/2) -1.
2. For every index from the last parent node, down to 0, apply the sift function. This ensures that all nodes satisfy the heap rule that parent nodes contain higher values than their child nodes. After this step the array can be treated as a heap.
3. Since parent nodes are always larger than their children, the node at index 0 contains the highest value in the heap.
4. Swap the value at the first index with the value of the last index in the tree. This last index is now sorted.
5. Since the last index of the array is now sorted the heap size is now one smaller.
6. Since index 0 now contains a new number the heap must be repaired by applying the sift function to index 0 and sifting up the tree. 
7. Repeat steps 3-7 until the heap size reaches 1. Each repetition sorts the highest remaining value in the heap into the last index occupied by the heap, thus filling the array backwards from the last index down to 0 as the heap size decreases.
 */
package heapsort;

import java.util.Random;

/**
 *
 * @author Eric
 */
public class HeapSort {

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
            heapSort(input);
            printArray(input);
        }
    }
    
    public static int[] heapSort(int[] arr) {
        if (arr != null && arr.length > 0) {
            heapify(arr); //turn aray into a heap
            for (int end = arr.length - 1; end > 0; end--) { //each loop extracts the largest value in the heap by swapping it to the end then decreasing the heap size by one.
                int temp = arr[end];
                arr[end] = arr[0];
                sift(arr, 0, end-1); //fix the heap since index 0 no longer satisfies the heap rule.
            }
            return arr;
        } else {
            System.out.println("Array could not be sorted, empty or null");
            return arr;
        }
    }
     //This function turns the whole array into a heap. It starts at the endmost parent nodes and works backwards to index 0.
    private static void heapify(int[] arr) {
        int start = arr.length /2 -1; //first parent node
        while (start >= 0) {
            sift(arr, start, arr.length-1);
            --start;
        }
    }
    
    //This function fixes a node so it satisfies the rule that a parent node must contain a value larger than the child nodes, by swapping the highest value to the parent.
    //if a child is swapped it may no longer satisfy the heap rule, so it recursively calls itself on the child node, working up the tree until it is repaired.
    private static void sift(int[] arr, int parent, int end) {
        int child = parent * 2 + 1;
        int swapNode = parent;
        
        if (child <= end && arr[child] > arr[parent])
            swapNode = child; 
        if (child+1 <= end && arr[child+1] > arr[swapNode])
            swapNode = child+1;
        if (swapNode != parent) {
            int temp = arr[swapNode];
            arr[swapNode] = arr[parent];
            arr[parent] = temp;
            
            sift(arr, swapNode, end); //fix the child if its value changed.
        }
    }
    
    public static void printArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.print("\n");
    }
}
