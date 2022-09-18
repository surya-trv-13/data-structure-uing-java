package com.dsa.surya.bst;

public class BinarySearchTree {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.createBst();
		
		linkedList.inOrderTraversal(linkedList.head);
	}
}
