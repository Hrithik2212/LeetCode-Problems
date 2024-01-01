// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

// Example 1:


// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
// Example 2:

// Input: head = [5], left = 1, right = 1
// Output: [5]
 

// Constraints:

// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
 

// Follow up: Could you do it in one pass?

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right ) return head ; 
        ListNode dummyHead = new ListNode(0, head) ; // use a dummyHead to handle edge cases 
        ListNode curr = dummyHead ,tail = null  ; 
        int pos = 0; 
        while(pos != left){ // Traverse till left idx
            tail = curr ;
            curr = curr.next ; 
            pos++ ; 
        } 
        ListNode prev = null  , next = null ; 
        while(pos++ <= right ){ // Reverse till right idx
            next = curr.next ; 
            curr.next = prev ; 
            prev = curr ; 
            curr = next ;
        }
        tail.next = prev ; 
        while(prev.next != null) { // connect the reversed list to the list on right side of right idx
            prev = prev.next ; 
        }
        prev.next = curr ; 
        return dummyHead.next ;
    }
}