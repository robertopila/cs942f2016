/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            heapify(arr);
            for (int end = arr.length - 1; end > 0; end--) {
                int temp = arr[end];
                arr[end] = arr[0];
                arr[0] = temp;
                sift(arr, 0, end-1);
            }
            return arr;
        } else {
            System.out.println("Array could not be sorted, empty or null");
            return arr;
        }
    }
    
    private static void heapify(int[] arr) {
        int start = arr.length /2 -1; //first parent node
        while (start >= 0) {
            sift(arr, start, arr.length-1);
            --start;
        }
    }
    
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
            
            sift(arr, swapNode, end);
        }
    }
    
    public static void printArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.print("\n");
    }
}
