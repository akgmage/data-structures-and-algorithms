// https://leetcode.com/problems/intersection-of-two-linked-lists/

function getIntersectionNode (headA, headB) { 

    let headANode = headA;
    let headBNode = headB;

    while(headANode !== headBNode) {
        headANode = headANode === null ? headB : headANode.next;
        headBNode = headBNode === null ? headA : headBNode.next;
    }
    return headANode;
}

