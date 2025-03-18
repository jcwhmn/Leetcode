package com.jcwhmn;

public class LeetCode34SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode34SearchRange obj = new LeetCode34SearchRange();
		int[] nums = new int[] {5,7,7,8,8,10};
		int[] nums1 = new int[] {5,5,5,5,5,5,5,5,5,5,5,5};
		int[] res = obj.searchRange(nums, 7);
		System.out.println(res[0] + " " + res[1]);
	}

	
    public int[] searchRange(int[] nums, int target) {
    	int[] res = new int[2];
    	if(nums == null || nums.length == 0) return res;
    	searchRange(nums, target, 0, nums.length - 1, res, 0);
    	
    	return res;
    }
    
    public void searchRange(int[] nums, int target, int start, int end, int[] res, int found) {
    	if (start > end) return;
    	if(found == -1 && nums[start] == target) {
    		res[0] = start;
    		return;
    	}
    	if(found == 1 && nums[end] == target) {
    		res[1] = end;
    		return;
    	}
    	int pos = (start + end) / 2;
    	
    	if(nums[pos] == target) {
    		if (found == 0) {
    			res[0] = pos;
    			res[1] = pos;
    			searchRange(nums, target, start, end - 1, res, -1);
    			searchRange(nums, target, pos + 1, end, res, 1);
    		} else if(found == -1) {
    			res[0] = pos;
    			searchRange(nums, target, start, pos - 1, res, found);
    		}else {
    			res[1] = pos;
    			searchRange(nums, target, pos + 1, end, res, found);
    		}
    		
    	} else if(nums[pos] < target) {
   			searchRange(nums, target, pos + 1, end, res, found);
    	} else {
    		searchRange(nums, target, start, pos - 1, res, found);
    	}
    }

    public int[] searchRange1(int[] nums, int target) {
    	int[] res = new int[] {-1, -1};
    	res[0] = findLeft(nums, target);
    	res[1] = findRight(nums, target);
    	return res;
    }
    public int findLeft(int[] nums, int target) {
    	int start = 0;
    	int end = nums.length - 1;
    	int res = -1;
    	while(start <= end) {
        	int pos = (start + end) / 2;
        	if(nums[pos] == target) {
        		res = pos;
        		end = pos - 1;
        	} else if(nums[pos] < target) {
        		start = pos + 1;
        	} else {
        		end = pos - 1;
        	}    		
    	}
    	return res;
    }

    public int findRight(int[] nums, int target) {
    	int start = 0;
    	int end = nums.length - 1;
    	int res = -1;
    	while(start <= end) {
        	int pos = (start + end) / 2;
        	if(nums[pos] == target) {
        		res = pos;
        		start = pos + 1;
        	} else if(nums[pos] < target) {
        		start = pos + 1;
        	} else {
        		end = pos - 1;
        	}    		
    	}
    	return res;
    }

}

