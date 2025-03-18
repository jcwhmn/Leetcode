package com.jcwhmn;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.print(isValid("{[]}"));
		System.out.print(isValid("(([]){})"));
		System.out.print(isValid("(){}}{"));
		

	}
	
	public static boolean isValid(String s) {
		String symbols = "({[)}]";
		
		char c = s.charAt(0);
		int index = symbols.indexOf(c);
		if (index > 2) return false; //if no left side, fail

		char c1 = symbols.charAt(index + 3);
		int index1 = s.indexOf(c1);
		if (index1 == -1) return false;  //if no match, fail
		
		if (index1 == 1) {
			if (s.length() == 2) return true;
			if (!isValid(s.substring(2))) return false;
			return true;
		}

		String str = s.substring(1, index1);
		int index2 = str.lastIndexOf(c);
		if (index2 == -1) { 
			if (!isValid(str)) return false;
			if ( index1 == s.length() - 1) return true;
			
			str = s.substring(index1 + 1);
			return isValid(str);
		} else {
			str = s.substring(index2 + 1, index1 + 1);
			if (!isValid(str)) return false;
			str = s.substring(0, index2 + 1) + s.substring(index1 + 1);
			return isValid(str);
		}
	}

}
