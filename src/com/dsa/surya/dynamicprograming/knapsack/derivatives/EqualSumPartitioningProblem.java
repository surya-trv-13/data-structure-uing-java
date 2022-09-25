package com.dsa.surya.dynamicprograming.knapsack.derivatives;

public class EqualSumPartitioningProblem {
	public static void main(String[] args) {
		EqualSumPartitioningProblem equalSumPartitioningProblem = new EqualSumPartitioningProblem();
		Integer[] arr = {1,5,12,5};
		System.out.println("Is Equal Sum Partion possible : "+ equalSumPartitioningProblem.isEqualSumPartion(arr));
	}
	public boolean isEqualSumPartion(Integer[] arr) {
		Integer sum = 0;
		for(int index = 0; index < arr.length; index++) {
			sum += arr[index];
		}
		
		if(sum % 2 == 0) {
			// Subset Problem: 
			Integer target = sum/2;
			Integer n = arr.length;
			boolean[][] t = new boolean[n+1][target+1];
			// Initialization
			for(int i = 0; i < n+1; i++) {
				for(int j = 0; j < target + 1; j++) {
					if(i == 0) {
						t[i][j] = false;
					}
					if(j == 0) {
						t[i][j] = true;
					}
				}
			}
			
			// Choice Diagram
			for(int i = 1; i < n+1 ; i++) {
				for(int j = 1; j < target+1 ; j++) {
					if(arr[i-1] <= j) {
						t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
					}
					else {
						t[i][j] = t[i-1][j];
					}
				}
			}
			
			return t[n][target];
		} else {
			return false;
		}
	}
}
