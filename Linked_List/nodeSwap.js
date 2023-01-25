class LinkedList {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

//! O(n) time | O(n) space
function nodeSwap(head) {
    if(head == null || head.next == null) return head;

    const nodeNext = head.next;

    head.next = nodeSwap(head.next.next);

    nodeNext.next = head;

    return nextNode;
}

//! O(n) time | O(1) space
function nodeSwap(head) {
    let tempNode = new LinkedList(0);
    tempNode.next = head;
    let previousNode = tempNode.prev;
    
    while(previousNode.next != null && previousNode.next.next != null) {
        const firstNode = previousNode.next;
        const secondNode = previousNode.next.next;

        firstNode.next = secondNode.next;
        secondNode.next = firstNode;
        previousNode.next = secondNode;

        previousNode = firstNode;
    }

    return tempNode.next;
}