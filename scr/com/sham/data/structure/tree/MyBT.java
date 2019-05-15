package com.sham.data.structure.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.sham.data.structure.node.Node;

public class MyBT {

	private Node<Integer> root = null;
	private Node<Integer> head = null;
	public static void main(String[] args) {
		new MyBT().test();
	}

	public void insert(Node<Integer> root, Node<Integer> node){
		if(this.root == null){
			this.root = node;
		}else{
			Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
			queue.add(root);
			while(!queue.isEmpty()){
				Node<Integer> temp = queue.remove();
				if(temp.getLeftChild() == null){
					temp.setLeftChild(node);
					break;
				}
				if(temp.getRightChild() == null){
					temp.setRightChild(node);
					break;
				}
				queue.add(temp.getLeftChild());
				queue.add(temp.getRightChild());
			}
		}
	}

	public Node<Integer> addBST(Node<Integer> root, Node<Integer> node){
		if(root == null){
			root = node;
		}else if(root.getData() > node.getData()){
			root.setLeftChild(addBST(root.getLeftChild(), node));
		}else if(root.getData() < node.getData()){
			root.setRightChild(addBST(root.getRightChild(), node));
		}
		return root;
	}
	public void preOrder(Node<Integer> root){
		if(root == null){
			return;
		}
		System.out.print(root.getData() + " ");
		preOrder(root.getLeftChild());
		preOrder(root.getRightChild());
	}

	public void preOrderIterative(Node<Integer> root){
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while(true){
			while(root != null){
				System.out.print(root.getData() + " ");
				stack.push(root);
				root = root.getLeftChild();
			}
			if(stack.isEmpty()){
				break;
			}
			root = stack.pop();
			root = root.getRightChild();
		}
	}

	public void postOrder(Node<Integer> root){
		if(root == null){
			return;
		}
		postOrder(root.getLeftChild());
		postOrder(root.getRightChild());
		System.out.print(root.getData() + " ");
	}

	public void postOrderIterative(Node<Integer> root){
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		Node<Integer> previous = null;
		do{
			while(root != null){
				stack.push(root);
				root = root.getLeftChild();
			}
			while(root == null && !stack.isEmpty()){
				root = stack.peek();
				if(root.getRightChild() == null || root.getRightChild() == previous){
					System.out.print(root.getData() + " ");
					root = stack.pop();
					previous = root;
					root = null;
				}else{
					root = root.getRightChild();
				}
			}
		}while(!stack.isEmpty());
	}

	public void inOrder(Node<Integer> root){
		if(root == null){
			return;
		}
		inOrder(root.getLeftChild());
		System.out.print(root.getData() + " ");
		inOrder(root.getRightChild());
	}

	public void inOrderIterative(Node<Integer> root){
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while(true){

			while(root != null){
				stack.push(root);
				root = root.getLeftChild();
			}

			if(stack.isEmpty()){
				break;
			}
			root = stack.pop();
			System.out.print(root.getData() + " ");
			root = root.getRightChild();
		}
	}

