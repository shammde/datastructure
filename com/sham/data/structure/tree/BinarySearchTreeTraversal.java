package com.sham.data.structure.tree;

public class BinarySearchTreeTraversal {

	public static void main(String[] args) {
		new BinarySearchTreeTraversal().test();
	}

	private void test(){

		BST bst = new BST();
		bst.add(10);
		bst.add(6);
		bst.add(16);
		bst.add(4);
		bst.add(9);
		bst.add(13);
		bst.add(7);
		//bst.delete(bst.getRoot(), 10);
		
		System.out.print("\nPreOder ");
		bst.preOrder(bst.getRoot());
		bst.preOrderIterative(bst.getRoot());
		System.out.print("\nInOder ");
		bst.inOrder(bst.getRoot());
		bst.inOrderIterative(bst.getRoot());
		System.out.print("\nPostOder ");
		bst.postOrder(bst.getRoot());
		//bst.postOrderIterative(bst.getRoot());
		System.out.print("\nLevelOder ");
		bst.levelOrderIterative(bst.getRoot());
		System.out.println("\nMax Value is " + bst.findMax(bst.getRoot()));
		System.out.println("Common Ancestor " + bst.findLeastCommonAncestor(bst.getRoot(), 4, 9).getData());
	}
}
