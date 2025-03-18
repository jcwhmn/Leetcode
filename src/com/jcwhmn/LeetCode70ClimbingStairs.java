package com.jcwhmn;

import java.util.Arrays;

public class LeetCode70ClimbingStairs {
	public static void main(String[] args) {
		LeetCode70ClimbingStairs obj  = new LeetCode70ClimbingStairs();
		System.out.println(obj.climbStairs(10));
	}
	
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        cache[1] = 1;
        return climbStairsCache(n, cache);
      }

      public int climbStairsCache(int n, int[] cache) {
          if (cache[n] != -1) return cache[n];
          return cache[n] = climbStairsCache(n - 1, cache) + climbStairsCache(n - 2, cache);

      }

}
