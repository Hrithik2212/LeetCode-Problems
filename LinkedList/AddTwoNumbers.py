"""
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
"""



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = dummy = ListNode(0)
        carry = 0 
        while l1 or l2 or carry : 
            val = carry
            if l1 : 
                val += l1.val 
                l1 = l1.next 

            if l2 :
                val += l2.val 
                l2 = l2.next 

            carry , val = divmod(val , 10)
            
            dummy.next = ListNode(val)
            dummy = dummy.next 

        return head.next 
        
 '''
 OUTPUT
 
 Input
l1 =
[2,4,3]
l2 =
[5,6,4]
Output
[7,0,8]
Expected
[7,0,8]
 '''
