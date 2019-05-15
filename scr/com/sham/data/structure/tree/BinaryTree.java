package com.sham.data.structure.tree;
/* Java program to determine if binary tree is 
height balanced or not */

import java.util.LinkedList;
import java.util.Queue;

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
		lh = getHeight(node.getLeftChild());
		rh = getHeight(node.getRightChild());

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
	public int getHeight(Node<Integer> node) 
	{
		/* base case tree is empty */
		if (node == null)
			return 0;

		/* If tree is not empty then height = 1 + max of left
		height and right heights */
		return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
	}

	public void insert(Node<Integer> root, int data){

		Queue<Node<Integer>> queue  = new LinkedList<Node<Integer>>();
		Node<Integer> element = new Node<Integer>(data);
		if(root == null){
			root = element;
			return;
		}
		queue.add(root);
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.remove();
			if(temp.getLeftChild() == null){
				temp.setLeftChild(element);
				return;
			}else{
				queue.add(temp.getLeftChild());
			}
			if(temp.getRightChild() == null){
				temp.setRightChild(element);
				return;
			}else{
				queue.add(temp.getRightChild());
			}
		}
	}


	private int getLevel(Node<Integer> root, Node<Integer> node){
		if(root == null || node == null){
			return 0;
		}
		if(root == node){
			return 1;
		}
		
		int level = getLevel(root.getLeftChild(), node);
		if(level == 0){
			level = getLevel(root.getRightChild(), node);
			if(level == 0){
				return level;
			}else{
				return 1 + level;
			}
		}else{
			return 1 + level;
		}
	}
	
	public Node<Integer> findMaxByLevelOrder(Node<Integer> root) {

		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		Node<Integer> maxNode = null;
		if(root == null){
			return null;
		}
		maxNode = root;
		queue.add(root);
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.remove();
			if(temp.getData() > maxNode.getData()){
				maxNode = temp;
			}
			if(temp.getLeftChild() != null){
				queue.add(temp.getLeftChild());
			}
			if(temp.getRightChild() != null){
				queue.add(temp.getRightChild());
			}
		}
		return maxNode;
	}
	public Node<Integer> findMax(Node<Integer> root) {
		if(root == null){
			return null;
		}
		Node<Integer> maxNode = root;

		Node<Integer> leftNode = findMax(root.getLeftChild());
		if(leftNode != null && leftNode.getData() > maxNode.getData()){
			maxNode = leftNode;
		}
		Node<Integer> rightNode = findMax(root.getRightChild());
		if(rightNode != null && rightNode.getData() > maxNode.getData()){
			maxNode = rightNode;
		}

		return maxNode;
	}

	public boolean isContains(Node<Integer> root, Node<Integer> node){

		if(root == null){
			return false;
		}
		if(root == node){
			return true;
		}
		if(isContains(root.getLeftChild(), node)){
			return true;
		}else{
			return isContains(root.getRightChild(), node);
		}
	}

	public int countLeaf(Node<Integer> root){

		if(root != null){
			if(root.getLeftChild() == null && root.getRightChild() == null){
				return 1;
			}
			return countLeaf(root.getLeftChild()) + countLeaf(root.getRightChild());
		}
		return 0;
	}
	public int sizeOfBT(Node<Integer> root){
		if(root == null){
			return 0;
		}
		return 1 + sizeOfBT(root.getLeftChild()) + sizeOfBT(root.getRightChild());
	}
	public void mirror(Node<Integer> root){
		if(root == null){
			return;
		}
		mirror(root.getLeftChild());
		mirror(root.getRightChild());

		Node<Integer> temp = root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(temp);
	}

	public Node<Integer> LCA(Node<Integer> root, Node<Integer> a, Node<Integer> b){

		if(root == null){
			return null;
		}
		if(root == a || root == b){
			return root;
		}
		Node<Integer> leftCA = LCA(root.getLeftChild(), a, b);
		Node<Integer> rightCA = LCA(root.getRightChild(), a, b);
		if(leftCA != null && rightCA != null){
			return root;
		}
		return leftCA != null ? leftCA : rightCA;
	}

	public boolean printAncestor(Node<Integer> root, Node<Integer> node){

		if(root == null || node == null){
			return false;
		}
		if(root == node ||
				printAncestor(root.getLeftChild(), node) || 
				printAncestor(root.getRightChild(), node)){
			System.out.println(root.getData());
			return true;
		}
		return false;
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
		tree.root.getRightChild().getLeftChild().setLeftChild(new Node<Integer>(16));
		tree.root.getLeftChild().setLeftChild(new Node<Integer>(4));
		tree.root.getLeftChild().setRightChild(new Node<Integer>(5));
		tree.root.getLeftChild().getRightChild().setLeftChild(new Node<Integer>(15));
		tree.root.getLeftChild().getLeftChild().setLeftChild(new Node<Integer>(7));
		tree.root.getLeftChild().getLeftChild().setRightChild(new Node<Integer>(17));
		tree.insert(tree.root, 45);


		//tree.root.printTree();
		//tree.mirror(tree.root);
		tree.root.printTree();
		System.out.println("LEVEL" + tree.getLevel(tree.root, tree.root.getLeftChild().getLeftChild().getLeftChild()));
		//System.out.println(tree.printAncestor(tree.root, tree.root.getLeftChild()));
		if(tree.isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
