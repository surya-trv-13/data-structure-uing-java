package com.dsa.surya.dynamicprograming;

public class Knapsack01BottomUp {
	public static void main(String[] args) {
		Knapsack01BottomUp knapsack01BottomUp = new Knapsack01BottomUp();
		Integer[] weight = new Integer[] {1,2,3,4};
		Integer[] value = new Integer[] {3,7,6,5};
		Integer W = 7;
		Integer n = 4;
		
		System.out.println("Knapsack 0/1 Bottom Up: Max Profit : "+ knapsack01BottomUp.knapsack(weight, value, W, n));
	}
	
	public int knapsack(Integer[] wt, Integer[] val, Integer W, Integer n) {
		Integer[][] t = new Integer[n+1][W+1];
		
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < W+1; j++) {
				if(i == 0 || j == 0) 
					t[i][j] = 0;
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < W+1; j++) {
				if(wt[i-1] <= j) {
					t[i][j] = Math.max(val[i-1] + t[i-1][j - wt[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][W];
	}
}
