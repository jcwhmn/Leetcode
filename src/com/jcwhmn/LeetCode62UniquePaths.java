package com.jcwhmn;

import java.util.Arrays;

public class LeetCode62UniquePaths {
	public static void main(String[] args) {
		LeetCode62UniquePaths obj = new LeetCode62UniquePaths();
		System.out.println(obj.uniquePaths(3, 7));
	}
	
    public int uniquePaths(int m, int n) {
    	int[][] dp = new int[m][n];
    	for (int i = 0 ; i < m ; i++) {
    		Arrays.fill(dp[i], 0);
    	}
    	
    	dp[0][0] = 1;
    	for (int i = 1 ; i < n ; i++) {
    		dp[0][i] = 1;
    	}
    	
    	for(int j = 1; j < m ; j++) {
    		dp[j][0] = 1;
    	}
    	for(int x = 1 ; x < m; x++) {
    		for ( int y = 1; y < n ; y++) {
    			dp[x][y] = dp[x - 1][y] + dp[x][y-1];
    		}
    	}
    	return dp[m -1][n-1];
    	
    }
	
	
	
    public int uniquePaths1(int m, int n) {
        int[][] cache = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
        	Arrays.fill(cache[i], -1);
        }
        cache[m - 1][n - 1] = 1;
        
        return uniquePaths(m, n, 0, 0, cache);
    }
    
    public int uniquePaths(int m, int n, int x, int y, int[][] cache) {
    	if ( x >= m || y >= n) return 0;
    	if (cache[x][y] != -1) return cache[x][y];
    	
    	return uniquePaths(m, n, x + 1, y, cache) + uniquePaths(m, n, x, y + 1, cache);
    }
}
