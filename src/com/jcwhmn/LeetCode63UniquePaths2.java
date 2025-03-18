package com.jcwhmn;

import java.util.Arrays;


public class LeetCode63UniquePaths2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode63UniquePaths2 obj = new LeetCode63UniquePaths2();
//		int[][] nums = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
//		int[][] nums = new int[][] {{1,0}};
//		int[][] nums = new int[][] {{0, 1, 0, 0}};
//		int[][] nums = new int[][] {{0, 0}, {1, 1}, {0, 0}};
		int[][] nums = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		System.out.println(obj.uniquePathsWithObstacles(nums));
	}
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int x = 0 ; x < m ; x ++) {
        	for ( int y = 0; y < n ; y++) {
        		if (obstacleGrid[x][y] == 1) dp[x][y] = 0;
        		else if(x == 0 && y == 0) dp[x][y] = 1;
        		else if(x == 0) {
        			if(obstacleGrid[x][y - 1] == 1) {
        				obstacleGrid[x][y] = 1;
        			}else {
        				dp[x][y] = dp[x][y -1];
        				
        			}
        		} else if(y == 0) {
        			if(obstacleGrid[x -1][y] == 1) {
        				obstacleGrid[x][y]= 1;
        			} else {
        				dp[x][y] = dp[x -1][y];
        			}
        		} else {
        			if (obstacleGrid[x-1][y] == 1 && obstacleGrid[x][y -1] == 1) obstacleGrid[x][y]= 1;
        			else
        				dp[x][y] = dp[x -1][y] + dp[x][y -1];
        		}
        	}
        }
        return dp[m -1][n -1];
    }
}
