# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        head = ListNode('*');
        header_pointer = head;
        while(l1!=None or l2!=None):
            temp = carry
            if(l1==None):
                temp+= l2.val
                l2 = l2.next
            elif(l2==None):
                temp += l1.val
                l1 = l1.next
            else:
                temp+=l1.val+l2.val
                l1=l1.next
                l2=l2.next
            head.next = ListNode(temp%10)
            carry = temp//10
            head = head.next
        if(carry!=0):
            head.next = ListNode(carry)
            head = head.next
        return header_pointer.next
