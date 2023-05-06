'''Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem :Linked List: Add Two Numbers in Python
Issue Number : #621
Problem statement : 

Explanation of the below python code :

This code implements a solution for the "Add Two Numbers" problem on LeetCode, where the inputs are two non-empty linked lists representing two non-negative integers. The goal is to return the sum of the two integers as a linked list.

The function takes in two linked lists, l1 and l2, and creates a new linked list represented by the variable 'dummy' which will store the sum. The current node of the new linked list is represented by the variable 'curr'. The variable 'carry' stores the carry-over value from the previous sum.

The function then loops through both input linked lists, l1 and l2, as well as any carry-over value from the previous sum. It adds the values of the corresponding nodes in l1 and l2 (if they exist) and any carry-over value from the previous sum. It then calculates the carry-over value and the new value for the current node by dividing the sum by 10 and taking the remainder. The carry-over value is then updated for the next iteration of the loop.

The new node with the calculated value is added to the end of the new linked list using the 'curr' variable. 'curr' is then updated to point to the new node. Once the loop is completed, the new linked list is returned, but without the initial 'dummy' node, as the first node in the list is actually the second node in the sequence.

Overall, the function creates a new linked list representing the sum of the input linked lists, using a carry-over value to handle any values greater than 10. It runs in linear time in the length of the input linked lists, making it an efficient solution.


'''

-------------------------------------------------------------------------//python code begins here----------------------------------------------------------------------------------------------------------------------------------------------------------

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode()
        curr = dummy
        carry = 0
        while l1 or l2 or carry:
            val = carry
            if l1:
                val += l1.val
                l1 = l1.next
            if l2:
                val += l2.val
                l2 = l2.next
            carry, val = divmod(val, 10)
            curr.next = ListNode(val)
            curr = curr.next
        return dummy.next
