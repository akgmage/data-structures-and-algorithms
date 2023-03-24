class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy_header = ListNode('*')
        dummy_header.next=head
        slow = dummy_header
        fast = dummy_header

        for _ in range(1,n+2):
            fast=fast.next
        
        while(fast!=None):
            slow = slow.next
            fast = fast.next
        
        slow.next = slow.next.next
        return dummy_header.next
