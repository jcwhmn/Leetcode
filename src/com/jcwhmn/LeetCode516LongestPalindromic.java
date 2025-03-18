package com.jcwhmn;

import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

public class LeetCode516LongestPalindromic {
	public static void main(String[] args) {
		LeetCode516LongestPalindromic obj = new LeetCode516LongestPalindromic();
//		String str = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
		String str = "obottcoew";
//		String str = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbt";
		System.out.println(obj.longestPalindromeSubseq(str));
		
	}

	public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
        	dp[i][i]= 1; 
        }
        
        for(int len = 2; len <= n ; len++) {
        	for(int i = 0; i<= n-len;i++) {
        		int j = i + len - 1;
        		
        		if(chars[i] == chars[j]) {
        			dp[i][j] = dp[i + 1][j - 1] + 2;
        		} else {
        			dp[i][j] = Math.max(dp[i + 1][j], dp[i][j-1]);
        		}
        	}
        }
        return dp[0][n - 1];
	}
	
	
	public int longestPalindromeSubseq1(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] cache = new int[len][len];
        for(int i = 0; i < len; i++) {
        	Arrays.fill(cache[i], -1);
        }
        
        int max = -1;
        cache[len -1][len-1] = 1;
        for(int i = len - 1 ; i >= 0 ; i--) {
        	for ( int j= len - 1; j > i ; j--) {
            	int l = calc(chars, i, j, cache);
            	cache[i][j] = l;
            	System.out.println("start end res = " + i + " " + j + " " + l + " " + s.substring(i, j + 1));
            	if(l > max) max = l;;
        	}
        }
        return max;
    }
    
    public int calc(char[] chars, int start, int end, int[][] cache) {
    	int res = 0;
    	if(start == end) {
    		res = 1;
    	} else  	if(start > end) {
    		res =  0;
    	} else if(cache[start][end] == -1) {
	    	while(chars[start] != chars[end] && end > start) {
	    		end--;
	    	}
	    	if (end == start) res = 1;
	    	else {
	    		res =  2 + calc(chars, start + 1, end - 1, cache);
	    	}
    	} else {
    		return cache[start][end]; 
    	}
    	cache[start][end] = res;
    	return res;
    }
}
