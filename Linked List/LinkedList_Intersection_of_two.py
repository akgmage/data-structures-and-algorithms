# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def __init__(self):
        self.s=set()
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        while(headA!=None):
            self.s.add(headA)
            headA=headA.next
        while(headB!=None):
            if(headB in self.s):
                return headB
            headB=headB.next
