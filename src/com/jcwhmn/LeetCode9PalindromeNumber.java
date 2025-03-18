package com.jcwhmn;

public class LeetCode9PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode9PalindromeNumber obj = new LeetCode9PalindromeNumber();
		System.out.println(obj.isPalindrome(121));
	}

    public boolean isPalindrome(int x) {
        if ( x < 0) return false;
        int[] a = new int[10];
        int l = 0;
        while(x > 0) {
        	a[l] = x % 10;
        	x = x / 10;
        	l++;
        }
        
        for(int i = 0; i < l / 2; i++) {
        	if(a[i] != a[l - i -1]) return false;
        }
        return true;
    }
}
