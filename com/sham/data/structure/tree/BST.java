package com.sham.data.structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.sham.data.structure.node.Node;

public class BST {
	private Node<Integer> root;
	
	public BST(){
		root = null;
	}
	
	public Node<Integer> getRoot(){
		return root;
	}
	
	public int visit(){
		
		return root != null ? root.getData() : 0;
	}
	
	public void add(int data){
		root = add(root, data);
		System.out.println(root.getData());
	}
	
	private Node<Integer> add(Node<Integer> root, int data){
		if(root == null){
			root = new Node<Integer>(data);
		} else if(data < root.getData()){
			root.setLeftChild(add(root.getLeftChild(), data));
		} else if(data > root.getData()){
			root.setRightChild(add(root.getRightChild(), data));
		}
		return root;
	}
	
	public void preOrder(Node<Integer> root){
		if(root == null) return;
		System.out.print(root.getData() + ", ");
		preOrder(root.getLeftChild());
		preOrder(root.getRightChild());
	}
	
	public void preOrderIterative(Node<Integer> root){
		Node<Integer> temp = root;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while(true){
			while(temp != null){
				System.out.print(temp.getData() + ", ");
				if(temp.getRightChild() != null){
					stack.push(temp.getRightChild());
				}
				temp = temp.getLeftChild();
			}
			if(stack.isEmpty()){
				break;
			}
			temp = stack.pop();
		}
	}
	
	public void inOrder(Node<Integer> root){
		if(root == null) return;
		inOrder(root.getLeftChild());
		System.out.print(root.getData() + ", ");
		inOrder(root.getRightChild());
		
	}
	
	public void inOrderIterative(Node<Integer> root){
		Node<Integer> temp = root;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while(true){
			while(temp != null){
				stack.push(temp);
				temp = temp.getLeftChild();
			}
			if(stack.isEmpty()){
				break;
			}
			temp = stack.pop();
			System.out.print(temp.getData() + ", ");	
			temp = temp.getRightChild();
		}
	}
	
	public void postOrder(Node<Integer> root){
		if(root == null) return;
		postOrder(root.getLeftChild());
		postOrder(root.getRightChild());
		System.out.print(root.getData() + ", ");
		
	}
	
	public void postOrderIterative(Node<Integer> root){
		Node<Integer> temp = root;
		Node<Integer> previous = null;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		do{
			while(temp != null){
				stack.push(temp);
				temp = temp.getLeftChild();
			}
			while(temp != null && !stack.isEmpty()){
				temp = stack.peek();
				if(temp.getRightChild() == null || temp.getRightChild() == previous){
					System.out.print(temp.getData() + ", ");
					stack.pop();
					previous = temp;
					temp = null;
				}else{
					temp = temp.getRightChild();
				}
			}
		}while(!stack.isEmpty());
	}
	
	public void levelOrderIterative(Node<Integer> root){
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		if(root != null){
			queue.add(root);
		}
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.remove();
			System.out.print(temp.getData() + ", ");
			if(temp.getLeftChild() != null){
				queue.add(temp.getLeftChild());
			}
			if(temp.getRightChild() != null){
				queue.add(temp.getRightChild());
			}
		}
	}
	
	public int findMax(Node<Integer> root){
		
		int max = 0;
		if(root != null){
			int rootVal = root.getData();
			int leftVal = findMax(root.getLeftChild());
			int rightVal = findMax(root.getRightChild());
			max = (leftVal > rightVal) ? leftVal : rightVal;
			max = max > rootVal ? max : rootVal;
		}
		return max;
	}
	
    public int findMinBST(Node<Integer> root){
		
		if(root == null){
			return -1;
		}else if(root.getLeftChild() == null){
			return root.getData();
		}else{
			return findMinBST(root.getLeftChild());
		}
	}
    public int findMinIterativeBST(Node<Integer> root){
		
		if(root == null){
			return -1;
		}
		while(root.getLeftChild() != null){
			root = root.getLeftChild();
		}
		return root.getData();
	}
    
    public Node<Integer> findMaxBST(Node<Integer> root){
		
		if(root == null){
			return null;
		}else if(root.getLeftChild() == null){
			return root;
		}else{
			return findMaxBST(root.getRightChild());
		}
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
    			Node<Integer> temp = findMaxBST(root.getLeftChild());
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
    
    public boolean contains(Node<Integer> root, int data){
    	if(root == null){
    		return false;
    	}
    	if(root.getData() == data){
    		return true;
    	}
    	if(root.getData() > data){
    		return contains(root.getLeftChild(), data);
    	}else{
    		return contains(root.getRightChild(), data);
    	}
    }
    
    public Node<Integer> findLeastCommonAncestor(Node<Integer> root,
    		int first, int second){
    	
    	if(contains(root, first) && contains(root, second)){
    		while(true){
    			if(root.getData() > first && root.getData() < second || 
    					root.getData() < first && root.getData() > second){
    				return root;
    			}
    			if(first > root.getData()){
    				root = root.getRightChild();
    			}else{
    				root = root.getLeftChild();
    			}
    		}
    	}
    	return null;
    }
}
