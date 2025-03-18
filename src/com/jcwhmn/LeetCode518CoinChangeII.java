package com.jcwhmn;

import java.util.Arrays;

public class LeetCode518CoinChangeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode518CoinChangeII obj = new LeetCode518CoinChangeII();
		int[] coins = new int[] {1, 2, 5};
//		int[] coins = new int[] {3,5,7,8,9,10,11};
		System.out.println(obj.change(5, coins));
	}
	
    public int change(int amount, int[] coins) {
    	int res = 0;
    	int[][] dp = new int[coins.length + 1][amount + 1];
    	for(int i = 0 ; i < coins.length + 1; i++)
    		dp[i][0] = 1;

    	/*
    	首先尝试币值最小的,匹配所有amount,得到该币值能组成该amount的所有组合.当然,结果是0或1
    	然后尝试后续币值.
    		当当前amount小于该币值时,取前面一个币值当前amount的dp值
    		当当前amount大于或等于该币值时,值等于当前币值,amount减去前一个币值的值加上前一个币值当前amount的值,即表格中上一行加左列的值的和    	
    	 */
		for(int coin = 1; coin <= coins.length ; coin++) {
	    	for(int amoun = 1 ; amoun <= amount; amoun++) {
    			if(amoun < coins[coin - 1]) dp[coin][amoun] = dp[coin-1][amoun];
    			else {
    				dp[coin][amoun] = dp[coin][amoun - coins[coin -1]] + dp[coin - 1][amoun];
    			}
    		}
    	}
    	return dp[coins.length][amount];
    }
}
