//programmer: Andrew Frazier
// Binary Search Tree with inOrder traversal
// specially made to take in bribes of students and list them in order for a professor

import java.util.*;

import java.util.*;
public class test
{
    public static void main(String[]args)
    {
    	int num;
    	bTree ct = new bTree();
    	do
    	{
    		num = displayMenu();
    		if (num != 3)
    			processChoice(num, ct);
    	} while (num != 3);
    	return;
    }
    
    static int displayMenu()
    {
    	Scanner sc = new Scanner(System.in);
    	int choice;
    	System.out.println("\nMenu");
    	System.out.println("==============================\n");
    	System.out.println("1. Add student to waiting list");
    	System.out.println("2. View waiting list");
    	System.out.println("3. Exit program\n");
    	System.out.print("Please enter choice: ");
    	choice = sc.nextInt();
    	return choice;
    }
    
    public static void processChoice(int choice, bTree myTree)
    {
    	switch (choice)
    	{
    	case 1: myTree.Add(); break;
    	case 2: myTree.View(); break;
    	}
    }
}