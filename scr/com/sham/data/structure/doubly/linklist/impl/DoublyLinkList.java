package com.sham.data.structure.doubly.linklist.impl;

import com.sham.data.structure.node.Node;

public class DoublyLinkList {
	
	Node<Integer> node;
	
	public DoublyLinkList(){
		node = null;
	}
	
	public boolean add(int data){
		return addLast(data);
	}
	
	public boolean addAt(int data, int index) throws Exception{
		
		if(index <= this.size() && index >= 0){
			if(index == 0){
				addFirst(data);
			} else if(this.size() == index){
				addLast(data);
			}else{
				Node<Integer> tempNode = node.getNodeAt(index - 1);
				Node<Integer> newNode = new Node<Integer>(data);
				newNode.setNext(tempNode.getNext());
				tempNode.getNext().setPrev(newNode);
				tempNode.setNext(newNode);
				newNode.setPrev(tempNode);
			}
		}else{
			new ArrayIndexOutOfBoundsException("Invalid index");
		}
		return true;
	}
	
	public boolean addLast(int data){
		
		if(node == null){
			node = new Node<Integer>(data);
		} else {
			Node <Integer> lastNode = node.getLastNode();
			Node <Integer> tempNode = new Node<Integer>(data);
			lastNode.setNext(tempNode);
			tempNode.setPrev(lastNode);
		}
		return true;
	}
	
	public boolean addFirst(int data){
		
		Node<Integer> tempNode = new Node<Integer>(data);
		tempNode.setNext(node);
		if(node != null){
			node.setPrev(tempNode);
		}
		node = tempNode;
		return true;
	}
	
	public boolean  deleteAt(int index) throws Exception{
		
		if(index <= this.size() && index >= 0){
			if(index == 0){
				deleteFirst();
			} else if(this.size() == index){
				deleteLast();
			}else{
				Node<Integer> tempNode = node.getNodeAt(index - 1);
				tempNode.setNext(tempNode.getNext().getNext());
			}
		}else{
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
		return true;
	}
	public boolean deleteFirst() throws Exception {
		if(node == null){
			throw new Exception("Illegal Operation");
		}else{
			Node<Integer> tempNode = node;
			node = node.getNext();
			node.setPrev(null);
			tempNode.setNext(null);
			tempNode.setPrev(null);
			tempNode = null;
		}
		return true;
	}
	
	public boolean deleteLast() throws Exception {
		if(node == null){
			throw new Exception("Illegal Operation");
		}else{
			if(this.size() == 1){
				node = null;
			}else{
				Node<Integer> tempNode = node.getNodeAt(node.getLastNodeIndex() - 1);
				tempNode.setNext(tempNode.getNext().getNext());
			}
		}
		return true;
	}
	
	public int size(){
		int size = 0;
		if(node != null){
			size = node.size();
		}
		return size;
	}
	
	public String toString(){
		StringBuilder strBuf = new StringBuilder("");
		if(node != null){
			Node<Integer> tempNode = node;
			strBuf.append(node.getData());
			while(tempNode.getNext() != null){
				tempNode = tempNode.getNext();
				strBuf.append("->" +  tempNode.getData());
			}
		}
		return strBuf.toString();
	}
	
	public boolean contains(int data){
		boolean retval = false;
		if(node != null){
			Node<Integer> tempNode = node;
			while(tempNode != null){
				if(tempNode.getData() == data){
					retval = true;
					break;
				}
				tempNode = tempNode.getNext();
			}
		}
		return retval;
	}
}
