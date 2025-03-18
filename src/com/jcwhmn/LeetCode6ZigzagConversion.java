package com.jcwhmn;

import java.util.Arrays;

public class LeetCode6ZigzagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode6ZigzagConversion obj = new LeetCode6ZigzagConversion();
		String str = "A";
		System.out.println(obj.convert(str, 1));
	}

    public String convert(String s, int numRows) {
    	if(numRows == 1) return s;
        String[] res = new String[numRows];
        Arrays.fill(res, "");
        
        int pos = 0;
        for(int i = 0; i < s.length(); i+=numRows * 2 - 2) {
        	for(int j = 0 ; j < numRows && pos < s.length(); j++) {
        		res[j] = res[j] + s.charAt(pos++);
        	}
        	
        	for(int j = numRows-2; j > 0 && pos < s.length(); j--) {
        		res[j] = res[j]+ s.charAt(pos++); 
        	}
        }
        
        return String.join("", res);
    }
}
