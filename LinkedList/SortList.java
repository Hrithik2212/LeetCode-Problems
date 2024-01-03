// Given the head of a linked list, return the list after sorting it in ascending order.

 

// Example 1:


// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105
 

// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

// Intuition
// Perform Merge Sort to keep the Time Complexity minimal

// Approach
// Use the slow pointer fast pointer approach to find the mid
// Dissconnect the linked list at mid and store their heads as left and right
// Recursively call the merge sort for left and right linked list and store them in left and right variables
// Finally merge the left and right lists using a merge function
// The space complexity of using any abstract data structres is O(1) as its linked list , however the recursion itself take
// Complexity
// Time complexity:
// O(NlogN)O(N logN)O(NlogN)
// Space complexity:
// O(1)O(1)O(1)
// The space complexity of using any abstract data structres is O(1) as its linked list , however the recursion itself takes Stack memory and can't comment or more like IDK the time complexity internally for recursive stack memory

// Advantage of MergeSort over QuickSort
// The advantage that I feel for using merge sort over quicksort for this questions is

// MergeSort time complexity is NlogN for all casses whereas in Quicksort the time complexity is N^2 in worst case
// MergeSort for linked list doesn't use the additional O(N) space complexity which is shown as a disadvantage of Merge Sort compared to O(1) space complexity quicksort
// Compared to Quicksort , MergeSort is easier and simple to implement in code for linked list


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
    public ListNode Merge(ListNode left , ListNode right ){
        ListNode dummyHead = new ListNode() ; 
        ListNode curr = dummyHead ; 
        while (left != null && right != null) {
            if (left.val < right.val){
                curr.next = left ; 
                left = left.next ;
            }
            else {
                curr.next = right ; 
                right = right.next ; 
            }
            curr = curr.next ; 
        }
        if(left != null ) curr.next = left ; 
        if(right != null ) curr.next = right ; 
        return dummyHead.next ; 
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head ; 
        ListNode slow = head  , fast = head.next ; 
        while(fast != null && fast.next != null) {
            slow = slow.next ; 
            fast = fast.next.next ; 
        }
        ListNode left = head ; 
        ListNode right = slow.next ; 
        slow.next = null ; 
        left = sortList(left) ; 
        right = sortList(right) ; 
        return Merge(left , right) ; 
    }
}