package BinarySearchTree;

public class BinarySearchTree {
	Node root;
	//Method to insert a node
	public void insert(int value)
	{
		Node node = new Node(value);
		if(root == null){
		root = node;
		return;
		}
		insetNode(root,node);
	}
	
	//checking where to insert the node in the three
	
	private void insetNode(Node root, Node node)
	{
		if(root.value > node.value)
		{
			if(root.left == null)
			{
				root.left = node;
				return;
			}
			else
			{
				insetNode(root.left,node);
			}
		}
		else{
			if(root.right == null)
			{
				root.right = node;
				return;
			}
			else 
			{
				insetNode(root.right, node);
			}
		}		
	}
	//finding the min value in the binary search tree
	public int minValue()
	{
		if(root==null)
		{
			return 0;
		}
		//keep track of the current node to check the values 
		Node current = root;
		while(current.left != null)
		{
			current = current.left;
		}
		return current.value;
	}
	//checks the max value in the tree

	public int maxValue()
	{
		if(root == null)
		{
			return 0;
		}
		Node current = root;
		while(current.right != null)
		{
			current = current.right;
		}
		return current.value;
		
	}
	//check if the tree is empty returns boolean true or false if the tree is empty
	public boolean isEmpty()
	{
		return root == null;
	}
	
	//prints in order traversals
	public void order()
	{
		orderRecursively(root);
		System.out.println("");
	}
	//recursive method to print of the node's

	private void orderRecursively(Node current)
	{
		if(current == null)
		{	
			return;
		}

		orderRecursively(current.left);
		System.out.println(current.value+ ",");
		orderRecursively(current.right);
	}
	//prints in pre-order in traversal 
	public void preorder()
	{
		preorderRecursively(root);
		System.out.println("");
	}
	//recursive method to print of the node's

	private void preorderRecursively(Node current)
	{
		if(current == null)
		{
			return;
		}
		System.out.println(current.value+ ",");
		preorderRecursively(current.left);
		preorderRecursively(current.right);
	}
	//prints in post-order in traversal 
		public void postorder()
		{
			postorderRecursively(root);
			System.out.println("");
		}
		//recursive method to print of the node's

		private void postorderRecursively(Node current)
		{
			if(current == null)
			{
				return;
			}
			postorderRecursively(current.left);
			postorderRecursively(current.right);
			System.out.println(current.value+ ",");
		}
		public Node find(int key)
		{
			Node current = root;
			while(current.value != key)
			{
				if(key < current.value)
				{
					current = current.left;
				}
				else
				{
					current = current.right;
				}
				if(current == null)
				{
					return null;
				}
			}
			return current;
		}
		
}