# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    #Maintaining hashset to store all the values
    def __init__(self):
        self.s=set()
    
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        #Iterating through all the elements linked with headA
        #Inserting them in the hashset
        while(headA!=None):
            self.s.add(headA)
            headA=headA.next
            
        #While iterating through elements linked with headB
        #Return the first element which is already present in the hashset
        while(headB!=None):
            if(headB in self.s):
                return headB
            headB=headB.next
