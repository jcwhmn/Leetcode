package com.jcwhmn;

import java.util.Arrays;

public class LeetCode5LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode5LongestPalindrome obj = new LeetCode5LongestPalindrome();
		String str = "babad";
		System.out.println(obj.longestPalindrome(str));
	}

    public String longestPalindrome(String s) {
    	if (s == null || s.length() == 0) return "";
        char[] cc = s.toCharArray();
        int n = cc.length;
        
        for(int len = n ; len >= 2; len-- ) {
        	for(int i = 0; i <= n -len ; i++) {
        		if(isPalindrome(cc, i, i + len - 1))
        			return s.substring(i, i + len);
        	}
        }
        
        return s.substring(0, 1);
    }	
    
    public boolean isPalindrome(char[] cc, int start, int end) {
    	while(start < end) {
    		if(cc[start] != cc[end]) return false;
    		start++;
    		end--;
    	}
    	return true;
    }
}
