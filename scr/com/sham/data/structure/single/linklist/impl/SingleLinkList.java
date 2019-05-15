package com.sham.data.structure.single.linklist.impl;

import com.sham.data.structure.node.Node;

public class SingleLinkList {
	
	Node<Integer> head;
	
	public SingleLinkList(){
		head = null;
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
				tempNode.setNext(newNode);
			}
		}else{
			new ArrayIndexOutOfBoundsException("Invalid index");
		}
		return true;
	}
	
	public boolean addLast(int data){
		
		if(head == null){
			head = new Node<Integer>(data);
		} else {
			head.getLastNode().setNext(new Node<Integer>(data));
		}
		return true;
	}
	
	public boolean addFirst(int data){
		
		Node<Integer> tempNode = new Node<Integer>(data);
		tempNode.setNext(head);
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
	
	public Node<Integer> getAt(int index) throws Exception{
		
		if(index <= this.size() && index >= 0){
			return head.getNodeAt(index - 1);
		}else{
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
	}

	public boolean deleteFirst() throws Exception {
		if(head == null){
			throw new Exception("Illegal Operation");
		}else{
			head = head.getNext();
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
			size = head.getLastNodeIndex() + 1;
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
	
	/**
	 * 
	 * @param current
	 * @param end
	 * @return
	 */
	public Node<Integer> reverseRecursion (Node<Integer> current, Node<Integer> end) {
		current.setNext(end);
		return (current.getNext() != null ? reverseRecursion(current.getNext(), current) : current);
	}
	
	/**
	 * 
	 */
	public void reverseIterative(){
		Node<Integer> currNode = head;
		Node<Integer> nextNode = null;
		Node<Integer> prevNode = null;
		while(currNode!=null){
			nextNode = currNode.getNext();
			currNode.setNext(prevNode);
			prevNode = currNode;
			currNode = nextNode;
		}
		head = prevNode;
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
	
	public Node<Integer> getHead(){
		return head;
	}
	
	public void setHead(Node<Integer> head){
		this.head = head;
	}
	
	public Node<Integer> getTail() throws Exception {
		if(head != null)		
			return head.getNodeAt(head.getLastNodeIndex());
		else
			return null;
	}
	
	public boolean isCyclicList() {
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		while(slow != null && fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(fast == slow){
				return true;
			}
		}
		return false;
	}
	
	public Node<Integer> findBeginOfLoop(){
		
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		while(slow != null && fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(fast == slow){
				break;
			}
		}
		slow = head;
		while(slow != fast){
			fast = fast.getNext();
			slow = slow.getNext();
		}
		
		return slow;
	}
	
	public Node<Integer> unlinkLoop(){
		
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		while(slow != null && fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(fast == slow){
				break;
			}
		}
		slow = head;
		Node<Integer> prevFast = null;
		while(slow != fast){
			prevFast = fast;
			fast = fast.getNext();
			slow = slow.getNext();
		}
		prevFast.setNext(null);
		return slow;
	}
}
