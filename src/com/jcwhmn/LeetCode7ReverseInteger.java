package com.jcwhmn;

public class LeetCode7ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode7ReverseInteger obj = new LeetCode7ReverseInteger();
		System.out.println(obj.reverse(-2147483648));
	}

    public int reverse(int x) {
    	if(x == Integer.MIN_VALUE) return 0;
    	int factor = 1;
    	if(x < 0) {
    		factor = -1;
    		x = x * factor;
    	}
    	long num = 0;
    	do {
    		num = num * 10 + x % 10;
    		x = x / 10;
    	}while(x > 0);
    	if(num > Integer.MAX_VALUE) return 0;
    	
    	return (int)(num * factor);
    }
}
