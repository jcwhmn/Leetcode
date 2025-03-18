package com.jcwhmn;

import java.util.Arrays;

public class LeetCode198HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode198HouseRobber obj = new LeetCode198HouseRobber();
		
//		int[] nums = new int[] {1, 2, 3, 1};
		
		int[] nums = new int[] {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
		
		
		System.out.println(obj.rob(nums));
	}
	
    public int rob(int[] nums) {
    	int[] cache = new int[nums.length + 1];
    	Arrays.fill(cache, -1);
    	cache[nums.length] = 0;
    	cache[nums.length - 1] = nums[nums.length - 1];
        return rob(nums, 0, cache);
    }	
    
    public int rob(int[] nums, int pos, int[] cache) {
    	if (cache[pos] != -1) return cache[pos];
    	return  cache[pos] = Math.max(rob(nums, pos + 2, cache) + nums[pos], rob(nums, pos + 1, cache));
    }

}
