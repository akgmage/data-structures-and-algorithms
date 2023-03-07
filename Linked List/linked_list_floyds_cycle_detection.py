# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        #Floyd's cycle detection algorithm uses slow and fast points to find the loop
        #Reference - https://www.geeksforgeeks.org/floyds-cycle-finding-algorithm/
        slow,fast= head,head
        while(slow!=None and fast!=None and fast.next!=None):
            slow = slow.next
            fast = fast.next.next
            if(slow == fast):
                return True
        return False