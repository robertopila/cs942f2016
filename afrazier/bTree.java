//programmer Andrew Frazier
import java.util.Scanner;

public class bTree
{
	personRec root;
	public bTree() //node structure for student and bribe
	{
	     personRec root = null;
	}
	public class personRec
	{
		private personRec lChild, rChild;
		private String name; private int bribe;
		public personRec()
		{
			lChild = null;
			rChild = null;
			name = null;
			bribe = 0;	
		}
	public void setName(String n)
	{name = n;}
	public void setBribe(int b)
	{bribe = b;}
	public String getName()
	{return name;}
	public int getBribe()
	{return bribe;}
	public personRec getlChild()
	{return lChild;}
	public personRec getrChild()
	{return rChild;}
	public void setlChild(personRec l)
	{ lChild = l;}
	public void setrChild(personRec r)
	{ rChild = r;}
	}

	public void Add() //decide whether to make a new root or add to the tree.
	//calls helper function to actually add. no duplicates accepted
	{
		int tbribe; String tname;
		Scanner sc = new Scanner(System.in);
		System.out.print("Name: ");
		tname = sc.nextLine();
		System.out.print("Bribe: ");
		tbribe = sc.nextInt();
		if (root == null)
			buildRoot(tname, tbribe);
		else
			append(tname, tbribe);

	}
	public void View() //list tree in descending order by bribe amount.
	//calls helper recursive function to display
	{
		if(root == null)
		{
		  System.out.println("There are no items to view!");
			return;
		}
		personRec temp = root;
		System.out.println("Name\t\tBribe Amount\n");
		DisplayTree(temp);
	}
	
	public void DisplayTree(personRec p)
	{
		if(p != null)
		{
    		DisplayTree(p.getrChild());
    		System.out.println(p.getName() + "\t\t" + p.getBribe());
    		DisplayTree(p.getlChild());
		}
	}

	public void buildRoot(String n, int b)
	{
		root = new personRec();
		root.setName(n);
		root.setBribe(b);
	}

	public void append(String n, int b)
	{
		personRec temp = root;
		if (temp.getrChild() == null && temp.getlChild() == null) //handles root having no children
		{
			if (temp.getBribe() < b)
			{
				temp.setrChild(new personRec());
				temp = temp.getrChild();
				temp.setBribe(b);
				temp.setName(n);
				return;
			}
			else if (temp.getBribe() > b)
			{
				temp.setlChild(new personRec());
				temp = temp.getlChild();
				temp.setBribe(b);
				temp.setName(n);
				return;
			}
			else
			{
				System.out.println("That Bribe Amount Exists. Hint: Go Higher");
				return;
			}

		}
		while (temp.getrChild() != null || temp.getlChild() != null) //traverses tree to find place to add
		{
			if (b > temp.getBribe())
			{
				if (temp.getrChild() != null)
					temp = temp.getrChild();
				else
				{
					temp.setrChild(new personRec());
					temp = temp.getrChild();
					temp.setName(n);
					temp.setBribe(b);
					return;
				}
			}
			else if (b < temp.getBribe())
			{
				if (temp.getlChild() != null)
					temp = temp.getlChild();
				else
				{
					temp.setlChild(new personRec());
					temp = temp.getlChild();
					temp.setName(n);
					temp.setBribe(b);
					return;
				}
			}
			else
			{
				System.out.println("That Bribe Amount Exists. Hint: Go Higher");
				return;
			}
		}
			if (temp.getBribe() < b)
			{
				temp.setrChild(new personRec());
				temp = temp.getrChild();
				temp.setBribe(b);
				temp.setName(n);
				return;
			}
		else if (temp.getBribe() > b)
			{
				temp.setlChild(new personRec());
				temp = temp.getlChild();
				temp.setBribe(b);
				temp.setName(n);
				return;
			}
		else
			{
				System.out.println("That Bribe Amount Exists. Hint: Go Higher");
				return;
			}
	}
}