	public void levelOrder(Node<Integer> root){
		if(root == null){
			return;
		}
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.remove();
			System.out.print(temp.getData() + " ");
			if(temp.getLeftChild() != null){
				queue.add(temp.getLeftChild());
			}
			if(temp.getRightChild() != null){
				queue.add(temp.getRightChild());
			}
		}
	}

	public Node<Integer> findMax(Node<Integer> root){
		if(root == null){
			return null;
		}
		Node<Integer> maxNode = root;
		Node<Integer> leftMaxNode = findMax(root.getLeftChild());
		Node<Integer> rightMaxNode = findMax(root.getRightChild());
		if(leftMaxNode != null && maxNode.getData() < leftMaxNode.getData()){
			maxNode = leftMaxNode;
		}
		if(rightMaxNode != null && maxNode.getData() < rightMaxNode.getData()){
			maxNode = rightMaxNode;
		}
		return maxNode;
	}

	public boolean contains(Node<Integer> root, Node<Integer> node){
		if(root ==null || node == null){
			return false;
		}
		if(root == node || contains(root.getLeftChild(), node)|| contains(root.getRightChild(), node)){
			return true;
		}
		return false;
	}

	public int size(Node<Integer> root){
		if(root == null){
			return 0;
		}
		return 1 + size(root.getLeftChild()) + size(root.getRightChild());
	}

	public void levelOrderReverse(Node<Integer> root){
		if(root == null){
			return;
		}
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();

		queue.add(root);
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.remove();
			stack.push(temp);
			if(temp.getRightChild() != null) queue.add(temp.getRightChild());
			if(temp.getLeftChild() != null) queue.add(temp.getLeftChild());
		}
		while(!stack.isEmpty()) {
			Node<Integer> temp = stack.pop();
			System.out.print(temp.getData() + " ");
		}
	}

	public int getHeight(Node<Integer> root){
		if(root == null){
			return 0;
		}else{
			return Math.max(1 + getHeight(root.getLeftChild()), 1 + getHeight(root.getRightChild()));
		}
	}

	public int getHeightIterative(Node<Integer> root){
		if(root == null){
			return 0;
		}
		int level = 0;
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.remove();
			if(temp == null) {
				level++;
				if(!queue.isEmpty()) queue.add(null);
			}else{
				if(temp.getRightChild() != null) queue.add(temp.getRightChild());
				if(temp.getLeftChild() != null) queue.add(temp.getLeftChild());
			}
		}
		return level;
	}

	public int getLevel(Node<Integer> root, Node<Integer> node){
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
				return 0;
			}else{
				return 1 + level;
			}
		}else{
			return 1 + level;
		}
	}

	public int leafCount(Node<Integer> root){
		if(root == null){
			return 0;
		}
		if(root.getLeftChild() == null && root.getRightChild() == null){
			return 1;
		}
		return leafCount(root.getLeftChild()) + leafCount(root.getRightChild());
	}

	public int fullNodeCount(Node<Integer> root){
		if(root == null){
			return 0;
		}
		if(root.getLeftChild() != null && root.getRightChild() != null){
			return 1 + fullNodeCount(root.getLeftChild()) + fullNodeCount(root.getRightChild());
		}
		if(root.getLeftChild() != null){
			fullNodeCount(root.getLeftChild());
		}
		if(root.getRightChild() != null){
			fullNodeCount(root.getRightChild());
		}
		return 0;
	}

	public boolean isIdentical(Node<Integer> root1, Node<Integer> root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		return root1.getData() == root2.getData() 
				&& isIdentical(root1.getLeftChild(), root2.getLeftChild())
				&& isIdentical(root1.getRightChild(), root2.getRightChild());
	}

	public int getWidth(Node<Integer> root){
		if(root == null){
			return 0;
		}
		int diameter = 1 + getHeight(root.getLeftChild()) + getHeight(root.getRightChild());
		int ldiameter = getWidth(root.getLeftChild());
		int rdiameter = getWidth(root.getRightChild());
		return Math.max(diameter, Math.max(ldiameter, rdiameter));
	}

	public int sum(Node<Integer> root){
		if(root == null){
			return 0;
		}
		return root.getData() + sum(root.getLeftChild()) + sum(root.getRightChild());
	}

	public void mirror(Node<Integer> root){
		if(root != null){
			Node<Integer> temp = root.getLeftChild();
			root.setLeftChild(root.getRightChild());
			root.setRightChild(temp);
			mirror(root.getLeftChild());
			mirror(root.getRightChild());

		}
	}

	public boolean isMirror(Node<Integer> root1, Node<Integer> root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		if(root1.getData() != root2.getData()){
			return false;
		}
		return isMirror(root1.getLeftChild(), root2.getRightChild()) &&
				isMirror(root1.getRightChild(), root2.getLeftChild());
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
			System.out.print(root.getData() + " ");
			return true;
		}
		return false;
	}

	public void createMinHeapFromBST(Node<Integer> root){
		int array[] = new int[size(root)];
		int index = 0;
		Node<Integer> tempRoot = root;
		//In Order
		Stack <Node<Integer>> stack = new Stack<Node<Integer>>();
		while(true){
			while(tempRoot != null){
				stack.push(tempRoot);
				tempRoot = tempRoot.getLeftChild();
			}
			if(stack.isEmpty()){
				break;
			}
			Node<Integer> temp = stack.pop();
			array[index++] = temp.getData();
			tempRoot = temp.getRightChild();
		}

		//PreOrder
		index = 0;
		tempRoot = root;
		while(true){
			while(tempRoot != null){
				tempRoot.setData(array[index++]);
				stack.push(tempRoot);
				tempRoot = tempRoot.getLeftChild();
			}
			if(stack.isEmpty()){
				break;
			}
			Node<Integer> temp = stack.pop();
			tempRoot = temp.getRightChild();
		}
	}

	public void zigZagTravels(Node<Integer> root){
		if(root == null){
			return;
		}
		boolean toggle = false;
		Stack<Node<Integer>> currentLevel = new Stack<Node<Integer>>();
		Stack<Node<Integer>> nextLevel = new Stack<Node<Integer>>();
		currentLevel.push(root);
		while(!currentLevel.isEmpty()){
			Node<Integer> temp = currentLevel.pop();
			if(temp != null) {
				System.out.print(temp.getData() + " ");
				if(toggle){
					if(temp.getRightChild() != null) nextLevel.push(temp.getRightChild());
					if(temp.getLeftChild() != null) nextLevel.push(temp.getLeftChild());
				}else{
					if(temp.getLeftChild() != null) nextLevel.push(temp.getLeftChild());
					if(temp.getRightChild() != null) nextLevel.push(temp.getRightChild());
				}
			}
			if(currentLevel.isEmpty()){
				toggle = !toggle;
				currentLevel.addAll(nextLevel);
				nextLevel.clear();
			}
		}
	}
	/*
	 *   Algorithm: buildTree()
	 *	1) Pick an element from PreOrder. Increment a PreOrder Index Variable (preIndex in below code) to pick next element in next recursive call.
	 *	2) Create a new tree node tNode with the data as picked element.
	 *	3) Find the picked element’s index in InOrder. Let the index be inIndex.
	 *	4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
	 *	5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
	 *	6) return tNode.
	 */
	static int preIndex = 0;
	Node<Integer> buildTree(int inOrder[], int preOrder[], int inStart, int inEnd) 
	{
		if (inStart > inEnd) 
			return null;

		/* Pick current node from preOrder traversal using preIndex
           and increment preIndex */
		Node<Integer> tNode = new Node<Integer>(preOrder[preIndex++]);

		/* If this node has no children then return */
		if (inStart == inEnd)
			return tNode;

		/* Else find the index of this node in InOrder traversal */
		int inIndex = search(inOrder, inStart, inEnd, tNode.getData());

		/* Using index in InOrder traversal, construct left and
           right subTrees */
		tNode.setLeftChild(buildTree(inOrder, preOrder, inStart, inIndex - 1));
		tNode.setRightChild(buildTree(inOrder, preOrder, inIndex + 1, inEnd));

		return tNode;
	}

	/* UTILITY FUNCTIONS */

	/* Function to find index of value in arr[start...end]
     The function assumes that value is present in in[] */
	int search(int arr[], int start, int end, int value) {
		int i;
		for (i = start; i <= end; i++) {
			if (arr[i] == value)
				return i;
		}
		return i;
	}

	public Node<Integer> delete(Node<Integer> root, int data){

		if(root == null){
			System.out.println("Nothing to delete");
		}else if(root.getData() > data){
			root.setLeftChild(delete(root.getLeftChild(), data));
		}else if(root.getData() < data){
			root.setRightChild(delete(root.getRightChild(), data));
		}else{
			/** Found element which need to be deleted */
			if(root.getRightChild() != null && root.getLeftChild() != null){
				/** contains both child */
				Node<Integer> temp = findMax(root.getLeftChild());
				root.setData(temp.getData());
				root.setLeftChild(delete(root.getLeftChild(), root.getData()));
			}else{
				/** contains one child */
				if(root.getLeftChild() == null){
					root = root.getRightChild();
				}else if(root.getRightChild() == null){
					root = root.getLeftChild();
				}
			}
		}
		return root;
	}
	
	public void verticalSum(Map<Integer, Integer> map, Node<Integer> root, int col){

		if(root == null){
			return;
		}
		verticalSum(map, root.getLeftChild(), col - 1);
		verticalSum(map, root.getRightChild(), col + 1);

		//System.out.println("Key " + col + " Value " + root.getData());
		if(map.containsKey(col)){
			map.put(col, map.get(col) + root.getData());
		}else{
			map.put(col, root.getData());
		}

	}

	public boolean isSumTree(Node<Integer> root){
		if(root == null){
			return true;
		}
		if (root.getData() == sum(root.getLeftChild()) + sum(root.getRightChild()) 
				&& isSumTree(root.getLeftChild()) && isSumTree(root.getRightChild())) {
			return true;
		}
		return false;
	}

	void MyBTToDLL(Node<Integer> root){
		
		if(root == null){
			return;
		}
		MyBTToDLL(root.getLeftChild());
		
		root.setLeftChild(head);
		
		
	}
	void BToDLL(Node<Integer> root) 
	{
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		BToDLL(root.getRightChild());

		// insert root into DLL
		root.setRightChild(head);

		// Change left pointer of previous head
		if (head != null)
			(head).setLeftChild(root);

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		BToDLL(root.getLeftChild());
	}

	void printList(Node<Integer> head) 
	{
		System.out.println("Extracted Double Linked List is : ");
		while (head != null) 
		{
			System.out.print(head.getData() + " ");
			head = head.getRightChild();
		}
	}
	
	public void leftView(Node<Integer> root){
		if(root == null){
			return;
		}
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		queue.add(null);
		System.out.print("\n" + root.getData() + " ");
		boolean levelEnd = false;
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.remove();
			if(temp == null){
				levelEnd = true;
				if(!queue.isEmpty()){
					queue.add(null);
				}
			}else{
				if(levelEnd){
					System.out.print(temp.getData() + " ");
					levelEnd = false;
				}
				if(temp.getLeftChild() != null) queue.add(temp.getLeftChild());
				if(temp.getRightChild() != null) queue.add(temp.getRightChild());
			}
		}
	}
	
	public void rightView(Node<Integer> root){
		if(root == null){
			return;
		}
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		queue.add(null);
		System.out.println();
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.remove();
			if(temp == null){
				if(!queue.isEmpty()){
					queue.add(null);
				}
			}else{
				if(queue.peek() == null){
					System.out.print(temp.getData() + " ");
				}
				if(temp.getLeftChild() != null) queue.add(temp.getLeftChild());
				if(temp.getRightChild() != null) queue.add(temp.getRightChild());
			}
		}
	}
	
	public void test(){

		root = addBST(root, new Node<Integer>(4));
		Node<Integer> nodeDelete = new Node<Integer>(2);
		addBST(root,nodeDelete);
		addBST(root, new Node<Integer>(6));
		addBST(root, new Node<Integer>(1));
		addBST(root, new Node<Integer>(3));
		addBST(root, new Node<Integer>(5));
		addBST(root, new Node<Integer>(7));
		//		insert(root, new Node<Integer>(1));
		//		insert(root, new Node<Integer>(2));
		//		insert(root, new Node<Integer>(3));
		//		insert(root, new Node<Integer>(4));
		//		insert(root, new Node<Integer>(5));
		//		insert(root, new Node<Integer>(6));
		//		insert(root, new Node<Integer>(7));
		//		insert(root, new Node<Integer>(8));
		//		insert(root, new Node<Integer>(9));
		//		insert(root, new Node<Integer>(10));
		root.printTree();
		preOrderIterative(root);
		System.out.println();
		root.printTree();
		//BToDLL(root);
		//printList(head);
		levelOrder(root);
		leftView(root);
		rightView(root);
	}
}
