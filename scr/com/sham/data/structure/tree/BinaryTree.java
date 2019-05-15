package com.sham.data.structure.tree;
/* Java program to determine if binary tree is 
height balanced or not */

import com.sham.data.structure.node.Node;

/* A binary tree node has data, pointer to left child,
and a pointer to right child */

public class BinaryTree 
{
	Node<Integer> root;

	/* Returns true if binary tree with root as root is height-balanced */
	boolean isBalanced(Node<Integer> node) 
	{
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = height(node.getLeftChild());
		rh = height(node.getRightChild());

		if (Math.abs(lh - rh) <= 1
				&& isBalanced(node.getLeftChild())
				&& isBalanced(node.getRightChild())) 
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	/* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
	/* The function Compute the "height" of a tree. Height is the
		number of nodes along the longest path from the root node
		down to the farthest leaf node.*/
	int height(Node<Integer> node) 
	{
		/* base case tree is empty */
		if (node == null)
			return 0;

		/* If tree is not empty then height = 1 + max of left
		height and right heights */
		return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
	}

	public static void main(String args[]) 
	{
		/* Constructed binary tree is
        1
      /   \
    2      3
  /  \    /
4     5  6
/
7
*/   
		BinaryTree tree = new BinaryTree();
		tree.root = new Node<Integer>(1);
		tree.root.setLeftChild(new Node<Integer>(2));
		tree.root.setRightChild(new Node<Integer>(3));
		tree.root.getRightChild().setLeftChild(new Node<Integer>(6));
		tree.root.getLeftChild().setLeftChild(new Node<Integer>(4));
		tree.root.getLeftChild().setRightChild(new Node<Integer>(5));
		tree.root.getLeftChild().getLeftChild().setLeftChild(new Node<Integer>(7));
		

		if(tree.isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
