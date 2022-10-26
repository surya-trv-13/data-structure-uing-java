package com.dsa.surya.dynamicprograming.knapsack.derivatives;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDiff {
	public static void main(String[] args) {
		MinimumSubsetSumDiff minimumSubsetSumDiff = new MinimumSubsetSumDiff();
		Integer[] arr = {2,3,5,8,7,10};
		Integer n = 6;
		
		Integer t = minimumSubsetSumDiff.minimumSubsetSumDiff(arr, n);
		
		System.out.println("Minimum subset sum difference is " + t);
	}
	public Integer minimumSubsetSumDiff(Integer[] arr, Integer n) {
		Integer sumTotal = 0;
		for(Integer val : arr) {
			sumTotal += val;
		}
		Integer subSumTotal = sumTotal % 2 == 0 ? sumTotal/2 : sumTotal/2 + 1;
		Boolean[][] t = new Boolean[n+1][subSumTotal+1];
//		Initialization 
		for(int i = 0; i < n+1 ; i++) {
			for(int j = 0; j < subSumTotal+1 ; j++) {
				if(i == 0) {
					t[i][j] = false;
				}
				
				if(j == 0) {
					t[i][j] = true;
				}
			}
		}
		
		for(int i = 1; i < n+1 ; i++) {
			for(int j = 1; j < subSumTotal+1 ; j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];	
				} else {
					t[i][j] = t[i-1][j];
				}
				 
			}
		}
		
		return minimumDifference(n, sumTotal, subSumTotal, t);
	}
	
	private Integer minimumDifference(Integer n, Integer sumTotal, Integer subSumTotal, Boolean[][] t) {
		for(int i = subSumTotal; i >= 0 ; i--) {
			if(Boolean.TRUE.equals(t[n][i])) {
				System.out.println("subTotal Sum: "+ i);
				return Math.abs(sumTotal - (2*i));
			}
		}
		
		return null;
	}
}
