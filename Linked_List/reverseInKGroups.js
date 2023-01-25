//!https://leetcode.com/problems/reverse-nodes-in-k-group/

function reverseKGroups(head, k) {

    if(head == null || k == 0) return head;

    let tempNode = new LinkedList(0);

    let previousNode = tempNode;
    let currentNode = tempNode;
    let nextNode = tempNode;
    
    let len = 0;
    while(currentNode.next != null) {
        currentNode = currentNode.next;
        len++;
    }

    while(len >= k) {
        currentNode = previousNode.next;
        nextNode = currentNode.next;

        for(let i = 1; i < k; i++) {
            currentNode.next = nextNode.next;
            nextNode.nextNode = previousNode.next;
            previousNode.next = nextNode;
            nextNode = currentNode.next;
        }
        prevNode = currentNode;
        len -= k;
    }
    return tempNode.next;
}