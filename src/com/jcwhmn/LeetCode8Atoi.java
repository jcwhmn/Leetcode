package com.jcwhmn;

public class LeetCode8Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode8Atoi obj = new LeetCode8Atoi();
		String str1 = "9223372036854775808";
		String str = "   -042";
		System.out.println(obj.myAtoi(str));
	}
	
    public int myAtoi(String s) {
    	s = s.trim();
    	if(s == null || s.length() == 0) return 0;
    	long num = 0;
    	int factor = 1;
    	char[] cc = s.toCharArray();
    	if (cc[0] == '-') {
    		factor = -1;
    	}else  	if (cc[0] == '+') {
    		factor = 1;
    	}
    	else if(cc[0] >= '0'  && cc[0] <= '9') num =  (int)( cc[0] - '0');
    	else return 0;
    	
    	for(int i = 1; i < cc.length; i++) {
    		if(cc[i] < '0'  || cc[i] > '9') break;
    		num = num * 10 + (int)(cc[i] - '0');
        	if(num > Integer.MAX_VALUE) {
        		if(factor == -1) return Integer.MIN_VALUE;
        		else return Integer.MAX_VALUE;
        	}
    	}
    	
    	return (int)(num * factor);
    	
    }
}
