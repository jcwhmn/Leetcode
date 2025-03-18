package com.jcwhmn;

public class Test1 {

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5};
		ListNode node = convert(input);
		node = reverseList(node);
		System.out.println(node);
	}

	 public static ListNode reverseList(ListNode head) {
		 if (head == null) {
			 return null;
		 }

		 ListNode node = head;
		 ListNode next = head;
		 ListNode res = head;
		 ListNode prev = null;
		 ListNode prev1 = null;
		 
		 while(node.next != null) {
			 next = node.next;
			 prev1 = res;
			 
			 res.next = prev;
			 prev = res;
			 
			 node = next;
			 res = next;
		 }
		 res.next = prev;
		 return res;
	 }
	 private static ListNode convert(int[] input) {
		 ListNode res = new ListNode(input[0]);
		 
		 ListNode node = res;
		 for(int i = 1; i < input.length ; i++) {
			 ListNode node1 = new ListNode(input[i]);
			 node.next = node1;
			 node = node1;
		 }
		 return res;
	 }
	 
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
