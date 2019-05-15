package com.sham.data.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.sham.data.structure.node.Node;

public class ReviseBST {
	
	Node<Integer> root = null;
	public static void main(String args[]){
		
		new ReviseBST().test();
	}

	public void test(){
		
		root = addToBST(root, new Node<Integer>(6));
		addToBST(root, new Node<Integer>(4));
		addToBST(root, new Node<Integer>(2));
		addToBST(root, new Node<Integer>(1 ));
		addToBST(root, new Node<Integer>(5));
		addToBST(root, new Node<Integer>(7));
		addToBST(root, new Node<Integer>(8));
		addToBST(root, new Node<Integer>(10));
		addToBST(root, new Node<Integer>(9));
		addToBST(root, new Node<Integer>(3));
		if(root == null){
			System.out.println("Root is null");
		}
		root.printTree();
		printLeftView();
	}
	
	private Node<Integer> addToBST(Node<Integer> root, Node<Integer> node){
		if(root == null){
			root = node;
		}else if(node.getData() < root.getData()){
			root.setLeftChild(addToBST(root.getLeftChild(), node));
		}else{
			root.setRightChild(addToBST(root.getRightChild(), node));
		}
		return root;
	}
	
	private void printLeftView(){
		if(root != null){
			Queue<Node<Integer>> stack = new LinkedList<Node<Integer>>();
			System.out.println(root.getData() + " ");
			stack.add(root);
			stack.add(null);
			boolean levelEnd = false;
			while(!stack.isEmpty()){
				Node<Integer> node = stack.remove();
				if(node == null){
					levelEnd = true;
					if(!stack.isEmpty()){
						stack.add(null);
					}
				}else{
					if(levelEnd){
						System.out.println(node.getData() + " ");
						levelEnd = false;
					}
					if(node.getLeftChild() != null) stack.add(node.getLeftChild());
					if(node.getRightChild() != null) stack.add(node.getRightChild());
				}
			}
		}
	}
}
