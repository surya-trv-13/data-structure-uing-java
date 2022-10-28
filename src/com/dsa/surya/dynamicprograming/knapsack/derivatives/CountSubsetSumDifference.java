package com.dsa.surya.dynamicprograming.knapsack.derivatives;

public class CountSubsetSumDifference {
	public static void main(String[] args) {
		Integer[] arr = {1,5,6,11};
		Integer difference = 2;
		
		Integer noOfSubsetDiff = countSubsetDiffwithGivenDifference(arr, difference);
		System.out.println("Count of difference for the given array and diff is " + noOfSubsetDiff);
	}

	private static Integer countSubsetDiffwithGivenDifference(Integer[] arr, Integer difference) {
		// Find Sum of the given Array
		Integer sumTotal = 0;
		for(Integer arrItem : arr) {
			sumTotal += arrItem;
		}
		
		// Checking possibility for the subset sum difference
		if((sumTotal + difference) % 2 != 0) {
			return 0;
		} else {
			Integer subSumTotal = (sumTotal + difference) / 2;
			Integer[][] t = new Integer[arr.length + 1][subSumTotal + 1];
			for(Integer i = 0; i < arr.length + 1; i++) {
				for(Integer j = 0; j < subSumTotal + 1; j++) {
					if(i == 0) {
						t[i][j] = 0;
					}
					
					if(j == 0) {
						t[i][j] = 1;
					}
				}
			}
			
			for(int i = 1; i < arr.length + 1; i++) {
				for(Integer j = 1; j < subSumTotal + 1; j++) {
					if(arr[i-1] <= j) {
						t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
					} else {
						t[i][j] = t[i-1][j];
					}
				}
			}
			
			return t[arr.length][subSumTotal];
		}
	}
}
