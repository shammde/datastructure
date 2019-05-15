package com.sham.data.structure.tree;

//Java program to convert a given Binary Tree to 
//Doubly Linked List

/* Structure for tree and Linked List */
class Node1 
{
	int data;
	Node1 left, right;

	public Node1(int data) 
	{
		this.data = data;
		left = right = null;
	}
}

class TempBT 
{
	// 'root' - root of binary tree
	Node1 root;

	// 'head' - reference to head node of created
	//double linked list
	Node1 head;

	// A simple recursive function to convert a given
	// Binary tree to Doubly Linked List
	void BToDLL(Node1 root) 
	{
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		BToDLL(root.right);

		// insert root into DLL
		root.right = head;

		// Change left pointer of previous head
		if (head != null)
			(head).left = root;

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		BToDLL(root.left);
	}

	// Utility function for printing double linked list.
	void printList(Node1 head) 
	{
		System.out.println("Extracted Double Linked List is : ");
		while (head != null) 
		{
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	// Driver program to test the above functions
	public static void main(String[] args) 
	{
		/* Constructing below tree
            5
          /   \
         3     6
        / \     \
       1   4     8
      / \       / \
     0   2     7   9  */

		TempBT tree = new TempBT();
		tree.root = new Node1(5);
		tree.root.left = new Node1(3);
		tree.root.right = new Node1(6);
		tree.root.left.right = new Node1(4);
		tree.root.left.left = new Node1(1);
		tree.root.right.right = new Node1(8);
		tree.root.left.left.right = new Node1(2);
		tree.root.left.left.left = new Node1(0);
		tree.root.right.right.left = new Node1(7);
		tree.root.right.right.right = new Node1(9);

		tree.BToDLL(tree.root);
		tree.printList(tree.head);
	}
}

//This code has been contributed by Mayank Jaiswal(mayank_24)