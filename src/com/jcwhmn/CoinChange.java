package com.jcwhmn;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange aaa = new CoinChange();
//		int[] coins = new int[] {1, 2, 5};
//		System.out.println(aaa.coinChange1(coins, 11));
		int[] coins = new int[] {2};
		System.out.println(aaa.coinChange1(coins, 3));
	}
	
    public int coinChange(int[] coins, int amount) {
    	int[] dp = new int[amount + 1];
    	for ( int i = 1; i < amount+1 ; i++) {
    		dp[i] = amount + 1;
    	}
    	dp[0] = 0;
    	
    	for(int num = 1 ; num < amount + 1; num++) {
    		for(int coin: coins) {
    			if (num - coin >= 0) {
    				dp[num] = Math.min(dp[num], 1 + dp[num - coin]);
    			}
    		}
    	}
    	
    	int res = dp[amount];
    	return res == amount + 1? -1 : res;
        
    }
    
    public int coinChange1(int[] coins, int amount) {
    	int[] cache = new int[amount + 1];
    	Arrays.fill(cache, -1);
    	
    	return coinChangeRecursive(coins, amount, cache);
    }
    
    public int coinChangeRecursive(int[] coins, int amount, int[] cache) {
    	if (amount == 0) return 0;
    	if (amount < 0) return Integer.MIN_VALUE;
    	if (cache[amount] != -1) return cache[amount];
    	
    	int minCoins = Integer.MIN_VALUE;
    	for(int coin: coins) {
    		int res = coinChangeRecursive(coins, amount - coin, cache);
    		if (res != Integer.MIN_VALUE) {
    			minCoins = Math.min(minCoins,  res + 1);
    		}
    	}
    	
    	return cache[amount] = (minCoins == Integer.MIN_VALUE) ? -1 : minCoins;
    }

}
