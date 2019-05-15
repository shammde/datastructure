package com.sham.data.structure.node;

public class Node <E>{
	
	private E data;
	private Node<E> next;
	private Node<E> prev;
	private Node<E> leftChild;
	private Node<E> rightChild;
	
	public Node(){
		this.data = null;
		this.next = null;
		this.prev = null;
	}

	public Node(E data, Node<E> next, Node<E> prev){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public Node(E data){
		this.data = data;
		this.next = null;
		this.prev = null;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Node(E data, Node<E> next){
		this.data = data;
		this.next = next;
		this.prev = null;
	}
	
	public Node<E> getLastNode(){
		Node<E> temp = this;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		return temp;
	}
	
	public Node <E> getNodeAt(int index) throws Exception{
		if(index > getLastNodeIndex() || index < 0){
			throw new Exception("Illegal Operation");
		}else {
			int tempIndex = 0;
			Node<E> temp = this;
			while(tempIndex != index){
				temp = temp.getNext();
				tempIndex++;
			}
			return temp;
		}
	}
	
	public int getLastNodeIndex(){
		int index = 0;
		Node<E> temp = this;
		while(temp.getNext() != null){
			temp = temp.getNext();
			index++;
		}
		return index;
	}
	
	public int size(){
		return getLastNodeIndex() + 1;
	}
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Node<E> getPrev() {
		return prev;
	}

	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}

	public Node<E> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<E> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<E> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<E> rightChild) {
		this.rightChild = rightChild;
	}
}


