package com.dsa.surya.bst;

import java.util.Scanner;

public class BinarySearchTree {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.createBst();
		linkedList.inOrderTraversal(linkedList.head);
		
		linkedList.findMinMax();

		String choice; 
		do {
			System.out.println("Enter the number you want to search");
			int number = scanner.nextInt();
			boolean result = linkedList.searchData(number);
			System.out.println("The value in the search result is "+result);

			System.out.println("Do you want to search more?");
			choice = scanner.next();
		} while("y".equals(choice) || "Y".equals(choice));
	}
}
