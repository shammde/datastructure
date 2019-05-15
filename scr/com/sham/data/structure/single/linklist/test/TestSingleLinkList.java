package com.sham.data.structure.single.linklist.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sham.data.structure.single.linklist.impl.SingleLinkList;

public class TestSingleLinkList {

	SingleLinkList linkList;
	
	@Before
	public void setAtrrib(){
		linkList = new SingleLinkList();
		
	}
	
	@Test
	public void testAdd() throws Exception{
		
		linkList.add(2);
		linkList.addLast(3);
		Assert.assertEquals("2->3", linkList.toString());
		System.out.println(linkList.toString());
		linkList.addFirst(1);
		Assert.assertEquals("1->2->3", linkList.toString());
		linkList.addLast(5);
		linkList.addAt(4, 3);
		Assert.assertEquals("1->2->3->4->5", linkList.toString());
		Assert.assertEquals(true, linkList.contains(3));
		linkList.deleteAt(2);
		Assert.assertEquals(false, linkList.contains(3));
		Assert.assertEquals(true, linkList.contains(5));
		//linkList.deleteFirst();
		//linkList.deleteLast();
		linkList.addAt(3, 2);
		linkList.add(6);
		linkList.add(7);
		linkList.addAt(0,0);
		linkList.addFirst(-1);
		linkList.addAt(-2, 0);
		System.out.println(linkList.toString());
		linkList.getTail().setNext(linkList.getAt(4));
		
		System.out.println(linkList.isCyclicList());
		System.out.println(linkList.findBeginOfLoop().getData());
		System.out.println(linkList.unlinkLoop().getData());
		System.out.println(linkList.toString());
		
		linkList.setHead(linkList.reverseRecursion(linkList.getHead(), null));
		System.out.println(linkList.toString());
		linkList.setHead(linkList.reverseRecursion(linkList.getHead(), null));
		System.out.println(linkList.toString());
		linkList.printReverse(linkList.getHead());
		
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testInvalidIndexOnDelete() throws Exception{
		linkList.deleteAt(1);
	}
}


