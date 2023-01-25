/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */


function length(node) {
    
    let length = 0;
    
    while (node) {
        node = node.next;
        length++;
    }
    return length;
}
var getIntersectionNode = function(headA, headB) {
    
    let lengthA = length(headA);
    let lengthB = length(headB);
    
    while (lengthA > lengthB) {
            
        headA = headA.next;
        lengthA--;
    }
    
        while (lengthB > lengthA) {
            
        headB = headB.next;
        lengthB--;
    }
    
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
        
    }
    return headA;
    
};