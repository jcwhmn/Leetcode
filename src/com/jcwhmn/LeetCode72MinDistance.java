package com.jcwhmn;

import java.util.Arrays;

public class LeetCode72MinDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode72MinDistance obj = new LeetCode72MinDistance();
//		String word1 = "horse";
//		String word2 = "ros";
		String word1 = "intention";
		String word2 = "execution";
		System.out.println(obj.minDistance(word1, word2));
	}
	
    public int minDistance(String word1, String word2) {
    	char[] c1 = word1.toCharArray();
    	int m = c1.length;
    	char[] c2 = word2.toCharArray();
    	int n = c2.length;

    	int[][] dp = new int[m + 1][n + 1];
    	
    	for(int i = 0 ; i <= m ; i++) {
    		dp[i][n]= m - i;
    	}
    	
    	for(int i = 0; i <= n; i++) {
    		dp[m][i] = n -i;
    	}
    	
    	for(int i = m - 1; i >= 0 ; i--) {
    		for(int j = n - 1; j >= 0; j--) {
    			if(c1[i] == c2[j]) {
    				dp[i][j]= dp[i+1][j+1]; 
    			} else {
    				dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
    			}
    		}
    	}
    	return dp[0][0];
	}
    
	
    
}
