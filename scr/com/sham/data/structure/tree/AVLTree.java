package com.sham.data.structure.tree;

import com.sham.data.structure.node.Node;

//Java program for insertion in AVL Tree
/*class Node {
 int key, height;
 Node left, right;

 Node(int d) {
     key = d;
     height = 1;
 }
}*/

class AVLTree {

	Node<Integer> root;

	// A utility function to get height of the tree
	int height(Node<Integer> N) {
		if (N == null)
			return 0;

		return N.getHeight();
	}

	// A utility function to get maximum of two integers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	Node<Integer> rightRotate(Node<Integer> y) {
		Node<Integer> x = y.getLeftChild();
		Node<Integer> T2 = x.getRightChild();

		// Perform rotation
		x.setRightChild(y);
		y.setLeftChild(T2);

		// Update heights
		y.setHeight(max(height(y.getLeftChild()), height(y.getRightChild())) + 1);
		x.setHeight(max(height(x.getLeftChild()), height(x.getRightChild())) + 1);

		// Return new root
		return x;
	}

	// A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	Node<Integer> leftRotate(Node<Integer> x) {
		Node<Integer> y = x.getRightChild();
		Node<Integer> T2 = y.getLeftChild();

		// Perform rotation
		y.setLeftChild(x);
		x.setRightChild(T2);

		//  Update heights
		x.setHeight(max(height(x.getLeftChild()), height(x.getRightChild())) + 1);
		y.setHeight(max(height(y.getLeftChild()), height(y.getRightChild())) + 1);

		// Return new root
		return y;
	}

	// Get Balance factor of node N
	int getBalance(Node<Integer> N) {
		if (N == null)
			return 0;

		return height(N.getLeftChild()) - height(N.getRightChild());
	}

	Node<Integer> insert(Node<Integer> node, int data) {

		/* 1.  Perform the normal BST insertion */
		if (node == null)
			return (new Node<Integer>(data));

		if (data < node.getData())
			node.setLeftChild(insert(node.getLeftChild(), data));
		else if (data > node.getData())
			node.setRightChild(insert(node.getRightChild(), data));
		else // Duplicate keys not allowed
			return node;

		/* 2. Update height of this ancestor node */
		node.setHeight(1 + max(height(node.getLeftChild()),
				height(node.getRightChild())));

		/* 3. Get the balance factor of this ancestor
           node to check whether this node became
           unbalanced */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && data < node.getLeftChild().getData())
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && data > node.getRightChild().getData())
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && data > node.getLeftChild().getData()) {
			node.setLeftChild(leftRotate(node.getLeftChild()));
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && data < node.getRightChild().getData()) {
			node.setRightChild(rightRotate(node.getRightChild()));

			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	/* Given a non-empty binary search tree, return the
    node with minimum key value found in that tree.
    Note that the entire tree does not need to be
    searched. */
	Node<Integer> minValueNode(Node<Integer> node)
	{
		Node<Integer> current = node;

		/* loop down to find the leftmost leaf */
		while (current.getLeftChild() != null)
			current = current.getLeftChild();

		return current;
	}
	Node<Integer> deleteNode(Node<Integer> root, int data)
	{
		// STEP 1: PERFORM STANDARD BST DELETE
		if (root == null)
			return root;

		// If the key to be deleted is smaller than
		// the root's key, then it lies in left subtree
		if (data < root.getData())
			root.setLeftChild(deleteNode(root.getLeftChild(), data));

		// If the key to be deleted is greater than the
		// root's key, then it lies in right subtree
		else if (data > root.getData())
			root.setRightChild(deleteNode(root.getRightChild(), data));

		// if key is same as root's key, then this is the node
		// to be deleted
		else
		{

			// node with only one child or no child
			if ((root.getLeftChild() == null) || (root.getRightChild() == null))
			{
				Node<Integer> temp = null;
				if (temp == root.getLeftChild())
					temp = root.getRightChild();
				else
					temp = root.getLeftChild();

				// No child case
				if (temp == null)
				{
					temp = root;
					root = null;
				}
				else   // One child case
					root = temp; // Copy the contents of
				// the non-empty child
			}
			else
			{

				// node with two children: Get the inorder
				// successor (smallest in the right subtree)
				Node<Integer> temp = minValueNode(root.getRightChild());

				// Copy the inorder successor's data to this node
				root.setData(temp.getData());

				// Delete the inorder successor
				root.setRightChild(deleteNode(root.getRightChild(), temp.getData()));
			}
		}

		// If the tree had only one node then return
		if (root == null)
			return root;

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		root.setHeight(max(height(root.getLeftChild()), height(root.getRightChild())) + 1);

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
		//  this node became unbalanced)
		int balance = getBalance(root);

		// If this node becomes unbalanced, then there are 4 cases
		// Left Left Case
		if (balance > 1 && getBalance(root.getLeftChild()) >= 0)
			return rightRotate(root);

		// Left Right Case
		if (balance > 1 && getBalance(root.getLeftChild()) < 0)
		{
			root.setLeftChild(leftRotate(root.getLeftChild()));
			return rightRotate(root);
		}

		// Right Right Case
		if (balance < -1 && getBalance(root.getRightChild()) <= 0)
			return leftRotate(root);

		// Right Left Case
		if (balance < -1 && getBalance(root.getRightChild()) > 0)
		{
			root.setRightChild(rightRotate(root.getRightChild()));
			return leftRotate(root);
		}

		return root;
	}
	// A utility function to print preorder traversal
	// of the tree.
	// The function also prints height of every node
	void preOrder(Node<Integer> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);
        tree.root.printTree();
        /* The constructed AVL Tree would be
           9
          /  \
         1    10
        /  \    \
        0    5    11
        /    /  \
        -1   2    6
         */
        System.out.println("Preorder traversal of "+
                            "constructed tree is : ");
        tree.preOrder(tree.root);
 
        tree.root = tree.deleteNode(tree.root, 10);
        System.out.println();
        tree.root.printTree();
 
        /* The AVL Tree after deletion of 10
           1
          /  \
         0    9
        /     / \
        -1    5   11
        /  \
        2    6
         */
        System.out.println("");
        System.out.println("Preorder traversal after "+
                           "deletion of 10 :");
        tree.preOrder(tree.root);
    }
}
//This code has been contributed by Mayank Jaiswal