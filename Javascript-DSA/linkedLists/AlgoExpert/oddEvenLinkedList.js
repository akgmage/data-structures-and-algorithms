//! https://leetcode.com/problems/odd-even-linked-list/



//! O(n) time | O(1) space

function oddEvenList(head) {
    
    if(!head) return null;
    
    let odd = head;
    let even = head.next;
    let evenHead = even;
    
    while(even && even.next) {
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    odd.next = evenHead;
    return head;
};