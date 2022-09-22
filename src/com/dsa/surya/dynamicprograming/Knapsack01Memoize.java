package com.dsa.surya.dynamicprograming;

import java.util.Arrays;

public class Knapsack01Memoize {
	Integer[][] t = new Integer[1000][1000]; 
	public static void main(String[] args) {
		Knapsack01Memoize knapsack01Memoize = new Knapsack01Memoize();
		knapsack01Memoize.initializeMemory();
		Integer[] weight = new Integer[] {1,2,3,4};
		Integer[] value = new Integer[] {3,7,6,5};
		Integer W = 7;
		Integer n = 4;
		
		System.out.println("Knapsack 0/1 Memoize: Max Profit : "+ knapsack01Memoize.knapsack(weight, value, W, n));
	}
	
	public int knapsack(Integer[] weight, Integer[] value, Integer W, Integer n) {
		if(n == 0 || W == 0) {
			return 0;
		}
		
		if(t[W-1][n-1] != -1) {
			return t[W-1][n-1];
		}else {
			if(weight[n-1] <= W) {
				t[W-1][n-1] = Math.max(value[n-1] + knapsack(weight, value, W - weight[n-1], n-1), knapsack(weight, value, W, n-1));
			}else {
				t[W-1][n-1] = knapsack(weight, value, W, n-1);
			}
			return t[W-1][n-1];
		}
	}
	
	public void initializeMemory() {
		for(Integer[] data: t) {
			Arrays.fill(data, -1);
		}
	}
}
