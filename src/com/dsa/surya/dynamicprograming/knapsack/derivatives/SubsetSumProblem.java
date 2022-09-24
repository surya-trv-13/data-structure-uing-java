package com.dsa.surya.dynamicprograming.knapsack.derivatives;

/**
 * 
 * @author suryanarayan.rath
 * 
 * Problem Statement : Given an array of numbers and given the sum value
 * 	Need to find if the subset of the array contains the sum of SUM value.
 *
 */

public class SubsetSumProblem {
	public static void main(String[] args) {
		SubsetSumProblem subsetSumProblem = new SubsetSumProblem();
		Integer[] arr = {2,3,7,8,10};
		Integer sum = 14;
		Integer n = 5;
		
		System.out.println("Is sub set of sum available :"+ subsetSumProblem.subSetSum(arr, sum, n));
	}
	
	public Boolean subSetSum(Integer[] arr, Integer sum, Integer n) {
		Boolean[][] t = new Boolean[n + 1][sum + 1];
		// Initialize
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < sum + 1; j++) {
				if(i == 0) {
					t[i][j] = false;
				}
				
				if(j == 0) {
					t[i][j] = true;
				}
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < sum + 1; j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
			
		return t[n][sum];
	}
}
