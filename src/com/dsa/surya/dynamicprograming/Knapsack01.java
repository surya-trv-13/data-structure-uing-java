package com.dsa.surya.dynamicprograming;

public class Knapsack01 {
	public static void main(String[] args) {
		Knapsack01 knapsack01 = new Knapsack01();
		Integer[] weight = new Integer[] {1,2,3,4};
		Integer[] value = new Integer[] {3,7,6,5};
		Integer W = 7;
		Integer n = 4;
		int maxProfit = knapsack01.knapsack(weight, value, W, n);
		
		System.out.println("Max Profit is :"+ maxProfit);
	}
	
	public int knapsack(Integer[] weight, Integer[] value, Integer W, Integer n) {
		if(n == 0 || W == 0) {
			return 0;
		}
		
		if(weight[n-1] <= W) {
			return Math.max(value[n-1] + knapsack(weight, value, W - weight[n-1], n-1), knapsack(weight, value, W, n-1));
		}else {
			return knapsack(weight, value, W, n-1);
		}
	}
}	
