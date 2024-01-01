// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
// Example 2:


// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
 

// Constraints:

// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000

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
    public ListNode reverse(ListNode head){
        ListNode curr = head  , prev = null ; 
        while(curr != null ){
            ListNode next = curr.next  ; 
            curr.next = prev ; 
            prev = curr ; 
            curr = next ; 
        }
        return prev ; 
    }

    public ListNode mergeLL(ListNode l1 , ListNode l2){
        ListNode head = l1  ; 
        while( l2 != null){
            ListNode temp1 = l1.next ; 
            ListNode temp2 = l2.next ; 
            l1.next = l2 ;
            l2.next = temp1 ; 
            l1 = temp1 ;
            l2 = temp2 ; 
        }
        return head ; 
    }
    
    public void reorderList(ListNode head) {
        ListNode slow = head , fast = head ; 
        while(fast.next != null && fast.next.next != null ){
            slow = slow.next ; 
            fast = fast.next.next ; 
        }
        ListNode alter = reverse(slow.next);
        slow.next = null ; 
        mergeLL(head , alter );

    }
}
