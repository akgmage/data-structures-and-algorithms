class LinkedList {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}
 
//! O(n) time | O(1) space
function zipLinkedList(linkedList) {
    if(linkedList.next != null || linkedList.next.next != null) return linkedList;

    const firstHalfHead = linkedList;
    const secondHalfHead = splitLinkedList(linkedList);

    const reversedSecondHalfHead = reverseLinkedList(secondHalfHead);

    return combineLinkedLists(firstHalfHead, reversedSecondHalfHead);
    
}

function splitLinkedList(linkedList) {
    let slowIterator = linkedList;
    let fastIterator = linkedList;

    while(fastIterator != null && fastIterator.next != null) {
        slowIterator = slowIterator.next;
        fastIterator = fastIterator.next.next;
    }

    const secondHalfHead = slowIterator.next;
    slowIterator.next = null;

    return secondHalfHead;
}

function combineLinkedLists(linkedList1, linkedList2) {
        let linkedList1Iterator = linkedList1;
        let linkedList2Iterator = linkedList2;

        while(linkedList2Iterator) {
            let linkedList1IteratorNext = linkedList1Iterator.next;
            let linkedList2IteratorNext = linkedList2Iterator.next;

            linkedList1Iterator.next = linkedList2Iterator;
            linkedList2Iterator.next = linkedList1IteratorNext;

            linkedList1Iterator = linkedList1IteratorNext;
            linkedList2Iterator = linkedList2IteratorNext;
        }
        return linkedList1;
} 

function reverseLinkedList(head) {
    let previousNode = null;
    let currentNode = head;

    while(currentNode != null) {
        const nextNode = currentNode.next;
        currentNode.next = previousNode;
        previousNode = currentNode;
        currentNode = nextNode;
    }
    return previousNode;
}