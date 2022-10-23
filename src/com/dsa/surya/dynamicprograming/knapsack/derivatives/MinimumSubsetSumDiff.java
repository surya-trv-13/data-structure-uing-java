package com.dsa.surya.dynamicprograming.knapsack.derivatives;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDiff {
	public static void main(String[] args) {
		MinimumSubsetSumDiff minimumSubsetSumDiff = new MinimumSubsetSumDiff();
		Integer[] arr = {2,3,5,8,7,10};
		Integer sum = 15;
		Integer n = 6;
		
		Integer t = minimumSubsetSumDiff.minimumSubsetSumDiff(arr, n);
		
		System.out.println("Minimum subset sum difference is " + t);
	}
	public Integer minimumSubsetSumDiff(Integer[] arr, Integer n) {
		Integer sumTotal = 0;
		for(Integer val : arr) {
			sumTotal += val;
		}
		
		Integer[][] t = new Integer[n+1][sumTotal+1];
//		Initialization 
		for(int i = 0; i < n+1 ; i++) {
			for(int j = 0; j < sumTotal+1 ; j++) {
				if(i == 0) {
					
				}
				
				if(j == 0) {
					
				}
			}
		}
		
		return null;
	}
}
