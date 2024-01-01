// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

// Example 1:


// Input: l1 = [7,2,4,3], l2 = [5,6,4]
// Output: [7,8,0,7]
// Example 2:

// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [8,0,7]
// Example 3:

// Input: l1 = [0], l2 = [0]
// Output: [0]
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode  reverse(ListNode root){
        ListNode curr = root; 
        ListNode prev = null ; 
        while (curr!= null) {
            ListNode next = curr.next ; 
            curr.next = prev ; 
            prev = curr ; 
            curr = next ; 
        }
        return prev ; 
    } 

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0) ; 
        ListNode curr = dummyHead ; 
        int carry = 0 ;
        l1 = reverse(l1) ; 
        l2 = reverse(l2) ; 
        while (l1 != null || l2 != null){
            int val1 = (l1 != null )? l1.val:0 ; 
            int val2 = (l2 != null )? l2.val:0 ; 
            int sum = val1 + val2 + carry ; 
            curr.next  = new ListNode(sum % 10) ; 
            carry = sum / 10 ; 
            curr = curr.next ; 
            if(l1 != null) l1 = l1.next ; 
            if(l2 != null) l2 = l2.next ;
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return reverse(dummyHead.next);
    }
}