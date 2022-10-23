package com.dsa.surya.dynamicprograming.knapsack.derivatives;

public class CountSubsetSum {
	public static void main(String[] args) {
		CountSubsetSum countSubsetSum = new CountSubsetSum();
		Integer[] arr = {2,3,5,8,7,10};
		Integer sum = 15;
		Integer n = 6;
		
		Integer[][] t = countSubsetSum.countSubsetSum(arr, sum, n);
		
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < sum+1 ; j++) {
				System.out.print(t[i][j]+" ");
			}
			
			System.out.println();
		}
		
		System.out.println("Number of subset with sum "+ sum +" is "+t[n][sum]);
	}
	public Integer[][] countSubsetSum(Integer[] arr, Integer target, Integer n) {
		Integer[][] t = new Integer[n+1][target+1];
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < target+1; j++) {
				if(i == 0) {
					t[i][j] = 0;
				}
				if(j == 0) {
					t[i][j] = 1;
				}
			}
		}
		
		// choice diagram
		for(int i = 1; i < n+1; i++) {
			for(int j = 1 ; j < target + 1; j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t;
	}
}
