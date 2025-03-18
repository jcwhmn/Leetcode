package com.jcwhmn;

public class FindMedianSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedianSortedArrays obj = new FindMedianSortedArrays();
//		int[] nums1 = new int[] {1, 2, 3, 4, 5};
//		int[] nums2 = new int[] {6,7,8,9,10,11,12,13,14,15,16,17};
		int[] nums1 = new int[] {2, 3, 4, 5, 6};
		int[] nums2 = new int[] {1};
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
	}

	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( nums1.length < nums2.length) {
        	int[] temp = nums1;
        	nums1 = nums2;
        	nums2 = temp;
        } else if(nums1.length == nums2.length) {
        	if(nums1[0] > nums2[0]) {
            	int[] temp = nums1;
            	nums1 = nums2;
            	nums2 = temp;
        	}
        }
        
        int m = nums1.length;
        int n = nums2.length;

        boolean isOdd = (m + n) % 2 == 1;
        int middlepos = (m + n) /2;

        int left = 0;
        int right = nums1.length - 1;

        while(true) {
        	int i = (right + left) / 2;
        	if (right + left < 0) i = -1;
        	int j = middlepos - i -2;
        	if ( j < -1) j = -1;
        	if ( j > n - 1) j = n - 1;
        	
        	int m1, m2;
        	if (i < 0) {
        		m1 = Integer.MIN_VALUE;
        	} else {
        		m1 = nums1[i];
        	}
        	
        	if ( i >= nums1.length - 1) {
        		m2 = Integer.MAX_VALUE;
        	} else {
        		m2 = nums1[i + 1];
        	}
        	
        	int n1, n2;
        	if (j < 0) {
        		n1 = Integer.MIN_VALUE;
        	} else {
        		n1 = nums2[j];
        	}
        	
        	if ( j >= nums2.length - 1) {
        		n2 = Integer.MAX_VALUE;
        	} else {
        		n2 = nums2[j + 1];
        	}
        	
        	if (m1 <= n2 && n1 <= m2) {
        		if (isOdd) {
        			return Math.min(n2, m2);
        		} else {
        			return (Math.max(n1, m1) + Math.min(n2, m2)) / 2.0;
        		}
        	}
        	
        	if (m1 > n2) {
        		right = i - 1;
        	} else {
        		left = i + 1;
        	}
        }
    }
}
