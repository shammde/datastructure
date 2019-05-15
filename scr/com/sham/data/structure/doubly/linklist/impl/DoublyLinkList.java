package com.sham.data.structure.doubly.linklist.impl;

import com.sham.data.structure.node.Node;

public class DoublyLinkList {
	
	Node<Integer> head;
	Node<Integer> tail;
	
	public DoublyLinkList(){
		head = null;
		tail = null;
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
				Node<Integer> tempNode = head.getNodeAt(index - 1);
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
		
		if(head == null){
			head = new Node<Integer>(data);
			tail = head;
		} else {
			Node <Integer> lastNode = head.getLastNode();
			Node <Integer> tempNode = new Node<Integer>(data);
			lastNode.setNext(tempNode);
			tempNode.setPrev(lastNode);
		}
		return true;
	}
	
	public boolean addFirst(int data){
		
		Node<Integer> tempNode = new Node<Integer>(data);
		tempNode.setNext(head);
		if(head != null){
			head.setPrev(tempNode);
		}
		head = tempNode;
		return true;
	}
	
	public boolean  deleteAt(int index) throws Exception{
		
		if(index <= this.size() && index >= 0){
			if(index == 0){
				deleteFirst();
			} else if(this.size() == index){
				deleteLast();
			}else{
				Node<Integer> tempNode = head.getNodeAt(index - 1);
				tempNode.setNext(tempNode.getNext().getNext());
			}
		}else{
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
		return true;
	}
	public boolean deleteFirst() throws Exception {
		if(head == null){
			throw new Exception("Illegal Operation");
		}else{
			Node<Integer> tempNode = head;
			head = head.getNext();
			head.setPrev(null);
			tempNode.setNext(null);
			tempNode.setPrev(null);
			tempNode = null;
		}
		return true;
	}
	
	public boolean deleteLast() throws Exception {
		if(head == null){
			throw new Exception("Illegal Operation");
		}else{
			if(this.size() == 1){
				head = null;
			}else{
				Node<Integer> tempNode = head.getNodeAt(head.getLastNodeIndex() - 1);
				tempNode.setNext(tempNode.getNext().getNext());
			}
		}
		return true;
	}
	
	public int size(){
		int size = 0;
		if(head != null){
			size = head.size();
		}
		return size;
	}
	
	public String toString(){
		StringBuilder strBuf = new StringBuilder("");
		if(head != null){
			Node<Integer> tempNode = head;
			strBuf.append(head.getData());
			while(tempNode.getNext() != null){
				tempNode = tempNode.getNext();
				strBuf.append("->" +  tempNode.getData());
			}
		}
		return strBuf.toString();
	}
	
	public boolean contains(int data){
		boolean retval = false;
		if(head != null){
			Node<Integer> tempNode = head;
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
